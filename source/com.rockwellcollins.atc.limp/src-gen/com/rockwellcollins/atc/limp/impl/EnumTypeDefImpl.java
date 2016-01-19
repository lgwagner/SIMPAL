/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.EnumTypeDef;
import com.rockwellcollins.atc.limp.EnumValue;
import com.rockwellcollins.atc.limp.LimpPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Type Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.EnumTypeDefImpl#getEnumerations <em>Enumerations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumTypeDefImpl extends TypeDeclarationImpl implements EnumTypeDef
{
  /**
   * The cached value of the '{@link #getEnumerations() <em>Enumerations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumerations()
   * @generated
   * @ordered
   */
  protected EList<EnumValue> enumerations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumTypeDefImpl()
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
    return LimpPackage.Literals.ENUM_TYPE_DEF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EnumValue> getEnumerations()
  {
    if (enumerations == null)
    {
      enumerations = new EObjectContainmentEList<EnumValue>(EnumValue.class, this, LimpPackage.ENUM_TYPE_DEF__ENUMERATIONS);
    }
    return enumerations;
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
      case LimpPackage.ENUM_TYPE_DEF__ENUMERATIONS:
        return ((InternalEList<?>)getEnumerations()).basicRemove(otherEnd, msgs);
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
      case LimpPackage.ENUM_TYPE_DEF__ENUMERATIONS:
        return getEnumerations();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LimpPackage.ENUM_TYPE_DEF__ENUMERATIONS:
        getEnumerations().clear();
        getEnumerations().addAll((Collection<? extends EnumValue>)newValue);
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
      case LimpPackage.ENUM_TYPE_DEF__ENUMERATIONS:
        getEnumerations().clear();
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
      case LimpPackage.ENUM_TYPE_DEF__ENUMERATIONS:
        return enumerations != null && !enumerations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //EnumTypeDefImpl
