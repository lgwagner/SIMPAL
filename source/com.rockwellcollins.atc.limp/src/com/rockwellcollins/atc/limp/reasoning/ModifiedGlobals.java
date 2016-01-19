package com.rockwellcollins.atc.limp.reasoning;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.LocalProcedure;

public class ModifiedGlobals {
	private LocalProcedure lp;
	private List<String> modified_globals;
	
	public ModifiedGlobals (LocalProcedure lp){
		this.lp = lp;
		modified_globals = new ArrayList<>();
	}
	
	public String getLocalProcedureName() {
		return this.lp.getName();
	}
	
	public List<String> getModifiedGlobals() {
		return this.modified_globals;
	}
	
	public void addModifiedGlobal (String s) {
		//Add if new
		if (!modified_globals.contains(s))
			modified_globals.add(s);
		return;
	}
	
	public void addModifiedGlobal (GlobalDeclaration gd) {
		//Add if new
		if (!modified_globals.contains(gd.getName()))
			modified_globals.add(gd.getName());
		return;
	}
	
	
}
