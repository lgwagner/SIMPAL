package com.rockwellcollins.atc.limp.reasoning.visitor;

import com.rockwellcollins.atc.limp.StringLiteralExpr;

public class StringHack extends LimpVisitor {
	@Override
	public Unit caseStringLiteralExpr(StringLiteralExpr x) {
		System.out.println("** Hacking string " + x.getStringVal());
		x.setStringVal(x.getStringVal() + "_hacked");
		return Unit.UNIT;
	}
}
