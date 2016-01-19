package com.rockwellcollins.atc.limp.translate.lustre.procedure;

import jkind.lustre.ArrayAccessExpr;
import jkind.lustre.ArrayUpdateExpr;
import jkind.lustre.Equation;
import jkind.lustre.Expr;
import jkind.lustre.IdExpr;
import jkind.lustre.NodeCallExpr;
import jkind.lustre.RecordAccessExpr;
import jkind.lustre.RecordUpdateExpr;
import jkind.lustre.visitors.AstMapVisitor;

/**
 * AssignGlobal is used to generate an equation that assigns a global variable that 
 * is written by a procedure call.
 * 
 * This can be tricky because if the DefinesExpr only writes a portion of a global (i.e. field A of a global record)
 * we have to generate an expression that writes *just* that.
 * 
 * Defines G1
 *   G1_1 = ProcedureCall(arg1,arg2...)
 *   G1_2 = G1_1
 *   
 * Defines G2.a
 *   G2_a = ProcedureCall(arg1,arg2...)
 *   G2_2 = G2_1 with a = G2_a
 * 
 * The latter case gets a bit tricky and this class sorts that out.
 */
public class AssignGlobal {
	
	public Expr definesExpr;
	public Expr finalExpr;
	public String previousID;
	public String currentID;

	public static Equation crunch(Expr defines, Expr finalExpr, String previous, String current) {
		AssignGlobal assign = new AssignGlobal();
		assign.definesExpr=defines;
		assign.finalExpr=finalExpr;
		assign.previousID=previous;
		assign.currentID=current;
		return assign.crunch();
	}
	
	private Equation crunch() {
		IdExpr lhs = new IdExpr(currentID);
		Expr rhs = definesExpr.accept(new DefinesVisitor(finalExpr));
		return new Equation(lhs,rhs);
	}

	private class DefinesVisitor extends AstMapVisitor {
		private Expr current;
		
		private DefinesVisitor(Expr finalExpr) {
			current = finalExpr;
		}
		
		@Override
		public Expr visit(RecordAccessExpr rae) {
			//record = g1.a, field = b
			Expr record = rae.record.accept(new SubstitutionVisitor());
			String field = rae.field;
			Expr value = current;
			current=new RecordUpdateExpr(record,field,value);
			return rae.record.accept(this);
		}
		
		@Override
		public Expr visit(ArrayAccessExpr aae) {
			Expr array = aae.array.accept(new SubstitutionVisitor());
			Expr value = current;
			current = new ArrayUpdateExpr(array,aae.index,value);
			return aae.array.accept(this);
		}
		
		@Override
		public Expr visit(IdExpr ide) {
			return current;
		}
		
		@Override
		public Expr visit(NodeCallExpr call) {
			return current;
		}
	}

	private class SubstitutionVisitor extends AstMapVisitor {
		@Override
		public Expr visit(NodeCallExpr e) {
			return e;
		}
		
		@Override
		public Expr visit(ArrayAccessExpr e) {
			return new ArrayAccessExpr(e.location, e.array.accept(this), e.index);
		}
		
		@Override
		public Expr visit(IdExpr ide) {
			return new IdExpr(previousID);
		}
	}
}
