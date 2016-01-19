package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import java.util.ArrayList;
import java.util.List;

import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.VarDecl;

import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LocalProcedureToLustre;
import com.rockwellcollins.atc.limp.translate.lustre.procedure.Procedure;

/**
 * RectifyProcedure calls operates over an equation and modifies any procedure calls to include the proper
 * number of arguments.
 * 
 * Each procedure call is represented with an uninterpreted function. If the procedure reads a global, the uninterpreted
 * function must accept that value as an input. If the procedure writes a global, the uninterpreted function must return 
 * a value that assigns that global.
 *
 */
public class RectifyProcedureCalls {

	public static ExtendedEquation crunch(ExtendedEquation eeq, LustreBasicBlock block, LocalProcedureToLustre p2l) {
		RectifyProcedureCalls rpc = new RectifyProcedureCalls();
		rpc.procedureToLustre=p2l;
		rpc.block=block;
		return rpc.rectifyProcedureCalls(eeq);
	}

	private LocalProcedureToLustre procedureToLustre;
	private LustreBasicBlock block;
	
	private ExtendedEquation rectifyProcedureCalls(ExtendedEquation eeq) {
		//here we must update the Function that represents the procedure call
		//such that it accepts and returns the modified globals.
		if (eeq.equation.expr instanceof NodeCallExpr) {
			NodeCallExpr call = (NodeCallExpr) eeq.equation.expr;
			List<Expr> args = new ArrayList<>(call.args);
			List<IdExpr> lhs = new ArrayList<>(eeq.equation.lhs);
			
			if(procedureToLustre.limpToLustre.procedures.containsKey(call.name)) {
				Procedure p = procedureToLustre.limpToLustre.procedures.get(call.name);

				for(VarDecl vd : p.additionalInputs.values()) {
					VarDecl updatedVD = new VarDecl(block.getUniqueID(vd.id), vd.type);
					eeq.fcnArgDecls.put(vd, updatedVD);
					args.add(new IdExpr(updatedVD.id));
					block.generatedLocals.put(updatedVD.id, updatedVD.type);
				}
				
				for(VarDecl vd : p.additionalOutputs.values()) {
					VarDecl updatedVD = new VarDecl(block.getUniqueID(vd.id), vd.type);
					eeq.fcnReturnDecls.put(vd, updatedVD);
					lhs.add(new IdExpr(updatedVD.id));
					block.generatedLocals.put(updatedVD.id, updatedVD.type);
				}
				eeq.equation = new Equation(lhs,new NodeCallExpr(p.function.id, args));
			}
		}
		return eeq;
	}
}
