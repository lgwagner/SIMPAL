/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.RecordFieldExpr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Field Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordFieldExprImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordFieldExprImpl#getFieldExpr <em>Field Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordFieldExprImpl extends MinimalEObjectImpl.Container implements RecordFieldExpr
{
  /**
   * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldName()
   * @generated
   * @ordered
   */
  protected static final String FIELD_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldName()
   * @generated
   * @ordered
   */
  protected String fieldName = FIELD_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getFieldExpr() <em>Field Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldExpr()
   * @generated
   * @ordered
   */
  protected Expr fieldExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordFieldExprImpl()
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
    return LimpPackage.Literals.RECORD_FIELD_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFieldName()
  {
    return fieldName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldName(String newFieldName)
  {
    String oldFieldName = fieldName;
    fieldName = newFieldName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_FIELD_EXPR__FIELD_NAME, oldFieldName, fieldName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getFieldExpr()
  {
    return fieldExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFieldExpr(Expr newFieldExpr, NotificationChain msgs)
  {
    Expr oldFieldExpr = fieldExpr;
    fieldExpr = newFieldExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR, oldFieldExpr, newFieldExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldExpr(Expr newFieldExpr)
  {
    if (newFieldExpr != fieldExpr)
    {
      NotificationChain msgs = null;
      if (fieldExpr != null)
        msgs = ((InternalEObject)fieldExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR, null, msgs);
      if (newFieldExpr != null)
        msgs = ((InternalEObject)newFieldExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR, null, msgs);
      msgs = basicSetFieldExpr(newFieldExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR, newFieldExpr, newFieldExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR:
        return basicSetFieldExpr(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_NAME:
        return getFieldName();
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR:
        return getFieldExpr();
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
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_NAME:
        setFieldName((String)newValue);
        return;
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR:
        setFieldExpr((Expr)newValue);
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
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_NAME:
        setFieldName(FIELD_NAME_EDEFAULT);
        return;
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR:
        setFieldExpr((Expr)null);
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
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_NAME:
        return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
      case LimpPackage.RECORD_FIELD_EXPR__FIELD_EXPR:
        return fieldExpr != null;
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
    result.append(" (fieldName: ");
    result.append(fieldName);
    result.append(')');
    return result.toString();
  }

} //RecordFieldExprImpl
