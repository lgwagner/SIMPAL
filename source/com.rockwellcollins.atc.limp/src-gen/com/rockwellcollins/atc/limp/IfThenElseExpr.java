/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then Else Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getCondExpr <em>Cond Expr</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getThenExpr <em>Then Expr</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getElseExpr <em>Else Expr</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getIfThenElseExpr()
 * @model
 * @generated
 */
public interface IfThenElseExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Cond Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cond Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond Expr</em>' containment reference.
   * @see #setCondExpr(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getIfThenElseExpr_CondExpr()
   * @model containment="true"
   * @generated
   */
  Expr getCondExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getCondExpr <em>Cond Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond Expr</em>' containment reference.
   * @see #getCondExpr()
   * @generated
   */
  void setCondExpr(Expr value);

  /**
   * Returns the value of the '<em><b>Then Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Expr</em>' containment reference.
   * @see #setThenExpr(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getIfThenElseExpr_ThenExpr()
   * @model containment="true"
   * @generated
   */
  Expr getThenExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getThenExpr <em>Then Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Expr</em>' containment reference.
   * @see #getThenExpr()
   * @generated
   */
  void setThenExpr(Expr value);

  /**
   * Returns the value of the '<em><b>Else Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Expr</em>' containment reference.
   * @see #setElseExpr(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getIfThenElseExpr_ElseExpr()
   * @model containment="true"
   * @generated
   */
  Expr getElseExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.IfThenElseExpr#getElseExpr <em>Else Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Expr</em>' containment reference.
   * @see #getElseExpr()
   * @generated
   */
  void setElseExpr(Expr value);

} // IfThenElseExpr
