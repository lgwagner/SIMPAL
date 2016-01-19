package com.rockwellcollins.atc.limp.reasoning.visitor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.util.LimpSwitch;

public class LimpVisitor extends LimpSwitch<Unit> {
	@Override
	public Unit defaultCase(EObject e) {
		for (EObject sub : e.eContents()) {
			doSwitch(sub);
		}
		return Unit.UNIT;
	}
	
	public void copyAndReplace(EObject oldeo, EObject neweo) {
		EcoreUtil2.replace(oldeo, EcoreUtil2.copy(neweo));
	}
}
