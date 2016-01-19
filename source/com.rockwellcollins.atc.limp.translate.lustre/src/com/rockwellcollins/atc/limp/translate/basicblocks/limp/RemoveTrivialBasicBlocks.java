package com.rockwellcollins.atc.limp.translate.basicblocks.limp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.rockwellcollins.atc.limp.Statement;

/**
 * This pass removes trivial BasicBlock elements from the linked list representation.
 * A BasicBlock is trivial if:
 * 
 * - It contains no statements
 * - It has no conditional exits
 * - It has a non-null unconditional exit (it is not null terminated)
 *
 * The translation from Limp to BasicBlocks can generate trivial BasicBlocks and this
 * is used to remove them to keep the end-result as simple as possible.
 */
public class RemoveTrivialBasicBlocks {

	public static BasicBlock remove(BasicBlock first) {
		return new RemoveTrivialBasicBlocks().removeInternal(first);
	}

	private Map<BasicBlock,BasicBlock> map = new LinkedHashMap<>();
	
	private BasicBlock removeInternal(BasicBlock current) {
		
		if(map.containsKey(current)) {
			return map.get(current);
		} 
		
		if(isTrivial(current)) {
			BasicBlock transformed = removeInternal(current.unconditionalExit.destination);
			map.put(current, transformed);
			return transformed;
		}
		
		BasicBlock newCurrent = new BasicBlock(current.parent);
		for(Statement s : current.statements) {
			newCurrent.addStatement(s);
		}
		map.put(current, newCurrent);
		
		for(BlockEdge cbe : current.conditionalExits) {
			newCurrent.addConditionalEdge(removeInternal(cbe.destination), cbe.condition);
		}
		
		if(current.unconditionalExit != null) {
			newCurrent.setUnconditionalExit(removeInternal(current.unconditionalExit.destination));	
		}
		return newCurrent;
	}

	private boolean isTrivial(BasicBlock current) {
		return current.statements.isEmpty() && current.conditionalExits.isEmpty() && current.unconditionalExit != null;
	}
}
