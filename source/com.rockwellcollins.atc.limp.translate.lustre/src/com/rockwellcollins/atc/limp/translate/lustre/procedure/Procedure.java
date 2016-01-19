package com.rockwellcollins.atc.limp.translate.lustre.procedure;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkind.lustre.Expr;
import jkind.lustre.Function;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.VarDecl;

import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePostcondition;
import com.rockwellcollins.atc.limp.translate.basicblocks.lustre.LustrePrecondition;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpDeclarationToLustreDeclaration;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpToLustre;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.MangleList;

/**
 * Procedure is a class the captures all of the information necessary to correctly
 * process a procedure call. While they are represented with an uninterpreted function, 
 * the defines and uses expressions indicate more inputs/outputs than the signature of
 * the function.
 * 
 * This information is captured here along with some utilities to keep variable naming
 * unique, etc.
 */
public class Procedure {

	private static final String inputSuffix = "_IN";
	private static final String outputSuffix = "_OUT";

	public static Procedure crunch(LocalProcedure lp, LimpToLustre l2l, MangleList mangleList) {
		Procedure p = new Procedure(l2l, mangleList);
		p.translateLocalProcedure(lp);
		return p;
	}
	
	public static Procedure crunch(ExternalProcedure ep, LimpToLustre l2l, MangleList mangleList) {
		Procedure p = new Procedure(l2l, mangleList);
		p.translateExternalProcedure(ep);
		return p;
	}
	
	public static NodeCallExpr getCallExpr(Expr e) {
		if (e instanceof NodeCallExpr) {
			NodeCallExpr call = (NodeCallExpr) e;
			return call;
		}
		return null;
	}
	
	public Function function;	
	public List<LustrePrecondition> preconditions = new ArrayList<>();
	public List<LustrePostcondition> postconditions = new ArrayList<>();

	public Map<Expr,VarDecl> additionalInputs = new LinkedHashMap<>();
	public Map<Expr,VarDecl> additionalOutputs = new LinkedHashMap<>();
	
	public List<Expr> defineExprs;
	public List<Expr> useExprs;
	
	public LimpToLustre limpToLustre;
	
	public MangleList mangleList;
	
	private Procedure(LimpToLustre l2l, MangleList mangleList) {
		this.limpToLustre=l2l;
		this.mangleList = mangleList;
	}
	
	public Function getFunction() {
		return function;
	}
	
	private void translateLocalProcedure(LocalProcedure lp) {
		function = LimpDeclarationToLustreDeclaration.crunch(lp);
		TranslateAttributes translateAttributes = TranslateAttributes.crunch(lp, mangleList);
		preconditions = translateAttributes.preconditions;
		postconditions = translateAttributes.postconditions;
		defineExprs = translateAttributes.defineExprs;
		useExprs = translateAttributes.usesExprs;
		updateSignatures();
	}
	
	private void translateExternalProcedure(ExternalProcedure ep) {
		function = LimpDeclarationToLustreDeclaration.crunch(ep);
		TranslateAttributes translateAttributes = TranslateAttributes.crunch(ep, mangleList);
		preconditions = translateAttributes.preconditions;
		postconditions = translateAttributes.postconditions;
		defineExprs = translateAttributes.defineExprs;
		useExprs = translateAttributes.usesExprs;
		updateSignatures();
	}
	
	private void updateSignatures() {
		String name = function.id;
		List<VarDecl> outputs = new ArrayList<>(function.outputs);
		List<VarDecl> inputs = new ArrayList<>(function.inputs);
		Set<String> usedIds = this.getUsedIds();

		for(Expr e : useExprs) {
			VarDecl vd = GetDefineExprType.crunch(limpToLustre, e, mangleList);
			VarDecl updated = new VarDecl(limpToLustre.getUniqueID(vd.id + inputSuffix, usedIds), vd.type);
			mangleList.addSingleToMangleList(e.toString(), updated.id);
			usedIds.add(updated.id);
			inputs.add(updated);
			this.additionalInputs.put(e, updated);
		}
		
		for(Expr e : defineExprs) {
			VarDecl vd = GetDefineExprType.crunch(limpToLustre, e, mangleList);
			VarDecl updated = new VarDecl(limpToLustre.getUniqueID(vd.id + outputSuffix, usedIds), vd.type);
			mangleList.addSingleToMangleList(e.toString(), updated.id);
			usedIds.add(updated.id);
			outputs.add(updated);
			this.additionalOutputs.put(e,updated);
		}
		function = new Function(name,inputs,outputs);
	}
	
	private Set<String> getUsedIds() {
		Set<String> usedIds = limpToLustre.getGlobalUsedIds();
		for(VarDecl vd : function.inputs) {
			usedIds.add(vd.id);
		}
		
		for(VarDecl vd : function.outputs) {
			usedIds.add(vd.id);
		}
		return usedIds;
	}
}
