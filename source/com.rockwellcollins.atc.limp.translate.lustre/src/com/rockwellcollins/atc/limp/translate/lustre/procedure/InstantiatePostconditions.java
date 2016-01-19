package com.rockwellcollins.atc.limp.translate.lustre.procedure;

import java.util.LinkedHashMap;
import java.util.Map;

import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.visitors.AstMapVisitor;

import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.ExtendedEquation;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBasicBlock;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePostcondition;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LocalProcedureToLustre;

/**
 * InstantiatePostconditions takes a generic postcondition and rewrites its values for the 
 * instance in which is it applied. Consider the following:
 * 
 *  procedure test (in1 : int) returns (out1 : int)
 *  attributes {
 *     postcondition post1 = out1 > in1;
 *  }
 *  
 *  g = test(g);
 *  
 *  This postcondition needs to be lifted for analysis so we must pull it out of the procedure.
 *  
 *  g = test(g);
 *  post1 = out1 > in1;
 *  
 *  in1 and out1 do not make any sense here so we must instantiate those arguments with variables
 *  from the current scope.
 *  
 *  g = test(g);
 *  post1 = g > g;
 *  
 *  This doesn't make much sense in Lustre either because the variable g is being compared to itself. To 
 *  fix this we apply this instantiation after StaticSingleAssignment
 *  
 *  now:
 *  
 *  g_1 = test(g_0);
 *  post1 = g_1 > g_0;
 *  
 *  This makes sense.
 */
public class InstantiatePostconditions extends AstMapVisitor {

	public static ExtendedEquation crunch(ExtendedEquation eeq, LustreBasicBlock block, LocalProcedureToLustre p2l) {
		InstantiatePostconditions instantiate = new InstantiatePostconditions(p2l);
		return instantiate.doEquation(eeq,block);
	}
	
	private InstantiatePostconditions(LocalProcedureToLustre p2l) {
		this.procedureToLustre=p2l;
	}
	
	private LocalProcedureToLustre procedureToLustre;

	public ExtendedEquation doEquation(ExtendedEquation eeq, LustreBasicBlock block) {
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
				
				ContextVisitor contextVisit = new ContextVisitor(context);
				InitIdVisitor initIdVisit = new InitIdVisitor(block);
				
				for(LustrePostcondition lpost : p.postconditions) {
					String uniqueName = block.getUniqueID(lpost.name);
					Expr liftedCondition = lpost.condition.accept(contextVisit).accept(initIdVisit);
					eeq.postconditions.add(LustrePostcondition.create(uniqueName, liftedCondition));
				}
				
				for(Expr e : p.defineExprs) {
					Expr instantiatedExpr = e.accept(contextVisit).accept(initIdVisit);
					eeq.instantiatedDefinesExpr.put(e, instantiatedExpr);
				}
				
				return eeq;
			}
		}
		return eeq;
	}
	
	private class InitIdVisitor extends AstMapVisitor {

		private LustreBasicBlock block; 
		
		private InitIdVisitor(LustreBasicBlock block) {
			this.block=block;
		}
		
		@Override
		public Expr visit(IdExpr ide) {
			if(InitIds.isEncoded(ide.id)) {
				String decoded = InitIds.decode(ide.id);
				String initId = block.getInitialSSAID(decoded);
				return new IdExpr(initId);
			} else {
				return ide;
			}
		}
	}
}
