package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkind.lustre.IdExpr;
import jkind.lustre.Type;

import com.rockwellcollins.atc.limp.LocalProcedure;

/**
 * LustreBasicBlocks are basic blocks translated to the lustre language format. This means that all
 * of the LimpStatements now appear as ExtendedEquations (Equations with relevant preconditions, postconditions,
 * defineExprs, and useExprs).
 * 
 * A lot of infrastructure is captured in this class to assist in the process of translating BasicBlocks to
 * Lustre representations.
 * 
 * - All of the used and current IDS are captured in maps. This is to ensure names are unique and 
 *   the StaticSingleAssignment pass is executed correctly.
 * - An ID is assigned to the BasicBlock
 * - Conditional/Unconditional Exits are maintained similar to the Limp BasicBlock representation.
 * - All of the generated locals are captured in a map so they can be declared when the Lustre node
 *   is generated.
 *
 */
public class LustreBasicBlock {
	
	public LocalProcedure parent;
	public final Integer id;
	
	public List<ExtendedEquation> equations = new ArrayList<>();
	
	public List<LustreBlockEdge> conditionalExits = new ArrayList<>();
	public LustreBlockEdge unconditionalExit;

	public Map<String,Integer> currentIds = new LinkedHashMap<>();
	public Map<String, Integer> initIds = new LinkedHashMap<>();
	public Set<String> usedIds = new HashSet<>();
	public Map<String,Type> generatedLocals = new LinkedHashMap<>();

	public String triggerId;
	public String nodeName;
	public String stateInputId;
	public String stateOutputId;
	public String globalInputId;
	public String globalOutputId;
	public String postconditionId;
	public String preconditionId;
	
	public LustreBasicBlock(Integer id, LocalProcedure parent) {
		this.id = id;
		this.parent = parent;
	}

	public static String generateNumberedID(String base, Integer iv) {
		return base + "_" + Integer.toString(iv);
	}
	
	public static LustreBasicBlock copy(LustreBasicBlock block) {
		LustreBasicBlock newBlock = new LustreBasicBlock(block.id, block.parent);
		newBlock.triggerId=block.triggerId;
		newBlock.nodeName=block.nodeName;
		newBlock.usedIds=block.usedIds;
		newBlock.currentIds=block.currentIds;
		newBlock.stateInputId=block.stateInputId;
		newBlock.stateOutputId=block.stateOutputId;
		newBlock.globalInputId=block.globalInputId;
		newBlock.globalOutputId=block.globalOutputId;
		newBlock.preconditionId=block.preconditionId;
		newBlock.postconditionId=block.postconditionId;
		return newBlock;
	}
	
	public String getUniqueID(String id) {
		Integer current = 0;
		String name = id;
		while(usedIds.contains(name)) {
			name = generateNumberedID(id, current);
			current++;
		}
		usedIds.add(name);
		return name;
	}
	
	public String getCurrentSSAID(String id) {
		return generateNumberedID(id, currentIds.get(id));
	}
	
	public String getInitialSSAID(String id) {
		return generateNumberedID(id, initIds.get(id));
	}
	
	public String getUniqueSSAID(String id) {
		Integer current = 0;
		if(currentIds.containsKey(id)) {
			current = currentIds.get(id);
		}

		String next = generateNumberedID(id, current);
		while(usedIds.contains(next)) {
			current++;
			next = generateNumberedID(id, current);
		}
		
		usedIds.add(next);
		currentIds.put(id, current);
		return next;
	}
	
	public IdExpr getCurrentId(String id) {
		return new IdExpr(generateNumberedID(id, currentIds.get(id)));	
	}
}
