package com.rockwellcollins.atc.limp.reasoning;

import java.util.ArrayList;
import java.util.List;

import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.LocalProcedure;

public class ModifiedGlobalsList {
	private List<ModifiedGlobals> mgl;

	public ModifiedGlobalsList() {
		mgl = new ArrayList<>();
	}
	
	public List<ModifiedGlobals> getModifiedGlobalsList() {
		return this.mgl;
	}
	
	//Check to see if a ModifiedGlobals exists with the same lp name. If so, add to that one. Otherwise, create a new one.
	public Void addGlobal (LocalProcedure lp, GlobalDeclaration gd) {
		boolean found_it = false;
		for (ModifiedGlobals mg : this.getModifiedGlobalsList()) {
			if (lp.getName() == mg.getLocalProcedureName()) {
				mg.addModifiedGlobal(gd);
				found_it = true;
			}
		}
		if (found_it == false) {
			ModifiedGlobals mgnew = new ModifiedGlobals(lp);
			mgnew.addModifiedGlobal(gd);
			mgl.add(mgnew);
		}
		return null;
	}
	
	//Check to see if a ModifiedGlobals exists with the same lp name. If so, add to that one. Otherwise, create a new one.
	public Void addFieldName (LocalProcedure lp, String s) {
		boolean found_it = false;
		for (ModifiedGlobals mg : this.getModifiedGlobalsList()) {
			if (lp.getName() == mg.getLocalProcedureName()) {
				mg.addModifiedGlobal(s);
				found_it = true;
			}
		}
		if (found_it == false) {
			ModifiedGlobals mgnew = new ModifiedGlobals(lp);
			mgnew.addModifiedGlobal(s);
			mgl.add(mgnew);
		}
		return null;
	}

	//Check to see if a ModifiedGlobals exists with the same lp name. If so, add to that one. Otherwise, create a new one.
	public Void addIndex (LocalProcedure lp, String s) {
		boolean found_it = false;
		for (ModifiedGlobals mg : this.getModifiedGlobalsList()) {
			if (lp.getName() == mg.getLocalProcedureName()) {
				mg.addModifiedGlobal(s);
				found_it = true;
			}
		}
		if (found_it == false) {
			ModifiedGlobals mgnew = new ModifiedGlobals(lp);
			mgnew.addModifiedGlobal(s);
			mgl.add(mgnew);
		}
		return null;
	}
	
}
