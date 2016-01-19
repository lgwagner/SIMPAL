/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.RealLiteralExpr;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Literal Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RealLiteralExprImpl#getRealVal <em>Real Val</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RealLiteralExprImpl extends ExprImpl implements RealLiteralExpr
{
  /**
   * The default value of the '{@link #getRealVal() <em>Real Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealVal()
   * @generated
   * @ordered
   */
  protected static final String REAL_VAL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRealVal() <em>Real Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRealVal()
   * @generated
   * @ordered
   */
  protected String realVal = REAL_VAL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RealLiteralExprImpl()
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
    return LimpPackage.Literals.REAL_LITERAL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRealVal()
  {
    return realVal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRealVal(String newRealVal)
  {
    String oldRealVal = realVal;
    realVal = newRealVal;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.REAL_LITERAL_EXPR__REAL_VAL, oldRealVal, realVal));
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
      case LimpPackage.REAL_LITERAL_EXPR__REAL_VAL:
        return getRealVal();
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
      case LimpPackage.REAL_LITERAL_EXPR__REAL_VAL:
        setRealVal((String)newValue);
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
      case LimpPackage.REAL_LITERAL_EXPR__REAL_VAL:
        setRealVal(REAL_VAL_EDEFAULT);
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
      case LimpPackage.REAL_LITERAL_EXPR__REAL_VAL:
        return REAL_VAL_EDEFAULT == null ? realVal != null : !REAL_VAL_EDEFAULT.equals(realVal);
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
    result.append(" (realVal: ");
    result.append(realVal);
    result.append(')');
    return result.toString();
  }

} //RealLiteralExprImpl
