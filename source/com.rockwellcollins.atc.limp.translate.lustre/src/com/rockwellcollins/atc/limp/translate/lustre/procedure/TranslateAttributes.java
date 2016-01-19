package com.rockwellcollins.atc.limp.translate.lustre.procedure;

import java.util.ArrayList;
import java.util.List;

import jkind.lustre.Expr;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.Attribute;
import com.rockwellcollins.atc.limp.Define;
import com.rockwellcollins.atc.limp.DefineUseRef;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Postcondition;
import com.rockwellcollins.atc.limp.Precondition;
import com.rockwellcollins.atc.limp.SomeAttributeBlock;
import com.rockwellcollins.atc.limp.Uses;
import com.rockwellcollins.atc.limp.exceptions.UnsupportedException;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePostcondition;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePrecondition;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpExprToLustreExpr;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.MangleList;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.LimpVoid;
/**
 * TranslateAttributes is used to grab all of the relevant information out of a
 * ProcedureCall's list of Attributes, which are 
 *  Preconditions
 *  Postconditions
 *  UseExprs
 *  DefineExprs
 *
 */
public class TranslateAttributes extends LimpSwitch<LimpVoid> {
	
	public static TranslateAttributes crunch(LocalProcedure lp, MangleList mangleList) {
		TranslateAttributes translateAttributes = new TranslateAttributes(lp.getName(), mangleList);
		if (lp.getAttributeBlock() instanceof SomeAttributeBlock) {
			SomeAttributeBlock sab = (SomeAttributeBlock) lp.getAttributeBlock();
			for(Attribute a : sab.getAttributeList()) {
				translateAttributes.doSwitch(a);
			}
		}
		return translateAttributes;
	}

	public static TranslateAttributes crunch(ExternalProcedure ep, MangleList mangleList) {
		TranslateAttributes translateAttributes = new TranslateAttributes(ep.getName(), mangleList);
		if (ep.getAttributeBlock() instanceof SomeAttributeBlock) {
			SomeAttributeBlock sab = (SomeAttributeBlock) ep.getAttributeBlock();
			for(Attribute a : sab.getAttributeList()) {
				translateAttributes.doSwitch(a);
			}
		}
		return translateAttributes;
	}

	private String name;
	
	public MangleList mangleList;

	public TranslateAttributes(String name, MangleList mangleList) {
		this.name=name;
		this.mangleList = mangleList;
	}
	
	public List<LustrePrecondition> preconditions = new ArrayList<>();
	public List<LustrePostcondition> postconditions = new ArrayList<>();
	public List<Expr> defineExprs = new ArrayList<>();
	public List<Expr> usesExprs = new ArrayList<>();
	
	@Override
	public LimpVoid casePrecondition(Precondition pre) {
		preconditions.add(LustrePrecondition.from(pre,name));
		// TBD this addition to the mangleList is what this LustrePrecondition.from mangles as of today
		mangleList.addSingleToMangleList(pre.getName(), name + "_" + pre.getName());
		return LimpVoid.instance;
	}
	
	@Override
	public LimpVoid casePostcondition(Postcondition post) {
		postconditions.add(LustrePostcondition.from(post,name));
		// TBD this addition to the mangleList is what this LustrePostcondition.from mangles as of today
		mangleList.addSingleToMangleList(post.getName(), name + "_" + post.getName());		
		return LimpVoid.instance;
	}
	
	@Override
	public LimpVoid caseDefine(Define define) {
		for(DefineUseRef dur : define.getElements()) {
			Expr e = LimpExprToLustreExpr.translate(dur.getReferenceExpr());
			defineExprs.add(e);
		}
		return LimpVoid.instance;
	}
	
	@Override
	public LimpVoid caseUses(Uses uses) {
		for(DefineUseRef dur : uses.getElements()) {
			Expr e = LimpExprToLustreExpr.translate(dur.getReferenceExpr());
			usesExprs.add(e);
		}
		return LimpVoid.instance;
	}
	
	@Override
	public LimpVoid defaultCase(EObject eo) {
		throw new UnsupportedException(eo.toString() + " is not supported here.");
	}
}
