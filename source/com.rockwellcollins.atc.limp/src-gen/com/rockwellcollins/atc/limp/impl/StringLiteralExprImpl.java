/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.StringLiteralExpr;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Literal Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.StringLiteralExprImpl#getStringVal <em>String Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringLiteralExprImpl extends ExprImpl implements StringLiteralExpr
{
  /**
   * The default value of the '{@link #getStringVal() <em>String Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringVal()
   * @generated
   * @ordered
   */
  protected static final String STRING_VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStringVal() <em>String Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStringVal()
   * @generated
   * @ordered
   */
  protected String stringVal = STRING_VAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StringLiteralExprImpl()
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
    return LimpPackage.Literals.STRING_LITERAL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getStringVal()
  {
    return stringVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStringVal(String newStringVal)
  {
    String oldStringVal = stringVal;
    stringVal = newStringVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.STRING_LITERAL_EXPR__STRING_VAL, oldStringVal, stringVal));
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
      case LimpPackage.STRING_LITERAL_EXPR__STRING_VAL:
        return getStringVal();
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
      case LimpPackage.STRING_LITERAL_EXPR__STRING_VAL:
        setStringVal((String)newValue);
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
      case LimpPackage.STRING_LITERAL_EXPR__STRING_VAL:
        setStringVal(STRING_VAL_EDEFAULT);
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
      case LimpPackage.STRING_LITERAL_EXPR__STRING_VAL:
        return STRING_VAL_EDEFAULT == null ? stringVal != null : !STRING_VAL_EDEFAULT.equals(stringVal);
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
    result.append(" (stringVal: ");
    result.append(stringVal);
    result.append(')');
    return result.toString();
  }

} //StringLiteralExprImpl
