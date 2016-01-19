/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.LimpPackage;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Literal Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.IntegerLiteralExprImpl#getIntVal <em>Int Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegerLiteralExprImpl extends ExprImpl implements IntegerLiteralExpr
{
  /**
   * The default value of the '{@link #getIntVal() <em>Int Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntVal()
   * @generated
   * @ordered
   */
  protected static final BigInteger INT_VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIntVal() <em>Int Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntVal()
   * @generated
   * @ordered
   */
  protected BigInteger intVal = INT_VAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegerLiteralExprImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return LimpPackage.Literals.INTEGER_LITERAL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getIntVal()
  {
    return intVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntVal(BigInteger newIntVal)
  {
    BigInteger oldIntVal = intVal;
    intVal = newIntVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.INTEGER_LITERAL_EXPR__INT_VAL, oldIntVal, intVal));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case LimpPackage.INTEGER_LITERAL_EXPR__INT_VAL:
        return getIntVal();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LimpPackage.INTEGER_LITERAL_EXPR__INT_VAL:
        setIntVal((BigInteger)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case LimpPackage.INTEGER_LITERAL_EXPR__INT_VAL:
        setIntVal(INT_VAL_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case LimpPackage.INTEGER_LITERAL_EXPR__INT_VAL:
        return INT_VAL_EDEFAULT == null ? intVal != null : !INT_VAL_EDEFAULT.equals(intVal);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (intVal: ");
    result.append(intVal);
    result.append(')');
    return result.toString();
  }

} //IntegerLiteralExprImpl
