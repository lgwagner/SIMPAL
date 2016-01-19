/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.ArrayType;
import com.rockwellcollins.atc.limp.ArrayTypeDef;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ArrayTypeImpl#getArrayDef <em>Array Def</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayTypeImpl extends TypeImpl implements ArrayType
{
  /**
   * The cached value of the '{@link #getArrayDef() <em>Array Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayDef()
   * @generated
   * @ordered
   */
  protected ArrayTypeDef arrayDef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArrayTypeImpl()
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
    return LimpPackage.Literals.ARRAY_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayTypeDef getArrayDef()
  {
    if (arrayDef != null && arrayDef.eIsProxy())
    {
      InternalEObject oldArrayDef = (InternalEObject)arrayDef;
      arrayDef = (ArrayTypeDef)eResolveProxy(oldArrayDef);
      if (arrayDef != oldArrayDef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LimpPackage.ARRAY_TYPE__ARRAY_DEF, oldArrayDef, arrayDef));
      }
    }
    return arrayDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayTypeDef basicGetArrayDef()
  {
    return arrayDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArrayDef(ArrayTypeDef newArrayDef)
  {
    ArrayTypeDef oldArrayDef = arrayDef;
    arrayDef = newArrayDef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.ARRAY_TYPE__ARRAY_DEF, oldArrayDef, arrayDef));
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
      case LimpPackage.ARRAY_TYPE__ARRAY_DEF:
        if (resolve) return getArrayDef();
        return basicGetArrayDef();
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
      case LimpPackage.ARRAY_TYPE__ARRAY_DEF:
        setArrayDef((ArrayTypeDef)newValue);
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
      case LimpPackage.ARRAY_TYPE__ARRAY_DEF:
        setArrayDef((ArrayTypeDef)null);
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
      case LimpPackage.ARRAY_TYPE__ARRAY_DEF:
        return arrayDef != null;
    }
    return super.eIsSet(featureID);
  }

} //ArrayTypeImpl
