/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.ForStatement;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.StatementBlock;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ForStatementImpl#getInitStatement <em>Init Statement</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ForStatementImpl#getLimitExpr <em>Limit Expr</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ForStatementImpl#getIncrementStatement <em>Increment Statement</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.ForStatementImpl#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForStatementImpl extends StatementImpl implements ForStatement
{
  /**
   * The cached value of the '{@link #getInitStatement() <em>Init Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitStatement()
   * @generated
   * @ordered
   */
  protected AssignmentStatement initStatement;

  /**
   * The cached value of the '{@link #getLimitExpr() <em>Limit Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimitExpr()
   * @generated
   * @ordered
   */
  protected Expr limitExpr;

  /**
   * The cached value of the '{@link #getIncrementStatement() <em>Increment Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncrementStatement()
   * @generated
   * @ordered
   */
  protected AssignmentStatement incrementStatement;

  /**
   * The cached value of the '{@link #getBlock() <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBlock()
   * @generated
   * @ordered
   */
  protected StatementBlock block;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForStatementImpl()
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
    return LimpPackage.Literals.FOR_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentStatement getInitStatement()
  {
    return initStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitStatement(AssignmentStatement newInitStatement, NotificationChain msgs)
  {
    AssignmentStatement oldInitStatement = initStatement;
    initStatement = newInitStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.FOR_STATEMENT__INIT_STATEMENT, oldInitStatement, newInitStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitStatement(AssignmentStatement newInitStatement)
  {
    if (newInitStatement != initStatement)
    {
      NotificationChain msgs = null;
      if (initStatement != null)
        msgs = ((InternalEObject)initStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FOR_STATEMENT__INIT_STATEMENT, null, msgs);
      if (newInitStatement != null)
        msgs = ((InternalEObject)newInitStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FOR_STATEMENT__INIT_STATEMENT, null, msgs);
      msgs = basicSetInitStatement(newInitStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.FOR_STATEMENT__INIT_STATEMENT, newInitStatement, newInitStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr getLimitExpr()
  {
    return limitExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLimitExpr(Expr newLimitExpr, NotificationChain msgs)
  {
    Expr oldLimitExpr = limitExpr;
    limitExpr = newLimitExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.FOR_STATEMENT__LIMIT_EXPR, oldLimitExpr, newLimitExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLimitExpr(Expr newLimitExpr)
  {
    if (newLimitExpr != limitExpr)
    {
      NotificationChain msgs = null;
      if (limitExpr != null)
        msgs = ((InternalEObject)limitExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FOR_STATEMENT__LIMIT_EXPR, null, msgs);
      if (newLimitExpr != null)
        msgs = ((InternalEObject)newLimitExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FOR_STATEMENT__LIMIT_EXPR, null, msgs);
      msgs = basicSetLimitExpr(newLimitExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.FOR_STATEMENT__LIMIT_EXPR, newLimitExpr, newLimitExpr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentStatement getIncrementStatement()
  {
    return incrementStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIncrementStatement(AssignmentStatement newIncrementStatement, NotificationChain msgs)
  {
    AssignmentStatement oldIncrementStatement = incrementStatement;
    incrementStatement = newIncrementStatement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT, oldIncrementStatement, newIncrementStatement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIncrementStatement(AssignmentStatement newIncrementStatement)
  {
    if (newIncrementStatement != incrementStatement)
    {
      NotificationChain msgs = null;
      if (incrementStatement != null)
        msgs = ((InternalEObject)incrementStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT, null, msgs);
      if (newIncrementStatement != null)
        msgs = ((InternalEObject)newIncrementStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT, null, msgs);
      msgs = basicSetIncrementStatement(newIncrementStatement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT, newIncrementStatement, newIncrementStatement));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementBlock getBlock()
  {
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBlock(StatementBlock newBlock, NotificationChain msgs)
  {
    StatementBlock oldBlock = block;
    block = newBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.FOR_STATEMENT__BLOCK, oldBlock, newBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBlock(StatementBlock newBlock)
  {
    if (newBlock != block)
    {
      NotificationChain msgs = null;
      if (block != null)
        msgs = ((InternalEObject)block).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FOR_STATEMENT__BLOCK, null, msgs);
      if (newBlock != null)
        msgs = ((InternalEObject)newBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.FOR_STATEMENT__BLOCK, null, msgs);
      msgs = basicSetBlock(newBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.FOR_STATEMENT__BLOCK, newBlock, newBlock));
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
      case LimpPackage.FOR_STATEMENT__INIT_STATEMENT:
        return basicSetInitStatement(null, msgs);
      case LimpPackage.FOR_STATEMENT__LIMIT_EXPR:
        return basicSetLimitExpr(null, msgs);
      case LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT:
        return basicSetIncrementStatement(null, msgs);
      case LimpPackage.FOR_STATEMENT__BLOCK:
        return basicSetBlock(null, msgs);
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
      case LimpPackage.FOR_STATEMENT__INIT_STATEMENT:
        return getInitStatement();
      case LimpPackage.FOR_STATEMENT__LIMIT_EXPR:
        return getLimitExpr();
      case LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT:
        return getIncrementStatement();
      case LimpPackage.FOR_STATEMENT__BLOCK:
        return getBlock();
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
      case LimpPackage.FOR_STATEMENT__INIT_STATEMENT:
        setInitStatement((AssignmentStatement)newValue);
        return;
      case LimpPackage.FOR_STATEMENT__LIMIT_EXPR:
        setLimitExpr((Expr)newValue);
        return;
      case LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT:
        setIncrementStatement((AssignmentStatement)newValue);
        return;
      case LimpPackage.FOR_STATEMENT__BLOCK:
        setBlock((StatementBlock)newValue);
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
      case LimpPackage.FOR_STATEMENT__INIT_STATEMENT:
        setInitStatement((AssignmentStatement)null);
        return;
      case LimpPackage.FOR_STATEMENT__LIMIT_EXPR:
        setLimitExpr((Expr)null);
        return;
      case LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT:
        setIncrementStatement((AssignmentStatement)null);
        return;
      case LimpPackage.FOR_STATEMENT__BLOCK:
        setBlock((StatementBlock)null);
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
      case LimpPackage.FOR_STATEMENT__INIT_STATEMENT:
        return initStatement != null;
      case LimpPackage.FOR_STATEMENT__LIMIT_EXPR:
        return limitExpr != null;
      case LimpPackage.FOR_STATEMENT__INCREMENT_STATEMENT:
        return incrementStatement != null;
      case LimpPackage.FOR_STATEMENT__BLOCK:
        return block != null;
    }
    return super.eIsSet(featureID);
  }

} //ForStatementImpl
