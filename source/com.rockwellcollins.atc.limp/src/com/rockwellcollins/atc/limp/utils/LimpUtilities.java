package com.rockwellcollins.atc.limp.utils;

/*
 * This class includes several utility methods for working with Limp expressions.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.DefineUseRef;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordFieldType;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.SomeVarBlock;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.Type;
import com.rockwellcollins.atc.limp.TypeDeclaration;
import com.rockwellcollins.atc.limp.VarBlock;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;

public class LimpUtilities {
	//private LimpFactory f = LimpFactory.eINSTANCE;
	
	public static Map<String,VariableRef> getVariableMap(LocalProcedure lp) {
		Map<String,VariableRef> map = new LinkedHashMap<>();
		for(InputArg iarg : lp.getInputs().getInputArgs()) {
			map.put(iarg.getName(), iarg);
		}
		
		for(OutputArg oarg : lp.getOutputs().getOutputArgs()) {
			map.put(oarg.getName(), oarg);
		}
		
		if (lp.getVarBlock() instanceof SomeVarBlock) {
			SomeVarBlock svb = (SomeVarBlock) lp.getVarBlock();
			for(LocalArg larg : svb.getLocals()) {
				map.put(larg.getName(), larg);
			}
		}
		return map;
	}
	
	public static LocalProcedure getMainLocalProcedure(Specification s) {
		Map<String,LocalProcedure> map = getLocalProcedureMap(s);
		if(map.containsKey("main")) {
			return map.get("main");
		} else {
			LocalProcedure last = null;
			for(String key : map.keySet()) {
				last = map.get(key);
			}
			return last;
		}
	}

	public static Map<String,LocalProcedure> getLocalProcedureMap(Specification s) {
		Map<String,LocalProcedure> procedures = new LinkedHashMap<>();
		for(Declaration d : s.getDeclarations()) {
			if (d instanceof LocalProcedure) {
				LocalProcedure lp = (LocalProcedure) d;
				procedures.put(lp.getName(), lp);
			}
		}
		return procedures;
	}
	
	public static List<InputArg> getInputs(LocalProcedure lp) {
		List<InputArg> inputArgs = new ArrayList<>();
		inputArgs.addAll(lp.getInputs().getInputArgs());
		return inputArgs;
	}
	
	public static List<InputArg> getInputs(ExternalProcedure ep) {
		List<InputArg> inputArgs = new ArrayList<>();
		inputArgs.addAll(ep.getInputs().getInputArgs());
		return inputArgs;
	}
		
	public static List<LocalArg> getLocals(LocalProcedure lp) {
		List<LocalArg> localArgs = new ArrayList<>();
		if (lp.getVarBlock() instanceof SomeVarBlock) {
			SomeVarBlock svb = (SomeVarBlock) lp.getVarBlock();
			localArgs.addAll(svb.getLocals());
		}
		return localArgs;
	}
	
	public static List<OutputArg> getOutputs(LocalProcedure lp) {
		List<OutputArg> outputArgs = new ArrayList<>();
		outputArgs.addAll(lp.getOutputs().getOutputArgs());
		return outputArgs;
	}
	
	public static List<OutputArg> getOutputs(ExternalProcedure ep) {
		List<OutputArg> outputArgs = new ArrayList<>();
		outputArgs.addAll(ep.getOutputs().getOutputArgs());
		return outputArgs;
	}
	
	private static Expr getBaseExpr(Expr e) {
		if(e instanceof ArrayAccessExpr) {
			ArrayAccessExpr aae = (ArrayAccessExpr) e;
			return LimpUtilities.getBaseExpr(aae.getArray());
		}
		
		if(e instanceof RecordAccessExpr) {
			RecordAccessExpr rae = (RecordAccessExpr) e;
			return LimpUtilities.getBaseExpr(rae.getRecord());
		}
		
		return e;
	}
	
	public static GlobalDeclaration getGlobalInDefineUseRef(DefineUseRef ref) {
		Expr baseExpr = LimpUtilities.getBaseExpr(ref.getReferenceExpr());
		if(baseExpr instanceof IdExpr) {
			IdExpr ide = (IdExpr) baseExpr;
			if(ide.getId() instanceof GlobalDeclaration) {
				GlobalDeclaration gd = (GlobalDeclaration) ide.getId();
				return gd;
			}
		}
		return null;
	}
	
	public static Map<String,Type> getRecordTypeAsMap(RecordType rt) {
		Map<String,Type> map = new LinkedHashMap<>();
		for(RecordFieldType rft : rt.getRecordDef().getFields()) {
			map.put(rft.getFieldName(), rft.getFieldType());
		}
		return map;
	}
	
	public static Map<String,Expr> getRecordExprAsMap(RecordExpr re) {
		Map<String,Expr> map = new LinkedHashMap<>();
		for(RecordFieldExpr rfe : re.getFieldExprList()) {
			map.put(rfe.getFieldName(), rfe.getFieldExpr());
		}
		return map;
	}
	
	public static List<LocalArg> getLocalsFromVarBlock(VarBlock vb) {
		List<LocalArg> locals = new ArrayList<>();
		if (vb instanceof SomeVarBlock) {
			SomeVarBlock svb = (SomeVarBlock) vb;
			for(LocalArg larg : svb.getLocals()) {
				locals.add(larg);
			}
		}
		return locals;
	}
	
	public static FcnCallExpr getFunctionCallExpr(Statement s) {
		List<FcnCallExpr> fcnCalls = EcoreUtil2.getAllContentsOfType(s, FcnCallExpr.class);
		if(fcnCalls.size() == 0) {
			return null;
		}
		
		if(fcnCalls.size() == 1) {
			return fcnCalls.get(0);
		}
		
		throw new UnexpectedException("Multiple Function Calls found in a statement.  Bad bad bad.");
	}

	public static List<VariableRef> getStatementLHS(Statement s) {
		List<VariableRef> lhs = new ArrayList<>();
		if (s instanceof AssignmentStatement) {
			AssignmentStatement assign = (AssignmentStatement) s;
			lhs.addAll(assign.getIds().getIds());
		}
		return lhs;
	}
	
	public static List<Declaration> getSortedDeclarations(Specification s) {
		List<Declaration> sortedDecls = new ArrayList<>();
		sortedDecls.addAll(EcoreUtil2.getAllContentsOfType(s, TypeDeclaration.class));
		sortedDecls.addAll(EcoreUtil2.getAllContentsOfType(s, ConstantDeclaration.class));
		sortedDecls.addAll(EcoreUtil2.getAllContentsOfType(s, GlobalDeclaration.class));
		sortedDecls.addAll(EcoreUtil2.getAllContentsOfType(s, LocalFunction.class));
		sortedDecls.addAll(EcoreUtil2.getAllContentsOfType(s, ExternalFunction.class));
		sortedDecls.addAll(EcoreUtil2.getAllContentsOfType(s, LocalProcedure.class));
		sortedDecls.addAll(EcoreUtil2.getAllContentsOfType(s, ExternalProcedure.class));
		return sortedDecls;
	}

	//Collect the base and all indices of ArrayAccessExprs found in e.
	public static Collection<Expr> getIndicesValuesAndBase(Expr e) {
		Collection<Expr> exprSet = new HashSet<Expr>();
		return getIndicesValuesAndBase_rec(e, exprSet);	
	}
		
	public static Collection<Expr> getIndicesValuesAndBase_rec(Expr e, Collection<Expr> exprSet) {
		if (e instanceof ArrayAccessExpr) {
			ArrayAccessExpr a = (ArrayAccessExpr) e;
			//Add the index of e to exprSet
			exprSet.add(a.getIndex());
			return getIndicesValuesAndBase_rec(a.getArray(), exprSet);
		} 
		
		if (e instanceof RecordAccessExpr) {
			// Nothing to add here. So make the recursive call and keep looking for indices of 
			//  ArrayAccessExprs.
			RecordAccessExpr r = (RecordAccessExpr) e;
			return getIndicesValuesAndBase_rec(r.getRecord(), exprSet);
		} 
		
		if (e instanceof ArrayUpdateExpr) {
			ArrayUpdateExpr arrayUpdateExpr = (ArrayUpdateExpr) e;
			//Add the index of the ArrayUpdateExpr to exprSet
			exprSet.add(arrayUpdateExpr.getAccess().getIndex());
			//Add the value of the ArrayUpdateExpr to exprSet
			exprSet.add(arrayUpdateExpr.getValue());
			return getIndicesValuesAndBase_rec(arrayUpdateExpr.getAccess().getArray(), exprSet);
		}
		
		if (e instanceof RecordUpdateExpr) {
			RecordUpdateExpr recordUpdateExpr = (RecordUpdateExpr) e;
			//Add the value of the RecordUpdateExpr to exprSet
			exprSet.add(recordUpdateExpr.getValue());
			return getIndicesValuesAndBase_rec(recordUpdateExpr.getRecord(), exprSet);
		}
		
		// We should be down to the base at this point (a function call or an IdExpr). 
		// Add it to the exprSet and return
		exprSet.add(e);
		return exprSet;
		
	}
	
}
