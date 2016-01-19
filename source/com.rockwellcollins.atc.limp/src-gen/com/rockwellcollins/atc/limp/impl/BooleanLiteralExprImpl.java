/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.BooleanLiteralExpr;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Literal Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.BooleanLiteralExprImpl#getBoolVal <em>Bool Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanLiteralExprImpl extends ExprImpl implements BooleanLiteralExpr
{
  /**
   * The default value of the '{@link #getBoolVal() <em>Bool Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolVal()
   * @generated
   * @ordered
   */
  protected static final String BOOL_VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBoolVal() <em>Bool Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolVal()
   * @generated
   * @ordered
   */
  protected String boolVal = BOOL_VAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BooleanLiteralExprImpl()
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
    return LimpPackage.Literals.BOOLEAN_LITERAL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBoolVal()
  {
    return boolVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoolVal(String newBoolVal)
  {
    String oldBoolVal = boolVal;
    boolVal = newBoolVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.BOOLEAN_LITERAL_EXPR__BOOL_VAL, oldBoolVal, boolVal));
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
      case LimpPackage.BOOLEAN_LITERAL_EXPR__BOOL_VAL:
        return getBoolVal();
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
      case LimpPackage.BOOLEAN_LITERAL_EXPR__BOOL_VAL:
        setBoolVal((String)newValue);
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
      case LimpPackage.BOOLEAN_LITERAL_EXPR__BOOL_VAL:
        setBoolVal(BOOL_VAL_EDEFAULT);
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
      case LimpPackage.BOOLEAN_LITERAL_EXPR__BOOL_VAL:
        return BOOL_VAL_EDEFAULT == null ? boolVal != null : !BOOL_VAL_EDEFAULT.equals(boolVal);
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
    result.append(" (boolVal: ");
    result.append(boolVal);
    result.append(')');
    return result.toString();
  }

} //BooleanLiteralExprImpl
