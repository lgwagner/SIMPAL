/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.ChoiceExpr#getFirst <em>First</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ChoiceExpr#getSecond <em>Second</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getChoiceExpr()
 * @model
 * @generated
 */
public interface ChoiceExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference.
   * @see #setFirst(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getChoiceExpr_First()
   * @model containment="true"
   * @generated
   */
  Expr getFirst();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ChoiceExpr#getFirst <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' containment reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(Expr value);

  /**
   * Returns the value of the '<em><b>Second</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Second</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Second</em>' containment reference.
   * @see #setSecond(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getChoiceExpr_Second()
   * @model containment="true"
   * @generated
   */
  Expr getSecond();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ChoiceExpr#getSecond <em>Second</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Second</em>' containment reference.
   * @see #getSecond()
   * @generated
   */
  void setSecond(Expr value);

} // ChoiceExpr
