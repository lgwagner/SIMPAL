package com.rockwellcollins.atc.limp.translate.lustre.procedure;

import jkind.lustre.ArrayAccessExpr;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.visitors.AstMapVisitor;

/**
 * GetDefineName returns the top level name of a DefineExpr. 
 * 
 * Defines G1 returns 'G1'
 * Defines G1.a returns 'G1'
 * Defines G1.a[2].b returns...you guessed it 'G1'
 *
 */
public class GetDefineUseName extends AstMapVisitor {
	
	public static String crunch(Expr e) {
		GetDefineUseName pv = new GetDefineUseName();
		e.accept(pv);
		return pv.ID;
	}
	
	public String ID;
	
	@Override
	public Expr visit(RecordAccessExpr rae) {
		rae.record.accept(this);
		return rae;
	}
	
	@Override
	public Expr visit(ArrayAccessExpr aae) {
		aae.array.accept(this);
		return aae;
	}
	
	@Override
	public Expr visit(IdExpr ide) {
		ID = ide.id;
		return ide;
	}
	
	@Override
	public Expr visit(NodeCallExpr call) {
		ID = call.name;
		return call;
	}
}
