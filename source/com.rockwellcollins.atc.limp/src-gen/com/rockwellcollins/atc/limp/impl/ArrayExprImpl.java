/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayTypeDef;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.LimpPackage;

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
 * An implementation of the model object '<em><b>Array Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ArrayExprImpl#getArrayDefinition <em>Array Definition</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ArrayExprImpl#getExprList <em>Expr List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArrayExprImpl extends ExprImpl implements ArrayExpr
{
  /**
   * The cached value of the '{@link #getArrayDefinition() <em>Array Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArrayDefinition()
   * @generated
   * @ordered
   */
  protected ArrayTypeDef arrayDefinition;

  /**
   * The cached value of the '{@link #getExprList() <em>Expr List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExprList()
   * @generated
   * @ordered
   */
  protected EList<Expr> exprList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArrayExprImpl()
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
    return LimpPackage.Literals.ARRAY_EXPR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayTypeDef getArrayDefinition()
  {
    if (arrayDefinition != null && arrayDefinition.eIsProxy())
    {
      InternalEObject oldArrayDefinition = (InternalEObject)arrayDefinition;
      arrayDefinition = (ArrayTypeDef)eResolveProxy(oldArrayDefinition);
      if (arrayDefinition != oldArrayDefinition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, LimpPackage.ARRAY_EXPR__ARRAY_DEFINITION, oldArrayDefinition, arrayDefinition));
      }
    }
    return arrayDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayTypeDef basicGetArrayDefinition()
  {
    return arrayDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setArrayDefinition(ArrayTypeDef newArrayDefinition)
  {
    ArrayTypeDef oldArrayDefinition = arrayDefinition;
    arrayDefinition = newArrayDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.ARRAY_EXPR__ARRAY_DEFINITION, oldArrayDefinition, arrayDefinition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expr> getExprList()
  {
    if (exprList == null)
    {
      exprList = new EObjectContainmentEList<Expr>(Expr.class, this, LimpPackage.ARRAY_EXPR__EXPR_LIST);
    }
    return exprList;
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
      case LimpPackage.ARRAY_EXPR__EXPR_LIST:
        return ((InternalEList<?>)getExprList()).basicRemove(otherEnd, msgs);
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
      case LimpPackage.ARRAY_EXPR__ARRAY_DEFINITION:
        if (resolve) return getArrayDefinition();
        return basicGetArrayDefinition();
      case LimpPackage.ARRAY_EXPR__EXPR_LIST:
        return getExprList();
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
      case LimpPackage.ARRAY_EXPR__ARRAY_DEFINITION:
        setArrayDefinition((ArrayTypeDef)newValue);
        return;
      case LimpPackage.ARRAY_EXPR__EXPR_LIST:
        getExprList().clear();
        getExprList().addAll((Collection<? extends Expr>)newValue);
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
      case LimpPackage.ARRAY_EXPR__ARRAY_DEFINITION:
        setArrayDefinition((ArrayTypeDef)null);
        return;
      case LimpPackage.ARRAY_EXPR__EXPR_LIST:
        getExprList().clear();
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
      case LimpPackage.ARRAY_EXPR__ARRAY_DEFINITION:
        return arrayDefinition != null;
      case LimpPackage.ARRAY_EXPR__EXPR_LIST:
        return exprList != null && !exprList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ArrayExprImpl
