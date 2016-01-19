package com.rockwellcollins.atc.limp.utils;

import java.util.List;

import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.BooleanLiteralExpr;
import com.rockwellcollins.atc.limp.Else;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.GotoStatement;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.LabelStatement;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.UnaryMinusExpr;
import com.rockwellcollins.atc.limp.UnaryNegationExpr;
import com.rockwellcollins.atc.limp.VariableRef;

public class LimpAST {
	
	private static LimpFactory f = LimpFactory.eINSTANCE;
	
	public static IdList createIdList(List<VariableRef> written) {
		IdList idl = f.createIdList();
		idl.getIds().addAll(written);
		return idl;
	}
	
	public static BinaryExpr implies(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("=>");
		return binaryExpr;
	}

	public static BinaryExpr or(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("or");
		return binaryExpr;
	}

	public static BinaryExpr and(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("and");
		return binaryExpr;
	}
	
	public static BinaryExpr greaterThan(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp(">");
		return binaryExpr;
	}

	public static BinaryExpr greaterEqualThan(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp(">=");
		return binaryExpr;
	}
	
	public static BinaryExpr lessThan(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("<");
		return binaryExpr;
	}

	public static BinaryExpr lessEqualThan(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("<=");
		return binaryExpr;
	}
	
	public static BinaryExpr equalTo(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("==");
		return binaryExpr;
	}
	
	public static BinaryExpr notEqualTo(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("<>");
		return binaryExpr;
	}
	
	public static BinaryExpr plus(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("+");
		return binaryExpr;
	}
	
	public static BinaryExpr subtract(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("-=");
		return binaryExpr;
	}
	
	public static BinaryExpr multiply(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("*");
		return binaryExpr;
	}

	public static BinaryExpr divide(Expr left, Expr right) {
		BinaryExpr binaryExpr = f.createBinaryExpr();
		binaryExpr.setLeft(left);
		binaryExpr.setRight(right);
		binaryExpr.setOp("/");
		return binaryExpr;
	}
	
	public static BooleanLiteralExpr trueLiteral() {
		BooleanLiteralExpr ble = f.createBooleanLiteralExpr();
		ble.setBoolVal("true");
		return ble;
	}
	
	public static BooleanLiteralExpr falseLiteral() {
		BooleanLiteralExpr ble = f.createBooleanLiteralExpr();
		ble.setBoolVal("false");
		return ble;
	}
	
	public static UnaryNegationExpr not(Expr sub) {
		UnaryNegationExpr negate = f.createUnaryNegationExpr();
		negate.setExpr(sub);
		return negate;
	}
	
	public static UnaryMinusExpr minus(Expr sub) {
		UnaryMinusExpr minus = f.createUnaryMinusExpr();
		minus.setExpr(sub);
		return minus;
	}
	
	public static IfThenElseStatement ifThenElseStatement(Expr cond, StatementBlock thenBlock, Else theElse) {
		IfThenElseStatement ites = f.createIfThenElseStatement();
		ites.setCond(cond);
		ites.setThenBlock(thenBlock);
		ites.setElse(theElse);
		return ites;
	}
	
	public static StatementBlock statementBlock(List<Statement> statements) {
		StatementBlock sb = f.createStatementBlock();
		sb.getStatements().addAll(statements);
		return sb;
	}
	
	public static LabelStatement createLabel(String name) {
		LabelStatement label = f.createLabelStatement();
		label.setName(name);
		return label;
	}
	
	public static GotoStatement createConditionalGoto(LabelStatement label, Expr condition) {
		GotoStatement gotoStatement = f.createGotoStatement();
		gotoStatement.setLabel(label);
		gotoStatement.setWhenExpr(condition);
		return gotoStatement;
	}
	
	public static GotoStatement createUnconditionalGoto(LabelStatement label) {
		GotoStatement gotoStatement = f.createGotoStatement();
		gotoStatement.setLabel(label);
		return gotoStatement;
	}

}
