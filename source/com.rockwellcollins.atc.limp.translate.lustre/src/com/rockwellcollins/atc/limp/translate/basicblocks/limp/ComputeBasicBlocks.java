package com.rockwellcollins.atc.limp.translate.basicblocks.limp;

import java.util.LinkedHashMap;
import java.util.Map;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.GotoStatement;
import com.rockwellcollins.atc.limp.LabelStatement;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 * ComputeBasicBlocks will process a normalized Limp file and 
 * turn it into a BasicBlock representation.
 * 
 * Before running this pass the following transformations must be run first:
 *  - ImportExpansion
 *  - RemoveUnspecifiedConstants
 *  - RemoveLustreKeywords
 *  - RemoveAbstractTypes
 *  - RemoveElseIfs
 *  - RemoveStrings
 *  - RemoveControlFlow
 *
 * This pass will start on the LocalProcedure of interest (the one marked "main" or the last one) and
 * generate a BasicBlock representation of the program. The only statements that should appear inside of
 * a BasicBlock is an AssignmentStatement or VoidStatement. Goto statements will generate edges that transition
 * out of the BasicBlock to the next BasicBlock.
 */
public class ComputeBasicBlocks extends LimpSwitch<Void> {

	private BasicBlock first;
	private BasicBlock current;
	private enum State {IN_BLOCK, IN_CONDITIONAL, OUT_BLOCK};
	private State state;
	
	private Map<LabelStatement,BasicBlock> map = new LinkedHashMap<>();
	
	public static BasicBlock computeBasicBlocks(LocalProcedure lp) {
		ComputeBasicBlocks compute = new ComputeBasicBlocks();
		compute.doSwitch(lp);
		return compute.getFirst();
	}
	
	public BasicBlock getFirst() {
		return first;
	}
	
	public void createNextBasicBlock() {
		setNextBasicBlock(new BasicBlock(first.parent));
	}
	
	public void setNextBasicBlock(BasicBlock next) {
		BasicBlock previous = current;
		current = next;
		
		if(state != State.OUT_BLOCK) {
			previous.setUnconditionalExit(current);
		}
		state = State.IN_BLOCK;
	}

	@Override
	public Void caseLocalProcedure(LocalProcedure lp) {
		//yeah, this just happened
		this.first = this.current = new BasicBlock(lp);
		this.state = State.IN_BLOCK;
		this.doSwitch(lp.getStatementblock());
		return null;
	}
	
	@Override
	public Void caseStatementBlock(StatementBlock sb) {
		for(Statement s : sb.getStatements()) {
			this.doSwitch(s);
		}
		return null;
	}
	
	@Override
	public Void caseGotoStatement(GotoStatement gotoStatement) {
		if(state == State.OUT_BLOCK) {
			return null;
		}
		
		LabelStatement label = gotoStatement.getLabel();
		BasicBlock labelBlock = map.get(label);
		
		if(labelBlock == null) {
			//the block wasn't in the map yet, lets put it in there.
			labelBlock = new BasicBlock(first.parent);
			map.put(label, labelBlock);
		}
		
		if(gotoStatement.getWhenExpr() == null) {
			//unconditional
			current.setUnconditionalExit(labelBlock);
			state = State.OUT_BLOCK;
		} else {
			//conditional
			current.addConditionalEdge(labelBlock, gotoStatement.getWhenExpr());
			state = State.IN_CONDITIONAL;
		}
		return null;
	}
	
	@Override
	public Void caseLabelStatement(LabelStatement labelStatement) {
		if(map.containsKey(labelStatement)) {
			//we've already seen this label on a goto
			setNextBasicBlock(map.get(labelStatement));
		} else {
			//we've not seen this label yet
			createNextBasicBlock();
			map.put(labelStatement, current);
		}
		return null;
	}
	
	@Override
	public Void caseAssignmentStatement(AssignmentStatement as) {
		if(state == State.OUT_BLOCK) {
			return null;
		} else if(state == State.IN_CONDITIONAL) {
			createNextBasicBlock();
		}
		
		current.addStatement(as);
		return null;
	}
	
	@Override
	public Void caseVoidStatement(VoidStatement vs) {
		if(state == State.OUT_BLOCK) {
			return null;
		} else if(state == State.IN_CONDITIONAL) {
			createNextBasicBlock();
		}
		
		current.addStatement(vs);
		return null;
	}
	
}
