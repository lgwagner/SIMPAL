package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.util.ArrayList;
import java.util.List;

import jkind.lustre.Expr;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.Equation;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.exceptions.UnsupportedException;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.GetVariableName;

/**
 * LimpStatementToLustreEquation translates all of the LimpStatements to Lustre Equations.
 * 
 * This only supports
 *  - AssignmentStatement
 *  - VoidStatement
 *  
 * This should only be used after ControlFlow is removed by the 
 * RemoveControlFlow transformation.
 */
public class LimpStatementToLustreEquation extends LimpSwitch<jkind.lustre.Equation> {
	
	public static jkind.lustre.Equation translate(Statement s) {
		LimpStatementToLustreEquation statementToEquation = new LimpStatementToLustreEquation();
		jkind.lustre.Equation eq = statementToEquation.doSwitch(s);
		return eq;
	}
	
	public static jkind.lustre.Equation translate(Equation eq) {
		return new LimpStatementToLustreEquation().doSwitch(eq);
	}
	
	public List<jkind.lustre.IdExpr> getAssignmentLHS(AssignmentStatement as) {
		List<jkind.lustre.IdExpr> lhs = new ArrayList<>();
		for(VariableRef vr : as.getIds().getIds()) {
			lhs.add(new jkind.lustre.IdExpr(GetVariableName.getName(vr)));
		}
		return lhs;
	}
	
	@Override
	public jkind.lustre.Equation caseAssignmentStatement(AssignmentStatement as) {
		return new jkind.lustre.Equation(getAssignmentLHS(as), LimpExprToLustreExpr.translate(as.getRhs()));
	}
	
	@Override
	public jkind.lustre.Equation caseVoidStatement(VoidStatement vs) {
		List<jkind.lustre.IdExpr>lhs = new ArrayList<>();
		Expr e = LimpExprToLustreExpr.translate(vs.getExpr());
		return new jkind.lustre.Equation(lhs, e);
	}
	
	@Override
	public jkind.lustre.Equation defaultCase(EObject e) {
		throw new UnsupportedException("Statement not supported.");
	}
}
