/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.ChoiceExpr;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ChoiceExprImpl#getFirst <em>First</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ChoiceExprImpl#getSecond <em>Second</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChoiceExprImpl extends ExprImpl implements ChoiceExpr
{
  /**
   * The cached value of the '{@link #getFirst() <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirst()
   * @generated
   * @ordered
   */
  protected Expr first;

  /**
   * The cached value of the '{@link #getSecond() <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecond()
   * @generated
   * @ordered
   */
  protected Expr second;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChoiceExprImpl()
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
    return LimpPackage.Literals.CHOICE_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getFirst()
  {
    return first;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirst(Expr newFirst, NotificationChain msgs)
  {
    Expr oldFirst = first;
    first = newFirst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.CHOICE_EXPR__FIRST, oldFirst, newFirst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirst(Expr newFirst)
  {
    if (newFirst != first)
    {
      NotificationChain msgs = null;
      if (first != null)
        msgs = ((InternalEObject)first).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.CHOICE_EXPR__FIRST, null, msgs);
      if (newFirst != null)
        msgs = ((InternalEObject)newFirst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.CHOICE_EXPR__FIRST, null, msgs);
      msgs = basicSetFirst(newFirst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.CHOICE_EXPR__FIRST, newFirst, newFirst));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getSecond()
  {
    return second;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSecond(Expr newSecond, NotificationChain msgs)
  {
    Expr oldSecond = second;
    second = newSecond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.CHOICE_EXPR__SECOND, oldSecond, newSecond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSecond(Expr newSecond)
  {
    if (newSecond != second)
    {
      NotificationChain msgs = null;
      if (second != null)
        msgs = ((InternalEObject)second).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.CHOICE_EXPR__SECOND, null, msgs);
      if (newSecond != null)
        msgs = ((InternalEObject)newSecond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.CHOICE_EXPR__SECOND, null, msgs);
      msgs = basicSetSecond(newSecond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.CHOICE_EXPR__SECOND, newSecond, newSecond));
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
      case LimpPackage.CHOICE_EXPR__FIRST:
        return basicSetFirst(null, msgs);
      case LimpPackage.CHOICE_EXPR__SECOND:
        return basicSetSecond(null, msgs);
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
      case LimpPackage.CHOICE_EXPR__FIRST:
        return getFirst();
      case LimpPackage.CHOICE_EXPR__SECOND:
        return getSecond();
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
      case LimpPackage.CHOICE_EXPR__FIRST:
        setFirst((Expr)newValue);
        return;
      case LimpPackage.CHOICE_EXPR__SECOND:
        setSecond((Expr)newValue);
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
      case LimpPackage.CHOICE_EXPR__FIRST:
        setFirst((Expr)null);
        return;
      case LimpPackage.CHOICE_EXPR__SECOND:
        setSecond((Expr)null);
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
      case LimpPackage.CHOICE_EXPR__FIRST:
        return first != null;
      case LimpPackage.CHOICE_EXPR__SECOND:
        return second != null;
    }
    return super.eIsSet(featureID);
  }

} //ChoiceExprImpl
