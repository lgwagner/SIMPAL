package com.rockwellcollins.atc.limp.translate.basicblocks.limp;

import com.rockwellcollins.atc.limp.Expr;

/**
 * A BlockEdge represents the Conditional and Unconditional exits of a BasicBlock.
 * 
 * ConditionalExits should set the condition Expr, while UnconditionalExits should
 * set it to null.
 */
public class BlockEdge {
	
	public BasicBlock destination;
	public Expr condition;
	
	public BlockEdge(BasicBlock destination, Expr condition) {
		this.destination=destination;
		this.condition=condition;
	}
	
	public BlockEdge(BasicBlock destination) {
		this.destination=destination;
		this.condition=null;
	}
	
	public boolean isUnconditional() {
		return this.condition==null;
	}
}
