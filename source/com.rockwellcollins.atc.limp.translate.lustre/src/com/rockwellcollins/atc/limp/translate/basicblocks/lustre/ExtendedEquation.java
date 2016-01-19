package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.VarDecl;

/**
 * ExtendedEquation is a a class used to grab all of the relevant pieces of 
 * information from an Equation. 
 * 
 * If an Equation is a node/function call there may be preconditions, postconditions,
 * globals that are read and globals that are defined, that information needs to be
 * stored with the equation so it can be processed correctly later.
 */
public class ExtendedEquation {

	public List<LustrePrecondition> preconditions = new ArrayList<>();
	public List<LustrePostcondition> postconditions = new ArrayList<>();
	public List<Expr> useExprs = new ArrayList<>();
	public List<Expr> defineExprs = new ArrayList<>();
	
	public Equation equation;
	
	public List<Equation> globalReferences = new ArrayList<>();
	public List<Equation> globalAssignments = new ArrayList<>();
	
	public Map<VarDecl,VarDecl> fcnArgDecls = new LinkedHashMap<>();
	public Map<VarDecl,VarDecl> fcnReturnDecls = new LinkedHashMap<>();
	
	public Map<Expr,Expr> instantiatedDefinesExpr = new LinkedHashMap<>();
	
	public ExtendedEquation(Equation eq) {
		this.equation = eq;
	}
	
	public boolean isInstantiatedVarDecl(String id) {
		for(VarDecl vd : this.fcnReturnDecls.values()) {
			if(vd.id.equals(id)) {
				return true;
			}
		}
		return false;
	}
}


