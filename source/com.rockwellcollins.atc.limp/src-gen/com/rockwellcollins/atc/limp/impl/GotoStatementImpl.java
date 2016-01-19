/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.GotoStatement;
import com.rockwellcollins.atc.limp.LabelStatement;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goto Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.GotoStatementImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.GotoStatementImpl#getWhenExpr <em>When Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GotoStatementImpl extends StatementImpl implements GotoStatement
{
  /**
   * The cached value of the '{@link #getLabel() <em>Label</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabel()
   * @generated
   * @ordered
   */
  protected LabelStatement label;

  /**
   * The cached value of the '{@link #getWhenExpr() <em>When Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWhenExpr()
   * @generated
   * @ordered
   */
  protected Expr whenExpr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GotoStatementImpl()
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
    return LimpPackage.Literals.GOTO_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LabelStatement getLabel()
  {
    if (label != null && label.eIsProxy())
    {
      InternalEObject oldLabel = (InternalEObject)label;
      label = (LabelStatement)eResolveProxy(oldLabel);
      if (label != oldLabel)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LimpPackage.GOTO_STATEMENT__LABEL, oldLabel, label));
      }
    }
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LabelStatement basicGetLabel()
  {
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabel(LabelStatement newLabel)
  {
    LabelStatement oldLabel = label;
    label = newLabel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.GOTO_STATEMENT__LABEL, oldLabel, label));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getWhenExpr()
  {
    return whenExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetWhenExpr(Expr newWhenExpr, NotificationChain msgs)
  {
    Expr oldWhenExpr = whenExpr;
    whenExpr = newWhenExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.GOTO_STATEMENT__WHEN_EXPR, oldWhenExpr, newWhenExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWhenExpr(Expr newWhenExpr)
  {
    if (newWhenExpr != whenExpr)
    {
      NotificationChain msgs = null;
      if (whenExpr != null)
        msgs = ((InternalEObject)whenExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.GOTO_STATEMENT__WHEN_EXPR, null, msgs);
      if (newWhenExpr != null)
        msgs = ((InternalEObject)newWhenExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.GOTO_STATEMENT__WHEN_EXPR, null, msgs);
      msgs = basicSetWhenExpr(newWhenExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.GOTO_STATEMENT__WHEN_EXPR, newWhenExpr, newWhenExpr));
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
      case LimpPackage.GOTO_STATEMENT__WHEN_EXPR:
        return basicSetWhenExpr(null, msgs);
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
      case LimpPackage.GOTO_STATEMENT__LABEL:
        if (resolve) return getLabel();
        return basicGetLabel();
      case LimpPackage.GOTO_STATEMENT__WHEN_EXPR:
        return getWhenExpr();
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
      case LimpPackage.GOTO_STATEMENT__LABEL:
        setLabel((LabelStatement)newValue);
        return;
      case LimpPackage.GOTO_STATEMENT__WHEN_EXPR:
        setWhenExpr((Expr)newValue);
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
      case LimpPackage.GOTO_STATEMENT__LABEL:
        setLabel((LabelStatement)null);
        return;
      case LimpPackage.GOTO_STATEMENT__WHEN_EXPR:
        setWhenExpr((Expr)null);
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
      case LimpPackage.GOTO_STATEMENT__LABEL:
        return label != null;
      case LimpPackage.GOTO_STATEMENT__WHEN_EXPR:
        return whenExpr != null;
    }
    return super.eIsSet(featureID);
  }

} //GotoStatementImpl
