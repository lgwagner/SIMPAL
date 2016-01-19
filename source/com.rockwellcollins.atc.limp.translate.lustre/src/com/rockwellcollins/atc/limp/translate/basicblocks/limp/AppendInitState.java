package com.rockwellcollins.atc.limp.translate.basicblocks.limp;

/**
 * This transformation accepts a LustreBasicBlock (really a linked list of LustreBasicBlocks) and inserts
 * an empty BasicBlock with one UnconditionalExit to the original initial block.
 * 
 * 
 * This is so our embedded properties are triggered correctly on the init state.  It's a bit ugly,
 * and it adds an extra block that is always unused as the "INIT" state, but there's not really a great
 * way around it that doesn't involve a ton of work.
 * 
 * @author lgwagner
  */
public class AppendInitState {

	public static BasicBlock append(BasicBlock oldFirst) {
		BasicBlock newFirst = new BasicBlock(oldFirst.parent);
		newFirst.setUnconditionalExit(oldFirst);
		
		
		newFirst.setUnconditionalExit(oldFirst);
		return newFirst;
	}
}
