package com.rockwellcollins.atc.limp.translate.lustre.procedure;

/**
 * GenerateGlobalAssignment sorts through equations in the LustreBasicBlock and identifies
 * which modify globals. If a global is written then the new value must be captured and the
 * current value of a global variable updated.
 */
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.VarDecl;

import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.ExtendedEquation;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustreBasicBlock;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LocalProcedureToLustre;

public class GenerateGlobalAssignments {

	public static ExtendedEquation crunch(ExtendedEquation eeq, LustreBasicBlock block, LocalProcedureToLustre p2l) {
		GenerateGlobalAssignments generateAssignments = new GenerateGlobalAssignments(p2l);
		return generateAssignments.doExtendedEquation(eeq, block);
	}
	
	private GenerateGlobalAssignments(LocalProcedureToLustre p2l) {
		this.procedureToLustre=p2l;
	}
	
	private LocalProcedureToLustre procedureToLustre;

	private ExtendedEquation doExtendedEquation(ExtendedEquation eeq, LustreBasicBlock block) {
		if (eeq.equation.expr instanceof NodeCallExpr) {
			NodeCallExpr call = (NodeCallExpr) eeq.equation.expr;
			
			if(procedureToLustre.limpToLustre.procedures.containsKey(call.name)) {
				Procedure p = procedureToLustre.limpToLustre.procedures.get(call.name);
				
				for(Expr e : p.additionalOutputs.keySet()) {
					Expr instantiatedExpr = eeq.instantiatedDefinesExpr.get(e);
					VarDecl vd = p.additionalOutputs.get(e);
					VarDecl local = eeq.fcnReturnDecls.get(vd);
					
					String name = GetDefineUseName.crunch(instantiatedExpr);
					String previous = block.getCurrentSSAID(name);
					String current = block.getUniqueSSAID(name);
					Expr finalExpr = new IdExpr(local.id);
					
					Equation eq = AssignGlobal.crunch(instantiatedExpr, finalExpr, previous, current);
					eeq.globalAssignments.add(eq);
					block.generatedLocals.put(current, block.generatedLocals.get(previous));
				}
			}
		}
		return eeq;
	}
}
