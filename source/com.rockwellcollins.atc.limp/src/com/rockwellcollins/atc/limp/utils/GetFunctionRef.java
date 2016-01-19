package com.rockwellcollins.atc.limp.utils;

/*
 *  The switch defined here returns the Id of a function call expression, which may be 
 *  inside an assignment statement or void statement.
 */

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.FunctionRef;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

public class GetFunctionRef extends LimpSwitch<FunctionRef> {

	@Override
	public FunctionRef caseAssignmentStatement(AssignmentStatement as) {
		return this.doSwitch(as.getRhs());
	}
	
	@Override
	public FunctionRef caseVoidStatement(VoidStatement vs) {
		return this.doSwitch(vs.getExpr());
	}
	
	@Override
	public FunctionRef caseFcnCallExpr(FcnCallExpr fce) {
		return fce.getId();
	}
	
	@Override
	public FunctionRef defaultCase(EObject eo) {
		return null;
	}
}
