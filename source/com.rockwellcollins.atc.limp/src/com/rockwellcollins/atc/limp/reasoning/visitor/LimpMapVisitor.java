package com.rockwellcollins.atc.limp.reasoning.visitor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.util.LimpSwitch;

public class LimpMapVisitor extends LimpSwitch<EObject> {
	@Override
	public EObject doSwitch(EObject e) {
		EObject modified = super.doSwitch(e);
		if (modified != e) {
			return EcoreUtil2.copy(modified);
		}
		return e;
	}
	
	@Override
	public EObject defaultCase(EObject e) {
		for (EObject orig : e.eContents()) {
			EObject modified = doSwitch(orig);
			if (modified != orig) {
				EcoreUtil2.replace(orig,modified);
			}
		}
		return e;
	}
	
	public void copyAndReplace(EObject oldeo, EObject neweo) {
		EcoreUtil2.replace(oldeo, EcoreUtil2.copy(neweo));
	}
}
