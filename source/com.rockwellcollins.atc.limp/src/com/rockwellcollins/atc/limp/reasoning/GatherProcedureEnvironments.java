package com.rockwellcollins.atc.limp.reasoning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.BooleanLiteralExpr;
import com.rockwellcollins.atc.limp.BreakStatement;
import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.ContinueStatement;
import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.ElseBlock;
import com.rockwellcollins.atc.limp.ElseIf;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.ForStatement;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.UnaryNegationExpr;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.WhileStatement;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.LimpAST;
import com.rockwellcollins.atc.limp.utils.SimplifyExpressions;
import com.rockwellcollins.atc.limp.utils.SerializerUtil;

public class GatherProcedureEnvironments extends LimpSwitch<Void> {

	LimpFactory f = LimpFactory.eINSTANCE;
	public List<GlobalDeclaration> globals;
	public List<Statement> statements;
	public List<VariableRef> modified_variable_refs_tmp;
	public List<RecordFieldExpr> record_field_exprs;
	public List<Expr> array_index_exprs;

	ModifiedGlobalsList mgl = new ModifiedGlobalsList();
	ModifiedGlobalsList mglfields = new ModifiedGlobalsList();
	ModifiedGlobalsList mglindices = new ModifiedGlobalsList();
	ProcedureEnvironmentList pel = new ProcedureEnvironmentList();
	
	public ProcedureEnvironmentList getProcedureEnvironmentList() {
		return pel;
	}

	public ModifiedGlobalsList getModifiedGlobalsList() {
		return mgl;
	}
	
	public ModifiedGlobalsList getModifiedGlobalsListwFields() {
		return mglfields;
	}
	
	public ModifiedGlobalsList getModifiedGlobalsListwIndices() {
		return mglindices;
	}
	
	public String indexToString(Expr e) {
		if (e instanceof IntegerLiteralExpr) {
			return SerializerUtil.EObjectToString(e);
		} else if (e instanceof IdExpr) {
			IdExpr ie = (IdExpr) e;
			if (ie.getId() instanceof InputArg) {
				return SerializerUtil.EObjectToString(e);
			} else if (ie.getId() instanceof ConstantDeclaration) {
				return SerializerUtil.EObjectToString(e);
			} else {
				return "";
			}
		} else {
			List<IdExpr> ids = EcoreUtil2.getAllContentsOfType(e, IdExpr.class);
			boolean useful_index = true;
			for (IdExpr id : ids) {
				if ((id.getId() instanceof ConstantDeclaration) || (id.getId() instanceof InputArg)) {
					//do nothing
				} else {
					useful_index = false;
				}						
			}
			if ((useful_index == true) && !(ids.isEmpty())) {
				return SerializerUtil.EObjectToString(e);
			} else {
				return "";
			}
		}
	}
	
	public void updateProcedureVariableStateWithSubst (LocalProcedure lp, VariableRef variable, Expr value) {
	// If the local procedure is in the list, replace all occurrences of IdExpr in value with their values in the program environment corresponding to lp.
		if (pel.containsLocalProcedure(lp)) {
			Map<VariableRef,Expr> pvsMap = pel.getProgramEnvironment(lp);
			SubForIds sfi = new SubForIds(pvsMap);
			sfi.doSwitch(value);
		} 
		//Add the (variable, value) pair to a a (potentially new) program environment in a (potentially new) procedure environment for lp in the list pel
		SimplifyExpressions se = new SimplifyExpressions();
		Expr e = (Expr) se.doSwitch(value);
		pel.updateProcedureVariableState(lp, variable, e);
	}
	
	public Expr substituteAndSimplify (LocalProcedure lp, Expr value) {
		// If the local procedure is in the list, replace all occurrences of IdExpr in value with their values in the program environment corresponding to lp.
			if (pel.containsLocalProcedure(lp)) {
				Map<VariableRef,Expr> pvsMap = pel.getProgramEnvironment(lp);
				SubForIds sfi = new SubForIds(pvsMap);
				value = (Expr) sfi.doSwitch(value);
			} 
			//Simplify
			SimplifyExpressions se = new SimplifyExpressions();
			Expr e = (Expr) se.doSwitch(value);
			return e;
		}
		
	public Expr simplifyExpression (Expr value) {	
		//Simplify
		SimplifyExpressions se = new SimplifyExpressions();
		Expr e = (Expr) se.doSwitch(value);
		return e;
	}
	
	@Override
	public Void caseSpecification(Specification s) {
		globals = new ArrayList<>();
		statements = new ArrayList<>();
		modified_variable_refs_tmp = new ArrayList<>();
		record_field_exprs = new ArrayList<>();
		array_index_exprs = new ArrayList<>();
		
		List<Declaration> decls = s.getDeclarations();
		for(Declaration d : decls) {
			this.doSwitch(d);
		}			

		return null;
	}
	
	@Override
	public Void caseGlobalDeclaration(GlobalDeclaration gd) {
		globals.add(gd);
		return null;
	}
	
	@Override
	public Void caseLocalProcedure(LocalProcedure lp) {
		statements.clear();
		statements.addAll(lp.getStatementblock().getStatements());
		
		for (Statement s : statements) {
			this.doSwitch(s);
		}
		return null;
	}
	 
	@Override
	public Void caseIfThenElseStatement(IfThenElseStatement ifes) {
		LocalProcedure mylp = ((LocalProcedure) ifes.eContainer().eContainer());
		conditionalIfThenElseStatement(mylp, LimpAST.trueLiteral(), ifes);
		return null;
	}
	
	public Void conditionalIfThenElseStatement(LocalProcedure lp, Expr condition, IfThenElseStatement ifes) {
		// Note: The input condition has already been substituted into by the
		// calling method (typically, conditionalIfThenElseStatement)

		// TODO: Add check for whether then or else branch is always true (given
		// the current program condition). Then the early checking on condition
		// could be removed (superseded by checking simplified binary condition)

		// TODO: The early checking for the input condition being true could be
		// replaced by simplification on the binary expression
		// (just and in the true or false and simplify later)

		// Create the conditions for the then and else branches
		Expr thencond = f.createExpr();
		Expr elsecond = f.createExpr();
		if (condition instanceof BooleanLiteralExpr) {
			BooleanLiteralExpr ble = (BooleanLiteralExpr) condition;
			if (ble.getBoolVal().equals("true")) {
				thencond = EcoreUtil2.copy(ifes.getCond());
				thencond = substituteAndSimplify(lp, thencond);

				UnaryNegationExpr mynegcond = f.createUnaryNegationExpr();
				mynegcond.setExpr(EcoreUtil2.copy(ifes.getCond()));
				elsecond = mynegcond;
				elsecond = substituteAndSimplify(lp, elsecond);
			} else {
				// otherwise condition is identically false
				// do nothing for this ifes
				// thencond = LimpUtilities.falseBooleanLiteral();
				// elsecond = LimpUtilities.falseBooleanLiteral();
				return null;
			}
		} else {
			BinaryExpr thenbincond = f.createBinaryExpr();
			//The input condition has already been substituted into
			thenbincond.setLeft(EcoreUtil2.copy(condition));
			thenbincond.setOp("and");
			thenbincond.setRight(substituteAndSimplify(lp, EcoreUtil2.copy(ifes.getCond())));
			thencond = simplifyExpression(thenbincond);
			
			UnaryNegationExpr mynegcond = f.createUnaryNegationExpr();
			mynegcond.setExpr(EcoreUtil2.copy(ifes.getCond()));
			BinaryExpr elsebincond = f.createBinaryExpr();
			//The input condition has already been substituted into
			elsebincond.setLeft(EcoreUtil2.copy(condition));
			elsebincond.setOp("and");
			elsebincond.setRight(substituteAndSimplify(lp, EcoreUtil2.copy(mynegcond)));
			elsecond = simplifyExpression(elsebincond);
		}
		
		for (Statement s : ifes.getThenBlock().getStatements()) {
			if (s instanceof AssignmentStatement) {
				AssignmentStatement as = (AssignmentStatement) s;
				conditionalAssignmentStatement(lp, EcoreUtil.copy(thencond), as);
			} else if (s instanceof IfThenElseStatement) {
				IfThenElseStatement thenifes = (IfThenElseStatement) s;
				conditionalIfThenElseStatement(lp, thencond, thenifes);
			} else{ //Skip symbolic execution and just collect the list of modified globals
				gatherModifiedGlobals(lp, s);
			}
		} 	
		
		// Simple else block (just a statement block)
		if (ifes.getElse() instanceof ElseBlock) {
			ElseBlock elseblk = (ElseBlock) ifes.getElse();
			StatementBlock stmtblk = elseblk.getBlock();
			for (Statement s : stmtblk.getStatements()) {
				if (s instanceof AssignmentStatement) {
					AssignmentStatement as = (AssignmentStatement) s;
					conditionalAssignmentStatement(lp, elsecond, as);
				} else if (s instanceof IfThenElseStatement) {
					IfThenElseStatement elseifes = (IfThenElseStatement) s;
					conditionalIfThenElseStatement(lp, elsecond, elseifes);
				} else{ //Skip symbolic execution and just collect the list of modified globals
					gatherModifiedGlobals(lp, s);
				}
			}
		} else if (ifes.getElse() instanceof ElseIf) {
			ElseIf elseif = (ElseIf) ifes.getElse();
			IfThenElseStatement elseifstmt = (IfThenElseStatement) elseif.getIfThenElse();
			conditionalIfThenElseStatement(lp, elsecond, elseifstmt);
		}
		// else (case of NoElse) do nothing
		return null;			
	}

	public Expr createExprForGather(LocalProcedure lp, Expr condition, Expr thenExpr, VariableRef vref) {
		
		IdExpr myidexpr = f.createIdExpr();
		myidexpr.setId(vref);
		
		if (condition instanceof BooleanLiteralExpr) {
			BooleanLiteralExpr ble = (BooleanLiteralExpr) condition;
			if (ble.getBoolVal().equals("true")) {
				return substituteAndSimplify(lp, thenExpr);
			} else { // Condition is false. Return the current value of the variable.
				return substituteAndSimplify(lp, myidexpr); //I could just substitute here
			}
			
		} else {
			//Create IfThenElseExpr for vref
			IfThenElseExpr myexpr = f.createIfThenElseExpr();
			//Set the condition. Note the condition has already been substituted into.
			myexpr.setCondExpr(EcoreUtil2.copy(condition));
			//Set the else expression as the current value of the variable.
			myexpr.setElseExpr(substituteAndSimplify(lp, myidexpr));
			//Set then expression
			myexpr.setThenExpr(substituteAndSimplify(lp, EcoreUtil2.copy(thenExpr)));
			return simplifyExpression(myexpr);
		}
	}

	public Void conditionalAssignmentStatement(LocalProcedure lp, Expr condition, AssignmentStatement as) {
		//Note: The condition has already been substituted into and simplified by the calling method (typically, conditionalIfThenElseStatement)
		//TODO(?): Do nothing if condition is identically false. 
		//TODO: RHS of as could be an external procedure that modifies some globals. I need to take that into account. Maybe add a warning for now...	
						
		modified_variable_refs_tmp.clear();
		modified_variable_refs_tmp.addAll(as.getIds().getIds());
									
		for (VariableRef vref : modified_variable_refs_tmp) {
			if (vref instanceof GlobalDeclaration) {
				GlobalDeclaration mygd = (GlobalDeclaration) vref;
				mgl.addGlobal(lp, mygd);
			}
			Expr myexpr = createExprForGather(lp, EcoreUtil.copy(condition), EcoreUtil.copy(as.getRhs()), vref);
			pel.updateProcedureVariableState(lp, vref, myexpr);
		}		
		return null;
	}
	
	@Override
	public Void caseAssignmentStatement(AssignmentStatement as) {
		
		LocalProcedure mylp = ((LocalProcedure) as.eContainer().eContainer()); 
		conditionalAssignmentStatement(mylp, LimpAST.trueLiteral(), as);
		return null;
	}
	
	public Void gatherModifiedGlobals(LocalProcedure lp, Statement s) {
		if (s instanceof AssignmentStatement) {
			AssignmentStatement as = (AssignmentStatement) s;
			modified_variable_refs_tmp.clear();
			modified_variable_refs_tmp.addAll(as.getIds().getIds());
			for (VariableRef vref : modified_variable_refs_tmp) {
				if (vref instanceof GlobalDeclaration) {
					GlobalDeclaration mygd = (GlobalDeclaration) vref;
					//TO DO (?): Do I want to skip this if the condition is false?
					mgl.addGlobal(lp, mygd);			
				}
			}
		} else if (s instanceof IfThenElseStatement) {
			IfThenElseStatement ifes = (IfThenElseStatement) s;
			for (Statement stmt : ifes.getThenBlock().getStatements()) {
				gatherModifiedGlobals(lp, stmt);
			} 	
			// Simple else block (just a statement block)
			if (ifes.getElse() instanceof ElseBlock) {
				ElseBlock elseblk = (ElseBlock) ifes.getElse();
				StatementBlock stmtblk = elseblk.getBlock();
				for (Statement stmt : stmtblk.getStatements()) {
					gatherModifiedGlobals(lp, stmt);
				}
			// ElseIf
			} else if (ifes.getElse() instanceof ElseIf) {
				ElseIf elseif = (ElseIf) ifes.getElse();
				IfThenElseStatement elseifstmt = (IfThenElseStatement) elseif.getIfThenElse();
				gatherModifiedGlobals(lp, elseifstmt);
			}
			// else (case of NoElse) do nothing				
		} else if (s instanceof WhileStatement) {
			WhileStatement ws = (WhileStatement) s;
			System.out.println("WARNING! WhileStatement encountered. While statements are skipped in symbolic execution (SE), so SE results might not be accurate.");
			for (Statement stmt: ws.getBlock().getStatements()) {
				gatherModifiedGlobals(lp, stmt);
			}
		} else if (s instanceof ForStatement) {
			System.out.println("WARNING! ForStatement encountered. For statements are skipped in symbolic execution (SE), so SE results might not be accurate.");
			for (Statement stmt : ((ForStatement) s).getBlock().getStatements()) {
				gatherModifiedGlobals(lp, stmt);
			}
		} else {//else do nothing (BreakStatement, ContinueStatement, VoidStatement)
			System.out.println("WARNING! Unsupported statement encountered. Unsupported statements are skipped in symbolic execution (SE), so SE results might not be accurate.");
		}
		return null;
	}
	
	@Override
	public Void caseVoidStatement(VoidStatement vs) {
		//TO DO: A void statement can modify globals. I need to take that into account.
		//For now, do nothing here.
		System.out.println("WARNING! VoidStatement encountered. Void statements are skipped in symbolic execution (SE), so SE results might not be accurate.");
		return null;
	}
	
	@Override
	public Void caseWhileStatement(WhileStatement ws) {
		LocalProcedure mylp = ((LocalProcedure) ws.eContainer().eContainer()); 
		for (Statement s : ws.getBlock().getStatements()) {
			gatherModifiedGlobals(mylp, s);
		}
		System.out.println("WARNING! WhileStatement encountered. While statements are skipped in symbolic execution (SE), so SE results might not be accurate.");
		//throw new IllegalArgumentException("While statements are not yet supported by symbolic execution");
		return null;
	}
	
	@Override
	public Void caseForStatement(ForStatement fs) {
		LocalProcedure mylp = ((LocalProcedure) fs.eContainer().eContainer()); 
		for (Statement s : fs.getBlock().getStatements()) {
			gatherModifiedGlobals(mylp, s);
		}
		System.out.println("WARNING! ForStatement encountered. For statements are skipped in symbolic execution (SE), so SE results might not be accurate.");
	//	throw new IllegalArgumentException("For statements are not yet supported by symbolic execution");
		return null;
	}
	
	@Override
	public Void caseBreakStatement(BreakStatement bs) {
		System.out.println("WARNING! BreakStatement encountered. Break statements are skipped in symbolic execution (SE), so SE results might not be accurate.");
		//throw new IllegalArgumentException("Break statements are not yet supported by symbolic execution");
		return null;
	}
	
	@Override
	public Void caseContinueStatement(ContinueStatement cs) {
		System.out.println("WARNING! ContinueStatement encountered. Continue statements are skipped in symbolic execution (SE), so SE results might not be accurate.");
		//throw new IllegalArgumentException("Continue statements are not yet supported by symbolic execution");
		return null;
	}
		
	@Override
	public Void defaultCase(EObject eo) {
		return null;
	}
}
