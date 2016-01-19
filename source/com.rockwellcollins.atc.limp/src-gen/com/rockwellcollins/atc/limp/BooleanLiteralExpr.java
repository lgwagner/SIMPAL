/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.BooleanLiteralExpr#getBoolVal <em>Bool Val</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getBooleanLiteralExpr()
 * @model
 * @generated
 */
public interface BooleanLiteralExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Bool Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bool Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bool Val</em>' attribute.
   * @see #setBoolVal(String)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getBooleanLiteralExpr_BoolVal()
   * @model
   * @generated
   */
  String getBoolVal();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.BooleanLiteralExpr#getBoolVal <em>Bool Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bool Val</em>' attribute.
   * @see #getBoolVal()
   * @generated
   */
  void setBoolVal(String value);

} // BooleanLiteralExpr
