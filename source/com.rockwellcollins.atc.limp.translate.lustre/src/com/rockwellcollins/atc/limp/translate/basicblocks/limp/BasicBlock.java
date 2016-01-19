package com.rockwellcollins.atc.limp.translate.basicblocks.limp;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.VoidStatement;

public class BasicBlock {

	/**
	 * A basic block is a list of statements that are always executed from top to bottom, regardless
	 * of control flow. 
	 * 
	 * BasicBlocks have:
	 * 
	 * List<Statement>
	 * ConditionalExits
	 * One and only one unconditional exit.
	 * 
	 * This class represents a list of statements that compose a Basic Block in the Limp language.
	 * There is an equivalent class for LustreBasicBlocks which has a lot more infrastructure
	 * for the translation of LustreBasicBlocks to Lustre nodes with unique variable naming, etc.
	 */

	public LocalProcedure parent;
	public List<Statement> statements = new ArrayList<>();
	public List<BlockEdge> conditionalExits = new ArrayList<>();
	public BlockEdge unconditionalExit;
	
	public BasicBlock(LocalProcedure lp) {
		this.parent = lp;
	}
	
	public void addStatement(Statement s) {
		if(s instanceof AssignmentStatement || s instanceof VoidStatement) {
			this.statements.add(s);	
		} else {
			throw new IllegalArgumentException(s + " is not allowed in a Basic Block.");
		}
	}
	
	public void addConditionalEdge(BasicBlock bb, Expr condition) {
		this.conditionalExits.add(new BlockEdge(bb, condition));
	}
	
	public void setUnconditionalExit(BasicBlock bb) {
		this.unconditionalExit = new BlockEdge(bb);
	}

	public String toString() {
		return "BasicBlock ";
	}
	
}
