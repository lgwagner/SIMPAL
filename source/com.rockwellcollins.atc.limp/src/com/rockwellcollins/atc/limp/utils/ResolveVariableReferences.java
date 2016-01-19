package com.rockwellcollins.atc.limp.utils;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
/**
 * VariableRefs are model-dependent.  When making delta changes to an existing
 * EMF model, it is sometimes necessary to update the VariableRefs.  This is handled
 * in this framework by keeping a map between existing VariableRefs and the VariableRef
 * they should be mapped to in the transformed model.
 * 
 * This class accepts this map, and then applies the transformation to any IdExpr that occurs.
  */
public class ResolveVariableReferences extends LimpSwitch<Void> {
	
	/**
	 * The mapping between VariableRefs in the pre-transformed model, and the VariableRefs
	 * they should be mapped to in the transformed model.
	 */
	private Map<VariableRef,VariableRef> vrm;
	
	/**
	 * Instantiate the ResolveVariableReferences object, setting the VariableRef map.
	 */
	public ResolveVariableReferences(Map<VariableRef,VariableRef> v) {
		super();
		vrm = v;
	}

	/**
	 * List all of the IdExprs in the Specification object and apply the transform to each.
	 */
	@Override
	public Void caseSpecification(Specification s) {
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(s, IdExpr.class)) {
			doSwitch(ide);
		}
		return null;
	}

	/**
	 * List all of the IdExprs in a LocalProcedure and apply the transform to each.
	 */
	@Override
	public Void caseLocalProcedure(LocalProcedure lp) {
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(lp, IdExpr.class)) {
			doSwitch(ide);
		}
		
		for(IdList idl : EcoreUtil2.getAllContentsOfType(lp, IdList.class)) {
			doSwitch(idl);
		}
		return null;
	}

	/**
	 * List all of the IdExprs in a IfThenElseStatement and apply the transform to each.
	 */
	@Override
	public Void caseIfThenElseStatement(IfThenElseStatement ite) {
		for(IdExpr ide : EcoreUtil2.getAllContentsOfType(ite, IdExpr.class)) {
			doSwitch(ide);
		}
		return null;
	}
	
	/**
	 * Find the VariableRef the IdExpr refers to, and replace that references from the one in the map.
	 */
	@Override
	public Void caseIdExpr(IdExpr ide) {
		VariableRef newVr = vrm.get(ide.getId());
		if(newVr != null) {
			ide.setId(newVr);
		}
		return null;
	}

	/**
	 * For an IdList, replace each VariableRef from it's corresponding value in the map.
	 */
	@Override
	public Void caseIdList(IdList idl) {
		ArrayList<VariableRef> newIdList = new ArrayList<VariableRef>(idl.getIds());
		idl.getIds().clear();
		
		for(VariableRef vr : newIdList) {
			VariableRef newVr = vrm.get(vr);
			if(newVr != null) {
				idl.getIds().add(newVr);
			} else {
				idl.getIds().add(vr);
			}
		}
		return null;
	}
	
	/**
	 * Do nothing in the event that an unspecified Limp EObject is encountered.
	 */
	@Override
	public Void defaultCase(EObject d) {
		return null;
	}
}
