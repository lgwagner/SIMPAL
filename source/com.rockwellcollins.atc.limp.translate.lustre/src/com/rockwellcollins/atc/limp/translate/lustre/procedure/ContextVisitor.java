package com.rockwellcollins.atc.limp.translate.lustre.procedure;

/**
 * This is a simple visitor that is used to update IdExprs. It is used by 
 */
import java.util.Map;

import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.visitors.AstMapVisitor;

public class ContextVisitor extends AstMapVisitor {
	
	private Map<String, Expr> context;

	public ContextVisitor(Map<String,Expr> context) {
		this.context = context;
	}
	
	@Override
	public Expr visit(IdExpr ide) {
		if(context.containsKey(ide.id)) {
			return context.get(ide.id);
		} else {
			return ide;
		}
	}
}
