package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;

import com.rockwellcollins.atc.limp.Precondition;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpExprToLustreExpr;

/**
 * LustrePrecondition is a class designed to capture a precondition, comprised
 * of an identifier 'name' and expression 'condition'.
 */
public class LustrePrecondition {

	public String name;
	public Expr condition;
	
	public Equation toEquation() {
		return new Equation(new IdExpr(name), condition);
	}
	
	private LustrePrecondition() {
		super();
	}
	
	/**
	 * Create a LustrePrecondition from a string and Lustre expression.
	 */
	public static LustrePrecondition create(String name, Expr condition) {
		LustrePrecondition lpre = new LustrePrecondition();
		lpre.name=name;
		lpre.condition=condition;
		return lpre;
	}
	
	/**
	 * Create a LustrePrecondition from a string and Limp postcondition.
	 */
	public static LustrePrecondition from(Precondition pre, String name) {
		LustrePrecondition lpre = new LustrePrecondition();
		lpre.name = name + "_" + pre.getName();
		lpre.condition = LimpExprToLustreExpr.translate(pre.getExpr());
		return lpre;
	}
}
