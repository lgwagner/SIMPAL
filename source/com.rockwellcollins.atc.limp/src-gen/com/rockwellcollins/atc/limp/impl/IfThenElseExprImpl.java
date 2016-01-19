/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Then Else Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.IfThenElseExprImpl#getCondExpr <em>Cond Expr</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.IfThenElseExprImpl#getThenExpr <em>Then Expr</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.IfThenElseExprImpl#getElseExpr <em>Else Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfThenElseExprImpl extends ExprImpl implements IfThenElseExpr
{
  /**
   * The cached value of the '{@link #getCondExpr() <em>Cond Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondExpr()
   * @generated
   * @ordered
   */
  protected Expr condExpr;

  /**
   * The cached value of the '{@link #getThenExpr() <em>Then Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenExpr()
   * @generated
   * @ordered
   */
  protected Expr thenExpr;

  /**
   * The cached value of the '{@link #getElseExpr() <em>Else Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseExpr()
   * @generated
   * @ordered
   */
  protected Expr elseExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfThenElseExprImpl()
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
    return LimpPackage.Literals.IF_THEN_ELSE_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getCondExpr()
  {
    return condExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondExpr(Expr newCondExpr, NotificationChain msgs)
  {
    Expr oldCondExpr = condExpr;
    condExpr = newCondExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR, oldCondExpr, newCondExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondExpr(Expr newCondExpr)
  {
    if (newCondExpr != condExpr)
    {
      NotificationChain msgs = null;
      if (condExpr != null)
        msgs = ((InternalEObject)condExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR, null, msgs);
      if (newCondExpr != null)
        msgs = ((InternalEObject)newCondExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR, null, msgs);
      msgs = basicSetCondExpr(newCondExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR, newCondExpr, newCondExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getThenExpr()
  {
    return thenExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenExpr(Expr newThenExpr, NotificationChain msgs)
  {
    Expr oldThenExpr = thenExpr;
    thenExpr = newThenExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR, oldThenExpr, newThenExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThenExpr(Expr newThenExpr)
  {
    if (newThenExpr != thenExpr)
    {
      NotificationChain msgs = null;
      if (thenExpr != null)
        msgs = ((InternalEObject)thenExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR, null, msgs);
      if (newThenExpr != null)
        msgs = ((InternalEObject)newThenExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR, null, msgs);
      msgs = basicSetThenExpr(newThenExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR, newThenExpr, newThenExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getElseExpr()
  {
    return elseExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseExpr(Expr newElseExpr, NotificationChain msgs)
  {
    Expr oldElseExpr = elseExpr;
    elseExpr = newElseExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR, oldElseExpr, newElseExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseExpr(Expr newElseExpr)
  {
    if (newElseExpr != elseExpr)
    {
      NotificationChain msgs = null;
      if (elseExpr != null)
        msgs = ((InternalEObject)elseExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR, null, msgs);
      if (newElseExpr != null)
        msgs = ((InternalEObject)newElseExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR, null, msgs);
      msgs = basicSetElseExpr(newElseExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR, newElseExpr, newElseExpr));
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
      case LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR:
        return basicSetCondExpr(null, msgs);
      case LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR:
        return basicSetThenExpr(null, msgs);
      case LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR:
        return basicSetElseExpr(null, msgs);
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
      case LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR:
        return getCondExpr();
      case LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR:
        return getThenExpr();
      case LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR:
        return getElseExpr();
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
      case LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR:
        setCondExpr((Expr)newValue);
        return;
      case LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR:
        setThenExpr((Expr)newValue);
        return;
      case LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR:
        setElseExpr((Expr)newValue);
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
      case LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR:
        setCondExpr((Expr)null);
        return;
      case LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR:
        setThenExpr((Expr)null);
        return;
      case LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR:
        setElseExpr((Expr)null);
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
      case LimpPackage.IF_THEN_ELSE_EXPR__COND_EXPR:
        return condExpr != null;
      case LimpPackage.IF_THEN_ELSE_EXPR__THEN_EXPR:
        return thenExpr != null;
      case LimpPackage.IF_THEN_ELSE_EXPR__ELSE_EXPR:
        return elseExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //IfThenElseExprImpl
