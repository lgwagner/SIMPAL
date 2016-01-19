package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;

import com.rockwellcollins.atc.limp.Postcondition;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpExprToLustreExpr;

/**
 * LustrePostcondition is a class designed to capture a postcondition, comprised
 * of an identifier 'name' and expression 'condition'.
 */
public class LustrePostcondition {

	public String name;
	public Expr condition;	
	
	public Equation toEquation() {
		return new Equation(new IdExpr(name), condition);
	}
	
	private LustrePostcondition() {
		super();
	}
	
	/**
	 * Create a LustrePostcondition from a string and Lustre expression.
	 */
	public static LustrePostcondition create(String name, Expr condition) {
		LustrePostcondition lpost = new LustrePostcondition();
		lpost.name=name;
		lpost.condition=condition;
		return lpost;
	}

	/**
	 * Create a LustrePostcondition from a string and Limp postcondition.
	 */
	public static LustrePostcondition from(Postcondition post, String name) {
		LustrePostcondition lpost = new LustrePostcondition();
		lpost.name = name + "_" + post.getName();
		lpost.condition = LimpExprToLustreExpr.translate(post.getExpr());
		return lpost;
	}
}
