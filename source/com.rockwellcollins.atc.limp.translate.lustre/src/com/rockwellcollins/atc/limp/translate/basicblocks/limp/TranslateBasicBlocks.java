package com.rockwellcollins.atc.limp.translate.basicblocks.limp;

import java.util.LinkedHashMap;
import java.util.Map;

import jkind.lustre.Equation;

import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.ExtendedEquation;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBasicBlock;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBlockEdge;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpExprToLustreExpr;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpStatementToLustreEquation;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LocalProcedureToLustre;

/**
 *	TranslateBasicBlocks  
 *
 *	This translates a linked list of Limp BasicBlocks and returns a linked list of LustreBasicBlocks.
 *
 *  In this translation we change every Limp statement into a Lustre equation. In addition we add
 *  infrastructure here to support unique naming, SSA transformations, and other general translation
 *  artifacts.
 *  
 *    triggerId - the name of the node triggering signal
 *    nodeName - the unique name of the node
 *    stateInputId - the name of the input state record
 *    stateOutputId - the name of the output state record
 *    globalInputId - the name of the input global record
 *    globalOutputId - the name of the output global record
 *    preconditionId - the name of the precondition aggregator signal
 *    postconditionId - the name of the postcondition aggregator signal
 */
public class TranslateBasicBlocks {

	public static LustreBasicBlock translate(BasicBlock first,LocalProcedureToLustre p2l) {
		return new TranslateBasicBlocks(p2l).translateBlock(first);
	}

	private TranslateBasicBlocks(LocalProcedureToLustre p2l) {
		this.procedureToLustre = p2l;
	}
	
	private Map<BasicBlock,LustreBasicBlock> map = new LinkedHashMap<>();
	private Integer id = 0;
	private LocalProcedureToLustre procedureToLustre;

	private LustreBasicBlock translateBlock(BasicBlock bb) {
		if(map.containsKey(bb)) {
			return map.get(bb);
		}
		
		LustreBasicBlock lustreBlock = new LustreBasicBlock(id++,bb.parent);
		map.put(bb, lustreBlock);
		lustreBlock.usedIds.addAll(procedureToLustre.getGlobalIdentifiers());
		lustreBlock.usedIds.addAll(procedureToLustre.getLocalIdentifiers());

		//these must come after we set the usedIds
		lustreBlock.triggerId = lustreBlock.getUniqueID("trigger");
		lustreBlock.nodeName = lustreBlock.getUniqueID(lustreBlock.parent.getName() + "_block_" + lustreBlock.id);
		lustreBlock.stateInputId = lustreBlock.getUniqueID("state_in");
		lustreBlock.stateOutputId = lustreBlock.getUniqueID("state_out");
		lustreBlock.globalInputId = lustreBlock.getUniqueID("globals_in");
		lustreBlock.globalOutputId = lustreBlock.getUniqueID("globals_out");
		lustreBlock.preconditionId = lustreBlock.getUniqueID("precondition");
		lustreBlock.postconditionId = lustreBlock.getUniqueID("postcondition");
		
		for(Statement s : bb.statements) {
			Equation eq = LimpStatementToLustreEquation.translate(s);
			ExtendedEquation eeq = new ExtendedEquation(eq);
			lustreBlock.equations.add(eeq);
		}
		
		for(BlockEdge be : bb.conditionalExits) {
			LustreBlockEdge lbe = translateBlockEdge(be);
			lustreBlock.conditionalExits.add(lbe);
		}
		
		lustreBlock.unconditionalExit = translateBlockEdge(bb.unconditionalExit);
		return lustreBlock;
	}
	
	private LustreBlockEdge translateBlockEdge(BlockEdge blockEdge) {
		if(blockEdge == null) {
			return null;
		}
		
		LustreBlockEdge lustreBlockEdge = new LustreBlockEdge();
		lustreBlockEdge.setDestination(translateBlock(blockEdge.destination));
		
		if(!blockEdge.isUnconditional()) {
			lustreBlockEdge.setCondition(LimpExprToLustreExpr.translate(blockEdge.condition));
		}
		return lustreBlockEdge;
	}
}
