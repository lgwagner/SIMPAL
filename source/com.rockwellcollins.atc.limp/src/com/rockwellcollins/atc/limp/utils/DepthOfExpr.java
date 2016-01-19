package com.rockwellcollins.atc.limp.utils;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.util.LimpSwitch;


// This class uses a visitor to compute the depth of an Expr.
// The depth is the number of accesses in the expression.
// For example, the depth of a[i].joe[j] is 3.
// The depth of a[i].joe[j][k] is 4.
// The depth of i is 0.
// The depth of a[i] + b[j] is 0 (since it is a BinaryrExpr and not a ArrayAccessExpr or RecordAccessExpr).

public class DepthOfExpr extends LimpSwitch<Integer> {
	

	private DepthOfExpr() {
		//We don't want anyone to create this object but rather to use the getDepth method.
	}
	
	public static Integer getDepth(Expr e) {
		return new DepthOfExpr().doSwitch(e);
	}
	
	@Override
	public Integer caseArrayAccessExpr(ArrayAccessExpr e) {
		return doSwitch(e.getArray()) + 1;
	}
	
	@Override
	public Integer caseRecordAccessExpr(RecordAccessExpr e) {
		return doSwitch(e.getRecord()) + 1;
	}
	
	@Override
	public Integer defaultCase(EObject e) {
		return 0;
	}
	
}
