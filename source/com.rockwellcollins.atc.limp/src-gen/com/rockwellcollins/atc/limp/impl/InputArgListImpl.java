/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.InputArgList;
import com.rockwellcollins.atc.limp.LimpPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Arg List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.InputArgListImpl#getInputArgs <em>Input Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputArgListImpl extends MinimalEObjectImpl.Container implements InputArgList
{
  /**
   * The cached value of the '{@link #getInputArgs() <em>Input Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputArgs()
   * @generated
   * @ordered
   */
  protected EList<InputArg> inputArgs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InputArgListImpl()
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
    return LimpPackage.Literals.INPUT_ARG_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<InputArg> getInputArgs()
  {
    if (inputArgs == null)
    {
      inputArgs = new EObjectContainmentEList<InputArg>(InputArg.class, this, LimpPackage.INPUT_ARG_LIST__INPUT_ARGS);
    }
    return inputArgs;
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
      case LimpPackage.INPUT_ARG_LIST__INPUT_ARGS:
        return ((InternalEList<?>)getInputArgs()).basicRemove(otherEnd, msgs);
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
      case LimpPackage.INPUT_ARG_LIST__INPUT_ARGS:
        return getInputArgs();
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
      case LimpPackage.INPUT_ARG_LIST__INPUT_ARGS:
        getInputArgs().clear();
        getInputArgs().addAll((Collection<? extends InputArg>)newValue);
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
      case LimpPackage.INPUT_ARG_LIST__INPUT_ARGS:
        getInputArgs().clear();
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
      case LimpPackage.INPUT_ARG_LIST__INPUT_ARGS:
        return inputArgs != null && !inputArgs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //InputArgListImpl
