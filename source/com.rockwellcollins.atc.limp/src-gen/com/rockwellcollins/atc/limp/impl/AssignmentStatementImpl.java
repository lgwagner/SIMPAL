/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.LimpPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.AssignmentStatementImpl#getIds <em>Ids</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.AssignmentStatementImpl#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentStatementImpl extends StatementImpl implements AssignmentStatement
{
  /**
   * The cached value of the '{@link #getIds() <em>Ids</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIds()
   * @generated
   * @ordered
   */
  protected IdList ids;

  /**
   * The cached value of the '{@link #getRhs() <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRhs()
   * @generated
   * @ordered
   */
  protected Expr rhs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignmentStatementImpl()
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
    return LimpPackage.Literals.ASSIGNMENT_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdList getIds()
  {
    return ids;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIds(IdList newIds, NotificationChain msgs)
  {
    IdList oldIds = ids;
    ids = newIds;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.ASSIGNMENT_STATEMENT__IDS, oldIds, newIds);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIds(IdList newIds)
  {
    if (newIds != ids)
    {
      NotificationChain msgs = null;
      if (ids != null)
        msgs = ((InternalEObject)ids).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.ASSIGNMENT_STATEMENT__IDS, null, msgs);
      if (newIds != null)
        msgs = ((InternalEObject)newIds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.ASSIGNMENT_STATEMENT__IDS, null, msgs);
      msgs = basicSetIds(newIds, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.ASSIGNMENT_STATEMENT__IDS, newIds, newIds));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getRhs()
  {
    return rhs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs)
  {
    Expr oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.ASSIGNMENT_STATEMENT__RHS, oldRhs, newRhs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRhs(Expr newRhs)
  {
    if (newRhs != rhs)
    {
      NotificationChain msgs = null;
      if (rhs != null)
        msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.ASSIGNMENT_STATEMENT__RHS, null, msgs);
      if (newRhs != null)
        msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.ASSIGNMENT_STATEMENT__RHS, null, msgs);
      msgs = basicSetRhs(newRhs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.ASSIGNMENT_STATEMENT__RHS, newRhs, newRhs));
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
      case LimpPackage.ASSIGNMENT_STATEMENT__IDS:
        return basicSetIds(null, msgs);
      case LimpPackage.ASSIGNMENT_STATEMENT__RHS:
        return basicSetRhs(null, msgs);
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
      case LimpPackage.ASSIGNMENT_STATEMENT__IDS:
        return getIds();
      case LimpPackage.ASSIGNMENT_STATEMENT__RHS:
        return getRhs();
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
      case LimpPackage.ASSIGNMENT_STATEMENT__IDS:
        setIds((IdList)newValue);
        return;
      case LimpPackage.ASSIGNMENT_STATEMENT__RHS:
        setRhs((Expr)newValue);
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
      case LimpPackage.ASSIGNMENT_STATEMENT__IDS:
        setIds((IdList)null);
        return;
      case LimpPackage.ASSIGNMENT_STATEMENT__RHS:
        setRhs((Expr)null);
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
      case LimpPackage.ASSIGNMENT_STATEMENT__IDS:
        return ids != null;
      case LimpPackage.ASSIGNMENT_STATEMENT__RHS:
        return rhs != null;
    }
    return super.eIsSet(featureID);
  }

} //AssignmentStatementImpl
