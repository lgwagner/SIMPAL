/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.EnumType;
import com.rockwellcollins.atc.limp.EnumTypeDef;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.EnumTypeImpl#getEnumDef <em>Enum Def</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumTypeImpl extends TypeImpl implements EnumType
{
  /**
   * The cached value of the '{@link #getEnumDef() <em>Enum Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumDef()
   * @generated
   * @ordered
   */
  protected EnumTypeDef enumDef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumTypeImpl()
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
    return LimpPackage.Literals.ENUM_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumTypeDef getEnumDef()
  {
    if (enumDef != null && enumDef.eIsProxy())
    {
      InternalEObject oldEnumDef = (InternalEObject)enumDef;
      enumDef = (EnumTypeDef)eResolveProxy(oldEnumDef);
      if (enumDef != oldEnumDef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LimpPackage.ENUM_TYPE__ENUM_DEF, oldEnumDef, enumDef));
      }
    }
    return enumDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumTypeDef basicGetEnumDef()
  {
    return enumDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumDef(EnumTypeDef newEnumDef)
  {
    EnumTypeDef oldEnumDef = enumDef;
    enumDef = newEnumDef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.ENUM_TYPE__ENUM_DEF, oldEnumDef, enumDef));
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
      case LimpPackage.ENUM_TYPE__ENUM_DEF:
        if (resolve) return getEnumDef();
        return basicGetEnumDef();
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
      case LimpPackage.ENUM_TYPE__ENUM_DEF:
        setEnumDef((EnumTypeDef)newValue);
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
      case LimpPackage.ENUM_TYPE__ENUM_DEF:
        setEnumDef((EnumTypeDef)null);
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
      case LimpPackage.ENUM_TYPE__ENUM_DEF:
        return enumDef != null;
    }
    return super.eIsSet(featureID);
  }

} //EnumTypeImpl
