/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.AbstractType;
import com.rockwellcollins.atc.limp.AbstractTypeDef;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.AbstractTypeImpl#getAbstractDef <em>Abstract Def</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractTypeImpl extends TypeImpl implements AbstractType
{
  /**
   * The cached value of the '{@link #getAbstractDef() <em>Abstract Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAbstractDef()
   * @generated
   * @ordered
   */
  protected AbstractTypeDef abstractDef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AbstractTypeImpl()
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
    return LimpPackage.Literals.ABSTRACT_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractTypeDef getAbstractDef()
  {
    if (abstractDef != null && abstractDef.eIsProxy())
    {
      InternalEObject oldAbstractDef = (InternalEObject)abstractDef;
      abstractDef = (AbstractTypeDef)eResolveProxy(oldAbstractDef);
      if (abstractDef != oldAbstractDef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LimpPackage.ABSTRACT_TYPE__ABSTRACT_DEF, oldAbstractDef, abstractDef));
      }
    }
    return abstractDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractTypeDef basicGetAbstractDef()
  {
    return abstractDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAbstractDef(AbstractTypeDef newAbstractDef)
  {
    AbstractTypeDef oldAbstractDef = abstractDef;
    abstractDef = newAbstractDef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.ABSTRACT_TYPE__ABSTRACT_DEF, oldAbstractDef, abstractDef));
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
      case LimpPackage.ABSTRACT_TYPE__ABSTRACT_DEF:
        if (resolve) return getAbstractDef();
        return basicGetAbstractDef();
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
      case LimpPackage.ABSTRACT_TYPE__ABSTRACT_DEF:
        setAbstractDef((AbstractTypeDef)newValue);
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
      case LimpPackage.ABSTRACT_TYPE__ABSTRACT_DEF:
        setAbstractDef((AbstractTypeDef)null);
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
      case LimpPackage.ABSTRACT_TYPE__ABSTRACT_DEF:
        return abstractDef != null;
    }
    return super.eIsSet(featureID);
  }

} //AbstractTypeImpl
