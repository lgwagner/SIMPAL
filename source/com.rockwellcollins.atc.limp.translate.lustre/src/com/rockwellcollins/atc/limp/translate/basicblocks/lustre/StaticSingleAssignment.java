package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.RecordExpr;
import jkind.lustre.Type;
import jkind.lustre.visitors.AstMapVisitor;

import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LocalProcedureToLustre;
import com.rockwellcollins.atc.limp.translate.lustre.procedure.GenerateGlobalAssignments;
import com.rockwellcollins.atc.limp.translate.lustre.procedure.InstantiatePostconditions;
import com.rockwellcollins.atc.limp.translate.lustre.procedure.InstantiatePreconditions;

/**
 *  StaticSingleAssignment accepts a LustreBasicBlock and rewrites the equation
 *  list such that each variable is only assigned once. If a variable is assigned more
 *  than once, a temporary variable is assigned. At the end of the basic block the final
 *  variable name is assigned to the most recent temporary.
 *  
 *  For example, consider a basic block with teh following equations:
 *  
 *  x = y + 1;
 *  y = y + 1;
 *  x = y + 1;
 *  
 *  This will be rewritten as
 *  
 *  x0 = x;
 *  y0 = y;
 *  x1 = y0 + 1;
 *  y1 = y0 + 1;
 *  x2 = y1 + 1;
 *  x = x2;
 *  y = y1;
 *
 */
public class StaticSingleAssignment {

	public static LustreBasicBlock transform(LustreBasicBlock first, LocalProcedureToLustre p2l) {
		StaticSingleAssignment ssa = new StaticSingleAssignment(p2l);
		LustreBasicBlock newFirst = ssa.doSSA(first);
		return newFirst;
	}

	public StaticSingleAssignment(LocalProcedureToLustre p2l) {
		this.procedureToLustre = p2l;
	}
	
	private LocalProcedureToLustre procedureToLustre;
	private Map<LustreBasicBlock,LustreBasicBlock> map = new LinkedHashMap<>();

	private Type getType(LustreBasicBlock block, String id) {
		if(procedureToLustre.state.containsKey(id)) {
			return procedureToLustre.state.get(id);
		} else if (procedureToLustre.limpToLustre.globals.containsKey(id)) {
			return procedureToLustre.limpToLustre.globals.get(id);
		} else if (block.generatedLocals.containsKey(id)) {
			return block.generatedLocals.get(id);
		} else {
			throw new UnexpectedException(id + " was not found in state or global map.");
		}
	}
	
	private LustreBasicBlock doSSA(LustreBasicBlock block) {

		//we've already processed this block, just return the value.
		if(map.containsKey(block)) {
			return map.get(block);
		}

		//we have to process this block.
		LustreBasicBlock newBlock = LustreBasicBlock.copy(block);
		
		/* 
		 * generate equations to assign the first instance of each state and global variable to
		 * the state input variable.
		 */ 
		for(String id : procedureToLustre.state.keySet()) {
			String lhs_id = newBlock.getUniqueSSAID(id);
			Equation eq = new Equation(new IdExpr(lhs_id),new RecordAccessExpr(new IdExpr(newBlock.stateInputId),id));
			ExtendedEquation eeq = new ExtendedEquation(eq);
			newBlock.equations.add(eeq);
			newBlock.generatedLocals.put(lhs_id, getType(block,id));
		}
		
		for(String id : procedureToLustre.limpToLustre.globals.keySet()) {
			String lhs_id = newBlock.getUniqueSSAID(id);
			Equation eq = new Equation(new IdExpr(lhs_id),new RecordAccessExpr(new IdExpr(newBlock.globalInputId), id));
			ExtendedEquation eeq = new ExtendedEquation(eq);
			newBlock.equations.add(eeq);
			newBlock.generatedLocals.put(lhs_id, getType(block,id));
		}
		
		newBlock.initIds.putAll(newBlock.currentIds);

		for(ExtendedEquation eeq : block.equations) {
			ExtendedEquation newEEQ = updateExtendedEquation(eeq,newBlock);
			newBlock.equations.add(newEEQ);
		}
		
		/*
		 * assign the final variable instance to the current variable instance for each
		 * global and output.
		 */
		for(String id : procedureToLustre.state.keySet()) {
			Equation eq = new Equation(new IdExpr(id), newBlock.getCurrentId(id));
			ExtendedEquation eeq = new ExtendedEquation(eq);
			newBlock.equations.add(eeq);
			newBlock.generatedLocals.put(id, getType(block,id));
		}
		
		for(String id : procedureToLustre.limpToLustre.globals.keySet()) {
			Equation eq = new Equation(new IdExpr(id), newBlock.getCurrentId(id));
			ExtendedEquation eeq = new ExtendedEquation(eq);
			newBlock.equations.add(eeq);
			newBlock.generatedLocals.put(id, getType(block,id));
		}
		
		/*
		 * assign the final state_output record and global_output record to each instance variable.
		 */
		if(!procedureToLustre.state.isEmpty()) {
			Map<String,Expr> stateRecordFieldExprs = new LinkedHashMap<>();
			for(String id : procedureToLustre.state.keySet()) {
				stateRecordFieldExprs.put(id, new IdExpr(id));
			}
			Equation stateRecordOutputEquation = new Equation(new IdExpr(newBlock.stateOutputId), new RecordExpr(procedureToLustre.getStateRecordType().id,stateRecordFieldExprs));
			ExtendedEquation stateRecordOutputEquationEeq = new ExtendedEquation(stateRecordOutputEquation);
			newBlock.equations.add(stateRecordOutputEquationEeq);
		}
		
		if(!procedureToLustre.limpToLustre.globals.isEmpty()) {
			Map<String,Expr> globalRecordFieldExprs = new LinkedHashMap<>();
			for(String id : procedureToLustre.limpToLustre.globals.keySet()) {
				globalRecordFieldExprs.put(id, new IdExpr(id));
			}
			
			Equation globalRecordOutputEquation = new Equation(new IdExpr(newBlock.globalOutputId), new RecordExpr(procedureToLustre.getGlobalRecordType().id,globalRecordFieldExprs));
			ExtendedEquation globalRecordOutputEquationEeq = new ExtendedEquation(globalRecordOutputEquation);
			newBlock.equations.add(globalRecordOutputEquationEeq);
		}

		//stick this in the map
		map.put(block, newBlock);	
		
		//Process the conditional exits from this block.
		for(LustreBlockEdge lbe : block.conditionalExits) {
			LustreBlockEdge newEdge = new LustreBlockEdge();
			newEdge.setCondition(lbe.getCondition());
			newEdge.setDestination(doSSA(lbe.getDestination()));
			newBlock.conditionalExits.add(newEdge);
		}
		
		//Process the unconditional exit from the block.
		if(block.unconditionalExit != null) {
			LustreBlockEdge newEdge = new LustreBlockEdge();
			LustreBasicBlock next = block.unconditionalExit.getDestination();
			LustreBasicBlock newNext = doSSA(next);
			newEdge.setDestination(newNext);
			newBlock.unconditionalExit = newEdge;
		}
		
		return newBlock;
	}

	private ExtendedEquation updateExtendedEquation(ExtendedEquation eeq, LustreBasicBlock newBlock) {
		eeq = RectifyProcedureCalls.crunch(eeq, newBlock, procedureToLustre);
		eeq = InstantiatePreconditions.crunch(eeq, newBlock, procedureToLustre);
		
		List<Equation> newGlobalReferences = new ArrayList<>();
		for(Equation eq : eeq.globalReferences) {
			Expr newRHS = eq.expr.accept(new SubstitutionVisitor(newBlock.currentIds));
			newGlobalReferences.add(new Equation(eq.lhs,newRHS));
		}
		eeq.globalReferences=newGlobalReferences;
		
		//Preconditions
		for(LustrePrecondition lpre : eeq.preconditions) {
			Expr ssaExpr = lpre.condition.accept(new SubstitutionVisitor(newBlock.currentIds));
			lpre.condition = ssaExpr;
		}
		
		Expr newRHS = eeq.equation.expr.accept(new SubstitutionVisitor(newBlock.currentIds));
		List<IdExpr> newLHS = new ArrayList<>();
		for(IdExpr ide : eeq.equation.lhs) {
			if(!eeq.isInstantiatedVarDecl(ide.id)) {
				IdExpr nextID = new IdExpr(newBlock.getUniqueSSAID(ide.id));
				newLHS.add(nextID);
				Type t = getType(newBlock,ide.id);
				newBlock.generatedLocals.put(nextID.id, t);
			} else {
				newLHS.add(ide);
			}
		}
		eeq.equation = new Equation(newLHS,newRHS);

		eeq = InstantiatePostconditions.crunch(eeq, newBlock, procedureToLustre);
		eeq = GenerateGlobalAssignments.crunch(eeq, newBlock, procedureToLustre);
		
		//postconditions
		for(LustrePostcondition lpost : eeq.postconditions) {
			Expr ssaExpr = lpost.condition.accept(new SubstitutionVisitor(newBlock.currentIds));
			lpost.condition = ssaExpr;
		}
		
		List<Equation> globalAssignments = new ArrayList<>(eeq.globalAssignments);
		eeq.globalAssignments.clear();
		for(Equation eq : globalAssignments) {
			Expr rhs = eq.expr.accept(new SubstitutionVisitor(newBlock.currentIds));
			eeq.globalAssignments.add(new Equation(eq.lhs,rhs));
		}
		
		return eeq;
	}

	private class SubstitutionVisitor extends AstMapVisitor {
		private final Map<String,Integer> current;
		
		public SubstitutionVisitor(Map<String,Integer> current) {
			this.current=current;
		}
		
		@Override
		public Expr visit(IdExpr e) {
			if (current.containsKey(e.id)) {
				String name = LustreBasicBlock.generateNumberedID(e.id, current.get(e.id));
				return new IdExpr(name);
			} else {
				return e;
			}
		}
	}
}
