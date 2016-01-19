/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.ExprList;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.FunctionRef;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fcn Call Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.FcnCallExprImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.FcnCallExprImpl#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FcnCallExprImpl extends ExprImpl implements FcnCallExpr
{
  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected FunctionRef id;

  /**
   * The cached value of the '{@link #getExprs() <em>Exprs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExprs()
   * @generated
   * @ordered
   */
  protected ExprList exprs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FcnCallExprImpl()
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
    return LimpPackage.Literals.FCN_CALL_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionRef getId()
  {
    if (id != null && id.eIsProxy())
    {
      InternalEObject oldId = (InternalEObject)id;
      id = (FunctionRef)eResolveProxy(oldId);
      if (id != oldId)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LimpPackage.FCN_CALL_EXPR__ID, oldId, id));
      }
    }
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionRef basicGetId()
  {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setId(FunctionRef newId)
  {
    FunctionRef oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.FCN_CALL_EXPR__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprList getExprs()
  {
    return exprs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExprs(ExprList newExprs, NotificationChain msgs)
  {
    ExprList oldExprs = exprs;
    exprs = newExprs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.FCN_CALL_EXPR__EXPRS, oldExprs, newExprs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExprs(ExprList newExprs)
  {
    if (newExprs != exprs)
    {
      NotificationChain msgs = null;
      if (exprs != null)
        msgs = ((InternalEObject)exprs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FCN_CALL_EXPR__EXPRS, null, msgs);
      if (newExprs != null)
        msgs = ((InternalEObject)newExprs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FCN_CALL_EXPR__EXPRS, null, msgs);
      msgs = basicSetExprs(newExprs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.FCN_CALL_EXPR__EXPRS, newExprs, newExprs));
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
      case LimpPackage.FCN_CALL_EXPR__EXPRS:
        return basicSetExprs(null, msgs);
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
      case LimpPackage.FCN_CALL_EXPR__ID:
        if (resolve) return getId();
        return basicGetId();
      case LimpPackage.FCN_CALL_EXPR__EXPRS:
        return getExprs();
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
      case LimpPackage.FCN_CALL_EXPR__ID:
        setId((FunctionRef)newValue);
        return;
      case LimpPackage.FCN_CALL_EXPR__EXPRS:
        setExprs((ExprList)newValue);
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
      case LimpPackage.FCN_CALL_EXPR__ID:
        setId((FunctionRef)null);
        return;
      case LimpPackage.FCN_CALL_EXPR__EXPRS:
        setExprs((ExprList)null);
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
      case LimpPackage.FCN_CALL_EXPR__ID:
        return id != null;
      case LimpPackage.FCN_CALL_EXPR__EXPRS:
        return exprs != null;
    }
    return super.eIsSet(featureID);
  }

} //FcnCallExprImpl
