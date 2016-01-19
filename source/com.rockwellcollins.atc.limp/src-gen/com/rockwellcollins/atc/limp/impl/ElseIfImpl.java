/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.ElseIf;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Else If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ElseIfImpl#getIfThenElse <em>If Then Else</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElseIfImpl extends ElseImpl implements ElseIf
{
  /**
   * The cached value of the '{@link #getIfThenElse() <em>If Then Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIfThenElse()
   * @generated
   * @ordered
   */
  protected IfThenElseStatement ifThenElse;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElseIfImpl()
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
    return LimpPackage.Literals.ELSE_IF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfThenElseStatement getIfThenElse()
  {
    return ifThenElse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIfThenElse(IfThenElseStatement newIfThenElse, NotificationChain msgs)
  {
    IfThenElseStatement oldIfThenElse = ifThenElse;
    ifThenElse = newIfThenElse;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.ELSE_IF__IF_THEN_ELSE, oldIfThenElse, newIfThenElse);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIfThenElse(IfThenElseStatement newIfThenElse)
  {
    if (newIfThenElse != ifThenElse)
    {
      NotificationChain msgs = null;
      if (ifThenElse != null)
        msgs = ((InternalEObject)ifThenElse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.ELSE_IF__IF_THEN_ELSE, null, msgs);
      if (newIfThenElse != null)
        msgs = ((InternalEObject)newIfThenElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.ELSE_IF__IF_THEN_ELSE, null, msgs);
      msgs = basicSetIfThenElse(newIfThenElse, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.ELSE_IF__IF_THEN_ELSE, newIfThenElse, newIfThenElse));
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
      case LimpPackage.ELSE_IF__IF_THEN_ELSE:
        return basicSetIfThenElse(null, msgs);
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
      case LimpPackage.ELSE_IF__IF_THEN_ELSE:
        return getIfThenElse();
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
      case LimpPackage.ELSE_IF__IF_THEN_ELSE:
        setIfThenElse((IfThenElseStatement)newValue);
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
      case LimpPackage.ELSE_IF__IF_THEN_ELSE:
        setIfThenElse((IfThenElseStatement)null);
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
      case LimpPackage.ELSE_IF__IF_THEN_ELSE:
        return ifThenElse != null;
    }
    return super.eIsSet(featureID);
  }

} //ElseIfImpl
