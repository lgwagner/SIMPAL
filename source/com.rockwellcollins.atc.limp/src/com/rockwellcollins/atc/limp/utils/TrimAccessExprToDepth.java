package com.rockwellcollins.atc.limp.utils;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.util.LimpSwitch;


// This class uses a visitor to trim an Access Expr to the specified depth.
// The depth is the number of accesses in the expression.
// The result of trimExpr(a[i].joe[j][k], 2) is a[i].joe.

public class TrimAccessExprToDepth extends LimpSwitch<Expr> {

	private static int depth;

	private TrimAccessExprToDepth() {
		//We don't want anyone to create this object but rather to use the trimExpr method.
	}
	
	public static Expr trimExpr(Expr e, int d) {
		depth = d;
		return new TrimAccessExprToDepth().doSwitch(e);
	}
	
	@Override
	public Expr caseArrayAccessExpr(ArrayAccessExpr e) {
		if (DepthOfExpr.getDepth(e)==depth) {
			return e;
		}
		return doSwitch(e.getArray());
	}
	
	@Override
	public Expr caseRecordAccessExpr(RecordAccessExpr e) {
		if (DepthOfExpr.getDepth(e)==depth) {
			return e;
		}
		return doSwitch(e.getRecord());
	}
	
	@Override
	public Expr defaultCase(EObject e) {
		throw new IllegalArgumentException("Input must be a access expr of the specified depth!");
	}
	
}
