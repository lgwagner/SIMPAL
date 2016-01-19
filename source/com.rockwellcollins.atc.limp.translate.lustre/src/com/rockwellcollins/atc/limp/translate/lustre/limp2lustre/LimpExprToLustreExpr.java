package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import jkind.lustre.BinaryOp;
import jkind.lustre.Expr;
import jkind.lustre.UnaryOp;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.BooleanLiteralExpr;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.InitExpr;
import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.RealLiteralExpr;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.StringLiteralExpr;
import com.rockwellcollins.atc.limp.UnaryMinusExpr;
import com.rockwellcollins.atc.limp.UnaryNegationExpr;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.exceptions.UnsupportedException;
import com.rockwellcollins.atc.limp.translate.lustre.procedure.InitIds;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.GetFunctionName;
import com.rockwellcollins.atc.limp.utils.GetVariableName;
/**
 * Extends the LimpSwitch XText generated Visitor to generate a LustreExpression
 * from LimpExpressions.
 * 
 * If something other than a LimpExpression is encountered, null will be returned 
 * and an exception will be thrown.
 *
 */
public class LimpExprToLustreExpr extends LimpSwitch<Expr> {
	
	public static Expr translate(com.rockwellcollins.atc.limp.Expr expr, Map<String,Expr> map) {
		LimpExprToLustreExpr expr2expr = new LimpExprToLustreExpr();
		expr2expr.context = map;
		return expr2expr.doSwitch(expr);
	}
	
	public static Expr translate(com.rockwellcollins.atc.limp.Expr expr) {
		return new LimpExprToLustreExpr().doSwitch(expr);
	}
	
	private Map<String,Expr> context = new LinkedHashMap<>();
	
	@Override
	public Expr caseIfThenElseExpr(IfThenElseExpr ite) {
		Expr condExpr = doSwitch(ite.getCondExpr());
		Expr thenExpr = doSwitch(ite.getThenExpr());
		Expr elseExpr = doSwitch(ite.getElseExpr());
		return new jkind.lustre.IfThenElseExpr(condExpr, thenExpr, elseExpr);
	}
	
	@Override
	public Expr caseBinaryExpr(BinaryExpr be) {
		Expr leftExpr = doSwitch(be.getLeft());
		Expr rightExpr = doSwitch(be.getRight());
		BinaryOp binop = getBinaryOp(be.getOp());
		return new jkind.lustre.BinaryExpr(leftExpr, binop, rightExpr);
	}
	
	@Override
	public Expr caseUnaryNegationExpr(UnaryNegationExpr une) {
		Expr subExpr = doSwitch(une.getExpr());
		UnaryOp uop = getUnaryOp("not");
		return new jkind.lustre.UnaryExpr(uop, subExpr);
	}
	
	@Override
	public Expr caseUnaryMinusExpr(UnaryMinusExpr ume) {
		Expr subExpr = doSwitch(ume.getExpr());
		UnaryOp uop = getUnaryOp("-");
		return new jkind.lustre.UnaryExpr(uop, subExpr);
	}
	
	@Override
	public Expr caseRecordAccessExpr(RecordAccessExpr rae) {
		Expr record = doSwitch(rae.getRecord());
		String field = rae.getField();
		return new jkind.lustre.RecordAccessExpr(record, field);
	}
	
	@Override
	public Expr caseRecordUpdateExpr(RecordUpdateExpr rue) {
		Expr record = doSwitch(rue.getRecord());
		Expr value = doSwitch(rue.getValue());
		return new jkind.lustre.RecordUpdateExpr(record, rue.getField(), value);
	}
	
	@Override
	public Expr caseArrayAccessExpr(ArrayAccessExpr aae) {
		Expr array = doSwitch(aae.getArray());
		Expr index = doSwitch(aae.getIndex());
		return new jkind.lustre.ArrayAccessExpr(array, index);
	}
	
	@Override
	public Expr caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		Expr array = doSwitch(aue.getAccess().getArray());
		Expr index = doSwitch(aue.getAccess().getIndex());
		Expr value = doSwitch(aue.getValue());
		return new jkind.lustre.ArrayUpdateExpr(array, index, value);
	}
	
	@Override
	public Expr caseBooleanLiteralExpr(BooleanLiteralExpr ble) {
		boolean parseBoolean = Boolean.parseBoolean(ble.getBoolVal());
		return new jkind.lustre.BoolExpr(parseBoolean);
	}
	
	@Override
	public Expr caseIntegerLiteralExpr(IntegerLiteralExpr ile) {
		BigInteger bigInt = new BigInteger(ile.getIntVal().toString());
		return new jkind.lustre.IntExpr(bigInt);
	}
	
	@Override
	public Expr caseRealLiteralExpr(RealLiteralExpr rle) {
		BigDecimal bd = new BigDecimal(rle.getRealVal());
		return new jkind.lustre.RealExpr(bd);
	}
	
	@Override
	public Expr caseStringLiteralExpr(StringLiteralExpr sle) {
		try {
			throw new UnsupportedException("StringLiteral expressions are not supported.");
		} catch (UnsupportedException use) {
			use.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method is a bit different from the rest in that an InitExpr is no different than an IdExpr
	 * other than in name. To handle this we modify the ID inside of the expr so that when we process
	 * later we can handle it correctly.
	 * 
	 * Later on when we're processing IDs in Lustre we can identify InitIds with their very unique prefix.
	 */
	@Override
	public Expr caseInitExpr(InitExpr ie) {
		String name = GetVariableName.getName(ie.getId());
		String encodedName = InitIds.encode(name);
		return new jkind.lustre.IdExpr(encodedName);
	}
	
	@Override
	public Expr caseArrayExpr(ArrayExpr ae) {
		List<Expr> exprlist = new ArrayList<>();
		for(com.rockwellcollins.atc.limp.Expr e : ae.getExprList()) {
			exprlist.add(doSwitch(e));
		}
		return new jkind.lustre.ArrayExpr(exprlist);
	}
	
	@Override
	public Expr caseRecordExpr(RecordExpr re) {
		String typeID = re.getRecordDefinition().getName();
		SortedMap<String,Expr> fields = new TreeMap<>();
		for(RecordFieldExpr rfe : re.getFieldExprList()) {
			fields.put(rfe.getFieldName(), (Expr) doSwitch(rfe.getFieldExpr()));
		}
		return new jkind.lustre.RecordExpr(typeID, fields);
	}
	
	@Override
	public Expr caseIdExpr(IdExpr ide) {
		VariableRef id = ide.getId();
		String name = GetVariableName.getName(id);
		
		if(context.containsKey(name)) {
			return context.get(name);
		} else {
			return new jkind.lustre.IdExpr(name);			
		}
	}	

	/*TODO:
	 * This needs to be updated to look for a nodecall or function call expr.  Right JKind has support for both
	 * with equivalent functionality. When that changes, this will need to.
	 * 
	 * @see com.rockwellcollins.atc.limp.util.LimpSwitch#caseFcnCallExpr(com.rockwellcollins.atc.limp.FcnCallExpr)
	 */
	@Override
	public Expr caseFcnCallExpr(FcnCallExpr fce) {
		String fcnName = GetFunctionName.getName(fce.getId());
		List<Expr> args = new ArrayList<>();
		for(com.rockwellcollins.atc.limp.Expr e : fce.getExprs().getExprList()) {
			args.add(doSwitch(e));
		}
		return new jkind.lustre.NodeCallExpr(fcnName, args);
	}

	private UnaryOp getUnaryOp(String op) {
		op = resolveNoncomformingOps(op);
		UnaryOp uop = UnaryOp.fromString(op);
		return uop;
	}

	private BinaryOp getBinaryOp(String op) {
		op = resolveNoncomformingOps(op);
		BinaryOp binop = BinaryOp.fromString(op);
		return binop;
	}

	private String resolveNoncomformingOps(String op) {
		if(op.equals("==")) {
			return "=";
		} else if (op.equals("->")) {
			return "=>";
		} else {
			return op;
		}
	}
}
