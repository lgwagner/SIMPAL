/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordTypeDef;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordExprImpl#getRecordDefinition <em>Record Definition</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.RecordExprImpl#getFieldExprList <em>Field Expr List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RecordExprImpl extends ExprImpl implements RecordExpr
{
  /**
   * The cached value of the '{@link #getRecordDefinition() <em>Record Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordDefinition()
   * @generated
   * @ordered
   */
  protected RecordTypeDef recordDefinition;

  /**
   * The cached value of the '{@link #getFieldExprList() <em>Field Expr List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFieldExprList()
   * @generated
   * @ordered
   */
  protected EList<RecordFieldExpr> fieldExprList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecordExprImpl()
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
    return LimpPackage.Literals.RECORD_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTypeDef getRecordDefinition()
  {
    if (recordDefinition != null && recordDefinition.eIsProxy())
    {
      InternalEObject oldRecordDefinition = (InternalEObject)recordDefinition;
      recordDefinition = (RecordTypeDef)eResolveProxy(oldRecordDefinition);
      if (recordDefinition != oldRecordDefinition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LimpPackage.RECORD_EXPR__RECORD_DEFINITION, oldRecordDefinition, recordDefinition));
      }
    }
    return recordDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTypeDef basicGetRecordDefinition()
  {
    return recordDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordDefinition(RecordTypeDef newRecordDefinition)
  {
    RecordTypeDef oldRecordDefinition = recordDefinition;
    recordDefinition = newRecordDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.RECORD_EXPR__RECORD_DEFINITION, oldRecordDefinition, recordDefinition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RecordFieldExpr> getFieldExprList()
  {
    if (fieldExprList == null)
    {
      fieldExprList = new EObjectContainmentEList<RecordFieldExpr>(RecordFieldExpr.class, this, LimpPackage.RECORD_EXPR__FIELD_EXPR_LIST);
    }
    return fieldExprList;
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
      case LimpPackage.RECORD_EXPR__FIELD_EXPR_LIST:
        return ((InternalEList<?>)getFieldExprList()).basicRemove(otherEnd, msgs);
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
      case LimpPackage.RECORD_EXPR__RECORD_DEFINITION:
        if (resolve) return getRecordDefinition();
        return basicGetRecordDefinition();
      case LimpPackage.RECORD_EXPR__FIELD_EXPR_LIST:
        return getFieldExprList();
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
      case LimpPackage.RECORD_EXPR__RECORD_DEFINITION:
        setRecordDefinition((RecordTypeDef)newValue);
        return;
      case LimpPackage.RECORD_EXPR__FIELD_EXPR_LIST:
        getFieldExprList().clear();
        getFieldExprList().addAll((Collection<? extends RecordFieldExpr>)newValue);
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
      case LimpPackage.RECORD_EXPR__RECORD_DEFINITION:
        setRecordDefinition((RecordTypeDef)null);
        return;
      case LimpPackage.RECORD_EXPR__FIELD_EXPR_LIST:
        getFieldExprList().clear();
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
      case LimpPackage.RECORD_EXPR__RECORD_DEFINITION:
        return recordDefinition != null;
      case LimpPackage.RECORD_EXPR__FIELD_EXPR_LIST:
        return fieldExprList != null && !fieldExprList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RecordExprImpl
