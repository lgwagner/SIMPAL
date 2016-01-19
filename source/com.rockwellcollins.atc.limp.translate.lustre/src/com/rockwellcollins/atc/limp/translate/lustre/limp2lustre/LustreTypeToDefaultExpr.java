package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import jkind.lustre.ArrayType;
import jkind.lustre.BoolExpr;
import jkind.lustre.Expr;
import jkind.lustre.IntExpr;
import jkind.lustre.NamedType;
import jkind.lustre.RealExpr;
import jkind.lustre.RecordExpr;
import jkind.lustre.RecordType;
import jkind.lustre.EnumType;
import jkind.lustre.SubrangeIntType;
import jkind.lustre.Type;

import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;

/**
 * LustreTypeToDefaultExpr
 * 
 * Will return a defaultExpr for a given Lustre type.
 * 	
 * 	Reals will return -1.0
 *  Booleans will return false
 *  Integers will return -1 
 *
 *	Composite types will return the values of the subExpr.
 */
public class LustreTypeToDefaultExpr {

	public static Expr getDefaultExpr(Map<String,Type> map, Type t) {
		LustreTypeToDefaultExpr typeToDefault = new LustreTypeToDefaultExpr(map);
		return typeToDefault.doType(t);
	}
	
	private Map<String,Type> typedefs;
	
	private LustreTypeToDefaultExpr(Map<String,Type> map) {
		typedefs = map;
	}
	
	public Expr doType(Type t) {
		if(t instanceof NamedType) {
			return doNamedType((NamedType) t);
		}

		if(t instanceof EnumType) {
			return doEnumType((EnumType) t);
		}
		
		if(t instanceof RecordType) {
			return doRecordType((RecordType) t);
		}
		
		if(t instanceof ArrayType) {
			return doArrayType((ArrayType) t);
		}
		
		if(t instanceof SubrangeIntType) {
			return doSubrangeIntType((SubrangeIntType) t);
		}
		
		try {
			throw new UnexpectedException("Unxpected type encountered.");
		} catch (UnexpectedException use) {
			use.printStackTrace();
		}
		return null;
	}

	private Expr doEnumType(EnumType t) {
		return new jkind.lustre.IdExpr(t.values.get(0));
	}
	
	private Expr doArrayType(ArrayType t) {
		List<Expr> elements = new ArrayList<>();
		for(int i=0; i<t.size; i++) {
			elements.add(doType(t.base));
		}
		return new jkind.lustre.ArrayExpr(elements);
	}

	private Expr doSubrangeIntType(SubrangeIntType t) {
		return new IntExpr(t.low);
	}

	private Expr doRecordType(RecordType t) {
		SortedMap<String,Expr> fieldExprs = new TreeMap<>();
		Iterator<String> keyIt = t.fields.keySet().iterator();
		while(keyIt.hasNext()) {
			String key = keyIt.next();
			Expr e = this.doType(t.fields.get(key));
			fieldExprs.put(key, e);
		}
		return new RecordExpr(t.id, fieldExprs);
	}

	private Expr doNamedType(NamedType t) {
		if(t.name.equals("real")) {
			return new RealExpr(new BigDecimal("-1.0"));
		}

		if(t.name.equals("bool")) {
			return new BoolExpr(false);
		}
		
		if(t.name.equals("int")) {
			return new IntExpr(new BigInteger("-1"));
		}
		
		Type td = typedefs.get(t.name);
		Expr returnExpr = doType(td);
		return returnExpr;
	}
}
