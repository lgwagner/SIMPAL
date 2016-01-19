/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.AssignmentStatement#getIds <em>Ids</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.AssignmentStatement#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getAssignmentStatement()
 * @model
 * @generated
 */
public interface AssignmentStatement extends Statement, Equation
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' containment reference.
   * @see #setIds(IdList)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getAssignmentStatement_Ids()
   * @model containment="true"
   * @generated
   */
  IdList getIds();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.AssignmentStatement#getIds <em>Ids</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ids</em>' containment reference.
   * @see #getIds()
   * @generated
   */
  void setIds(IdList value);

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getAssignmentStatement_Rhs()
   * @model containment="true"
   * @generated
   */
  Expr getRhs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.AssignmentStatement#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(Expr value);

} // AssignmentStatement
