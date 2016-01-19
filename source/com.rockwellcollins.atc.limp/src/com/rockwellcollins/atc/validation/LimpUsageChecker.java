package com.rockwellcollins.atc.validation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.ElseBlock;
import com.rockwellcollins.atc.limp.ElseIf;
import com.rockwellcollins.atc.limp.Equation;
import com.rockwellcollins.atc.limp.EquationBlock;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.ForStatement;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.InitExpr;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.NoElse;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.SomeVarBlock;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.UnaryMinusExpr;
import com.rockwellcollins.atc.limp.UnaryNegationExpr;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.WhileStatement;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 * LimpUsageChecker checks Limp objects and throws errors and warnings when variables aren't
 * assigned or used correctly. 
 */
public class LimpUsageChecker extends LimpSwitch<Void> {
	
	private LimpJavaValidator v;
	
	private Stack<Expr> expr_stack;
	
	private Set<InputArg> inputs_defined;
	private Set<InputArg> inputs_accessed;
	
	private Set<LocalArg> locals_defined;
	private Set<OutputArg> outputs_defined;

	private Set<LocalArg> locals_written;
	private Set<OutputArg> outputs_written;
	
	private Declaration context;
	
	public LimpUsageChecker(LimpJavaValidator ljv) {
		v = ljv;
		expr_stack = new Stack<Expr>();
		inputs_defined = new HashSet<>();
		inputs_accessed = new HashSet<>();
		locals_defined = new HashSet<>();
		outputs_defined = new HashSet<>();
		locals_written = new HashSet<>();
		outputs_written = new HashSet<>();
	}
	
	private void error(String msg, EObject obj) {
		if(this != null) {
			v.error(msg, obj);
		}
	}
	
	private void error(String message, EObject source, EStructuralFeature feature, int index) {
		v.error(message, source, feature, index);
	}
	
	private void warning(String msg, EObject obj) {
		if(this != null) {
			v.warning(msg, obj);
		}
	}
	
	@Override
	public Void caseLocalFunction(LocalFunction lf) {
		context = lf;
		
		//get sets for the defines
		for(InputArg ia : lf.getInputs().getInputArgs()) {
			doSwitch(ia);
		}
		doSwitch(lf.getVarBlock());
		doSwitch(lf.getOutput());
		
		//get the use sets
		doSwitch(lf.getEquationBlock());
		
		Iterator<InputArg> iit = inputs_defined.iterator();
		while(iit.hasNext()) {
			InputArg iarg = iit.next();
			if(!inputs_accessed.contains(iarg)) {
				warning("Input " + iarg.getName() + " is never read.", iarg);
			}
		}
		
		//check the use set and defined sets
		Iterator<LocalArg> lit = locals_defined.iterator();
		while(lit.hasNext()) {
			LocalArg larg = lit.next();
			if(!locals_written.contains(larg)) {
				warning("Local " + larg.getName() + " must be assigned.", larg);
			}
		}
		
		Iterator<OutputArg> oit = outputs_defined.iterator();
		while(oit.hasNext()) {
			OutputArg oarg = oit.next();
			if(!outputs_written.contains(oarg)) {
				error("Output " + oarg.getName() + " must be assigned.", oarg);
			}
		}
		return null;
	}
	
	@Override
	public Void caseLocalProcedure(LocalProcedure lp) {
		context = lp;
		//get sets for the defines
		for(InputArg ia : lp.getInputs().getInputArgs()) {
			this.doSwitch(ia);
		}
		doSwitch(lp.getVarBlock());
		for(OutputArg oa : lp.getOutputs().getOutputArgs()) {
			this.doSwitch(oa);
		}
		
		//get the use sets
		this.doSwitch(lp.getStatementblock());		
		//check the use set and defined sets
		
		for(InputArg iarg : inputs_defined) {
			if(!inputs_accessed.contains(iarg)) {
				warning("Input " + iarg.getName() + " is never read.", iarg);
			}
		}
		
		for(LocalArg larg : locals_defined) {
			if(!locals_written.contains(larg)) {
				warning("Local " + larg.getName() + " must be assigned.", larg);
			}
		}
		
		for(OutputArg oarg : outputs_defined) {
			if(!outputs_written.contains(oarg)) {
				error("Output " + oarg.getName() + " must be assigned.", oarg);
			}
		}
		return null;		
	}
	
	@Override
	public Void caseSomeVarBlock(SomeVarBlock svb) {
  		for(LocalArg la : svb.getLocals()) {
			doSwitch(la);
		}
		return null;
	}
	
	@Override
	public Void caseInputArg(InputArg ia) {
		inputs_defined.add(ia);
		return null;
	}
	
	@Override
	public Void caseLocalArg(LocalArg la) {
		locals_defined.add(la);
		return null;
	}

	@Override
	public Void caseOutputArg(OutputArg oa) {
		outputs_defined.add(oa);
		return null;
	}
	
	@Override
	public Void caseEquationBlock(EquationBlock eb) {
		for(Equation eq : eb.getEquations()) {
			doSwitch(eq);
		}
		return null;
	}
	
	@Override
	public Void caseStatementBlock(StatementBlock sb) {
		for(Statement s : sb.getStatements()) {
			doSwitch(s);
		}
		return null;
	}
	
	@Override
	public Void caseIfThenElseStatement(IfThenElseStatement ites) {
		doSwitch(ites.getCond());
		doSwitch(ites.getThenBlock());
		doSwitch(ites.getElse());
		return null;
	}
	
	@Override
	public Void caseElseBlock(ElseBlock eb) {
		doSwitch(eb.getBlock());
		return null;
	}
	
	@Override
	public Void caseElseIf(ElseIf ei) {
		doSwitch(ei.getIfThenElse());
		return null;
	}
	
	@Override
	public Void caseNoElse(NoElse ne) {
		return null;
	}
	
	@Override
	public Void caseWhileStatement(WhileStatement ws) {
		doSwitch(ws.getCond());
		doSwitch(ws.getBlock());
		return null;
	}
	
	@Override
	public Void caseForStatement(ForStatement fs) {
		doSwitch(fs.getInitStatement());
		doSwitch(fs.getIncrementStatement());
		doSwitch(fs.getBlock());
		return null;
	}
	
	@Override
	public Void caseVoidStatement(VoidStatement vs) {
		doSwitch(vs.getExpr());
		return null;
	}
	
	@Override
	public Void caseAssignmentStatement(AssignmentStatement as) {		
		assert (context != null);
		doSwitch(as.getIds());
		doSwitch(as.getRhs());
		return null;
	}
	
	@Override
	public Void caseIfThenElseExpr(IfThenElseExpr ite) {
		expr_stack.push(ite);
		doSwitch(ite.getCondExpr());
		doSwitch(ite.getThenExpr());
		doSwitch(ite.getElseExpr());
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseBinaryExpr(BinaryExpr be) {
		expr_stack.push(be);
		doSwitch(be.getLeft());
		doSwitch(be.getRight());
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseUnaryNegationExpr(UnaryNegationExpr une) {
		expr_stack.push(une);
		doSwitch(une.getExpr());
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseUnaryMinusExpr(UnaryMinusExpr ume) {
		expr_stack.push(ume);
		doSwitch(ume.getExpr());
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseArrayAccessExpr(ArrayAccessExpr aae) {
		expr_stack.push(aae);
		doSwitch(aae.getArray());
		doSwitch(aae.getIndex());
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseRecordAccessExpr(RecordAccessExpr rae) {
		expr_stack.push(rae);
		doSwitch(rae.getRecord());
		expr_stack.pop();
		return null;
	}

	@Override
	public Void caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		expr_stack.push(aue);
		doSwitch(aue.getAccess());
		doSwitch(aue.getValue());
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseRecordUpdateExpr(RecordUpdateExpr rue) {
		expr_stack.push(rue);
		doSwitch(rue.getRecord());
		doSwitch(rue.getValue());
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseArrayExpr(ArrayExpr ae) {
		expr_stack.push(ae);
		for(Expr e : ae.getExprList()) {
			doSwitch(e);
		}
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseRecordExpr(RecordExpr re) {
		expr_stack.push(re);
		for(RecordFieldExpr fe : re.getFieldExprList()) {
			doSwitch(fe.getFieldExpr());
		}
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseIdExpr(IdExpr ide) {
		expr_stack.push(ide);
		if(ide.getId() instanceof InputArg) {
			InputArg iarg = (InputArg) ide.getId();
			inputs_accessed.add(iarg);
		}
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseInitExpr(InitExpr ie) {
		expr_stack.push(ie);
		if(ie.getId() instanceof InputArg) {
			InputArg iarg = (InputArg) ie.getId();
			inputs_accessed.add(iarg);
		}
		expr_stack.pop();
		return null;
	}
	
	
	@Override
	public Void caseFcnCallExpr(FcnCallExpr fce) {
		if(fce.getId() instanceof LocalProcedure || fce.getId() instanceof ExternalProcedure) {
			if(!expr_stack.isEmpty()) {
				error("Procedure calls cannot be contained inside of another expression.",fce);
			}
		}
		
		expr_stack.push(fce);
		for(Expr e : fce.getExprs().getExprList()) {
			doSwitch(e);
		}
		expr_stack.pop();
		return null;
	}
	
	@Override
	public Void caseIdList(IdList idl) {
		int i=0;
		for(VariableRef vr : idl.getIds()) {
			if (vr instanceof LocalArg) {
				LocalArg larg = (LocalArg) vr;
				if(locals_written.contains(larg) && context instanceof LocalFunction) {
					error("Local " + larg.getName() + " is written more than once.", idl, LimpPackage.Literals.ID_LIST__IDS, i);
				} else {
					locals_written.add(larg);	
				}
			}
			
			if (vr instanceof OutputArg) {
				OutputArg oarg = (OutputArg) vr;
				if(outputs_written.contains(oarg) && context instanceof LocalFunction) {
					error("Output " + oarg.getName() + " is written more than once.", idl, LimpPackage.Literals.ID_LIST__IDS, i);
				} else {
					outputs_written.add(oarg);
				}
			}
			i++;
		}
		return null;
	}
}
