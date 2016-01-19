package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
/**
 * RemoveUnreferencedGlobals removes any globals that are not read or written to simplify
 * the model. 
 */
public class RemoveUnreferencedGlobals extends LimpSwitch<EObject> {

	public static Specification transform(Specification s) {
		RemoveUnreferencedGlobals removeGlobals = new RemoveUnreferencedGlobals();
		removeGlobals.doSwitch(s);
		for(GlobalDeclaration gd : EcoreUtil2.getAllContentsOfType(s, GlobalDeclaration.class)) {
			if(!removeGlobals.referenced.contains(gd)) {
				EcoreUtil2.remove(gd);
			}
		}
		return s;
	}
	
	private Set<GlobalDeclaration> referenced = new HashSet<>();
	
	private RemoveUnreferencedGlobals() {
		super();
	}
	
	@Override
	public EObject caseIdExpr(IdExpr ide) {
		if (ide.getId() instanceof GlobalDeclaration) {
			GlobalDeclaration gd = (GlobalDeclaration) ide.getId();
			referenced.add(gd);
		}
		return ide;
	}
	
	@Override
	public EObject caseIdList(IdList idl) {
		for(VariableRef vr : idl.getIds()) {
			if (vr instanceof GlobalDeclaration) {
				GlobalDeclaration gd = (GlobalDeclaration) vr;
				referenced.add(gd);
			}
		}
		return idl;
	}
	
	@Override
	public EObject defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject sub : e.eCrossReferences()) {
			this.doSwitch(sub);
		}
		return e;
	}
}
