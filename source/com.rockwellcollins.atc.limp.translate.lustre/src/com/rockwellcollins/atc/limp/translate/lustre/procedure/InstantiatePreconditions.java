package com.rockwellcollins.atc.limp.translate.lustre.procedure;

import java.util.LinkedHashMap;
import java.util.Map;

import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.VarDecl;
import jkind.lustre.visitors.AstMapVisitor;

import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.ExtendedEquation;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBasicBlock;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePrecondition;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LocalProcedureToLustre;

/**
 * InstantiatePreconditions takes a generic precondition and rewrites its values for the 
 * instance in which is it applied. Consider the following:
 * 
 *  procedure test (in1 : int) returns (out1 : int)
 *  attributes {
 *     precondition pre1 = in1 > 0;
 *  }
 *  
 *  g = test(g);
 *  
 *  This postcondition needs to be lifted for analysis so we must pull it out of the procedure.
 *  
 *  pre1 = in1 > 0
 *  g = test(g);
 *  
 *  
 *  in1 does not make any sense here so we must instantiate those arguments with variables
 *  from the current scope.
 *  
 *  pre1 = g > 0;
 *  g = test(g);
 *
 *  Because we've placed this before the procedure call SSA preserves the semantics.
 *  
 *  pre1 = g_0 > 0;
 *  g_1 = test(g_0);
 *  
 *  
 */
public class InstantiatePreconditions extends AstMapVisitor {

	public static ExtendedEquation crunch(ExtendedEquation eeq, LustreBasicBlock block, LocalProcedureToLustre p2l) {
		InstantiatePreconditions instantiate = new InstantiatePreconditions(p2l);
		return instantiate.doEquation(eeq,block);
	}
	
	private InstantiatePreconditions(LocalProcedureToLustre p2l) {
		this.procedureToLustre=p2l;
	}
	
	private LocalProcedureToLustre procedureToLustre;

	private ExtendedEquation doEquation(ExtendedEquation eeq, LustreBasicBlock block) {
		Map<String,Expr> context = new LinkedHashMap<>();
		
		if (eeq.equation.expr instanceof NodeCallExpr) {
			NodeCallExpr call = (NodeCallExpr) eeq.equation.expr;
			if(procedureToLustre.limpToLustre.procedures.containsKey(call.name)) {
				Procedure p = procedureToLustre.limpToLustre.procedures.get(call.name);
				
				if(p.function.inputs.size() != call.args.size()) {
					throw new IllegalArgumentException(eeq.equation + " does provides incorrect number of arguments");
				}
				
				if(p.function.outputs.size() != eeq.equation.lhs.size()) {
					throw new IllegalArgumentException(eeq.equation +" returns incorrect number of values.");
				}

				for(int i=0; i<p.function.inputs.size(); i++) {
					context.put(p.function.inputs.get(i).id, call.args.get(i));
				}
				
				for(int i=0; i<p.function.outputs.size(); i++) {
					context.put(p.function.outputs.get(i).id, eeq.equation.lhs.get(i));
				}
				
				ContextVisitor visit = new ContextVisitor(context);
				
				for(LustrePrecondition lpre : p.preconditions) {
					String uniqueName = block.getUniqueID(lpre.name);
					Expr liftedCondition = lpre.condition.accept(visit);
					eeq.preconditions.add(LustrePrecondition.create(uniqueName, liftedCondition));
				}
				
				for(Expr e : p.additionalInputs.keySet()) {
					VarDecl keyVD = p.additionalInputs.get(e);
					Expr instantiatedExpr = e.accept(visit);
					String global = GetDefineUseName.crunch(instantiatedExpr);
					Equation eq = ReferenceGlobal.crunch(instantiatedExpr, eeq.fcnArgDecls.get(keyVD).id, global);
					eeq.globalReferences.add(eq);
				}
				return eeq;
			}
		}
		return eeq;
	}
}
