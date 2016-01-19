package com.rockwellcollins.atc.limp.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayType;
import com.rockwellcollins.atc.limp.ArrayTypeDef;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.Attribute;
import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.BoolType;
import com.rockwellcollins.atc.limp.ChoiceExpr;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.InitExpr;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.IntegerType;
import com.rockwellcollins.atc.limp.IntegerWildCardExpr;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.Postcondition;
import com.rockwellcollins.atc.limp.Precondition;
import com.rockwellcollins.atc.limp.RealLiteralExpr;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.RecordTypeDef;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.SecondInit;
import com.rockwellcollins.atc.limp.SomeAttributeBlock;
import com.rockwellcollins.atc.limp.StringLiteralExpr;
import com.rockwellcollins.atc.limp.Type;
import com.rockwellcollins.atc.limp.UnaryMinusExpr;
import com.rockwellcollins.atc.limp.UnaryNegationExpr;
import com.rockwellcollins.atc.limp.VariableRef;

////////////////////////////////////////////////////////////////////////////////
// This class includes several methods to construct LimpExprs from components. 
// Using the methods in this class rather than the LimpFactory directly should
//  help avoid bugs related to forgetting to copy Limp Exprs before using them
//  to build other Limp Exprs.
////////////////////////////////////////////////////////////////////////////////

public class LimpConstructors {

	static LimpFactory f = LimpFactory.eINSTANCE;
		
	public static IntegerWildCardExpr makeAny() {
		return makeIntegerWildCardExpr();
	}
	
	public static SecondInit makeSecondInit(VariableRef vref) {
		SecondInit secondInit = f.createSecondInit();
		secondInit.setId(vref);
		return secondInit;
	}
	
	public static IntegerWildCardExpr makeIntegerWildCardExpr() {
		return f.createIntegerWildCardExpr();
	}
	
	public static SomeAttributeBlock makeSomeAttributeBlock(EList<Attribute> attributeList) {
		SomeAttributeBlock someAttrBlock = f.createSomeAttributeBlock();
		EList<Attribute> newAttrList = someAttrBlock.getAttributeList();
		newAttrList.clear();
		newAttrList.addAll(attributeList);
		return someAttrBlock;
	}
	
	public static SomeAttributeBlock makeSomeAttributeBlock() {
		SomeAttributeBlock someAttrBlock = f.createSomeAttributeBlock();
		EList<Attribute> newAttrList = someAttrBlock.getAttributeList();
		//Ensure the attribute list is empty
		newAttrList.clear();
		return someAttrBlock;
	}
	
	public static Precondition makePrecondition(String precondName, Expr inputPrecondExpr) {
		Precondition precond = f.createPrecondition();
		precond.setName(precondName);
		precond.setExpr(EcoreUtil2.copy(inputPrecondExpr));
		return precond;
	}
	
	public static IfThenElseExpr makeITEEWithNullElse(Expr cond, Expr thenExpr) {
		IfThenElseExpr itee = f.createIfThenElseExpr();
		itee.setCondExpr(EcoreUtil2.copy(cond));
		itee.setThenExpr(EcoreUtil2.copy(thenExpr));
		return itee;
	}
	
	public static RecordFieldExpr makeRecordFieldExprWithNullExpr(String fieldName) {
		RecordFieldExpr rfe = f.createRecordFieldExpr();
		rfe.setFieldName(fieldName);
		return rfe;
	}
	
	public static RecordExpr makeRecordExprFromRecordTypeDef(RecordTypeDef inputRecordTypeDef) {
	
		RecordExpr re = f.createRecordExpr();
		re.setRecordDefinition(EcoreUtil2.copy(inputRecordTypeDef));
		return re;
	}
	
	public static ArrayExpr makeArrayExprFromArrayTypeDef(ArrayTypeDef inputArrayTypeDef) {
		
		ArrayExpr ae = f.createArrayExpr();
		ae.setArrayDefinition(EcoreUtil2.copy(inputArrayTypeDef));
		return ae;
	}
	
	public static UnaryNegationExpr makeUnaryNegationExpr(Expr e) {
		UnaryNegationExpr une = f.createUnaryNegationExpr();
		une.setExpr(EcoreUtil.copy(e));
		return une;
	}
	
	public static BinaryExpr makeBinaryExpr(Expr lhs, Expr rhs, String op) {
		BinaryExpr re = f.createBinaryExpr();
		re.setLeft(EcoreUtil.copy(lhs));
		re.setRight(EcoreUtil.copy(rhs));
		re.setOp(op);
		return re;
	}
	
	public static IdExpr makeBooleanIdExpr(String name) {
		BoolType t = f.createBoolType();
		
		GlobalDeclaration g = makeGlobalDeclaration(name, t); 
		
		IdExpr ie = f.createIdExpr();
		ie.setId(EcoreUtil.copy(g)); //IdExpr ie = name (global boolean)
		return ie;
	}
	
	public static InitExpr makeIntegerInitExpr(String name) {
		
		GlobalDeclaration g = makeGlobalDeclarationOfIntegerType(name);
		
		InitExpr ie = f.createInitExpr();
		ie.setId(EcoreUtil.copy(g));
		
		return ie;
	}

	public static GlobalDeclaration makeGlobalDeclarationOfIntegerType(String name) {
		IntegerType it = f.createIntegerType();
		return makeGlobalDeclaration(name, it);
	}
	
	public static GlobalDeclaration makeGlobalDeclaration(String name, Type T) {
		GlobalDeclaration g = f.createGlobalDeclaration();
		g.setName(name);
		g.setType(EcoreUtil2.copy(T));
		return g;
	}
	
	public static IdExpr makeIntegerIdExpr(String name) {
		GlobalDeclaration g = makeGlobalDeclarationOfIntegerType(name);
		
		//Create an IdExpr ie referring to name
		IdExpr ie = f.createIdExpr();
		ie.setId(EcoreUtil2.copy(g));
		return ie;
	}
	
	public static ArrayTypeDef makeIntegerArrayTypeDef(String arrayName, BigInteger size) {
		ArrayTypeDef atd = f.createArrayTypeDef();
		IntegerType it = f.createIntegerType();
		atd.setBaseType(EcoreUtil.copy(it));
		atd.setName(arrayName);
		atd.setSize(size);
		return atd;
	}
	
	public static IdExpr makeArrayIdExpr(String arrayName) {
		//Create a global variable with name arrayName for the array
		ArrayType at = f.createArrayType();
		//This is a magic number for the array size. I just needed something here for testing examples.
		BigInteger SIZE = BigInteger.valueOf(10); 
		at.setArrayDef(makeIntegerArrayTypeDef(arrayName, SIZE));
		
		GlobalDeclaration g2 = makeGlobalDeclaration(arrayName, at); 
		
		//Create an IdExpr aie referring to arrayName
		IdExpr ie = f.createIdExpr();
		ie.setId(EcoreUtil2.copy(g2));
		
		return ie;
	}
	
	public static IdExpr makeRecordIdExpr(String recordName) {
		//Create a global variable with name recordName for the record
		RecordType rt = f.createRecordType();
		GlobalDeclaration g2 = makeGlobalDeclaration(recordName, rt); 
		
		//Create an IdExpr ie referring to recordName
		IdExpr ie = f.createIdExpr();
		ie.setId(EcoreUtil2.copy(g2));
		
		return ie;
	}

	public static ArrayAccessExpr makeArrayAccessExpr(Expr array, Expr index) {
		
		//Define the ArrayAccessExpr array[index]
		ArrayAccessExpr aae = f.createArrayAccessExpr();
		aae.setArray(EcoreUtil2.copy(array));	
		aae.setIndex(EcoreUtil2.copy(index)); 
		return aae;
	}
	
	public static ArrayAccessExpr makeArrayAccessExpr(String arrayName, Expr index) {
		return makeArrayAccessExpr(makeArrayIdExpr(arrayName), index);
	}
	
	public static ArrayAccessExpr makeArrayAccessExpr(Expr array, String arrayIndex) {
		return makeArrayAccessExpr(array, makeIntegerIdExpr(arrayIndex));
	}
	
	public static ArrayAccessExpr makeArrayAccessExpr(String arrayName, String arrayIndex) {
		return makeArrayAccessExpr(makeArrayIdExpr(arrayName), makeIntegerIdExpr(arrayIndex));
	}
	
	public static ArrayAccessExpr makeArrayAccessExpr(String arrayName, int i) {
		return makeArrayAccessExpr(makeArrayIdExpr(arrayName), makeIntegerLiteralExpr(i));
	}
	
	public static RecordAccessExpr makeRecordAccessExpr(Expr record, String fieldname) {
		
		//Define the RecordAccessExpr record.fieldName
		RecordAccessExpr rae = f.createRecordAccessExpr();
		rae.setRecord(EcoreUtil2.copy(record));
		rae.setField(fieldname);
		return rae;
	}
	
	public static RecordAccessExpr makeRecordAccessExpr(String recordName, String fieldName) {
		return makeRecordAccessExpr(makeRecordIdExpr(recordName), fieldName);
	}

	public static RecordUpdateExpr makeRecordUpdateExpr(String recordName, String fieldName, Expr value) {
		IdExpr myRecord = makeRecordIdExpr(recordName);
		
		RecordUpdateExpr myRecordUpdateExpr = f.createRecordUpdateExpr();
		myRecordUpdateExpr.setRecord(EcoreUtil.copy(myRecord));
		myRecordUpdateExpr.setField(fieldName);
		myRecordUpdateExpr.setValue(EcoreUtil.copy(value));
	
		return myRecordUpdateExpr;
	}
	
	public static ArrayUpdateExpr makeArrayUpdateExpr(String arrayName, int index, Expr value) {
		ArrayAccessExpr myArrayAccessExpr = makeArrayAccessExpr(arrayName, index);
		return makeArrayUpdateExpr(myArrayAccessExpr, value);
	}
	
	public static ArrayUpdateExpr makeArrayUpdateExpr(ArrayAccessExpr inputArrayAccessExpr, Expr inputExpr) {
		ArrayUpdateExpr myArrayUpdateExpr = f.createArrayUpdateExpr();
		myArrayUpdateExpr.setAccess(EcoreUtil.copy(inputArrayAccessExpr));
		myArrayUpdateExpr.setValue(EcoreUtil.copy(inputExpr));
		return myArrayUpdateExpr;
	}
	
	public static IfThenElseExpr makeITEE(Expr cond, Expr thenExpr, Expr elseExpr) {
		IfThenElseExpr itee = f.createIfThenElseExpr();
		itee.setCondExpr(EcoreUtil2.copy(cond));
		itee.setThenExpr(EcoreUtil2.copy(thenExpr));
		itee.setElseExpr(EcoreUtil2.copy(elseExpr));
		return itee;
	}
	
	public static StringLiteralExpr makeSLE(String s) {
		StringLiteralExpr sle = f.createStringLiteralExpr();
		sle.setStringVal(s);
		return sle;
	}
	
	public static IdExpr makeIdExpr(InputArg inputArg) {
		IdExpr ide = f.createIdExpr();
		ide.setId(EcoreUtil.copy(inputArg));
		return ide;
	}
	
	public static IdExpr makeIdExpr(OutputArg outputArg) {
		IdExpr ide = f.createIdExpr();
		ide.setId(EcoreUtil.copy(outputArg));
		return ide;
	}
	
	public static IdExpr makeIdExpr(VariableRef id) {
			IdExpr ide = f.createIdExpr();
			ide.setId(id); 
			return ide;
	}
	
	public static IdExpr makeIdExpr(String name) {
		IdExpr ide = f.createIdExpr();
		ide.setId(makeVariableRef(name));
		return ide;
	}
	
	public static VariableRef makeVariableRef(String name) {
		VariableRef vref = f.createVariableRef();
		vref.setName(name);
		return vref;
	}

	public static IdList makeIdList(List<VariableRef> ids) {
		IdList idList = f.createIdList();
		List<VariableRef> idsOrig = idList.getIds();
		idsOrig.addAll(ids);
		return idList;
	}
	
	public static IdList makeIdList(VariableRef id) {
		IdList idList = f.createIdList();
		List<VariableRef> idsOrig = idList.getIds();
		idsOrig.add(id);
		return idList;
	}

	public static ChoiceExpr makeChoiceExpr(Expr expr1, Expr expr2) {
		ChoiceExpr choiceExpr = f.createChoiceExpr();
		choiceExpr.setFirst(EcoreUtil.copy(expr1));
		choiceExpr.setSecond(EcoreUtil.copy(expr2));
		return choiceExpr;
	}

	public static InitExpr makeInitExpr(InputArg inputArg) {
		InitExpr initExpr = f.createInitExpr();
		initExpr.setId(EcoreUtil.copy(inputArg));
		return initExpr;
	}

	public static InitExpr makeInitExpr(VariableRef id) {
		InitExpr initExpr = f.createInitExpr();
		initExpr.setId(EcoreUtil.copy(id));
		return initExpr;
	}

	public static IntegerLiteralExpr makeIntegerLiteralExpr(int i) {
		return makeIntegerLiteralExpr(BigInteger.valueOf(i));
	}

	public static IntegerLiteralExpr makeIntegerLiteralExpr(BigInteger bi) {
		//Create an IntegerLiteralExpr ile for the array index i
		IntegerLiteralExpr ile = f.createIntegerLiteralExpr();
		ile.setIntVal(bi);
		return ile;
	}
	
	public static IntegerLiteralExpr intZero() {
		return makeIntegerLiteralExpr(0);
	}
	
	public static IntegerLiteralExpr intOne() {
		return makeIntegerLiteralExpr(1);
	}
	
	public static RealLiteralExpr realZero() {
		return makeRealLiteralExpr(0.0);
	}
	
	public static RealLiteralExpr realOne() {
		return makeRealLiteralExpr(1.0);
	}

	public static RealLiteralExpr makeRealLiteralExpr(BigDecimal bd) {
		RealLiteralExpr realLiteralExpr = f.createRealLiteralExpr();
		realLiteralExpr.setRealVal(bd.toPlainString());
		return realLiteralExpr;
	}
	 
	public static RealLiteralExpr makeRealLiteralExpr(double d) {
		return makeRealLiteralExpr(BigDecimal.valueOf(d));
	}

	public static UnaryMinusExpr makeUnaryMinusExpr(Expr inputExpr) {
		UnaryMinusExpr unaryMinusExpr = f.createUnaryMinusExpr();
		unaryMinusExpr.setExpr(EcoreUtil.copy(inputExpr));
		return unaryMinusExpr;
	}

	public static Postcondition makePostcondition(String postcondName, Expr inputPostcondExpr) {
		Postcondition postcond = f.createPostcondition();
		postcond.setName(postcondName);
		postcond.setExpr(EcoreUtil2.copy(inputPostcondExpr));
		return postcond;
	}
	
}
