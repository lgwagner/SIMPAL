package com.rockwellcollins.atc.limp.utils;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayType;
import com.rockwellcollins.atc.limp.ArrayTypeDef;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordFieldType;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.RecordTypeDef;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;

////////////////////////////////////////////////////////////////////////////////
// This class includes several methods to convert one type of expression to 
// another.
////////////////////////////////////////////////////////////////////////////////

public class LimpConverters {

	public static EList<RecordFieldType> getRecordFieldTypeList(Expr rec) {
		if (GetType.getType(rec) instanceof RecordType) {
			RecordType rt = (RecordType) GetType.getType(rec);
			return rt.getRecordDef().getFields();
		}
		throw new IllegalArgumentException(
				"Input must be an Expr of type RecordType.");
	}
	
	public static Expr convertAccessOfArrayExprToChoiceExpr(ArrayExpr inputArrayExpr) {
		// Convert the ArrayAccessExpr inputArrayExpr[*] to a ChoiceExpr 
		// Example: Replace array arr [1, 2, 3, 4, 5] [*] with Choice(1,Choice(2,Choice(3,Choice(4,5)))).
		System.out.print("Converting " + SerializerUtil.EObjectToString(inputArrayExpr) + " to the ChoiceExpr ");
		EList<Expr> el = inputArrayExpr.getExprList();
		EList<Expr> e2 = new BasicEList<Expr>();
		e2.clear();
		e2.addAll(el);
		Expr tmp = convertAccessOfArrayExprToChoiceExpr_rec(el);
		System.out.println(SerializerUtil.EObjectToString(tmp));
		return tmp;
	}
	
	
	private static Expr convertAccessOfArrayExprToChoiceExpr_rec(EList<Expr> el) {
		//This is the recursive function used by convertAccessOfArrayExprToChoiceExpr.
		
		//Base Case. We are at the last element of el.
		if (el.size()==1) {
			return el.get(0);
		}
		
		// Recursive case. Build and return a ChoiceExpr.
		// Given el, return the following choice expression:
		//  Choice(el.get(0), [result of recursive call])
			
		//We are recurring down the ExprList beginning to end, so the element we want to grab is always the first.
		Expr nextExpr = el.get(0);
		//Remove the first element of the ExprList in preparation for the recursive call
		el.remove(0);
		
		return LimpConstructors.makeChoiceExpr(nextExpr, convertAccessOfArrayExprToChoiceExpr_rec(el));
	}

	private static Expr convertAccessOfArrayExprToIfThenElseExpr_rec(EList<Expr> el, Expr index, int i) {
		
		//This is the recursive function used by convertAccessOfArrayExprToIfThenElseExpr.
	
		//Base Case. We are at the last element of el.
		if (el.size()==1) {
			return el.get(0);
		}
		
		// Recursive case. Build and return an IfThenElseExpr.
		// Given el, index, and i, return the following if-then-else expression:
		//  (index==i) ? el.get(0) : [result of recursive call]
		
		// The value of i tells us which element of the array we are really on, so we use that to build the condition.
		Expr rhs = LimpConstructors.makeIntegerLiteralExpr(i);
		BinaryExpr cond = LimpConstructors.makeBinaryExpr(index, rhs, "==");
		//We are recurring down the ExprList beginning to end, so the element we want to grab is always the first.
		Expr thenExpr = el.get(0);
		//Remove the first element of the ExprList in preparation for the recursive call
		el.remove(0);
		
		return LimpConstructors.makeITEE(cond, thenExpr, convertAccessOfArrayExprToIfThenElseExpr_rec(el, index, i+1));
	}
	
	public static Expr convertAccessOfArrayExprToIfThenElseExpr(ArrayExpr inputArrayExpr, Expr index) {
		
		// Convert the ArrayAccessExpr inputArrayExpr[index] to an IfThenElseExpr 
		// Example: Replace array arr [1, 2, 3, 4, 5] [j] with j==0 ? 1 : j==1 ? 2 : j==2 ? 3 : j==3 ? 4 : 5
		EList<Expr> el = inputArrayExpr.getExprList();
		EList<Expr> e2 = new BasicEList<Expr>();
		e2.clear();
		e2.addAll(el);
		return convertAccessOfArrayExprToIfThenElseExpr_rec(e2, EcoreUtil.copy(index), 0);
		
	}
		
	public static RecordExpr pushIfThenElseIntoRecordExpr(Expr cond, RecordExpr thenRecordExpr, RecordExpr elseRecordExpr) {
		RecordTypeDef rtd = thenRecordExpr.getRecordDefinition();
		EList<RecordFieldExpr> thenRfel = thenRecordExpr.getFieldExprList();
		EList<RecordFieldExpr> elseRfel = elseRecordExpr.getFieldExprList();
		RecordExpr newRecordExpr = LimpConstructors.makeRecordExprFromRecordTypeDef(rtd);
		
		for (RecordFieldExpr rfe: thenRfel) {
			// Initialize the new RecordFieldExpr to that of the thenRfel
			// This allows me to copy over all the field names in the order of thenRfel 
			//   so that I only have to worry about matching up with elseRfel
			RecordFieldExpr myNewRfe = EcoreUtil2.copy(rfe);
			//The else will be filled in based on elseRfel and rfe.getFieldName
			IfThenElseExpr myNewIfee = LimpConstructors.makeITEEWithNullElse(cond, rfe.getFieldExpr());
			for (RecordFieldExpr rfeElse : elseRfel) {
				if (rfe.getFieldName().equals(rfeElse.getFieldName())) {
					myNewIfee.setElseExpr(EcoreUtil2.copy(rfeElse.getFieldExpr()));
				}
			}
			myNewRfe.setFieldExpr(myNewIfee);
			newRecordExpr.getFieldExprList().add(myNewRfe);
		}
		return newRecordExpr;
	}

	public static ArrayExpr pushIfThenElseIntoArrayExpr(Expr cond, ArrayExpr thenArrayExpr, ArrayExpr elseArrayExpr) {
		ArrayTypeDef atd = thenArrayExpr.getArrayDefinition();
		EList<Expr> thenExprList = thenArrayExpr.getExprList();
		EList<Expr> elseExprList = elseArrayExpr.getExprList();
		
		ArrayExpr newArrayExpr = LimpConstructors.makeArrayExprFromArrayTypeDef(atd);
		EList<Expr> newExprList = newArrayExpr.getExprList();
		
		//Clear out whatever might be in newExprList as a result of copying atd. We're going to create it from scratch.
		newExprList.clear();
		
		//Create the expression list for the new array. For each index i, the corresponding element is
		//  cond ? thenExprList.get(i) : elseExprList.get(i)
		int i;
		for (i = 0; i < thenExprList.size(); i++) {
			newExprList.add(LimpConstructors.makeITEE(cond, thenExprList.get(i), elseExprList.get(i)));
		}
		
		return newArrayExpr;
	}

	
	public static ArrayExpr convertArrayUpdateExprToArrayExpr(ArrayUpdateExpr x) {
		//Build an ArrayExpr from the ArrayUpdateExpr. 		
		Expr e = x.getAccess().getArray(); //This could be something "surprising", like a RecordAccessExpr, when dealing with nested data structures.
		ArrayType at = (ArrayType) GetType.getType(e);
		ArrayTypeDef atd = (ArrayTypeDef) at.getArrayDef();
		int size = at.getArrayDef().getSize().intValue();

		ArrayExpr ae = LimpConstructors.makeArrayExprFromArrayTypeDef(atd);
		
		//If the index is an integer literal, set the ith value to the value in the ArrayUpdateExpr.
		//Example: Replace a1 [2 := 9] with array arr [a1[0], a1[1], 9, a1[3], a1[4]].
		if (x.getAccess().getIndex() instanceof IntegerLiteralExpr) {
			IntegerLiteralExpr indexExpr = (IntegerLiteralExpr) x.getAccess().getIndex();
			int index = indexExpr.getIntVal().intValue();
			
			int i;
			for (i = 0; i < size; i++) {
				// If the index of the ArrayUpdateExpr is equal to i, set the ith value to the value in the ArrayUpdateExpr.
				if (i == index) {
					ae.getExprList().add(i, EcoreUtil.copy(x.getValue()));
				} else {
				// If the index of the ArrayUpdateExpr is not equal to i, set the ith value
				//   to an ArrayAccessExpr that refers to the ith element of idex (i.e., e[i]).
					IntegerLiteralExpr ile = LimpConstructors.makeIntegerLiteralExpr(i);
					ArrayAccessExpr aae = LimpConstructors.makeArrayAccessExpr(e, ile);
					ae.getExprList().add(i, EcoreUtil.copy(aae));
				}
			}
			return ae;
			
		//If the index is not an integer literal, create an IfThenElseExpr for each index.
		//Example: Replace a1 [a := 9] with array arr [a == 0 ? 9 : a1[0], a == 1 ? 9 : a1[1], a == 2 ? 9 : a1[2], a == 3 ? 9 : a1[3], a == 4 ? 9 : a1[4]].
		} else {
			int i = 0;
			for (i = 0; i < size; i++) {
				IntegerLiteralExpr ile = LimpConstructors.makeIntegerLiteralExpr(i);
				
				// For the example, the condition is a == i 
				BinaryExpr cond = LimpConstructors.makeBinaryExpr(x.getAccess().getIndex(), ile, "==");
				
				// For the example, the IfThenElseExpr is a == i ? 9 : a[i].
				// The ElseExpr is an ArrayAccessExpr that refers to the ith element of idex (a[i] in the example).
				ArrayAccessExpr aae = LimpConstructors.makeArrayAccessExpr(e, ile);
				IfThenElseExpr ifee = LimpConstructors.makeITEE(cond, x.getValue(), aae);
				
				// Update the ArrayExpr with the IfThenElseExpr
				ae.getExprList().set(i, EcoreUtil.copy(ifee));
			}
		}
		return ae;
	}
	
	public static RecordExpr convertRecordUpdateExprToRecordExpr(RecordUpdateExpr inputRecordUpdateExpr) {
		//Build a RecordExpr from the RecordUpdateExpr. 
		RecordType rt = (RecordType) GetType.getType(inputRecordUpdateExpr.getRecord());
		RecordTypeDef rtd = rt.getRecordDef();
		RecordExpr re = LimpConstructors.makeRecordExprFromRecordTypeDef(rtd);

		EList<RecordFieldType> rftl = getRecordFieldTypeList(inputRecordUpdateExpr.getRecord());
		for (RecordFieldType rft : rftl) {
			RecordFieldExpr rfe = LimpConstructors.makeRecordFieldExprWithNullExpr(rft.getFieldName());
			// If the field name is the same as that being updated in
			// the RecordUpdateExpr, copy the value from the
			// RecordUpdateExpr into this
			// RecordFieldExpr
			if (rft.getFieldName().equals(inputRecordUpdateExpr.getField())) {
				rfe.setFieldExpr(EcoreUtil2.copy(inputRecordUpdateExpr.getValue()));
				re.getFieldExprList().add(rfe);
			} else {
				// If the field name is not the same as that being
				// updated in the RecordUpdateExpr, create a
				// RecordAccesssExpr that refers to the proper
				// field of idex
				RecordAccessExpr rae = LimpConstructors.makeRecordAccessExpr(inputRecordUpdateExpr.getRecord(), rft.getFieldName());
				rfe.setFieldExpr(EcoreUtil2.copy(rae));
				re.getFieldExprList().add(rfe);
			}
		}
		return re;
	}

	
}