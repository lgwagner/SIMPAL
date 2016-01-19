/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.RecordTypeDef;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordTypeImpl#getRecordDef <em>Record Def</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordTypeImpl extends TypeImpl implements RecordType
{
  /**
   * The cached value of the '{@link #getRecordDef() <em>Record Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordDef()
   * @generated
   * @ordered
   */
  protected RecordTypeDef recordDef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordTypeImpl()
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
    return LimpPackage.Literals.RECORD_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTypeDef getRecordDef()
  {
    if (recordDef != null && recordDef.eIsProxy())
    {
      InternalEObject oldRecordDef = (InternalEObject)recordDef;
      recordDef = (RecordTypeDef)eResolveProxy(oldRecordDef);
      if (recordDef != oldRecordDef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LimpPackage.RECORD_TYPE__RECORD_DEF, oldRecordDef, recordDef));
      }
    }
    return recordDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTypeDef basicGetRecordDef()
  {
    return recordDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordDef(RecordTypeDef newRecordDef)
  {
    RecordTypeDef oldRecordDef = recordDef;
    recordDef = newRecordDef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_TYPE__RECORD_DEF, oldRecordDef, recordDef));
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
      case LimpPackage.RECORD_TYPE__RECORD_DEF:
        if (resolve) return getRecordDef();
        return basicGetRecordDef();
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
      case LimpPackage.RECORD_TYPE__RECORD_DEF:
        setRecordDef((RecordTypeDef)newValue);
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
      case LimpPackage.RECORD_TYPE__RECORD_DEF:
        setRecordDef((RecordTypeDef)null);
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
      case LimpPackage.RECORD_TYPE__RECORD_DEF:
        return recordDef != null;
    }
    return super.eIsSet(featureID);
  }

} //RecordTypeImpl
