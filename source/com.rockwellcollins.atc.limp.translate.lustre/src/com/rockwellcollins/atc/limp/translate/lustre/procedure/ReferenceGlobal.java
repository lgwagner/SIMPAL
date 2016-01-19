package com.rockwellcollins.atc.limp.translate.lustre.procedure;

import jkind.lustre.ArrayAccessExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.visitors.AstMapVisitor;

import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 * Reference is used to generate an equation that gets the most relevant part of a global variable that 
 * is read by a procedure call.
 * 
 * This can be tricky because if the Uses expression only reads a portion of a global (i.e. field A of a global record)
 * we have to generate an expression that writes *just* that.
 * 
 * Uses G1
 * 	 G1_1 = G1_0
 *   ProcedureCall(arg1,arg2,G1_1)
 *   
 * Uses G2.a
 * 	 G2_a = G2_0.a;
 *   ProcedureCall(arg1,arg2,G2_a)
 * 
 * The latter case gets a bit tricky and this class sorts that out.
 */
public class ReferenceGlobal extends LimpSwitch<Expr> {

	private Expr usesExpr;
	private String referencedName;
	private String globalName;

	public static Equation crunch(Expr uses, String referencedName, String globalName) {
		ReferenceGlobal reference = new ReferenceGlobal();
		reference.usesExpr=uses;
		reference.referencedName=referencedName;
		reference.globalName=globalName;
		
		return reference.crunch();
	}
	
	private Equation crunch() {
		IdExpr lhs = new IdExpr(referencedName);
		Expr rhs = usesExpr.accept(new UsesVisitor(new IdExpr(globalName)));
		return new Equation(lhs,rhs);
	}
	
	private class UsesVisitor extends AstMapVisitor {
		
		private Expr current;
		
		private UsesVisitor(Expr globalName) {
			this.current=globalName;
		}
		
		@Override
		public Expr visit(IdExpr ide) {
			return current;
		}
		
		@Override
		public Expr visit(NodeCallExpr call) {
			return current;
		}
		
		@Override
		public Expr visit(RecordAccessExpr rae) {
			Expr recordAccess = new RecordAccessExpr(rae.record.accept(this), rae.field);
			return recordAccess;
		}
		
		@Override
		public Expr visit(ArrayAccessExpr aae) {
			Expr arrayAccess = new ArrayAccessExpr(aae.array.accept(this), aae.index);
			return arrayAccess;
		}
	}
}
