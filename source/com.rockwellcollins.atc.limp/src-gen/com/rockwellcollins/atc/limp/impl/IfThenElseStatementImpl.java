/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.Else;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.StatementBlock;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Then Else Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.IfThenElseStatementImpl#getCond <em>Cond</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.IfThenElseStatementImpl#getThenBlock <em>Then Block</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.IfThenElseStatementImpl#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfThenElseStatementImpl extends StatementImpl implements IfThenElseStatement
{
  /**
   * The cached value of the '{@link #getCond() <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCond()
   * @generated
   * @ordered
   */
  protected Expr cond;

  /**
   * The cached value of the '{@link #getThenBlock() <em>Then Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenBlock()
   * @generated
   * @ordered
   */
  protected StatementBlock thenBlock;

  /**
   * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElse()
   * @generated
   * @ordered
   */
  protected Else else_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfThenElseStatementImpl()
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
    return LimpPackage.Literals.IF_THEN_ELSE_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getCond()
  {
    return cond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs)
  {
    Expr oldCond = cond;
    cond = newCond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_STATEMENT__COND, oldCond, newCond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCond(Expr newCond)
  {
    if (newCond != cond)
    {
      NotificationChain msgs = null;
      if (cond != null)
        msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_STATEMENT__COND, null, msgs);
      if (newCond != null)
        msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_STATEMENT__COND, null, msgs);
      msgs = basicSetCond(newCond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_STATEMENT__COND, newCond, newCond));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementBlock getThenBlock()
  {
    return thenBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenBlock(StatementBlock newThenBlock, NotificationChain msgs)
  {
    StatementBlock oldThenBlock = thenBlock;
    thenBlock = newThenBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK, oldThenBlock, newThenBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThenBlock(StatementBlock newThenBlock)
  {
    if (newThenBlock != thenBlock)
    {
      NotificationChain msgs = null;
      if (thenBlock != null)
        msgs = ((InternalEObject)thenBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK, null, msgs);
      if (newThenBlock != null)
        msgs = ((InternalEObject)newThenBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK, null, msgs);
      msgs = basicSetThenBlock(newThenBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK, newThenBlock, newThenBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Else getElse()
  {
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElse(Else newElse, NotificationChain msgs)
  {
    Else oldElse = else_;
    else_ = newElse;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE, oldElse, newElse);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElse(Else newElse)
  {
    if (newElse != else_)
    {
      NotificationChain msgs = null;
      if (else_ != null)
        msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE, null, msgs);
      if (newElse != null)
        msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE, null, msgs);
      msgs = basicSetElse(newElse, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE, newElse, newElse));
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
      case LimpPackage.IF_THEN_ELSE_STATEMENT__COND:
        return basicSetCond(null, msgs);
      case LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK:
        return basicSetThenBlock(null, msgs);
      case LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE:
        return basicSetElse(null, msgs);
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
      case LimpPackage.IF_THEN_ELSE_STATEMENT__COND:
        return getCond();
      case LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK:
        return getThenBlock();
      case LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE:
        return getElse();
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
      case LimpPackage.IF_THEN_ELSE_STATEMENT__COND:
        setCond((Expr)newValue);
        return;
      case LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK:
        setThenBlock((StatementBlock)newValue);
        return;
      case LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE:
        setElse((Else)newValue);
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
      case LimpPackage.IF_THEN_ELSE_STATEMENT__COND:
        setCond((Expr)null);
        return;
      case LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK:
        setThenBlock((StatementBlock)null);
        return;
      case LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE:
        setElse((Else)null);
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
      case LimpPackage.IF_THEN_ELSE_STATEMENT__COND:
        return cond != null;
      case LimpPackage.IF_THEN_ELSE_STATEMENT__THEN_BLOCK:
        return thenBlock != null;
      case LimpPackage.IF_THEN_ELSE_STATEMENT__ELSE:
        return else_ != null;
    }
    return super.eIsSet(featureID);
  }

} //IfThenElseStatementImpl
