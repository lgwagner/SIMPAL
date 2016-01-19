/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.DefineUseRef;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Define Use Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.DefineUseRefImpl#getReferenceExpr <em>Reference Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefineUseRefImpl extends MinimalEObjectImpl.Container implements DefineUseRef
{
  /**
   * The cached value of the '{@link #getReferenceExpr() <em>Reference Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceExpr()
   * @generated
   * @ordered
   */
  protected Expr referenceExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefineUseRefImpl()
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
    return LimpPackage.Literals.DEFINE_USE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getReferenceExpr()
  {
    return referenceExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReferenceExpr(Expr newReferenceExpr, NotificationChain msgs)
  {
    Expr oldReferenceExpr = referenceExpr;
    referenceExpr = newReferenceExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR, oldReferenceExpr, newReferenceExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenceExpr(Expr newReferenceExpr)
  {
    if (newReferenceExpr != referenceExpr)
    {
      NotificationChain msgs = null;
      if (referenceExpr != null)
        msgs = ((InternalEObject)referenceExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR, null, msgs);
      if (newReferenceExpr != null)
        msgs = ((InternalEObject)newReferenceExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR, null, msgs);
      msgs = basicSetReferenceExpr(newReferenceExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR, newReferenceExpr, newReferenceExpr));
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
      case LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR:
        return basicSetReferenceExpr(null, msgs);
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
      case LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR:
        return getReferenceExpr();
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
      case LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR:
        setReferenceExpr((Expr)newValue);
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
      case LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR:
        setReferenceExpr((Expr)null);
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
      case LimpPackage.DEFINE_USE_REF__REFERENCE_EXPR:
        return referenceExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //DefineUseRefImpl
