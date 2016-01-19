package com.rockwellcollins.atc.limp.utils;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayType;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.InitExpr;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldType;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.Type;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

public class GetType extends LimpSwitch<Type> {
	
	LimpFactory f = LimpFactory.eINSTANCE;
	
	//////////////////////////////////////////////////////////////////////////////////////////
	// Defines a visitor to get the type of an id, IdExpr, InitExpr, IfThenElseExpr, 
	//  ArrayAccessExpr, RecordAccessExpr, RecordUpdateExpr, ArrayUpdateExpr, RecordExpr, 
	//  or ArrayExpr
	//////////////////////////////////////////////////////////////////////////////////////////
	
	//Convenient method to call
	public static Type getType(Expr e) {
		GetType myGetType = new GetType();
		return myGetType.doSwitch(e);
	}
	
	public GetType() {
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Type caseGlobalDeclaration(GlobalDeclaration d) {
		return d.getType();
	}
	
	@Override
	public Type caseConstantDeclaration(ConstantDeclaration d) {
		return d.getType();
	}
	
	@Override
	public Type caseOutputArg(OutputArg a) {
		return a.getType();
	}
	
	@Override
	public Type caseInputArg(InputArg a) {
		return a.getType();
	}
	
	@Override
	public Type caseLocalArg(LocalArg a) {
		return a.getType();
	}
	
	@Override
	public Type caseIdExpr(IdExpr e) {
		return doSwitch(e.getId());
	}
	
	@Override
	public Type caseInitExpr(InitExpr e) {
		return doSwitch(e.getId());
	}
	
	@Override
	public Type caseIfThenElseExpr(IfThenElseExpr e) {
		return doSwitch(e.getThenExpr());
	}
		
	@Override
	public Type caseRecordExpr(RecordExpr e) {
		RecordType rt = f.createRecordType();
		rt.setRecordDef(e.getRecordDefinition());
		return rt;
	}
	
	@Override
	public Type caseArrayExpr(ArrayExpr e) {
		ArrayType at = f.createArrayType();
		at.setArrayDef(e.getArrayDefinition());
		return at;
	}
	
	@Override
	public Type caseArrayAccessExpr(ArrayAccessExpr e) {
		// Call getType recursively
		ArrayType at = (ArrayType) doSwitch(e.getArray());
		// Return the base type of the array.
		return at.getArrayDef().getBaseType();
	}
	
	@Override
	public Type caseRecordAccessExpr(RecordAccessExpr e) {
		// Call getType recursively
		RecordType rt = (RecordType) doSwitch(e.getRecord());
		// Find and return the field type
		EList<RecordFieldType> rftl = rt.getRecordDef().getFields();
		for (RecordFieldType rft : rftl) {
			if (rft.getFieldName().equals(e.getField())) {
				return rft.getFieldType();
			}
		}
		throw new IllegalArgumentException(
				"The field " + e.getField() + " is not in the record definition for " + rt.getRecordDef().getName() + "!");
	}
	
	@Override
	public Type caseRecordUpdateExpr(RecordUpdateExpr e) {
		// Call getType recursively
		return doSwitch(e.getRecord());
	}
	
	@Override
	public Type caseArrayUpdateExpr(ArrayUpdateExpr e) {
		// Call getType recursively
		return doSwitch(e.getAccess().getArray());
	}
	
	@Override
	public Type caseExternalFunction(ExternalFunction e) {
		return e.getOutput().getType();
	}
	
	@Override
	public Type caseLocalFunction(LocalFunction e) {
		return e.getOutput().getType();
	}
	
	@Override
	public Type caseFcnCallExpr(FcnCallExpr e) {
		return doSwitch(e.getId());
	}
	
	@Override
	public Type defaultCase(EObject E) {
		throw new IllegalArgumentException(
				"The input expression " + SerializerUtil.EObjectToString(E) + " is not of an expected type!");
	}
	
}