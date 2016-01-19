/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then Else Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getCond <em>Cond</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getThenBlock <em>Then Block</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getIfThenElseStatement()
 * @model
 * @generated
 */
public interface IfThenElseStatement extends Statement
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getIfThenElseStatement_Cond()
   * @model containment="true"
   * @generated
   */
  Expr getCond();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getCond <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond</em>' containment reference.
   * @see #getCond()
   * @generated
   */
  void setCond(Expr value);

  /**
   * Returns the value of the '<em><b>Then Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Block</em>' containment reference.
   * @see #setThenBlock(StatementBlock)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getIfThenElseStatement_ThenBlock()
   * @model containment="true"
   * @generated
   */
  StatementBlock getThenBlock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getThenBlock <em>Then Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Block</em>' containment reference.
   * @see #getThenBlock()
   * @generated
   */
  void setThenBlock(StatementBlock value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Else)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getIfThenElseStatement_Else()
   * @model containment="true"
   * @generated
   */
  Else getElse();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.IfThenElseStatement#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Else value);

} // IfThenElseStatement
