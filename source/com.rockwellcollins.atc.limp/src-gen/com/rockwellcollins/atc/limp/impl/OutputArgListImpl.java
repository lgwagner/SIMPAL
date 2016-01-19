/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.OutputArgList;

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
 * An implementation of the model object '<em><b>Output Arg List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.OutputArgListImpl#getOutputArgs <em>Output Args</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OutputArgListImpl extends MinimalEObjectImpl.Container implements OutputArgList
{
  /**
   * The cached value of the '{@link #getOutputArgs() <em>Output Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputArgs()
   * @generated
   * @ordered
   */
  protected EList<OutputArg> outputArgs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OutputArgListImpl()
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
    return LimpPackage.Literals.OUTPUT_ARG_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OutputArg> getOutputArgs()
  {
    if (outputArgs == null)
    {
      outputArgs = new EObjectContainmentEList<OutputArg>(OutputArg.class, this, LimpPackage.OUTPUT_ARG_LIST__OUTPUT_ARGS);
    }
    return outputArgs;
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
      case LimpPackage.OUTPUT_ARG_LIST__OUTPUT_ARGS:
        return ((InternalEList<?>)getOutputArgs()).basicRemove(otherEnd, msgs);
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
      case LimpPackage.OUTPUT_ARG_LIST__OUTPUT_ARGS:
        return getOutputArgs();
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
      case LimpPackage.OUTPUT_ARG_LIST__OUTPUT_ARGS:
        getOutputArgs().clear();
        getOutputArgs().addAll((Collection<? extends OutputArg>)newValue);
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
      case LimpPackage.OUTPUT_ARG_LIST__OUTPUT_ARGS:
        getOutputArgs().clear();
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
      case LimpPackage.OUTPUT_ARG_LIST__OUTPUT_ARGS:
        return outputArgs != null && !outputArgs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //OutputArgListImpl
