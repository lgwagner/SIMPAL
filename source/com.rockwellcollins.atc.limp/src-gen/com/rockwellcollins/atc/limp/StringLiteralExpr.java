/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.StringLiteralExpr#getStringVal <em>String Val</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getStringLiteralExpr()
 * @model
 * @generated
 */
public interface StringLiteralExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>String Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String Val</em>' attribute.
   * @see #setStringVal(String)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getStringLiteralExpr_StringVal()
   * @model
   * @generated
   */
  String getStringVal();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.StringLiteralExpr#getStringVal <em>String Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String Val</em>' attribute.
   * @see #getStringVal()
   * @generated
   */
  void setStringVal(String value);

} // StringLiteralExpr
