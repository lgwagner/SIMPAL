package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkind.lustre.BinaryExpr;
import jkind.lustre.BinaryOp;
import jkind.lustre.BoolExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.IfThenElseExpr;
import jkind.lustre.IntExpr;
import jkind.lustre.NamedType;
import jkind.lustre.Node;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.RecordExpr;
import jkind.lustre.TupleExpr;
import jkind.lustre.Type;
import jkind.lustre.UnaryExpr;
import jkind.lustre.UnaryOp;
import jkind.lustre.VarDecl;
import jkind.lustre.visitors.AstMapVisitor;

import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBasicBlock;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBlockEdge;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePostcondition;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePrecondition;
import com.rockwellcollins.atc.limp.translate.lustre.procedure.InitIds;
import com.rockwellcollins.atc.limp.translate.lustre.procedure.TranslateAttributes;
import com.rockwellcollins.atc.limp.utils.LimpUtilities;

/**
 * LocalProcedureToMainNode generates the main node that executes the LustreBasicBlock
 * representation in the correct order.
 * 
 * This does the following:
 * - generates the signature of the main node, essentially identifying all of the inputs, globals, 
 *   and outputs of the main node.
 * - generate nonconflicting IDs
 * - generate the state traversal expression
 * - generate equations that assign the state and global record
 */
public class LocalProcedureToMainNode {

	public static Node crunch(LocalProcedureToLustre p2l, MangleList mangleList) {
		LocalProcedureToMainNode procedureToMainNode = new LocalProcedureToMainNode(p2l, mangleList);
		procedureToMainNode.computeMainNode();
		return procedureToMainNode.node;
	}
	
	private LocalProcedureToLustre procedureToLustre;
	
	//ids used in the node
	public String mainNodeId;
	
	public String mainNodeStateId;
	public String mainNodePreStateId;
	public String mainNodeInitStateId;
	public String mainNodeFinalStateId;
	
	public String mainNodeStateRecordId;
	public String mainNodePreStateRecordId;
	public String mainNodeInitStateRecordId;
	
	public String mainNodeGlobalRecordId;
	public String mainNodePreGlobalRecordId;
	public String mainNodeInitGlobalRecordId;

	public String mainNodeComponentPreconditionId;
	public String mainNodeComponentPostconditionId;
	
	public MangleList mangleList;
	
	//the subcomponents of the node
	private List<VarDecl> inputs = new ArrayList<>();
	private List<VarDecl> locals = new ArrayList<>();
	private List<VarDecl> outputs = new ArrayList<>();
	private List<Equation> equations = new ArrayList<>();
	private List<String> properties = new ArrayList<>();
	private List<Expr> assertions = new ArrayList<>();
	
	//the node that is generated
	private Node node;
	
	//these fields are used for processing purposes.
	public Set<String> usedIds = new HashSet<>();
	public Map<Integer,LustreBasicBlock> blockMap = new LinkedHashMap<>();

	private LocalProcedureToMainNode(LocalProcedureToLustre p2l, MangleList mangleList) {
		this.procedureToLustre=p2l;
		this.mangleList = mangleList;
	}
	
	private String getUniqueMainNodeID(String name) {
		String updatedName = name;
		Integer current = 0;
		while(usedIds.contains(updatedName)) {
			updatedName = name + current; 
		}
		return updatedName;
	}
	
	private Expr generateBlockEdgeExpr(Iterator<LustreBlockEdge> conditionals, LustreBlockEdge unconditional, Expr previousState) {
		if(conditionals.hasNext()) {
			LustreBlockEdge lbe = conditionals.next();
			IntExpr thenExpr = new IntExpr(lbe.getDestination().id);
			Expr elseExpr = generateBlockEdgeExpr(conditionals,unconditional,previousState);
			IfThenElseExpr ite = new IfThenElseExpr(lbe.getCondition(), thenExpr, elseExpr);
			return ite;
		} else {
			if(unconditional != null) {
				return new IntExpr(unconditional.getDestination().id);
			} else {
				return previousState;
			}
		}
	}
	
	private Expr generateBlockMapExpr(Iterator<Integer> mapIterator, Map<Integer,LustreBasicBlock> map) {
		Expr preStateExpr = new IdExpr(this.mainNodePreStateId);
		if(mapIterator.hasNext()) {
			Integer current = mapIterator.next();
			LustreBasicBlock currentBlock = map.get(current);
			BinaryExpr condition = new BinaryExpr(new IdExpr(this.mainNodePreStateId),BinaryOp.EQUAL, new IntExpr(currentBlock.id));
			Expr thenExpr = generateBlockEdgeExpr(currentBlock.conditionalExits.iterator(), currentBlock.unconditionalExit, preStateExpr);
			Expr elseExpr = generateBlockMapExpr(mapIterator,map);
			return new IfThenElseExpr(condition,thenExpr,elseExpr);
		} else {
			return preStateExpr;
		}
	}
	
	private Equation generateStateEquation(Map<Integer,LustreBasicBlock> map) {
		BinaryExpr arrow = new BinaryExpr(new IdExpr(this.mainNodeInitStateId), BinaryOp.ARROW, generateBlockMapExpr(map.keySet().iterator(),map));
		return new Equation(new IdExpr(this.mainNodeStateId), arrow);
	}
	
	private Equation generatePreStateEquation() {
		Expr rhs = new BinaryExpr(new IdExpr(this.mainNodeInitStateId), BinaryOp.ARROW, new UnaryExpr(UnaryOp.PRE, new IdExpr(this.mainNodeStateId)));
		return new Equation(new IdExpr(this.mainNodePreStateId), rhs);
	}
	
	private Equation generateInitStateEquation() {
		return new Equation(new IdExpr(this.mainNodeInitStateId), new IntExpr(procedureToLustre.firstBlock.id));
	}
	
	private Equation generateFinalStateEquation(Map<Integer,LustreBasicBlock> blockMap) {
		for(LustreBasicBlock block : blockMap.values()) {
			if(block.unconditionalExit == null) {
				return new Equation(new IdExpr(this.mainNodeFinalStateId), new IntExpr(block.id));
			}
		}
		throw new UnexpectedException("No basic block was a terminal block.");
	}
	
	public static Map<Integer,LustreBasicBlock> getMapOfBasicBlocks(LustreBasicBlock block, Map<Integer,LustreBasicBlock> currentMap) {
		if(currentMap.containsKey(block.id)) {
			return currentMap;
		}
		
		currentMap.put(block.id, block);
		for(LustreBlockEdge lbe : block.conditionalExits) {
			currentMap = getMapOfBasicBlocks(lbe.getDestination(),currentMap);
		}
		
		if(block.unconditionalExit != null) {
			currentMap = getMapOfBasicBlocks(block.unconditionalExit.getDestination(), currentMap);	
		}
		
		return currentMap;
	}
	
	private void generateBaseMainNodeUsedIds() {
		usedIds = new HashSet<>();
		this.usedIds.addAll(procedureToLustre.limpToLustre.typedefs.keySet());
		this.usedIds.addAll(procedureToLustre.limpToLustre.functions.keySet());
		this.usedIds.addAll(procedureToLustre.limpToLustre.procedures.keySet());
	}

	private Map<String, String> generateStateAndGlobalMap(String suffix) {
		Map<String,String> inputs = new LinkedHashMap<>();
		for(String id : procedureToLustre.state.keySet()) {
			String id_in = getUniqueMainNodeID(id + suffix);
			usedIds.add(id_in);
			inputs.put(id,id_in);
			mangleList.addSingleToMangleList(id, id_in);
		}
		
		for(String id : procedureToLustre.limpToLustre.globals.keySet()) {
			String id_in = getUniqueMainNodeID(id + suffix);
			usedIds.add(id_in);
			inputs.put(id,id_in);
			mangleList.addSingleToMangleList(id, id_in);			
		}
		return inputs;
	}

	private Equation generateStateAndGlobalAssignmentEquation(Map<Integer,LustreBasicBlock> blockMap) {
		List<IdExpr> lhs = new ArrayList<>();
		List<Expr> elseExprTuple = new ArrayList<>();
		List<Expr> initExprTuple = new ArrayList<>();
		
		if(!procedureToLustre.state.isEmpty()) {
			lhs.add(new IdExpr(this.mainNodeStateRecordId));
			initExprTuple.add(new IdExpr(this.mainNodeInitStateRecordId));
			elseExprTuple.add(new IdExpr(this.mainNodePreStateRecordId));
		}
		
		if(!procedureToLustre.limpToLustre.globals.isEmpty()) {
			lhs.add(new IdExpr(this.mainNodeGlobalRecordId));
			initExprTuple.add(new IdExpr(this.mainNodeInitGlobalRecordId));
			elseExprTuple.add(new IdExpr(this.mainNodePreGlobalRecordId));
		}
		
		lhs.add(new IdExpr(this.mainNodeComponentPreconditionId));
		initExprTuple.add(new BoolExpr(true));
		elseExprTuple.add(new BoolExpr(true));
		
		lhs.add(new IdExpr(this.mainNodeComponentPostconditionId));
		initExprTuple.add(new BoolExpr(true));
		elseExprTuple.add(new BoolExpr(true));
		
		Expr finalExpr = new TupleExpr(elseExprTuple);
		Expr initExpr = new TupleExpr(initExprTuple);
		
		Expr rhs = new BinaryExpr(initExpr, BinaryOp.ARROW, generateStateAndGlobalAssignmentExpr(blockMap.keySet().iterator(), blockMap, finalExpr));
		return new Equation(lhs,rhs);
	}

	private Expr generateStateAndGlobalAssignmentExpr(Iterator<Integer> iterator, Map<Integer, LustreBasicBlock> blockMap, Expr finalExpr) {
		if(iterator.hasNext()) {
			Integer next = iterator.next();
			LustreBasicBlock nextBlock = blockMap.get(next);

			Expr triggerExpr = new BinaryExpr(new IdExpr(this.mainNodePreStateId), BinaryOp.EQUAL, new IntExpr(next));
			List<Expr> args = new ArrayList<>();
			args.add(triggerExpr);

			if(!procedureToLustre.state.isEmpty()) {
				args.add(new IdExpr(this.mainNodePreStateRecordId));
			}
			
			if(!procedureToLustre.limpToLustre.globals.isEmpty()) {
				args.add(new IdExpr(this.mainNodePreGlobalRecordId));
			}

			Expr condExpr = new BinaryExpr(new IdExpr(this.mainNodePreStateId), BinaryOp.EQUAL, new IntExpr(next));
			Expr thenExpr = new NodeCallExpr(nextBlock.nodeName, args);
			Expr elseExpr = generateStateAndGlobalAssignmentExpr(iterator,blockMap,finalExpr);
			return new IfThenElseExpr(condExpr,thenExpr,elseExpr);
		} else {
			return finalExpr;
		}
	}

	private Equation generateInitStateRecordEquation(Map<String,String> inputStateAndGlobalMap) {
		Map<String,Expr> recordFields = new LinkedHashMap<>();
		
		Map<String,VariableRef> variableMap = LimpUtilities.getVariableMap(procedureToLustre.main);
		for(String field : procedureToLustre.state.keySet()) {
			VariableRef vr = variableMap.get(field);
			if (vr instanceof InputArg) {
				String inputId = inputStateAndGlobalMap.get(field);
				recordFields.put(field, new IdExpr(inputId));
			} else {
				Expr defaultExpr = LustreTypeToDefaultExpr.getDefaultExpr(procedureToLustre.limpToLustre.typedefs, procedureToLustre.state.get(field));
				recordFields.put(field, defaultExpr);
			}
		}
		IdExpr initStateRecord = new IdExpr(mainNodeInitStateRecordId);
		RecordExpr recordExpr = new RecordExpr(procedureToLustre.stateRecordTypeId, recordFields);
		BinaryExpr rhs = new BinaryExpr(recordExpr, BinaryOp.ARROW, new UnaryExpr(UnaryOp.PRE, initStateRecord));
		return new Equation(initStateRecord,rhs);
	}

	private Equation generatePreStateRecordEquation() {
		IdExpr initStateRecord = new IdExpr(mainNodeInitStateRecordId);
		IdExpr stateRecord = new IdExpr(mainNodeStateRecordId);
		IdExpr preStateRecord = new IdExpr(mainNodePreStateRecordId);
		BinaryExpr rhs = new BinaryExpr(initStateRecord, BinaryOp.ARROW, new UnaryExpr(UnaryOp.PRE, stateRecord));
		return new Equation(preStateRecord, rhs);
	}

	private Equation generateInitGlobalRecordEquation(Map<String,String> inputStateAndGlobalMap) {
		Map<String,Expr> recordFields = new LinkedHashMap<>();
		for(String field : procedureToLustre.limpToLustre.globals.keySet()) {
			String inputId = inputStateAndGlobalMap.get(field);
			recordFields.put(field, new IdExpr(inputId));
		}
		IdExpr initGlobalRecord = new IdExpr(mainNodeInitGlobalRecordId);
		RecordExpr recordExpr = new RecordExpr(procedureToLustre.globalRecordTypeId, recordFields);
		BinaryExpr rhs = new BinaryExpr(recordExpr, BinaryOp.ARROW, new UnaryExpr(UnaryOp.PRE, initGlobalRecord));
		return new Equation(initGlobalRecord,rhs);
	}

	private Equation generatePreGlobalRecordEquation() {
		IdExpr initGlobalRecord = new IdExpr(mainNodeInitGlobalRecordId);
		IdExpr globalRecord = new IdExpr(mainNodeGlobalRecordId);
		IdExpr preGlobalRecord = new IdExpr(mainNodePreGlobalRecordId);
		BinaryExpr rhs = new BinaryExpr(initGlobalRecord, BinaryOp.ARROW, new UnaryExpr(UnaryOp.PRE, globalRecord));
		return new Equation(preGlobalRecord, rhs);
	}
	
	private void computeMainNode() {
		this.generateBaseMainNodeUsedIds();
		Map<String, String> inputStateAndGlobalMap = generateStateAndGlobalMap("__in");
		Map<String, String> outputStateAndGlobalMap = generateStateAndGlobalMap("");
		
		
		TranslateAttributes translateAttributes = TranslateAttributes.crunch(procedureToLustre.main, mangleList);
		
		mainNodeId = getUniqueMainNodeID(procedureToLustre.main.getName());
		usedIds.add(mainNodeId);
		mangleList.addSingleToMangleList(procedureToLustre.main.getName(), mainNodeId);
		
		for(String id : procedureToLustre.state.keySet()) {
			Type t = procedureToLustre.state.get(id);
			inputs.add(new VarDecl(inputStateAndGlobalMap.get(id), t));
			outputs.add(new VarDecl(outputStateAndGlobalMap.get(id), t));
		}
		
		for(String id : procedureToLustre.limpToLustre.globals.keySet()) {
			Type t = procedureToLustre.limpToLustre.globals.get(id);
			inputs.add(new VarDecl(inputStateAndGlobalMap.get(id), t));
			outputs.add(new VarDecl(outputStateAndGlobalMap.get(id), t));
		}
		
		blockMap = getMapOfBasicBlocks(procedureToLustre.firstBlock, blockMap);
		
		/* set the names for, and add locals and equations for the state tracking variables */
		mainNodeStateId = getUniqueMainNodeID("state");
		mainNodePreStateId = getUniqueMainNodeID("pre_state");
		mainNodeInitStateId = getUniqueMainNodeID("init_state");
		mainNodeFinalStateId = getUniqueMainNodeID("final_state");
		mainNodeComponentPreconditionId = getUniqueMainNodeID("component_preconditions");
		mainNodeComponentPostconditionId = getUniqueMainNodeID("component_postconditions");

		locals.add(new VarDecl(mainNodeStateId, NamedType.INT));
		locals.add(new VarDecl(mainNodePreStateId, NamedType.INT));
		locals.add(new VarDecl(mainNodeInitStateId, NamedType.INT));
		locals.add(new VarDecl(mainNodeFinalStateId, NamedType.INT));
		
		mangleList.addSingleToMangleList("state", mainNodeStateId);
		mangleList.addSingleToMangleList("pre_state", mainNodePreStateId);
		mangleList.addSingleToMangleList("init_state", mainNodeInitStateId);
		mangleList.addSingleToMangleList("final_state", mainNodeFinalStateId);		
		mangleList.addSingleToMangleList("component_preconditions", mainNodeComponentPreconditionId);
		mangleList.addSingleToMangleList("component_postconditions", mainNodeComponentPostconditionId);
		mangleList.addSingleToMangleList("", "state");
		mangleList.addSingleToMangleList("", "pre_state");
		mangleList.addSingleToMangleList("", "init_state");
		mangleList.addSingleToMangleList("", "final_state");
		mangleList.addSingleToMangleList("", "component_preconditions");
		mangleList.addSingleToMangleList("", "component_postconditions");
		
		equations.add(this.generateStateEquation(blockMap));
		equations.add(this.generatePreStateEquation());
		equations.add(this.generateInitStateEquation());
		equations.add(this.generateFinalStateEquation(blockMap));

		/* if there are state variables, lets set the names for, and add locals and equations for the node state record objects */		
		if(!procedureToLustre.state.isEmpty()) {
			mainNodeStateRecordId = getUniqueMainNodeID("state_record");
			mainNodePreStateRecordId = getUniqueMainNodeID("pre_state_record");
			mainNodeInitStateRecordId = getUniqueMainNodeID("init_state_record");
			locals.add(new VarDecl(mainNodeStateRecordId, new NamedType(procedureToLustre.stateRecordTypeId)));
			locals.add(new VarDecl(mainNodePreStateRecordId, new NamedType(procedureToLustre.stateRecordTypeId)));
			locals.add(new VarDecl(mainNodeInitStateRecordId, new NamedType(procedureToLustre.stateRecordTypeId)));
			mangleList.addSingleToMangleList("state_record", mainNodeStateRecordId);
			mangleList.addSingleToMangleList("pre_state_record", mainNodePreStateRecordId);
			mangleList.addSingleToMangleList("init_state_record", mainNodeInitStateRecordId);
			mangleList.addSingleToMangleList("", "state_record");
			mangleList.addSingleToMangleList("", "pre_state_record");
			mangleList.addSingleToMangleList("", "init_state_record");
			equations.add(this.generateInitStateRecordEquation(inputStateAndGlobalMap));
			equations.add(this.generatePreStateRecordEquation());
		}
		
		if(!procedureToLustre.limpToLustre.globals.isEmpty()) {
			/* set the names for, and add locals and equations for the node state record objects */
			mainNodeGlobalRecordId = getUniqueMainNodeID("global_record");
			mainNodePreGlobalRecordId = getUniqueMainNodeID("pre_global_record");
			mainNodeInitGlobalRecordId = getUniqueMainNodeID("init_global_record");
			locals.add(new VarDecl(mainNodeGlobalRecordId, new NamedType(procedureToLustre.globalRecordTypeId)));
			locals.add(new VarDecl(mainNodePreGlobalRecordId, new NamedType(procedureToLustre.globalRecordTypeId)));
			locals.add(new VarDecl(mainNodeInitGlobalRecordId, new NamedType(procedureToLustre.globalRecordTypeId)));
			mangleList.addSingleToMangleList("global_record", mainNodeGlobalRecordId);
			mangleList.addSingleToMangleList("pre_global_record", mainNodePreGlobalRecordId);
			mangleList.addSingleToMangleList("init_global_record", mainNodeInitGlobalRecordId);
			mangleList.addSingleToMangleList("", "global_record");
			mangleList.addSingleToMangleList("", "pre_global_record");
			mangleList.addSingleToMangleList("", "init_global_record");
			equations.add(this.generateInitGlobalRecordEquation(inputStateAndGlobalMap));
			equations.add(this.generatePreGlobalRecordEquation());	
		}
		
		locals.add(new VarDecl(mainNodeComponentPreconditionId, NamedType.BOOL));
		locals.add(new VarDecl(mainNodeComponentPostconditionId, NamedType.BOOL));				
		
		equations.add(this.generateStateAndGlobalAssignmentEquation(blockMap));

		assertions.add(new IdExpr(mainNodeComponentPostconditionId));

		for(LustrePrecondition lpre : translateAttributes.preconditions) {
			String name = getUniqueMainNodeID(lpre.name);
			locals.add(new VarDecl(name, NamedType.BOOL));
			mangleList.addSingleToMangleList(lpre.name, name);
			Expr stateComparison = new BinaryExpr(new IdExpr(this.mainNodeStateId), BinaryOp.EQUAL, new IdExpr(this.mainNodeInitStateId));
			Expr rhs = new BinaryExpr(stateComparison, BinaryOp.IMPLIES, lpre.condition);
			equations.add(new Equation(new IdExpr(name),rhs));
			assertions.add(new IdExpr(name));
		}

		for(LustrePostcondition lpost : translateAttributes.postconditions) {
			String name = getUniqueMainNodeID(lpost.name);
			Expr updated = lpost.condition.accept(new MainNodeIdVisitor(this.procedureToLustre,this.mainNodeInitGlobalRecordId));
			locals.add(new VarDecl(name, NamedType.BOOL));
			mangleList.addSingleToMangleList(lpost.name, name);
			Expr stateComparison = new BinaryExpr(new IdExpr(this.mainNodeStateId), BinaryOp.EQUAL, new IdExpr(this.mainNodeFinalStateId));
			Expr rhs = new BinaryExpr(stateComparison, BinaryOp.IMPLIES, updated);
			equations.add(new Equation(new IdExpr(name),rhs));
			properties.add(name);
		}

		for(Integer key : blockMap.keySet()) {
			String reachabilityId = getUniqueMainNodeID("state_" + key + "_is_unreachable");
			String viabilityId = getUniqueMainNodeID("state_" + key + "_is_nonviable");
			
			Expr stateComparison = new BinaryExpr(new IdExpr(this.mainNodePreStateId), BinaryOp.NOTEQUAL, new IntExpr(key));
			
			locals.add(new VarDecl(reachabilityId, NamedType.BOOL));
			locals.add(new VarDecl(viabilityId, NamedType.BOOL));
			
			mangleList.addSingleToMangleList("state_" + key + "_is_unreachable", reachabilityId);
			mangleList.addSingleToMangleList("state_" + key + "_is_nonviable", viabilityId);
			mangleList.addSingleToMangleList("", "state_" + key + "_is_unreachable");
			mangleList.addSingleToMangleList("", "state_" + key + "_is_nonviable");
			
			equations.add(new Equation(new IdExpr(reachabilityId), stateComparison));
			List<Expr> args = new ArrayList<>();
			args.add(new IdExpr(this.mainNodeComponentPreconditionId));
			equations.add(new Equation(new IdExpr(viabilityId), new BinaryExpr(new NodeCallExpr("H",args), BinaryOp.IMPLIES, stateComparison)));
			
			properties.add(reachabilityId);
			properties.add(viabilityId);
		}
		
		for(String id : procedureToLustre.state.keySet()) {
			IdExpr lhs = new IdExpr(outputStateAndGlobalMap.get(id));
			Expr rhs = new RecordAccessExpr(new IdExpr(this.mainNodeStateRecordId), id);
			equations.add(new Equation(lhs,rhs));
		}
		
		for(String id : procedureToLustre.limpToLustre.globals.keySet()) {
			IdExpr lhs = new IdExpr(outputStateAndGlobalMap.get(id));
			Expr rhs = new RecordAccessExpr(new IdExpr(this.mainNodeGlobalRecordId), id);
			equations.add(new Equation(lhs,rhs));
		}
		
		node = new Node(mainNodeId,inputs,outputs,locals,equations,properties,assertions);
	}
	
	private class MainNodeIdVisitor extends AstMapVisitor {

		private LocalProcedureToLustre procedureToLustre; 
		private final String initGlobalRecordId;
		
		public MainNodeIdVisitor(LocalProcedureToLustre p2l, String globalRecordId) {
			this.procedureToLustre=p2l;
			this.initGlobalRecordId=globalRecordId;
		}
		
		@Override
		public Expr visit(IdExpr ide) {
			if(InitIds.isEncoded(ide.id)) {
				String decoded = InitIds.decode(ide.id);
				if(procedureToLustre.limpToLustre.globals.containsKey(decoded)) {
					return new RecordAccessExpr(new IdExpr(initGlobalRecordId), decoded);
				}
				throw new IllegalArgumentException(decoded + " is not a global in this specification.");
			} else {
				return ide;
			}
		}
	}	
}
