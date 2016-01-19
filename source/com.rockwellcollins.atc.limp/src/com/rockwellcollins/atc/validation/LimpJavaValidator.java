/*
* generated by Xtext
*/
package com.rockwellcollins.atc.validation;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.validation.Check;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.AttributeBlock;
import com.rockwellcollins.atc.limp.BreakStatement;
import com.rockwellcollins.atc.limp.ChoiceExpr;
import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.ContinueStatement;
import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.Define;
import com.rockwellcollins.atc.limp.DefineUseRef;
import com.rockwellcollins.atc.limp.ElseBlock;
import com.rockwellcollins.atc.limp.ElseIf;
import com.rockwellcollins.atc.limp.EnumTypeDef;
import com.rockwellcollins.atc.limp.EnumValue;
import com.rockwellcollins.atc.limp.Equation;
import com.rockwellcollins.atc.limp.EquationBlock;
import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.ForStatement;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.InitExpr;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.IntegerWildCardExpr;
import com.rockwellcollins.atc.limp.LabelStatement;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.Postcondition;
import com.rockwellcollins.atc.limp.Precondition;
import com.rockwellcollins.atc.limp.SecondInit;
import com.rockwellcollins.atc.limp.SomeAttributeBlock;
import com.rockwellcollins.atc.limp.SomeVarBlock;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.TypeDeclaration;
import com.rockwellcollins.atc.limp.VarBlock;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.WhileStatement;
import com.rockwellcollins.atc.limp.utils.LimpUtilities;

/**
 * This file contains the methods that implement custom validation routines
 * that are called after parsing/lexing.  There is no need for the user to 
 * call them, as they are called automatically by the XText framework after
 * parsing.
 *
 * See http://www.eclipse.org/Xtext/documentation.html#validation for more
 * information.
 */
public class LimpJavaValidator extends com.rockwellcollins.atc.validation.AbstractLimpJavaValidator {

	public final LimpTypeChecker tc = new LimpTypeChecker(this);

	/**
	 * This will check for elements inside of a spec that are unsupported for analysis. It will
	 * throw a warning on each element.
	 */
	@Check
	public void checkForUnsupporteds(Specification s) {
		String message = "Expression is unsupported for formal analysis."; 
		for(ChoiceExpr choice : EcoreUtil2.getAllContentsOfType(s,ChoiceExpr.class)) {
			warning(message, choice);
		}
		
		for(SecondInit secondInit : EcoreUtil2.getAllContentsOfType(s,SecondInit.class)) {
			warning(message, secondInit);
		}
			
		for(IntegerWildCardExpr iwc : EcoreUtil2.getAllContentsOfType(s, IntegerWildCardExpr.class)) {
			warning(message, iwc);
		}
	}
	
	/**
	 * This checks for duplicate enumeration values within enumeration types
	 */
	@Check
	public void checkSpecForEnumValues(Specification s) {
		Set<String> names = new HashSet<>();
		for(Declaration d : s.getDeclarations()) {
			String name = SimpleAttributeResolver.NAME_RESOLVER.apply(d);
			if(names.contains(name)) {
				error(name + " is already used in previous declaration.", d, getNameFeature(d));
			} else {
				names.add(name);
			}

			if (d instanceof EnumTypeDef) {
				EnumTypeDef etd = (EnumTypeDef) d;
				for(EnumValue ev : etd.getEnumerations()) {
					String enumName = ev.getName();
					if(names.contains(enumName)) {
						error(ev.getName() + " is already used in a previous declaration.", ev);
					} else {
						names.add(enumName);
					}
				}
			}
		}
	}
	
	private EStructuralFeature getNameFeature(Declaration d) {
		if (d instanceof ExternalFunction) {
			return LimpPackage.Literals.EXTERNAL_FUNCTION__NAME;
		} else if (d instanceof ExternalProcedure) {
			return LimpPackage.Literals.EXTERNAL_PROCEDURE__NAME;
		} else if (d instanceof LocalFunction) {
			return LimpPackage.Literals.LOCAL_FUNCTION__NAME;
		} else if (d instanceof LocalProcedure) {
			return LimpPackage.Literals.LOCAL_PROCEDURE__NAME;
		} else if (d instanceof VariableRef) {
			return LimpPackage.Literals.VARIABLE_REF__NAME;
		} else if (d instanceof TypeDeclaration) {
			return LimpPackage.Literals.TYPE_DECLARATION__NAME;
		} else {
			return null;
		}
	}

	/**
	 * This analyzes the entire specification and checks to see a LocalProcedure is named "main", but if multiple
	 * LocalProcedures are found the last one is labeled as the main. In the latter case a warning is thrown on the 
	 * ID of the main node to alert the user.
	 * 
	 * If the main node does not have any outputs or written globals an error is thrown because it does not modify
	 * state.
	 */
	@Check
	public void checkSpecForLocalProcedures(Specification s) {
		LocalProcedure main = LimpUtilities.getMainLocalProcedure(s);
		if(!main.getName().equals("main")) {
			warning("Using " + main.getName() + " as main node for analysis.", main, LimpPackage.Literals.LOCAL_PROCEDURE__NAME);
		}
		
		for(LocalProcedure lp : EcoreUtil2.getAllContentsOfType(s, LocalProcedure.class)) {
			if(!lp.equals(main)) {
				List<Define> defines = EcoreUtil2.getAllContentsOfType(lp, Define.class);
				List<OutputArg> outputs = EcoreUtil2.getAllContentsOfType(lp, OutputArg.class);
				
				if(defines.size() + outputs.size() == 0) {
					error(lp.getName() + " must define at least one global variable or output.", lp, LimpPackage.Literals.LOCAL_PROCEDURE__NAME);
				}
			}
		}
	}
	
	/**
	 * External functions must modify a part of the program state. If one does not, an error is thrown. 
	 */
	@Check 
	public void checkExternalFunctionSignature(ExternalProcedure ep) {
		List<Define> defines = EcoreUtil2.getAllContentsOfType(ep, Define.class);
		List<OutputArg> outputs = EcoreUtil2.getAllContentsOfType(ep, OutputArg.class);
		
		if(defines.size() + outputs.size() == 0) {
			error(ep.getName() + " must define at least one global variable or output.", ep, LimpPackage.Literals.EXTERNAL_PROCEDURE__NAME);
		}
	}
	
	/**
	 * If there is an import declaration we have to flag any conflicts between the local file and imported file. 
	 */
	@Check
	public void checkReferencedDeclarationsDuplicate(Specification spec) {
		Map<String, String> referencedDeclarations = LimpGetReferencedDeclarations.get(spec);

		for (Declaration decl : spec.getDeclarations()) {
			String name = SimpleAttributeResolver.NAME_RESOLVER.apply(decl);
			if (referencedDeclarations.containsKey(name)) {
				error("Declaration " + name + " already imported from " + referencedDeclarations.get(name), decl);
			}
		}
	}
	
	private EObject getParent(EObject e) {
		if(e.eContainer() instanceof StatementBlock || 
		   e.eContainer() instanceof EquationBlock ||
		   e.eContainer() instanceof Precondition ||
		   e.eContainer() instanceof Postcondition ) {
			return e.eContainer();
		} else {
			return getParent(e.eContainer());
		}
	}
	
	/**
	 * Check that no labels in the program are named "end" as that is reserved for the NormalizeStatements
	 * pass.
	 */
	@Check
	public void verifyLabelStatement(LabelStatement label) {
		if(label.getName().equals("end")) {
			error("The end label is a reserved keyword and cannot be used.", label);
		}
	}
	
	/**
	 * This method ensures that InitExprs are only found in Postconditions.
	 */
	@Check
	public void preventInitExprsInStatements(InitExpr ie) {
		if(!(getParent(ie) instanceof Postcondition)) {
			error("InitExprs can only be used in PostConditions.", ie);
		}
		
		if(!(ie.getId() instanceof GlobalDeclaration)) {
			error("InitExprs can only be applied to global variables.", ie);
		}
	}
	
	/**
	 *  This method ensures AssignmentStatements contain no
	 *  Constants, ExternalConstants, and Input arguments on
	 *  the left hand side.
	 */
	@Check
	public void verifyAssignmentIDs(AssignmentStatement as) {
		IdList idl = as.getIds();
		
		int i=0;
		for(VariableRef vr : idl.getIds()) {
			if(vr instanceof ConstantDeclaration) {
				error("Constants may not be assigned in a function.", idl, LimpPackage.Literals.ID_LIST__IDS, i);
			}
			
			if(vr instanceof InputArg) {
				error("Inputs may not be assigned.", idl, LimpPackage.Literals.ID_LIST__IDS, i);
			}
			i++;
		}
	}
	
	/**
	 * This method flags a warning if the Attribute block is declared
	 * in a procedure or , but does not contain any used variables.
	 */
	@Check
	public void checkAtLeastOneAttributeDefined(AttributeBlock ab) {
		if(ab instanceof SomeAttributeBlock) {
			SomeAttributeBlock sab = (SomeAttributeBlock) ab;
			if(sab.getAttributeList().size() == 0) {
				warning("At least one attribute should be defined.", ab);
			}
		}
	}
	
	/**
	 * This method flags a warning if the Var block is declared
	 * in a procedure or function, but does not contain any used variables. 
	 */
	@Check
	public void checkAtLeastOneVarDefined(VarBlock vb) {
		if(vb instanceof SomeVarBlock) {
			SomeVarBlock svb = (SomeVarBlock) vb;
			if (svb.getLocals().size() == 0) {
				warning("At least one variable should be defined.", vb);
			}
		}
	}
	
	/**
	 * This method checks that LocalFunction declarations do not contain calls
	 * to procedures within them.  
	 * 
	 * Procedures are temporal operations that occur over a timespan, whereas
	 * Functions are executed instantly.  Due to this nature, Functions are not
	 * allowed to call Procedures.
	 */
	@Check
	public void checkFunctionsDoNotCallProcedures(LocalFunction lf) {
		for(FcnCallExpr fce : EcoreUtil2.getAllContentsOfType(lf, FcnCallExpr.class)) {
			if(fce.getId() instanceof LocalProcedure) {
				error("Local function may not make calls to local procedures", fce);
			}
			
			if(fce.getId() instanceof ExternalProcedure) {
				error("Local function may not make calls to external procedures", fce);
			}
		}
	}

	/**
	 * This method checks that LocalFunctions do not contain any references to 
	 * GlobalDeclarations or ExternalGlobalDeclarations.
	 */
	@Check
	public void checkFunctionsDoNotAccessGlobals(LocalFunction lf) {
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(lf, IdExpr.class)) {
			if(ide.getId() instanceof GlobalDeclaration) {
				error("Local functions may not read global variables",ide);
			}
		}
		
		for(AssignmentStatement as : EcoreUtil2.getAllContentsOfType(lf, AssignmentStatement.class)) {
			IdList idl = as.getIds();
			int i=0;
			for(VariableRef vr : idl.getIds()) {
				if(vr instanceof GlobalDeclaration) {
					error("Local functions may not write global variables",idl, LimpPackage.Literals.ID_LIST__IDS, i);
				}
				i++;
			}
		}
	}
	
	/**
	 * This top-level method calls the LimpUsageChecker class to verify that all assignable 
	 * variables (locals and outputs) are assigned in a LocalFunction declaration. 
	 */
	@Check
	public void checkVariablesAreAssigned(LocalFunction lf) {
		LimpUsageChecker luc = new LimpUsageChecker(this);
		luc.doSwitch(lf);
		luc = null;
	}

	/**
	 * This top-level method calls the LimpUsageChecker class to verify that all assignable 
	 * variables (locals and outputs) are assigned in a LocalProcedure declaration. 
	 */
	@Check
	public void checkVariablesAreAssigned(LocalProcedure lp) {
		LimpUsageChecker luc = new LimpUsageChecker(this);
		luc.doSwitch(lp);
		luc = null;
	}
	
	/**
	 * This method validates that the variable assignments in a ForDeclaration only assign 
	 * the variable that is declared by the ForDeclaration.
	 * 
	 * For example, in the following scenario:
	 * 
	 * 	for(i : int=0; i<20; j=i+1) {
	 * 		...
	 * 	}
	 * 
	 * This validation would flag an error where "j" is assigned, as it was not declared
	 * by this for declaration.
	 */
	@Check
	public void checkForStatement(ForStatement fs) {
		Set<VariableRef> ids = new LinkedHashSet<>();
		ids.addAll(fs.getInitStatement().getIds().getIds());
		IdList idl = fs.getIncrementStatement().getIds();
		int i=0;
		for(VariableRef vr : idl.getIds()) {
			if(!ids.contains(vr)) {
				error("Only variables defined in this ForLoop are allowed by assigned here.", idl, LimpPackage.Literals.ID_LIST__IDS,i);
			}
			i++;
		}
	}
	
	/**
	 * This validation will limit what types of expressions appear in "DefineUseRefs" to 
	 * somewhat limit what could occur.
	 */
	@Check
	public void checkDefineUseReference(DefineUseRef ref) {
		GlobalDeclaration gd = LimpUtilities.getGlobalInDefineUseRef(ref);
		if(gd == null) {
			error("Define/Use statements may only be made over global variables", ref);
			return;
		}
	}
	
	/**
	 * Here we are validating that break statements occur within a loop.
	 */
	@Check
	public void checkBreakOccursWithinLoop(BreakStatement bs) {
		EObject highestContainer = this.getHighestContainer(bs);
		
		if(!(highestContainer instanceof WhileStatement || highestContainer instanceof ForStatement)) {
			error("Break statements must occur within a loop", bs);
		}
		return;
	}
	
	/**
	 * Here we are validating that continue statements occur within a loop.
	 */
	@Check
	public void checkContinueOccursWithinLoop(ContinueStatement cs) {
		EObject highestContainer = this.getHighestContainer(cs);
		
		if(!(highestContainer instanceof WhileStatement || highestContainer instanceof ForStatement)) {
			error("Continue statements must occur within a loop", cs);
		}
		return;
	}
	
	private EObject getHighestContainer(EObject object) {
		if (object instanceof BreakStatement) {
			BreakStatement bs = (BreakStatement) object;
			return getHighestContainer(bs.eContainer());
		} else if (object instanceof ContinueStatement) {
			ContinueStatement cs = (ContinueStatement) object;
			return getHighestContainer(cs.eContainer());
		} else if (object instanceof WhileStatement) {
			WhileStatement ws = (WhileStatement) object;
			return ws;
		} else if (object instanceof ForStatement) {
			ForStatement fs = (ForStatement) object;
			return fs;
		} else if (object instanceof StatementBlock) {
			StatementBlock sb = (StatementBlock) object;
			return getHighestContainer(sb.eContainer());
		} else if (object instanceof IfThenElseStatement) {
			IfThenElseStatement ites = (IfThenElseStatement) object;
			return getHighestContainer(ites.eContainer());
		} else if (object instanceof ElseBlock) {
			ElseBlock eb = (ElseBlock) object;
			return getHighestContainer(eb.eContainer());
		} else if (object instanceof ElseIf) {
			ElseIf elseIf = (ElseIf) object;
			return getHighestContainer(elseIf.eContainer());
		} 	else if (object instanceof Specification) {
			Specification specification = (Specification) object;
			return specification;
		} else if (object instanceof VoidStatement) {
			VoidStatement vs = (VoidStatement) object;
			return vs;
		} else if (object instanceof AssignmentStatement) {
			AssignmentStatement as = (AssignmentStatement) object;
			return as;
		} else if (object instanceof LocalProcedure) {
			LocalProcedure lp = (LocalProcedure) object;
			return lp;
		} else {
			return null;
		}
	}

	@Check
	public void typeCheckPrecondition(Precondition pc) {
		tc.doSwitch(pc);
	}
	
	@Check
	public void typeCheckPostcondition(Postcondition pc) {
		tc.doSwitch(pc);
	}
	
	/**
	 * Call type-checking on all of the statements in any statement block
	 */
	@Check
	public void typeCheckStatement(Statement statement) {
		tc.doSwitch(statement);
	}
	
	/**
	 * Call type-checking on all of the equations in any equation block
	 */
	@Check
	public void typeCheckEquation(Equation equation) {
		tc.doSwitch(equation);
	}
	
	/**
	 * A method to call the provided Validation error function with a shortened argument list
	 */
	public void error(String message, EObject e) {
		error(message, e, null, 0);
	}

	/**
	 * A method to provide to the Type and Usage checkers.
	 */
	@Override
	public void error(String message, EObject source, EStructuralFeature feature) {
		super.error(message, source, feature);
	}

	/**
	 * A method to provide to the Type and Usage checkers.
	 */
	@Override
	public void error(String message, EObject source, EStructuralFeature feature, int index) {
		super.error(message, source, feature, index);
	}
	
	/**
	 * A method to call the provided Validation warning function with a shortened argument list
	 */
	public void warning(String message, EObject e) {
		warning(message, e, null, 0);
	}
}
