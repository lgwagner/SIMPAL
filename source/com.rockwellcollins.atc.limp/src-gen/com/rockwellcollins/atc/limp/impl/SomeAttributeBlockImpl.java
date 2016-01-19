/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.Attribute;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.SomeAttributeBlock;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Some Attribute Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.SomeAttributeBlockImpl#getAttributeList <em>Attribute List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SomeAttributeBlockImpl extends AttributeBlockImpl implements SomeAttributeBlock
{
  /**
   * The cached value of the '{@link #getAttributeList() <em>Attribute List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeList()
   * @generated
   * @ordered
   */
  protected EList<Attribute> attributeList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SomeAttributeBlockImpl()
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
    return LimpPackage.Literals.SOME_ATTRIBUTE_BLOCK;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Attribute> getAttributeList()
  {
    if (attributeList == null)
    {
      attributeList = new EObjectContainmentEList<Attribute>(Attribute.class, this, LimpPackage.SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST);
    }
    return attributeList;
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
      case LimpPackage.SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST:
        return ((InternalEList<?>)getAttributeList()).basicRemove(otherEnd, msgs);
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
      case LimpPackage.SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST:
        return getAttributeList();
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
      case LimpPackage.SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST:
        getAttributeList().clear();
        getAttributeList().addAll((Collection<? extends Attribute>)newValue);
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
      case LimpPackage.SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST:
        getAttributeList().clear();
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
      case LimpPackage.SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST:
        return attributeList != null && !attributeList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SomeAttributeBlockImpl
