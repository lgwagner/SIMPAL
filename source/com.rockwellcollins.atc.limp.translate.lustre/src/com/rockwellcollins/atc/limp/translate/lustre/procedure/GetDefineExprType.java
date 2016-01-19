package com.rockwellcollins.atc.limp.translate.lustre.procedure;

import jkind.lustre.ArrayAccessExpr;
import jkind.lustre.ArrayType;
import jkind.lustre.Expr;
import jkind.lustre.Function;
import jkind.lustre.IdExpr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.RecordType;
import jkind.lustre.Type;
import jkind.lustre.VarDecl;
import jkind.lustre.visitors.AstMapVisitor;
import jkind.util.TypeResolver;

import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpToLustre;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.MangleList;

/**
 * This will retrieve the type of a DefineExpr. For instance if global G1 is of type
 * 
 *  type G1_type = {a : int, b : real, c : bool};
 *  
 *  if global G1 is provided it will return type G1.
 *  if G1.a is provided it will return int
 *  if G1.b then it will return real
 *  etc...
 *
 */
public class GetDefineExprType extends AstMapVisitor {

	public static VarDecl crunch(LimpToLustre l2l, Expr e, MangleList mangleList) {
		GetDefineExprType getType = new GetDefineExprType(l2l, mangleList);
		e.accept(getType);
		return new VarDecl(getType.name, getType.type);
	}
	
	public String name = new String();
	public Type type;
	public LimpToLustre limpToLustre;
	public MangleList mangleList;
	
	private GetDefineExprType(LimpToLustre l2l, MangleList mangleList) {
		this.limpToLustre=l2l;
		this.mangleList = mangleList;
	}
	
	private Type resolve(Type t) {
		return TypeResolver.resolve(t, limpToLustre.typedefs);
	}
	
	@Override
	public Expr visit(RecordAccessExpr rae) {
		rae.record.accept(this);
		Type t = type;
		if (t instanceof RecordType) {
			RecordType record = (RecordType) t;
			type = resolve(record.fields.get(rae.field));
			name = name + "_" + rae.field;
		}
		return rae;
	}
	
	@Override
	public Expr visit(ArrayAccessExpr aae) {
		aae.array.accept(this);
		Type t = type;
		if (t instanceof ArrayType) {
			ArrayType array = (ArrayType) t;
			type = resolve(array.base);
			name = name + "_indexed_";
		}
		return aae;
	}
	
	@Override
	public Expr visit(NodeCallExpr call) {
		Function f = limpToLustre.functions.get(call.name);
		type = resolve(f.outputs.get(0).type);
		name = name + "_" + call.name;
		return call;
	}
	
	@Override
	public Expr visit(IdExpr ide) {
		type = resolve(limpToLustre.globals.get(ide.id));
		name = name + "_" + ide.id;
		return ide;
	}
	
}
