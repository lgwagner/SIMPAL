package com.rockwellcollins.atc.validation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.LimpVoid;

public class LimpGetReferencedDeclarations extends LimpSwitch<LimpVoid> {

	public static Map<String, String> get(EObject e) {
		LimpGetReferencedDeclarations visitor = new LimpGetReferencedDeclarations(e.eResource());
		visitor.doSwitch(e);
		return visitor.map;
	}

	private Map<String, String> map = new HashMap<>();
	private Resource resouce;

	public LimpGetReferencedDeclarations(Resource resource) {
		this.resouce = resource;
	}

	@Override
	public LimpVoid caseDeclaration(Declaration decl) {
		if (!decl.eResource().equals(resouce)) {
			String name = SimpleAttributeResolver.NAME_RESOLVER.apply(decl);
			if (name != null) {
				map.put(name, decl.eResource().getURI().lastSegment());
			}
		}

		this.defaultCase(decl);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid defaultCase(EObject e) {
		for (EObject sub : e.eContents()) {
			doSwitch(sub);
		}

		for (EObject ref : e.eCrossReferences()) {
			doSwitch(ref);
		}

		return LimpVoid.instance;
	}
}
