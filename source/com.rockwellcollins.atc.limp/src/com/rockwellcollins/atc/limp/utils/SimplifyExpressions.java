package com.rockwellcollins.atc.limp.utils;

/*
 * The 'simplifyExpression' method defined here simplifies a Limp expression.
 * This includes simplification of binary expressions, array access expressions, 
 * array update expressions, record access expressions, record update expressions,
 * and if-then-else expressions. 
 */

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

//import com.rockwellcollins.atc.LimpInjectorUtil;
import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayType;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.ChoiceExpr;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.IntegerWildCardExpr;
import com.rockwellcollins.atc.limp.RealLiteralExpr;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.UnaryMinusExpr;
import com.rockwellcollins.atc.limp.UnaryNegationExpr;
import com.rockwellcollins.atc.limp.reasoning.visitor.LimpMapVisitor;

public class SimplifyExpressions extends LimpMapVisitor {

	GetType getType = new GetType();

	public SimplifyExpressions() {
	}
	
	public static Expr simplifyExpression(EObject inputExpr) {
		//LimpInjectorUtil.doStandaloneSetup();
		SimplifyExpressions se = new SimplifyExpressions();
		//System.out.println("Input expression: " + SerializerUtil.EObjectToString(inputExpr));
		Expr outputExpr = (Expr) se.doSwitch(EcoreUtil.copy(inputExpr));
		//System.out.println("Simplified to: " + SerializerUtil.EObjectToString(outputExpr));
		return outputExpr;
	}
	
	public boolean isOfRecordType(IdExpr idexpr) {
		return getType.doSwitch(idexpr.getId()) instanceof RecordType;
	}
	
	public boolean isOfArrayType(IdExpr idexpr) {
		return getType.doSwitch(idexpr.getId()) instanceof ArrayType;
	}
	
	public BigInteger getArraySize(Expr a) {
		if (getType.doSwitch(a) instanceof ArrayType) {
			ArrayType at = (ArrayType) getType.doSwitch(a);
			return at.getArrayDef().getSize();
		}
		throw new IllegalArgumentException("Input must be an Expr of type ArrayType.");
	}
	
	@Override
	public EObject caseRecordAccessExpr(RecordAccessExpr x) {
		copyAndReplace(x.getRecord(), (Expr) this.doSwitch(x.getRecord()));
		
		//If the record is a RecordExpr, return the value of the field named in the RecordAccessExpr
		if (x.getRecord() instanceof RecordExpr) {
			RecordExpr rec = (RecordExpr) x.getRecord();
			EList<RecordFieldExpr> fel = (EList<RecordFieldExpr>) rec.getFieldExprList();
			for (RecordFieldExpr rfe : fel) {
				if (rfe.getFieldName().equals(x.getField())) {
					return rfe.getFieldExpr();
				}
			}
		}
		
		//If the record is a RecordUpdateExpr, push the access past it.
		if (x.getRecord() instanceof RecordUpdateExpr) {
			RecordUpdateExpr rue = (RecordUpdateExpr) x.getRecord();
			
			// If the field in the access expr is the same as that in the update expr, then simply return the updated value.
			if (x.getField().equals(rue.getField())) {
				return rue.getValue();
			}
			
			// If the fieldname in the access expr does not match that in the update expr, then return record.fieldname.
			return simplifyExpression(LimpConstructors.makeRecordAccessExpr(rue.getRecord(), x.getField()));
		} 
		
		//Push the access into an IfThenElseExpr.
		if (x.getRecord() instanceof IfThenElseExpr) {
			IfThenElseExpr recordITEE = (IfThenElseExpr) x.getRecord();
			Expr thenExpr = LimpConstructors.makeRecordAccessExpr(recordITEE.getThenExpr(), x.getField());
			Expr elseExpr = LimpConstructors.makeRecordAccessExpr(recordITEE.getElseExpr(), x.getField());
			return simplifyExpression(LimpConstructors.makeITEE(recordITEE.getCondExpr(), thenExpr, elseExpr));
		}
		
		return x;
	}
	
	@Override
	public EObject caseRecordUpdateExpr(RecordUpdateExpr x) {
		copyAndReplace(x.getRecord(), (Expr) this.doSwitch(x.getRecord()));
		copyAndReplace(x.getValue(), (Expr) this.doSwitch(x.getValue()));
		
		//If the record is a RecordExpr, update the field named in the RecordUpdateExpr with the new value
		if (x.getRecord() instanceof RecordExpr) {
			RecordExpr rec = (RecordExpr) x.getRecord();
			EList<RecordFieldExpr> fel = (EList<RecordFieldExpr>) rec.getFieldExprList();
			for (RecordFieldExpr rfe : fel) {
				if (rfe.getFieldName().equals(x.getField())) {
					copyAndReplace(rfe.getFieldExpr(), (Expr) x.getValue());
					return rec;
				}
			}
			throw new IllegalArgumentException("The field " + x.getField() + "does not appear in the record " + SerializerUtil.EObjectToString(x.getRecord()) + "!");
		} else {
			// We could convert the RecordUpdateExpr to a RecordExpr.
			// For example, r{f1 : = "tree"} would become record r{f1 = tree, f2 = r.f2, f3 = r.f3, ...}.
			// However, that tends to blow up the pragmatic preconditions.
			
			// return LimpConverters.convertRecordUpdateExprToRecordExpr(x);
			
			// So for now, just return x.
			return x;
		}
	}
	
	//This method needs to be used in combination with caseArrayUpdateExpr. Otherwise it messes up the 
	// ArrayUpdateExprs, such as array3 [1 := 11]. This is because an ArrayAccessExpr is used under-the-hood for
	// ArrayUpdateExpr; so if we don't process the ArrayUpdateExpr first, we run into trouble.
	@Override
	public EObject caseArrayAccessExpr(ArrayAccessExpr x) {
		//System.out.println(SerializerUtil.EObjectToString(x));
		copyAndReplace(x.getArray(), (Expr) this.doSwitch(x.getArray()));
		//System.out.println(SerializerUtil.EObjectToString(x));
		copyAndReplace(x.getIndex(), (Expr) this.doSwitch(x.getIndex()));
		//System.out.println(SerializerUtil.EObjectToString(x));
		
		//Push the access into an ArrayExpr.
		if (x.getArray() instanceof ArrayExpr) {
			ArrayExpr ae = (ArrayExpr) x.getArray();
			
			//If the array is an ArrayExpr and the index is an integer literal, then simply return the corresponding value of the array.
			if (x.getIndex() instanceof IntegerLiteralExpr) {
				IntegerLiteralExpr intIndex = (IntegerLiteralExpr) x.getIndex();
				return ae.getExprList().get(intIndex.getIntVal().intValue());	
			} 
			
			if (x.getIndex() instanceof IntegerWildCardExpr) {
				return simplifyExpression(LimpConverters.convertAccessOfArrayExprToChoiceExpr(ae));
			}
			
			//If the array is an ArrayExpr and the index is not an integer literal, then convert the ArrayAccessExpr to an IfThenElseExpr.
			//Example: array a[1,2,3][j] becomes j==0 ? 1 : j==1 ? 2 : 3.
			return simplifyExpression(LimpConverters.convertAccessOfArrayExprToIfThenElseExpr(ae, x.getIndex()));
		
		}
		
		//Push the access past the ArrayUpdateExpr.
		if (x.getArray() instanceof ArrayUpdateExpr) {
			//aue = updatedArray [ updateIndex := value] [accessIndex]
			ArrayUpdateExpr aue = (ArrayUpdateExpr) x.getArray();
			Expr accessIndex = x.getIndex();
			Expr updateIndex = aue.getAccess().getIndex();
			Expr updatedArray = aue.getAccess().getArray();
			
			//If the accessIndex or updateIndex is *, then return Choice(aue.getValue, updatedArray[*]).
			if ((accessIndex instanceof IntegerWildCardExpr) || (updateIndex instanceof IntegerWildCardExpr)) {
				return simplifyExpression(LimpConstructors.makeChoiceExpr(aue.getValue(), LimpConstructors.makeArrayAccessExpr(updatedArray, accessIndex)));
			}
			
			//If the update index and the access index are the same, then simply return the value of the update expression!
			if (EcoreUtil.equals(accessIndex, updateIndex)) {
				return aue.getValue();
			}
			
			//If the update index and the access index are integer literals that are different, then return a[access index].
			if ((accessIndex instanceof IntegerLiteralExpr) && (updateIndex instanceof IntegerLiteralExpr)) {
				
				if (!(((IntegerLiteralExpr) accessIndex).getIntVal().equals(((IntegerLiteralExpr) updateIndex).getIntVal()))) {
					return simplifyExpression(LimpConstructors.makeArrayAccessExpr(aue.getAccess().getArray(), accessIndex));
				}
			} 
			
			//Otherwise, create an if-then-else expression.
			//  (accessIndex == updateIndex) ? value : updatedArray [accessIndex]
			
			BinaryExpr cond = LimpConstructors.makeBinaryExpr(accessIndex, updateIndex, "==");
			Expr elseExpr = LimpConstructors.makeArrayAccessExpr(updatedArray, accessIndex);
			return simplifyExpression(LimpConstructors.makeITEE(cond, aue.getValue(), elseExpr));
		}
		
		//Push the access into an IfThenElseExpr.
		if (x.getArray() instanceof IfThenElseExpr) {
			IfThenElseExpr arrayITEE = (IfThenElseExpr) x.getArray();
			Expr thenExpr = LimpConstructors.makeArrayAccessExpr(arrayITEE.getThenExpr(), x.getIndex());
			Expr elseExpr = LimpConstructors.makeArrayAccessExpr(arrayITEE.getElseExpr(), x.getIndex());
			
			return simplifyExpression(LimpConstructors.makeITEE(arrayITEE.getCondExpr(), thenExpr, elseExpr));
		}
		
		return x;
	}
	
	@Override
	public EObject caseArrayUpdateExpr(ArrayUpdateExpr x) {
	//	System.out.println(SerializerUtil.EObjectToString(x));
		copyAndReplace(x.getAccess().getArray(), (Expr) this.doSwitch(x.getAccess().getArray()));
		copyAndReplace(x.getValue(), (Expr) this.doSwitch(x.getValue()));
	//	System.out.println(SerializerUtil.EObjectToString(x));
	
		// If the Array is an ArrayExpr and the index is an IntegerLiteralExpr, then update that element of the ArrayExpr.
		// Example: Replace array arr [1, 2, 3, 4, 5] [3 := value] with array arr [1, 2, value, 4, 5].
		if (x.getAccess().getArray() instanceof ArrayExpr) {
			ArrayExpr ae = (ArrayExpr) x.getAccess().getArray();
			if (x.getAccess().getIndex() instanceof IntegerLiteralExpr) {
				IntegerLiteralExpr intIndex = (IntegerLiteralExpr) x.getAccess().getIndex();
				copyAndReplace(ae.getExprList().get(intIndex.getIntVal().intValue()), x.getValue());
				return ae;	
			}
			
			// If the Array is an ArrayExpr and the index is *, then update the elements of the ArrayExpr with the corresponding ChoiceExprs.
			// Example: Replace array arr [1, 2, 3] [* := 9] with array arr [Choice(1, 9), Choice(2,9), Choice(3,9)].
			if (x.getAccess().getIndex() instanceof IntegerWildCardExpr) {
				int j = 0;
				for (Expr e : ae.getExprList()) {
					ChoiceExpr choiceExpr = LimpConstructors.makeChoiceExpr(e, x.getValue());
					// Update the ArrayExpr with the ChoiceExpr
					ae.getExprList().set(j, EcoreUtil.copy(choiceExpr));
					j++;
				}
				return simplifyExpression(ae);
			}
			
			// If the Array is an ArrayExpr and the index is not an IntegerLiteralExpr or an IntegerWildCardExpr, then update the elements of the ArrayExpr with corresponding IfThenElseExprs.
			// Example: Replace array arr [1, 2, 3, 4, 5] [a := 9] with array arr [a == 0 ? 9 : 1, a == 1 ? 9 : 2, a == 2 ? 9 : 3, a == 3 ? 9 : 4, a == 4 ? 9 : 5].
			int i = 0;
			for (Expr e : ae.getExprList()) {
				IntegerLiteralExpr index = LimpConstructors.makeIntegerLiteralExpr(i);
				// For the example, the condition is a == i
				BinaryExpr cond = LimpConstructors.makeBinaryExpr(x.getAccess().getIndex(), index, "==");
				// For the example, the IfThenElseExpr is a == i ? 9 : v, where v is the current ith element of the ArrayExpr
				IfThenElseExpr ifee = LimpConstructors.makeITEE(cond, x.getValue(), e);				 
				// Update the ArrayExpr with the IfThenElseExpr
				ae.getExprList().set(i, EcoreUtil.copy(ifee));
				i++;
			}
			return simplifyExpression(ae);
					
		} else {
			// We could convert the ArrayUpdateExpr to an ArrayExpr, but that causes the pragmatic preconditions to really explode.
			
			// return LimpConverters.convertArrayUpdateExprToArrayExpr(x);
			
			//  So for now, just return x.
			return x;
		} 
		
	}

	@Override 
	public EObject caseUnaryNegationExpr(UnaryNegationExpr x) {
		copyAndReplace(x.getExpr(), (Expr) this.doSwitch(x.getExpr()));
		
		// Replace not true with false
		if (EcoreUtil.equals(x.getExpr(), LimpAST.trueLiteral())) {
			return LimpAST.falseLiteral();
		}
		// Replace not false with true
		if (EcoreUtil.equals(x.getExpr(), LimpAST.falseLiteral())) {
			return LimpAST.trueLiteral();
		} 	
		// Replace not not x with x
		if (x.getExpr() instanceof UnaryNegationExpr) {
			return ((UnaryNegationExpr) x.getExpr()).getExpr();
		}
		return x;
	}
	
	@Override
	public EObject caseBinaryExpr(BinaryExpr x) {
		
		//Simplify the left and right sides
		copyAndReplace(x.getLeft(), (Expr) this.doSwitch(x.getLeft()));
		copyAndReplace(x.getRight(), (Expr) this.doSwitch(x.getRight()));

		Expr left = x.getLeft();
		Expr right = x.getRight();
		String op = x.getOp();
		
		// If the BinaryExpr is y==y, return the true literal.	
		if (op.equals("==")) {
			if (EcoreUtil.equals(left, right)) {
				return LimpAST.trueLiteral();
			}
		}	
		else if (op.equals("and")) {
			// (true and z) = z 
			if (EcoreUtil.equals(left, LimpAST.trueLiteral())) {
				return right;
			}
			// (false and z) = false
			if (EcoreUtil.equals(left, LimpAST.falseLiteral())) {
				return LimpAST.falseLiteral();
			}
			// (y and true) = y
			if (EcoreUtil.equals(right, LimpAST.trueLiteral())) {
				return left;
			}
			// (y and false) = false
			if (EcoreUtil.equals(right, LimpAST.falseLiteral())) {
				return LimpAST.falseLiteral();
			}
			// (y and y) = y
			if (EcoreUtil.equals(left, right)) {
				return left;
			}
		}
		else if (op.equals("or")) {
			// (true or z) = true
			if (EcoreUtil.equals(left, LimpAST.trueLiteral())) {
				return LimpAST.trueLiteral();
			}
			// (false or z) = z
			if (EcoreUtil.equals(left, LimpAST.falseLiteral())) {
				return right;
			}
			// (y or true) = true
			if (EcoreUtil.equals(right, LimpAST.trueLiteral())) {
				return LimpAST.trueLiteral();
			}
			// (y or false) = y
			if (EcoreUtil.equals(right, LimpAST.falseLiteral())) {
				return left;
			}
			// (y or y) = y
			if (EcoreUtil.equals(left, right)) {
				return left;
			}
		}
		

		 /* //Most logical simplification should be handled by POS.
		
		//Logical simplification
		else if (x.getOp().equals("or")) {
			// If we have (a or a), return a.
			if (EcoreUtil.equals(x.getLeft(), x.getRight())) {
				return x.getLeft();
			} 
			// If we have (a or not a), return true.
			UnaryNegationExpr negLeft = LimpConstructors.makeUnaryNegationExpr(x.getLeft());
			UnaryNegationExpr negRight = LimpConstructors.makeUnaryNegationExpr(x.getRight());
			if (EcoreUtil.equals(negLeft, x.getRight()) | 
					EcoreUtil.equals(x.getLeft(), negRight)) {
				return LimpAST.trueLiteral();
			}
		} else if (x.getOp().equals("and")) {
			// If we have (a and a), return a.
			if (EcoreUtil.equals(x.getLeft(), x.getRight())) {
				return x.getLeft();
			} 
			// If we have (a or not a), return false.
			UnaryNegationExpr negLeft = LimpConstructors.makeUnaryNegationExpr(x.getLeft());
			UnaryNegationExpr negRight = LimpConstructors.makeUnaryNegationExpr(x.getRight());
			if (EcoreUtil.equals(negLeft, x.getRight()) | 
					EcoreUtil.equals(x.getLeft(), negRight)) {
				return LimpAST.falseLiteral();
			}
		}*/
		
		if ((left instanceof IntegerLiteralExpr)
				&& (right instanceof IntegerLiteralExpr)) {
			
			//Get left and right integer values
			BigInteger leftInt  = ((IntegerLiteralExpr) left).getIntVal();
			BigInteger rightInt = ((IntegerLiteralExpr) right).getIntVal();
			
			if (op.equals("+")) {
				BigInteger result = leftInt.add(rightInt);
				return LimpConstructors.makeIntegerLiteralExpr(result);
				
			} 
			else if (op.equals("-")) {
				BigInteger result = leftInt.subtract(rightInt);
				//If the result is negative, we must create a UnaryMinusExpr with value -result (which is positive).
				if (result.compareTo(BigInteger.ZERO) < 0) {
					IntegerLiteralExpr negatedResult = LimpConstructors.makeIntegerLiteralExpr(result.negate());
					return LimpConstructors.makeUnaryMinusExpr(negatedResult);
				}
				return LimpConstructors.makeIntegerLiteralExpr(result);
				
			} else if (op.equals("*")) {
				BigInteger result = leftInt.multiply(rightInt);
				return LimpConstructors.makeIntegerLiteralExpr(result);
				
			} else if (op.equals("==")) {
				if (leftInt.compareTo(rightInt) == 0) { //This should be handled by my initial test for y==y
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();

			} else if (op.equals("<>")) {
				if (leftInt.compareTo(rightInt) != 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();

			} else if (op.equals(">")) {
				if(leftInt.compareTo(rightInt) > 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();

			} else if (op.equals("<")) {
				if (leftInt.compareTo(rightInt) < 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();

			} else if (op.equals("<=")) {
				if (leftInt.compareTo(rightInt) <= 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();

			} else if (op.equals(">=")) {
				if (leftInt.compareTo(rightInt) >= 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();
			}
		} 
		
		else if ((left instanceof RealLiteralExpr)
				&& (right instanceof RealLiteralExpr)) {
			
			//Get left and right real values (as strings)
			String leftString = ((RealLiteralExpr) left).getRealVal();
			String rightString = ((RealLiteralExpr) right).getRealVal();
			
			//Convert the strings to BigDecimals
			BigDecimal leftReal = new BigDecimal(leftString);
			BigDecimal rightReal = new BigDecimal(rightString);
			
			if (op.equals("+")) {
				BigDecimal result = leftReal.add(rightReal);
				return LimpConstructors.makeRealLiteralExpr(result);				
			} 
			else if (op.equals("-")) {
				BigDecimal result = leftReal.subtract(rightReal);
				//If the result is negative, we must create a UnaryMinusExpr with value -result (which is positive).
				if (result.compareTo(BigDecimal.ZERO) < 0) {
					RealLiteralExpr negatedResult = LimpConstructors.makeRealLiteralExpr(result.negate());
					return LimpConstructors.makeUnaryMinusExpr(negatedResult);
				}
				return LimpConstructors.makeRealLiteralExpr(result);				
			} 
			else if (op.equals("*")) {
				BigDecimal result = leftReal.multiply(rightReal);
				return LimpConstructors.makeRealLiteralExpr(result);				
			} 
			else if (op.equals("/")) {
				BigDecimal result = leftReal.divide(rightReal);
				return LimpConstructors.makeRealLiteralExpr(result);	
			} 
			else if (op.equals("==")) {
				if (leftReal.compareTo(rightReal) == 0) { //This should be handled by my initial test for y==y
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();
			} 
			else if (op.equals("<>")) {
				if (leftReal.compareTo(rightReal) != 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();
			} 
			else if (op.equals(">")) {
				if(leftReal.compareTo(rightReal) > 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();
			} 
			else if (op.equals("<")) {
				if (leftReal.compareTo(rightReal) < 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();
			} 
			else if (op.equals("<=")) {
				if (leftReal.compareTo(rightReal) <= 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();
			} 
			else if (op.equals(">=")) {
				if (leftReal.compareTo(rightReal) >= 0) {
					return LimpAST.trueLiteral();
				}
				return LimpAST.falseLiteral();
			}
		} 		
		
		//Rules for arithmetic operators that apply even when we don't have literals for the left and right
		if (op.equals("+")) {
			// Replace 0 + y with y. 
			if ((EcoreUtil.equals(left, LimpConstructors.intZero())) ||(EcoreUtil.equals(left, LimpConstructors.realZero()))) {
				return right;
			}
			// Replace y + 0 with y.
			if ((EcoreUtil.equals(right, LimpConstructors.intZero())) || (EcoreUtil.equals(right, LimpConstructors.realZero()))) {
				return left;
			}
			// Replace (-y) + (-z) with -(y+z)
			if ((right instanceof UnaryMinusExpr) && (left instanceof UnaryMinusExpr)) {
				Expr sum = simplifyExpression(LimpConstructors.makeBinaryExpr(((UnaryMinusExpr) left).getExpr(), ((UnaryMinusExpr) right).getExpr(), "+"));
				return LimpConstructors.makeUnaryMinusExpr(sum);
			}
			// Replace (-y) + z with z - y
			if (left instanceof UnaryMinusExpr) {
				return simplifyExpression(LimpConstructors.makeBinaryExpr(right, ((UnaryMinusExpr) left).getExpr(), "-"));
			}
			// Replace y + (-z) with y - z
			if (right instanceof UnaryMinusExpr) {
				return simplifyExpression(LimpConstructors.makeBinaryExpr(left, ((UnaryMinusExpr) right).getExpr(), "-"));
			}
		}
		else if (op.equals("-")) {
			// Replace y - 0 with y. 
			if ((EcoreUtil.equals(right, LimpConstructors.intZero())) || (EcoreUtil.equals(right, LimpConstructors.realZero()))) {
				return left;
			}
			// Replace 0 - y with -y.
			if ((EcoreUtil.equals(left, LimpConstructors.intZero())) || (EcoreUtil.equals(left, LimpConstructors.realZero()))) {
				return simplifyExpression(LimpConstructors.makeUnaryMinusExpr(right));
			}
			// Replace (-y) - (-z) with z - y
			if ((right instanceof UnaryMinusExpr) && (left instanceof UnaryMinusExpr)) {
				return simplifyExpression(LimpConstructors.makeBinaryExpr(((UnaryMinusExpr) right).getExpr(), ((UnaryMinusExpr) left).getExpr(), "-"));
			}
			// Replace (-y) - z with -(y+z)
			if (left instanceof UnaryMinusExpr) {
				Expr sum = simplifyExpression(LimpConstructors.makeBinaryExpr(((UnaryMinusExpr) left).getExpr(), right, "+"));
				return LimpConstructors.makeUnaryMinusExpr(sum);
			}
			// Replace y - (-z) with y + z
			if (right instanceof UnaryMinusExpr) {
				return simplifyExpression(LimpConstructors.makeBinaryExpr(left, ((UnaryMinusExpr) right).getExpr(), "+"));
			}
		}
		else if (op.equals("*")) {
			// Replace 1*y with y 
			if ((EcoreUtil.equals(left, LimpConstructors.intOne())) || (EcoreUtil.equals(left, LimpConstructors.realOne()))) {
				return right;
			}
			// Replace y*1 with y
			if ((EcoreUtil.equals(right, LimpConstructors.intOne())) || (EcoreUtil.equals(right, LimpConstructors.realOne()))) {
				return left;
			}
			// Replace 0*y with 0 (for ints) 
			if (EcoreUtil.equals(left, LimpConstructors.intZero())) {
				return LimpConstructors.intZero();
			}
			// Replace 0*y with 0 (for reals)
			if (EcoreUtil.equals(left, LimpConstructors.realZero())) {
				return LimpConstructors.realZero();
			}
			// Replace y*0 with 0 (for ints)
			if (EcoreUtil.equals(right, LimpConstructors.intZero())) {
				return LimpConstructors.intZero();
			}
			// Replace y*0 with 0 (for reals)
			if (EcoreUtil.equals(right, LimpConstructors.realZero())) {
				return LimpConstructors.realZero();
			}
			// Replace (-y) * (-z) with y*z
			if ((right instanceof UnaryMinusExpr) && (left instanceof UnaryMinusExpr)) {
				return simplifyExpression(LimpConstructors.makeBinaryExpr(((UnaryMinusExpr) left).getExpr(), ((UnaryMinusExpr) right).getExpr(), "*"));
			}
			// Replace (-y) * z with -(y*z)
			if (left instanceof UnaryMinusExpr) {
				Expr product = simplifyExpression(LimpConstructors.makeBinaryExpr(((UnaryMinusExpr) left).getExpr(), right, "*"));
				return LimpConstructors.makeUnaryMinusExpr(product);
			}
			// Replace y * (-z) with -(y*z)
			if (right instanceof UnaryMinusExpr) {
				Expr product = simplifyExpression(LimpConstructors.makeBinaryExpr(left, ((UnaryMinusExpr) right).getExpr(), "*"));
				return LimpConstructors.makeUnaryMinusExpr(product);
			}
		}
		else if (op.equals("/")) {
			// Replace y/1 with y
			if ((EcoreUtil.equals(right, LimpConstructors.intOne())) || (EcoreUtil.equals(right, LimpConstructors.realOne()))) {
				return left;
			}
			// Replace (-y) / (-z) with y/z
			if ((right instanceof UnaryMinusExpr) && (left instanceof UnaryMinusExpr)) {
				return simplifyExpression(LimpConstructors.makeBinaryExpr(((UnaryMinusExpr) left).getExpr(), ((UnaryMinusExpr) right).getExpr(), "*"));
			}
			// Replace (-y) / z with -(y/z)
			if (left instanceof UnaryMinusExpr) {
				Expr quotient = simplifyExpression(LimpConstructors.makeBinaryExpr(((UnaryMinusExpr) left).getExpr(), right, "/"));
				return LimpConstructors.makeUnaryMinusExpr(quotient);
			}
			// Replace y / (-z) with -(y/z)
			if (right instanceof UnaryMinusExpr) {
				Expr quotient = simplifyExpression(LimpConstructors.makeBinaryExpr(left, ((UnaryMinusExpr) right).getExpr(), "/"));
				return LimpConstructors.makeUnaryMinusExpr(quotient);
			}
		}		
		return x;
	}
	
	@Override 
	public EObject caseUnaryMinusExpr (UnaryMinusExpr e) {
		copyAndReplace(e.getExpr(), (Expr) this.doSwitch(e.getExpr()));
		//Replace -(-y) with y
		if (e.getExpr() instanceof UnaryMinusExpr) {
			return ((UnaryMinusExpr) e.getExpr()).getExpr();
		}
		return e;
	}
	
	@Override
	public EObject caseIfThenElseExpr (IfThenElseExpr e) {
		//Call the switch on the children
		copyAndReplace(e.getCondExpr(), (Expr) this.doSwitch(e.getCondExpr()));
		copyAndReplace(e.getThenExpr(), (Expr) this.doSwitch(e.getThenExpr()));
		copyAndReplace(e.getElseExpr(), (Expr) this.doSwitch(e.getElseExpr()));
		/*//if-lifting and POS will handle this
		if (e.getThenExpr() instanceof IfThenElseExpr) {
			//If outer and inner then conditions are the same, simplify.
			//Example: Replace g1 == 1 ? (g1 == 1 ? 11 : 3) : g2 with
			//                 g1 == 1 ? 11 : g2
			IfThenElseExpr ifeeInner = (IfThenElseExpr) e.getThenExpr();
			if (EcoreUtil.equals(ifeeInner.getCondExpr(), e.getCondExpr())) {
				e.setThenExpr(EcoreUtil2.copy(ifeeInner.getThenExpr()));
			}
			
			//If outer and inner then conditions are opposites, simplify.
			//Example: Replace not(g1 == 1) ? (g1 == 1 ? 11 : 3) : g2 with
			//                 not(g1 == 1) ? 3 : g2
			UnaryNegationExpr negOuterCond = LimpConstructors.makeUnaryNegationExpr(e.getCondExpr());
			UnaryNegationExpr negInnerCond = LimpConstructors.makeUnaryNegationExpr(ifeeInner.getCondExpr());
			if (EcoreUtil.equals(negInnerCond, e.getCondExpr())
					| EcoreUtil.equals(negOuterCond, ifeeInner.getCondExpr())) {
				e.setThenExpr(ifeeInner.getElseExpr());
			}
		}
		
		if (e.getElseExpr() instanceof IfThenElseExpr) {
			//If outer and inner else conditions are the same, simplify.
			//Example: Replace g1 == 1 ? 12 : (g1 == 1 ? 11 : 3) with
			//                 g1 == 1 ? 12 : 3
			IfThenElseExpr ifeeInner = (IfThenElseExpr) e.getElseExpr();
			if (EcoreUtil.equals(ifeeInner.getCondExpr(), e.getCondExpr())) {
				e.setElseExpr(EcoreUtil2.copy(ifeeInner.getElseExpr()));
			}
			
			//If outer and inner else conditions are opposites, simplify.
			//Example: Replace not(g1 == 1) ? 12 : (g1 == 1 ? 11 : 3) with
			//                 not(g1 == 1) ? 12 : 11
			UnaryNegationExpr negOuterCond = LimpConstructors.makeUnaryNegationExpr(e.getCondExpr());
			UnaryNegationExpr negInnerCond = LimpConstructors.makeUnaryNegationExpr(ifeeInner.getCondExpr());
			if (EcoreUtil.equals(negInnerCond, e.getCondExpr())
					| EcoreUtil.equals(negOuterCond, ifeeInner.getCondExpr())) {
				e.setElseExpr(ifeeInner.getThenExpr());
			}
		} */
		
		//Replace (true? x : y) with x
		if (EcoreUtil.equals(e.getCondExpr(), LimpAST.trueLiteral())) {
			return e.getThenExpr();
			
		//Replace (false? x : y) with y
		} else if (EcoreUtil.equals(e.getCondExpr(), LimpAST.falseLiteral())) {
			return e.getElseExpr();
		
		// Replace (cond? x : x) with x
		} else if (EcoreUtil.equals(e.getThenExpr(), e.getElseExpr())) {
			return e.getThenExpr();
			
		
		// Push IfThenElseExpr into RecordExpr
		} /* else if ((e.getThenExpr() instanceof RecordExpr) && (e.getElseExpr() instanceof RecordExpr)) {
			return simplifyExpression(LimpConverters.pushIfThenElseIntoRecordExpr(e.getCondExpr(), (RecordExpr) e.getThenExpr(), (RecordExpr) e.getElseExpr()));	
		
		// Push IfThenElseExpr into ArrayExpr
		} else if ((e.getThenExpr() instanceof ArrayExpr) && (e.getElseExpr() instanceof ArrayExpr)) {
			return simplifyExpression(LimpConverters.pushIfThenElseIntoArrayExpr(e.getCondExpr(), (ArrayExpr) e.getThenExpr(), (ArrayExpr) e.getElseExpr()));
		} */	
		return e;
	}
	
}
