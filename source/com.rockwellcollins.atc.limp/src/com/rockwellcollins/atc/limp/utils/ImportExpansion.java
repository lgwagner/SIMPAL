package com.rockwellcollins.atc.limp.utils;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

public class ImportExpansion extends LimpSwitch<EObject> {

	public static Specification transform(Specification s, LocalProcedure main) {
		if(main != null) {
			ImportExpansion expander = new ImportExpansion(main);
			return (Specification) expander.doSwitch(s);
		}
		return null;
	}
	
	private Set<Declaration> set = new HashSet<>();
	private LocalProcedure main;

	private ImportExpansion(LocalProcedure main) {
		this.main=main;
	}
	
	@Override
	public EObject caseSpecification(Specification s) {
		this.doSwitch(main);
		s.getDeclarations().clear();
		s.getDeclarations().addAll(EcoreUtil2.copyAll(set));
		return s;
	}
	
	@Override
	public Declaration caseDeclaration(Declaration d) {
		set.add(d);
		this.defaultCase(d);
		return d;
	}

	@Override
	public EObject defaultCase(EObject e) {
		for(EObject sub : e.eContents()) {
			this.doSwitch(sub);
		}
		
		for(EObject ref : e.eCrossReferences()) {
			this.doSwitch(ref);
		}
		return e;
	}
}
