/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.ForStatement#getInitStatement <em>Init Statement</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ForStatement#getLimitExpr <em>Limit Expr</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ForStatement#getIncrementStatement <em>Increment Statement</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ForStatement#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Init Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Statement</em>' containment reference.
   * @see #setInitStatement(AssignmentStatement)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getForStatement_InitStatement()
   * @model containment="true"
   * @generated
   */
  AssignmentStatement getInitStatement();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ForStatement#getInitStatement <em>Init Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Statement</em>' containment reference.
   * @see #getInitStatement()
   * @generated
   */
  void setInitStatement(AssignmentStatement value);

  /**
   * Returns the value of the '<em><b>Limit Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Limit Expr</em>' containment reference.
   * @see #setLimitExpr(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getForStatement_LimitExpr()
   * @model containment="true"
   * @generated
   */
  Expr getLimitExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ForStatement#getLimitExpr <em>Limit Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Limit Expr</em>' containment reference.
   * @see #getLimitExpr()
   * @generated
   */
  void setLimitExpr(Expr value);

  /**
   * Returns the value of the '<em><b>Increment Statement</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Increment Statement</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Increment Statement</em>' containment reference.
   * @see #setIncrementStatement(AssignmentStatement)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getForStatement_IncrementStatement()
   * @model containment="true"
   * @generated
   */
  AssignmentStatement getIncrementStatement();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ForStatement#getIncrementStatement <em>Increment Statement</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Increment Statement</em>' containment reference.
   * @see #getIncrementStatement()
   * @generated
   */
  void setIncrementStatement(AssignmentStatement value);

  /**
   * Returns the value of the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Block</em>' containment reference.
   * @see #setBlock(StatementBlock)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getForStatement_Block()
   * @model containment="true"
   * @generated
   */
  StatementBlock getBlock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ForStatement#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(StatementBlock value);

} // ForStatement
