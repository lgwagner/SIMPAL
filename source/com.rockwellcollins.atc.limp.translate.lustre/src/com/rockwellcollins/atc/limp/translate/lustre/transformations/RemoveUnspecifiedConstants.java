package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.InputArgList;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.Specification;
/**
 * RemoveUnspecifiedConstants removes any constant that is not defined and replaces it as 
 * an ExternalFunction with zero arguments (which will be translated into an uninterpreted
 * function with 0 args) that has identical semantics after translation. 
  */
public class RemoveUnspecifiedConstants {

	private static ExternalFunction createFrozenConstant(ConstantDeclaration cd) {
		LimpFactory factory = LimpFactory.eINSTANCE;
		
		InputArgList ial = factory.createInputArgList();
		
		OutputArg out = factory.createOutputArg();
		out.setName("out");
		out.setType(cd.getType());
		
		ExternalFunction ef = factory.createExternalFunction();
		
		ef.setName(cd.getName());
		ef.setInputs(ial);
		ef.setOutput(out);

		return ef;
	}

	private static EObject createFcnCallExpr(ExternalFunction ef) {
		LimpFactory factory = LimpFactory.eINSTANCE;
		
		FcnCallExpr fce = factory.createFcnCallExpr();
		fce.setId(ef);
		fce.setExprs(factory.createExprList());
		return fce;
	}
	
	public static Specification transform(Specification s) {
		Map<ConstantDeclaration,ExternalFunction> map = new HashMap<>();
		
		for(ConstantDeclaration cd : EcoreUtil2.getAllContentsOfType(s, ConstantDeclaration.class)){
			if(cd.getExpr() == null) {
				ExternalFunction ef = createFrozenConstant(cd);
				map.put(cd, ef);
				EcoreUtil2.replace(cd,ef);
			}
		}
		
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(s, IdExpr.class)) {
			if (ide.getId() instanceof ConstantDeclaration) {
				ConstantDeclaration referenced = (ConstantDeclaration) ide.getId();
				if(map.containsKey(referenced)) {
					ExternalFunction ef = map.get(referenced);
					EcoreUtil2.replace(ide, createFcnCallExpr(ef));
				}
			}
		}
		
		return s;
	}
}
