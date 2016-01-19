/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.WhileStatement#getCond <em>Cond</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.WhileStatement#getBlock <em>Block</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getWhileStatement()
 * @model
 * @generated
 */
public interface WhileStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cond</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond</em>' containment reference.
   * @see #setCond(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getWhileStatement_Cond()
   * @model containment="true"
   * @generated
   */
  Expr getCond();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.WhileStatement#getCond <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond</em>' containment reference.
   * @see #getCond()
   * @generated
   */
  void setCond(Expr value);

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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getWhileStatement_Block()
   * @model containment="true"
   * @generated
   */
  StatementBlock getBlock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.WhileStatement#getBlock <em>Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Block</em>' containment reference.
   * @see #getBlock()
   * @generated
   */
  void setBlock(StatementBlock value);

} // WhileStatement
