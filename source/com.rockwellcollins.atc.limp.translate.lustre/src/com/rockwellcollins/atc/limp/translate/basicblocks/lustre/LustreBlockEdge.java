package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import jkind.lustre.Expr;

/**
 * LustreBlockEdge is an edge that represents both the ConditionalExits and UnconditionalExits of a LustreBasicBlock
 * 
 * If the LustreBlockEdge has a valid condition it is a ConditionalExit
 * If the LustreBlockEdge has a null condition it is an UnconditionalExit
 * 
 */
public class LustreBlockEdge {

	private LustreBasicBlock destination;
	private Expr condition;
	
	public LustreBasicBlock getDestination() {
		return destination;
	}

	public Expr getCondition() {
		return condition;
	}
	
	public void setDestination(LustreBasicBlock destination) {
		this.destination = destination;
	}

	public void setCondition(Expr condition) {
		this.condition=condition;
	}
	
	public boolean isUnconditional() {
		return this.condition==null;
	}
}
