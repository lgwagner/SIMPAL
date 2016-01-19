package com.rockwellcollins.atc.limp.reasoning;

import java.util.Map;

import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.reasoning.visitor.LimpMapVisitor;

public class SubForIds extends LimpMapVisitor {
	
	private Map<VariableRef,Expr> programEnvironment;

	public SubForIds(Map<VariableRef,Expr> pvsMap) {
		programEnvironment = pvsMap;
	}
	
	//Note that the substitution for IdExprs will take place even if they have different types 
	// (e.g., InputArg versus GlobalDelcaration). I think this is fine for GatherProcedureEnvironments 
    // since I only put the left-hand side of assignment statements in the programEnvironment and so the
	// type is unique for a given VariableRef. I should verify that this is safe though. If not, I may need
	// to store the type info in the programEnvironment as well.
	
	@Override
	public Expr caseIdExpr(IdExpr id) {
		if (programEnvironment.containsKey(id.getId())) {
			return (Expr) programEnvironment.get(id.getId());
		} else if (id.getId() instanceof ConstantDeclaration) {
			ConstantDeclaration cd = (ConstantDeclaration) id.getId();
			return (Expr) cd.getExpr();
		}
		return id;
	}
	
}
