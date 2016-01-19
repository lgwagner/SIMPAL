package com.rockwellcollins.atc.limp.reasoning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.VariableRef;

public class ProcedureEnvironmentList {
	private List<ProcedureEnvironment> pel;

	public ProcedureEnvironmentList() {
		pel = new ArrayList<>();
	}
	
	public List<ProcedureEnvironment> getProcedureEnvironmentList() {
		return pel;
	}
	
	public boolean containsLocalProcedure(LocalProcedure lp) {
		//Output true if lp is in the list
		for (ProcedureEnvironment pe : this.getProcedureEnvironmentList()) {
			if (pe.getLocalProcedureName() == lp.getName()) {
				return true;
			} 
		}
		// If lp isn't in the list, return fale.
		return false;
	}
	
	
	public Map<VariableRef,Expr> getProgramEnvironment(LocalProcedure lp) {
		//Output ProcedureEnvironment if lp is in the list
		for (ProcedureEnvironment pe : this.getProcedureEnvironmentList()) {
			if (pe.getLocalProcedureName() == lp.getName()) {
				return pe.pvsMap;
			} 
		}
		// If lp isn't in the list, return null.
		return null;
	} 
	
	
	public Expr getValueOfVariable(LocalProcedure lp, VariableRef variable) {
		if (containsLocalProcedure(lp)) {
			Map<VariableRef,Expr> pvsMap = getProgramEnvironment(lp);
			return pvsMap.get(variable);
		} else {
			return null;
		}
	} 
	
	//Check to see if a ProcedureEnvironment exists with the same lp name. If so, add to that one. Otherwise, create a new one.
	public void updateProcedureVariableState (LocalProcedure lp, VariableRef variable, Expr value) {
		if (containsLocalProcedure(lp)) {
			Map<VariableRef,Expr> pvsMap = getProgramEnvironment(lp);
			pvsMap.put(variable, value);
		} else {
			ProcedureEnvironment penew = new ProcedureEnvironment(lp);
			penew.pvsMap.put(variable, value);
			pel.add(penew);
		}
	}
	
}
