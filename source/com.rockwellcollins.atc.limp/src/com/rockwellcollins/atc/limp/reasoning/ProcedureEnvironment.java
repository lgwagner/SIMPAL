package com.rockwellcollins.atc.limp.reasoning;

import java.util.LinkedHashMap;
import java.util.Map;

import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.VariableRef;

public class ProcedureEnvironment {
	private LocalProcedure lp;
	public Map<VariableRef,Expr> pvsMap;	
	
	public ProcedureEnvironment (LocalProcedure lp){
		this.lp = lp;
		pvsMap = new LinkedHashMap<>();
	}
	
	public String getLocalProcedureName() {
		return lp.getName();
	}
	
}
