package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.Type;
import jkind.lustre.VarDecl;

import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LocalProcedureToLustre;

/**
 * LustreBlocksToNodes accepts the first LustreBasicBlock in a linked-list of BasicBlocks and 
 * translates them to a Lustre Node.
 * 
 * Consider a LustreBasicBlock as shown below:
 * 
 * LustreBasicBlock B1:
 * Equations:
 * 	x = a;
 * 	y = b;
 * 
 * ConditionalExits:
 *  if (x > 0) then B2
 *  if (y < 0) then B3
 *  
 * UnconditionalExit:
 *  B4
 *  
 *  This will get translated into the following Lustre node (where a and b are inputs)
 *  
 *  node basicBlock_B1(a : int, b : int) returns (x : int, y : int)
 *  let
 *  	x = a;
 *  	y = b;
 *  tel;
 *
 * The ConditionalExits are handled at on the main node which is described in LocalProcedureToMainNode.java
 * 
 */
public class LustreBlocksToNodes {

	private static final String propSuffix = "_prop";

	public static List<Node> generateNodes(LocalProcedureToLustre p2l) {
		LustreBlocksToNodes blocksToNodes = new LustreBlocksToNodes(p2l);
		blocksToNodes.translate(p2l.firstBlock);
		return new ArrayList<>(blocksToNodes.map.values());
	}
	
	private Map<LustreBasicBlock,Node> map = new LinkedHashMap<>();
	
	private LocalProcedureToLustre procToLustre;

	public LustreBlocksToNodes(LocalProcedureToLustre p2l) {
		this.procToLustre=p2l;
	}
	
	private void translate(LustreBasicBlock block) {
		
		if(map.containsKey(block)) {
			return;
		}

		List<VarDecl> inputs = new ArrayList<>();
		List<VarDecl> locals = new ArrayList<>();
		List<VarDecl> outputs = new ArrayList<>();
		List<String> properties = new ArrayList<>();
		List<Expr> assertions = new ArrayList<>();
		List<Equation> equations = new ArrayList<>();

		//these are used to collect the equation Ids of pre and post conditions;
		List<String> preIds = new ArrayList<>();
		List<String> postIds = new ArrayList<>();
		
		inputs.add(new VarDecl(block.triggerId, NamedType.BOOL));
		if(!procToLustre.state.isEmpty()) {
			inputs.add(new VarDecl(block.stateInputId, new NamedType(procToLustre.getStateRecordType().id)));
			outputs.add(new VarDecl(block.stateOutputId, new NamedType(procToLustre.getStateRecordType().id)));
		}
		
		if(!procToLustre.limpToLustre.globals.isEmpty()) {
			inputs.add(new VarDecl(block.globalInputId, new NamedType(procToLustre.getGlobalRecordType().id)));
			outputs.add(new VarDecl(block.globalOutputId, new NamedType(procToLustre.getGlobalRecordType().id)));
		}
		
		Map<String,Type> generatedLocals = block.generatedLocals;
		for(String key : generatedLocals.keySet()) {
			locals.add(new VarDecl(key,generatedLocals.get(key)));
		}

		outputs.add(new VarDecl(block.preconditionId, NamedType.BOOL));
		outputs.add(new VarDecl(block.postconditionId, NamedType.BOOL));
		
		//our equations are right from the block on the previous SSA pass
		for(ExtendedEquation eeq : block.equations) {
		
			for(LustrePrecondition lpre : eeq.preconditions) {
				locals.add(new VarDecl(lpre.name, NamedType.BOOL));
				equations.add(lpre.toEquation());
				String propertyId = block.getUniqueID(lpre.name + propSuffix);
				Equation eq = new Equation(new IdExpr(propertyId), generatePreconditionExpr(block.triggerId,lpre.name));
				
				equations.add(eq);
				preIds.add(propertyId);
				locals.add(new VarDecl(propertyId, NamedType.BOOL));
				properties.add(propertyId);
			}
			
			equations.addAll(eeq.globalReferences);
			equations.add(eeq.equation);
			equations.addAll(eeq.globalAssignments);
			
			for(LustrePostcondition lpost : eeq.postconditions) {
				locals.add(new VarDecl(lpost.name, NamedType.BOOL));
				equations.add(lpost.toEquation());
				postIds.add(lpost.name);
			}
		}
		
		equations.add(new Equation(new IdExpr(block.preconditionId), generateAccumulatedExpr(preIds.iterator())));
		equations.add(new Equation(new IdExpr(block.postconditionId), generateAccumulatedExpr(postIds.iterator())));
		
		Node n = new Node(block.nodeName,inputs,outputs,locals,equations,properties,assertions);
		map.put(block, n);
		
		for(LustreBlockEdge lbe : block.conditionalExits) {
			this.translate(lbe.getDestination());
		}
		
		if(block.unconditionalExit != null) {
			this.translate(block.unconditionalExit.getDestination());
		}
	}

	private Expr generatePreconditionExpr(String triggerId, String name) {
		return new BinaryExpr(new IdExpr(triggerId), BinaryOp.IMPLIES, new IdExpr(name));
	}

	private Expr generateAccumulatedExpr(Iterator<String> it) {
		if(it.hasNext()) {
			String next = it.next();
			return new BinaryExpr(new IdExpr(next), BinaryOp.AND, generateAccumulatedExpr(it));
		} else {
			return new BoolExpr(true);
		}
	}
}
