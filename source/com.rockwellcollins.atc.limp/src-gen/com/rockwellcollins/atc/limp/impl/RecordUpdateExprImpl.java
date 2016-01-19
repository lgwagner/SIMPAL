/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Update Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordUpdateExprImpl#getRecord <em>Record</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordUpdateExprImpl#getField <em>Field</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordUpdateExprImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordUpdateExprImpl extends ExprImpl implements RecordUpdateExpr
{
  /**
   * The cached value of the '{@link #getRecord() <em>Record</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecord()
   * @generated
   * @ordered
   */
  protected Expr record;

  /**
   * The default value of the '{@link #getField() <em>Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getField()
   * @generated
   * @ordered
   */
  protected static final String FIELD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getField() <em>Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getField()
   * @generated
   * @ordered
   */
  protected String field = FIELD_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected Expr value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordUpdateExprImpl()
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
    return LimpPackage.Literals.RECORD_UPDATE_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getRecord()
  {
    return record;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRecord(Expr newRecord, NotificationChain msgs)
  {
    Expr oldRecord = record;
    record = newRecord;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_UPDATE_EXPR__RECORD, oldRecord, newRecord);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecord(Expr newRecord)
  {
    if (newRecord != record)
    {
      NotificationChain msgs = null;
      if (record != null)
        msgs = ((InternalEObject)record).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.RECORD_UPDATE_EXPR__RECORD, null, msgs);
      if (newRecord != null)
        msgs = ((InternalEObject)newRecord).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.RECORD_UPDATE_EXPR__RECORD, null, msgs);
      msgs = basicSetRecord(newRecord, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_UPDATE_EXPR__RECORD, newRecord, newRecord));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getField()
  {
    return field;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setField(String newField)
  {
    String oldField = field;
    field = newField;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_UPDATE_EXPR__FIELD, oldField, field));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(Expr newValue, NotificationChain msgs)
  {
    Expr oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_UPDATE_EXPR__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(Expr newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.RECORD_UPDATE_EXPR__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.RECORD_UPDATE_EXPR__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_UPDATE_EXPR__VALUE, newValue, newValue));
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
      case LimpPackage.RECORD_UPDATE_EXPR__RECORD:
        return basicSetRecord(null, msgs);
      case LimpPackage.RECORD_UPDATE_EXPR__VALUE:
        return basicSetValue(null, msgs);
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
      case LimpPackage.RECORD_UPDATE_EXPR__RECORD:
        return getRecord();
      case LimpPackage.RECORD_UPDATE_EXPR__FIELD:
        return getField();
      case LimpPackage.RECORD_UPDATE_EXPR__VALUE:
        return getValue();
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
      case LimpPackage.RECORD_UPDATE_EXPR__RECORD:
        setRecord((Expr)newValue);
        return;
      case LimpPackage.RECORD_UPDATE_EXPR__FIELD:
        setField((String)newValue);
        return;
      case LimpPackage.RECORD_UPDATE_EXPR__VALUE:
        setValue((Expr)newValue);
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
      case LimpPackage.RECORD_UPDATE_EXPR__RECORD:
        setRecord((Expr)null);
        return;
      case LimpPackage.RECORD_UPDATE_EXPR__FIELD:
        setField(FIELD_EDEFAULT);
        return;
      case LimpPackage.RECORD_UPDATE_EXPR__VALUE:
        setValue((Expr)null);
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
      case LimpPackage.RECORD_UPDATE_EXPR__RECORD:
        return record != null;
      case LimpPackage.RECORD_UPDATE_EXPR__FIELD:
        return FIELD_EDEFAULT == null ? field != null : !FIELD_EDEFAULT.equals(field);
      case LimpPackage.RECORD_UPDATE_EXPR__VALUE:
        return value != null;
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
    result.append(" (field: ");
    result.append(field);
    result.append(')');
    return result.toString();
  }

} //RecordUpdateExprImpl
