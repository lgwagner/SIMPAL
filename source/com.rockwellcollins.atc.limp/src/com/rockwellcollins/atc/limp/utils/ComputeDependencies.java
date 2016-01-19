package com.rockwellcollins.atc.limp.utils;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.Attribute;
import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.Define;
import com.rockwellcollins.atc.limp.DefineUseRef;
import com.rockwellcollins.atc.limp.ElseBlock;
import com.rockwellcollins.atc.limp.ElseIf;
import com.rockwellcollins.atc.limp.Equation;
import com.rockwellcollins.atc.limp.EquationBlock;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.ExprList;
import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.ForStatement;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.GotoStatement;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.InputArgList;
import com.rockwellcollins.atc.limp.LabelStatement;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.NoElse;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.OutputArgList;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.SomeAttributeBlock;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.UnaryMinusExpr;
import com.rockwellcollins.atc.limp.UnaryNegationExpr;
import com.rockwellcollins.atc.limp.Uses;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.WhileStatement;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 * This class will compute the variables read and written by the various
 * Limp constructs.  It is useful for performing validations, and processing
 * by both the Limp2ACL2 and Limp2Lustre tools.
 * 
 * We use a conservative approximation for ExternalProcedures and ExternalFunctions,
 * meaning we assume it reads and writes all of the variables defined in its interface. 
 * The major reason this class exists is to provide validation for unread/unwritten variables.
  */
public class ComputeDependencies extends LimpSwitch<LimpDependency> {

	public static LimpDependency compute(EObject e) {
		return new ComputeDependencies().doSwitch(e);
	}
	
	/**
	 * This will return all the variables read and written by a LocalProcedure
	 */
	@Override
	public LimpDependency caseLocalProcedure(LocalProcedure lp) {
		return doSwitch(lp.getStatementblock());
	}
	
	/**
	 * This will return all the variables read and written by a LocalFunction
	 */
	@Override
	public LimpDependency caseLocalFunction(LocalFunction lf) {
		return doSwitch(lf.getEquationBlock());
	}
	
	/**
	 * An external procedure is assumed to read every input and write
	 * every output, read every global it declares as used, and write
	 * every global it declares as read.
	 */
	@Override
	public LimpDependency caseExternalProcedure(ExternalProcedure ep) {
		LimpDependency inDeps = doSwitch(ep.getInputs());
		LimpDependency outDeps = doSwitch(ep.getOutputs());
		LimpDependency attributeDeps = doSwitch(ep.getAttributeBlock());
		return LimpDependency.merge(inDeps, LimpDependency.merge(outDeps, attributeDeps));
	}
	
	/**
	 * An external function will read every input, and write every output
	 * that is declared.
	 */
	@Override
	public LimpDependency caseExternalFunction(ExternalFunction ef) {
		LimpDependency inDeps = doSwitch(ef.getInputs());
		LimpDependency outDeps = doSwitch(ef.getOutput());
		return LimpDependency.merge(inDeps,outDeps);
	}
	
	@Override
	public LimpDependency caseStatementBlock(StatementBlock sb) {
		LimpDependency d = new LimpDependency();
		for(Statement s : sb.getStatements()) {
			d = LimpDependency.merge(d, doSwitch(s));
		}
		return d;
	}
	
	@Override
	public LimpDependency caseEquationBlock(EquationBlock eb) {
		LimpDependency d = new LimpDependency();
		for(Equation eq : eb.getEquations()) {
			d = LimpDependency.merge(d, doSwitch(eq));
		}
		return d;
	}

	/**
	 * The left hand side of an assignment statement will be considered written,
	 * and any IdExprs contained in the right hand side will be considered 
	 */
	@Override
	public LimpDependency caseAssignmentStatement(AssignmentStatement as) {
		LimpDependency id = doSwitch(as.getIds());
		LimpDependency ex = doSwitch(as.getRhs());
		return LimpDependency.merge(id,ex);
	}
	
	@Override
	public LimpDependency caseVoidStatement(VoidStatement vs) {
		LimpDependency d = doSwitch(vs.getExpr());
		return d;
	}

	/**
	 * This will return all the variables read and written by an IfThenElseStatement.
	 */
	@Override
	public LimpDependency caseIfThenElseStatement(IfThenElseStatement ites) {
		LimpDependency testVd = doSwitch(ites.getCond());
		LimpDependency thenVd = doSwitch(ites.getThenBlock());
		LimpDependency elseVd = doSwitch(ites.getElse());
		return LimpDependency.merge(testVd, LimpDependency.merge(thenVd, elseVd));
	}

	/**
	 * This will capture all of the variables read and written by an ElseBlock.
	 */
	@Override
	public LimpDependency caseElseBlock(ElseBlock eb) {
		return doSwitch(eb.getBlock());
	}
	
	/**
	 * This will capture all of the variables read and written by an ElseIf block.
	 */
	@Override
	public LimpDependency caseElseIf(ElseIf ei) {
		return doSwitch(ei.getIfThenElse());
	}
	
	/**
	 * This will capture all of the variables read and written by a NoElse block
	 */
	@Override
	public LimpDependency caseNoElse(NoElse noelse) {
		LimpDependency empty = new LimpDependency();
		return empty;
	}
	
	/**
	 * This will return all the variables read and written by an WhileStatement.
	 */
	@Override
	public LimpDependency caseWhileStatement(WhileStatement ws) {
		LimpDependency testVd = doSwitch(ws.getCond());
		LimpDependency blockVd = doSwitch(ws.getBlock());
		return LimpDependency.merge(testVd, blockVd);
	}
	
	/**
	 * This will return all the variables read and written by an ForStatement.
	 */
	@Override
	public LimpDependency caseForStatement(ForStatement fs) {
		LimpDependency init = doSwitch(fs.getInitStatement());
		LimpDependency limit = doSwitch(fs.getLimitExpr());
		LimpDependency increment = doSwitch(fs.getIncrementStatement());
		LimpDependency block = doSwitch(fs.getBlock());
		return LimpDependency.merge(init, LimpDependency.merge(limit, LimpDependency.merge(increment, block)));
	}
	
	@Override
	public LimpDependency caseGotoStatement(GotoStatement gs) {
		return new LimpDependency();
	}
	
	@Override
	public LimpDependency caseLabelStatement(LabelStatement gs) {
		return new LimpDependency();
	}
	
	/**
	 * This will return all the variables read and written by an IdList.
	 */
	@Override
	public LimpDependency caseIdList(IdList idl) {
		LimpDependency vd = new LimpDependency();
		for(VariableRef vr : idl.getIds()) {
			if(vr instanceof GlobalDeclaration) {
				GlobalDeclaration gd = (GlobalDeclaration) vr;
				vd.getWrittenGlobalVariables().add(gd);
			} else {
				vd.getWrittenVariables().add(vr);				
			}
		}
		return vd;
	}
	
	@Override
	public LimpDependency caseIfThenElseExpr(IfThenElseExpr ite) {
		LimpDependency testDep = doSwitch(ite.getCondExpr());
		LimpDependency thenDep = doSwitch(ite.getThenExpr());
		LimpDependency elseDep = doSwitch(ite.getElseExpr());
		return LimpDependency.merge(testDep, LimpDependency.merge(thenDep, elseDep));
	}
	
	/**
	 * This will return all the variables read and written by an BinaryExpr.
	 */
	@Override
	public LimpDependency caseBinaryExpr(BinaryExpr be) {
		LimpDependency lvd = doSwitch(be.getLeft());
		LimpDependency rvd = doSwitch(be.getRight());
		return LimpDependency.merge(lvd, rvd);
	}
	
	/**
	 * This will return all the variables read and written by an UnaryNegationExpr.
	 */
	@Override
	public LimpDependency caseUnaryNegationExpr(UnaryNegationExpr une) {
		return doSwitch(une.getExpr());
	}
	
	/**
	 * This will return all the variables read and written by an UnaryMinusExpr.
	 */
	@Override
	public LimpDependency caseUnaryMinusExpr(UnaryMinusExpr ume) {
		return doSwitch(ume.getExpr());
	}
	
	/**
	 * 
	 */
	@Override
	public LimpDependency caseRecordAccessExpr(RecordAccessExpr rae) {
		return doSwitch(rae.getRecord()); 
	}
	
	/**
	 * 
	 */
	@Override
	public LimpDependency caseRecordUpdateExpr(RecordUpdateExpr rue) {
		LimpDependency recordDep = doSwitch(rue.getRecord());
		LimpDependency valueDep = doSwitch(rue.getValue());
		return LimpDependency.merge(recordDep, valueDep);
	}
	
	@Override
	public LimpDependency caseArrayAccessExpr(ArrayAccessExpr aae) {
		LimpDependency arrayDep = doSwitch(aae.getArray());
		LimpDependency indexDep = doSwitch(aae.getIndex());
		return LimpDependency.merge(arrayDep, indexDep);
	}
	
	@Override
	public LimpDependency caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		LimpDependency access = doSwitch(aue.getAccess());
		LimpDependency value = doSwitch(aue.getValue());
		return LimpDependency.merge(access,value);
	}
	
	/**
	 * This will return all the variables read and written by an ArrayExpr.
	 */
	@Override
	public LimpDependency caseArrayExpr(ArrayExpr ae) {
		LimpDependency vd = new LimpDependency();
		for(Expr e : ae.getExprList()) {
			vd = LimpDependency.merge(vd, doSwitch(e));
		}
		return vd;
	}
	
	/**
	 * This will return all the variables read and written by a RecordExpr.
	 */
	@Override
	public LimpDependency caseRecordExpr(RecordExpr re) {
		LimpDependency vd = new LimpDependency();
		for(RecordFieldExpr fe : re.getFieldExprList()) {
			vd = LimpDependency.merge(vd, doSwitch(fe.getFieldExpr()));
		}
		return vd;
	}
	
	/**
	 * This will return all the variables read and written by an IdExpr.
	 */
	@Override
	public LimpDependency caseIdExpr(IdExpr ide) {
		LimpDependency vd = new LimpDependency();
		if (ide.getId() instanceof GlobalDeclaration) {
			GlobalDeclaration gd = (GlobalDeclaration) ide.getId();
			vd.getReadGlobalVariables().add(gd);
		} else {
			vd.getReadVariables().add(ide.getId());	
		}
		return vd;
	}
	
	/**
	 * This will return all the variables read and written by an FcnCallExpr.
	 */
	@Override
	public LimpDependency caseFcnCallExpr(FcnCallExpr fce) {
		//get the read and written globals of the function called
		LimpDependency fcnGlobals = LimpDependency.justGlobals(doSwitch(fce.getId()));
		LimpDependency fcnExprs = doSwitch(fce.getExprs());
		LimpDependency ld = new LimpDependency();
		ld.getCalledFunctions().add(fce.getId());
		return LimpDependency.merge(fcnGlobals, LimpDependency.merge(fcnExprs,ld));
	}
	
	/**
	 * This will return all the variables read and written by an ExprList.
	 */
	@Override
	public LimpDependency caseExprList(ExprList el) {
		LimpDependency vd = new LimpDependency();
		for(Expr e : el.getExprList()) {
			vd = LimpDependency.merge(vd, doSwitch(e));
		}
		return vd;
	}
	
	/**
	 * Returns a LimpDependency object that reports all of the input args
	 * as written variables. 
	 */
	@Override
	public LimpDependency caseInputArgList(InputArgList ial) {
		LimpDependency deps = new LimpDependency();
		for(InputArg iarg : ial.getInputArgs()) {
			deps.getReadVariables().add(iarg);
		}
		return deps;
	}
	
	/**
	 * Returns a LimpDependency object that reports all of the output args
	 * as read variables.
	 */
	@Override
	public LimpDependency caseOutputArgList(OutputArgList oal) {
		LimpDependency deps = new LimpDependency();
		for(OutputArg oarg : oal.getOutputArgs()) {
			deps.getWrittenVariables().add(oarg);
		}
		return deps;
	}
	
	@Override
	public LimpDependency caseOutputArg(OutputArg oarg) {
		LimpDependency deps = new LimpDependency();
		deps.getWrittenVariables().add(oarg);
		return deps;
	}
	
	/**
	 * Returns a LimpDependency object that reports all of the variables
	 * read or written in the attributes.
	 */
	@Override
	public LimpDependency caseSomeAttributeBlock(SomeAttributeBlock sab) {
		LimpDependency deps = new LimpDependency();
		for(Attribute a : sab.getAttributeList()) {
			deps = LimpDependency.merge(deps, doSwitch(a));
		}
		return deps;
	}
	
	/**
	 * Returns a LimpDependency object that reports all of the written globals.
	 */
	@Override
	public LimpDependency caseDefine(Define define) {
		LimpDependency deps = new LimpDependency();
		for(DefineUseRef ref : define.getElements()) {
			GlobalDeclaration gd = LimpUtilities.getGlobalInDefineUseRef(ref);
			if(gd != null) {
				deps.getWrittenGlobalVariables().add(gd);	
			}
		}
		return deps;
	}
	
	/**
	 * 
	 */
	@Override
	public LimpDependency caseUses(Uses uses) {
		LimpDependency deps = new LimpDependency();
		for(DefineUseRef ref : uses.getElements()) {
			GlobalDeclaration gd = LimpUtilities.getGlobalInDefineUseRef(ref);
			if(gd != null) {
				deps.getReadGlobalVariables().add(gd);	
			}
		}
		return deps;
	}
	
	/**
	 * This will return an empty LimpDependency if an unexpected construct is encountered.
	 */
	@Override
	public LimpDependency defaultCase(EObject e) {
		return new LimpDependency();
	}
}
