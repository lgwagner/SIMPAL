package com.rockwellcollins.atc.limp.utils;

/*
 * This class is used to test SimplifyExpressions.
 */

import com.rockwellcollins.atc.LimpInjectorUtil;
import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.IntegerWildCardExpr;

public class SimplifyExpressionsDriver {
	public static void main(String[] args) throws Exception {
		LimpInjectorUtil.doStandaloneSetup();
		
		//aue = b [ index := arg]

		//Example 1
		
		ArrayAccessExpr Bindex = LimpConstructors.makeArrayAccessExpr("B", "index");
		IdExpr arg = LimpConstructors.makeIntegerIdExpr("arg");
		ArrayUpdateExpr aue = LimpConstructors.makeArrayUpdateExpr(Bindex, arg);
		IntegerLiteralExpr ile = LimpConstructors.makeIntegerLiteralExpr(3);
		ArrayAccessExpr aae = LimpConstructors.makeArrayAccessExpr(aue, ile);
		
		System.out.println("Before simplification: " + SerializerUtil.EObjectToString(aae));
		Expr simplifiedExpr1 = SimplifyExpressions.simplifyExpression(aae);
		System.out.println("After simplification: " + SerializerUtil.EObjectToString(simplifiedExpr1));
		
		//Example 2
		
		IntegerWildCardExpr wildCard = LimpConstructors.makeIntegerWildCardExpr();
		ArrayAccessExpr aae2 = LimpConstructors.makeArrayAccessExpr(aue, wildCard);
		
		System.out.println("\n" + "Before simplification: " + SerializerUtil.EObjectToString(aae2));
		Expr simplifiedExpr2 = SimplifyExpressions.simplifyExpression(aae2);
		System.out.println("After simplification: " + SerializerUtil.EObjectToString(simplifiedExpr2));
		
		//Example 3
		
		ArrayAccessExpr BindexWild = LimpConstructors.makeArrayAccessExpr("B", wildCard);
		ArrayUpdateExpr aue3 = LimpConstructors.makeArrayUpdateExpr(BindexWild, arg);
		ArrayAccessExpr aae3 = LimpConstructors.makeArrayAccessExpr(aue3, ile);
		
		System.out.println("\n" + "Before simplification: " + SerializerUtil.EObjectToString(aae3));
		Expr simplifiedExpr3 = SimplifyExpressions.simplifyExpression(aae3);
		System.out.println("After simplification: " + SerializerUtil.EObjectToString(simplifiedExpr3));
		
		//Example 4
		IntegerLiteralExpr ile8 = LimpConstructors.makeIntegerLiteralExpr(8);
		ArrayUpdateExpr aueOuter = LimpConstructors.makeArrayUpdateExpr(aae, ile8);
		ArrayAccessExpr aae4 = LimpConstructors.makeArrayAccessExpr(aueOuter, wildCard);
		
		System.out.println("\n" + "Before simplification: " + SerializerUtil.EObjectToString(aae4));
		Expr simplifiedExpr4 = SimplifyExpressions.simplifyExpression(aae4);
		System.out.println("After simplification: " + SerializerUtil.EObjectToString(simplifiedExpr4));
	}
}
