package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jkind.lustre.Node;
import jkind.lustre.RecordType;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;

import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.translate.basicblocks.limp.BasicBlock;
import com.rockwellcollins.atc.limp.translate.basicblocks.limp.TranslateBasicBlocks;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.BasicBlockToDot;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBasicBlock;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBlocksToNodes;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePostcondition;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePrecondition;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.StaticSingleAssignment;
import com.rockwellcollins.atc.limp.utils.LimpUtilities;

/**
 *  LocalProcedureToLustre
 *  
 *  This class will take a LocalProcedure and
 *   1. Generate a LimpBasicBlock representation.
 *   2. Optimize the LimpBasicBlock representation.
 *   3. Translate the LimpBasicBlock representation to LustreBasicBlocks.
 *   4. Apply StaticSingleAssignment
 *   5. Translate each LustreBlock to a Lustre node.
 *   6. Generate the main node to execute the LustreBasicBlock nodes in the proper order (LocalProcedureToLustre)
 *
 */
public class LocalProcedureToLustre {

	public static Pair<BasicBlock,List<Node>> translateLocalProcedure(LocalProcedure lp, LimpToLustre l2l, File pdfFile, MangleList mangleList) {
		LocalProcedureToLustre procedureToLustre = new LocalProcedureToLustre(lp,l2l,pdfFile, mangleList);

		if(!procedureToLustre.state.isEmpty()) {
			TypeDef stateTypeDef = procedureToLustre.createStateRecordTypeDef();
			procedureToLustre.limpToLustre.typedefs.put(stateTypeDef.id, stateTypeDef.type);			
		}

		if(!procedureToLustre.limpToLustre.globals.isEmpty()) {
			TypeDef globalTypeDef = procedureToLustre.createGlobalRecordTypeDef();
			procedureToLustre.limpToLustre.typedefs.put(globalTypeDef.id, globalTypeDef.type);
		}

		procedureToLustre.computeBlocks(lp);
		procedureToLustre.blockNodes = LustreBlocksToNodes.generateNodes(procedureToLustre);
		procedureToLustre.mainNode = LocalProcedureToMainNode.crunch(procedureToLustre, mangleList);

		List<Node> nodes = new ArrayList<>(procedureToLustre.blockNodes);
		Node main = procedureToLustre.mainNode;
		nodes.add(main);

		Pair<BasicBlock,List<Node>> pair = new Pair<BasicBlock,List<Node>>(procedureToLustre.firstLimpBlock,nodes);
		return pair;
	}

	public LocalProcedure main;
	public LimpToLustre limpToLustre;

	public Map<String,Type> state = new LinkedHashMap<>();
	
	public List<LustrePrecondition> mainNodePreconditions = new ArrayList<>();
	public List<LustrePostcondition> mainNodePostconditions = new ArrayList<>();
	
	public LustreBasicBlock firstBlock;
	public List<Node> blockNodes = new ArrayList<>();
	public Node mainNode;

	public String stateRecordTypeId;
	public String globalRecordTypeId;
	
	public BasicBlock firstLimpBlock;
	
	public MangleList mangleList;
	
	private File pdfFile;

	private LocalProcedureToLustre(LocalProcedure lp, LimpToLustre l2l, File pdfFile, MangleList mangleList) {
		this.main = lp;
		this.pdfFile = pdfFile;
		this.limpToLustre = l2l;
		this.state = generateStateMap(lp);
		this.mangleList = mangleList;
	}

	public RecordType getStateRecordType() {
		return (RecordType) limpToLustre.typedefs.get(stateRecordTypeId);
	}

	public RecordType getGlobalRecordType() {
		return (RecordType) limpToLustre.typedefs.get(globalRecordTypeId);
	}

	private static Map<String, Type> generateStateMap(LocalProcedure lp) {
		Map<String, Type> map = new LinkedHashMap<>();
		for (InputArg iarg : lp.getInputs().getInputArgs()) {
			map.put(iarg.getName(), LimpTypeToLustreType.translateType(iarg.getType()));
		}

		for (LocalArg larg : LimpUtilities.getLocalsFromVarBlock(lp.getVarBlock())) {
			map.put(larg.getName(), LimpTypeToLustreType.translateType(larg.getType()));
		}

		for (OutputArg oarg : lp.getOutputs().getOutputArgs()) {
			map.put(oarg.getName(), LimpTypeToLustreType.translateType(oarg.getType()));
		}
		return map;
	}

	public Set<String> getGlobalIdentifiers() {
		Set<String> usedIds = new HashSet<>();
		usedIds.addAll(limpToLustre.typedefs.keySet());
		usedIds.addAll(limpToLustre.functions.keySet());
		usedIds.addAll(limpToLustre.procedures.keySet());
		return usedIds;
	}
	
	public Set<String> getLocalIdentifiers() {
		Set<String> usedIds = new HashSet<>();
		usedIds.addAll(state.keySet());
		usedIds.addAll(limpToLustre.globals.keySet());
		return usedIds;
	}
	
	private TypeDef createStateRecordTypeDef() {
		String suffix = "_state_type";
		String name = main.getName() + suffix;
		Integer current = 0;
		Set<String> usedIds = getGlobalIdentifiers();
		while (usedIds.contains(name)) {
			name = main.getName() + suffix + current;
			current++;
		}

		RecordType stateRecordType = new RecordType(name, state);
		TypeDef stateTypeDef = new TypeDef(name, stateRecordType);
		this.stateRecordTypeId = name;
		
		List<String> li = new ArrayList<>();
		for (Entry<String, Type> entry : state.entrySet()){
			li.add(entry.getKey());
		}
		mangleList.add(new Pair<List<String>,String>(li, name));
		
		return stateTypeDef;
	}

	private TypeDef createGlobalRecordTypeDef() {
		String suffix = "_global_type";
		String name = main.getName() + suffix;
		Integer current = 0;
		Set<String> usedIds = getGlobalIdentifiers();
		while (usedIds.contains(name)) {
			name = main.getName() + suffix + current;
		}

		RecordType globalRecordType = new RecordType(name, limpToLustre.globals);
		TypeDef globalTypeDef = new TypeDef(name, globalRecordType);
		this.globalRecordTypeId = name;
		
		List<String> li = new ArrayList<>();
		for (Entry<String, Type> entry : limpToLustre.globals.entrySet()){
			li.add(entry.getKey());
		}
		mangleList.add(new Pair<List<String>, String>(li, name));
		
		return globalTypeDef;
	}

	private void computeBlocks(LocalProcedure lp) {
		
		BasicBlock first = GenerateCFG.get(lp);
		firstLimpBlock = first;
		
		// translate the Limp basic blocks to Lustre basic blocks
		this.firstBlock = TranslateBasicBlocks.translate(first,this);
		printBasicBlocks(this.firstBlock);
		this.firstBlock = StaticSingleAssignment.transform(this.firstBlock,this);
	}

	private void printBasicBlocks(LustreBasicBlock first) {
		try { 
			BasicBlockToDot.display(first,pdfFile); 
		} catch (Exception e) {
			System.err.println("Error creating DOT PDF file.");
			e.printStackTrace(); 
		}
	}
}
