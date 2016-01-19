/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fcn Call Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.FcnCallExpr#getId <em>Id</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.FcnCallExpr#getExprs <em>Exprs</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getFcnCallExpr()
 * @model
 * @generated
 */
public interface FcnCallExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' reference.
   * @see #setId(FunctionRef)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getFcnCallExpr_Id()
   * @model
   * @generated
   */
  FunctionRef getId();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.FcnCallExpr#getId <em>Id</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' reference.
   * @see #getId()
   * @generated
   */
  void setId(FunctionRef value);

  /**
   * Returns the value of the '<em><b>Exprs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exprs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exprs</em>' containment reference.
   * @see #setExprs(ExprList)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getFcnCallExpr_Exprs()
   * @model containment="true"
   * @generated
   */
  ExprList getExprs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.FcnCallExpr#getExprs <em>Exprs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exprs</em>' containment reference.
   * @see #getExprs()
   * @generated
   */
  void setExprs(ExprList value);

} // FcnCallExpr
