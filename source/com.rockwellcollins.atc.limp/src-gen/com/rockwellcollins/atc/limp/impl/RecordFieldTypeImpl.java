/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.RecordFieldType;
import com.rockwellcollins.atc.limp.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Field Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordFieldTypeImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordFieldTypeImpl#getFieldType <em>Field Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordFieldTypeImpl extends MinimalEObjectImpl.Container implements RecordFieldType
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
   * The cached value of the '{@link #getFieldType() <em>Field Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldType()
   * @generated
   * @ordered
   */
  protected Type fieldType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordFieldTypeImpl()
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
    return LimpPackage.Literals.RECORD_FIELD_TYPE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_FIELD_TYPE__FIELD_NAME, oldFieldName, fieldName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getFieldType()
  {
    return fieldType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFieldType(Type newFieldType, NotificationChain msgs)
  {
    Type oldFieldType = fieldType;
    fieldType = newFieldType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE, oldFieldType, newFieldType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFieldType(Type newFieldType)
  {
    if (newFieldType != fieldType)
    {
      NotificationChain msgs = null;
      if (fieldType != null)
        msgs = ((InternalEObject)fieldType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE, null, msgs);
      if (newFieldType != null)
        msgs = ((InternalEObject)newFieldType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE, null, msgs);
      msgs = basicSetFieldType(newFieldType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE, newFieldType, newFieldType));
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
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE:
        return basicSetFieldType(null, msgs);
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
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_NAME:
        return getFieldName();
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE:
        return getFieldType();
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
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_NAME:
        setFieldName((String)newValue);
        return;
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE:
        setFieldType((Type)newValue);
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
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_NAME:
        setFieldName(FIELD_NAME_EDEFAULT);
        return;
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE:
        setFieldType((Type)null);
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
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_NAME:
        return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
      case LimpPackage.RECORD_FIELD_TYPE__FIELD_TYPE:
        return fieldType != null;
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

} //RecordFieldTypeImpl
