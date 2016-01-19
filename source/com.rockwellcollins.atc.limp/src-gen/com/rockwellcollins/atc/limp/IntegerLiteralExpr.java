/**
 */
package com.rockwellcollins.atc.limp;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Literal Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.IntegerLiteralExpr#getIntVal <em>Int Val</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getIntegerLiteralExpr()
 * @model
 * @generated
 */
public interface IntegerLiteralExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Int Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Int Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Int Val</em>' attribute.
   * @see #setIntVal(BigInteger)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getIntegerLiteralExpr_IntVal()
   * @model
   * @generated
   */
  BigInteger getIntVal();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.IntegerLiteralExpr#getIntVal <em>Int Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Int Val</em>' attribute.
   * @see #getIntVal()
   * @generated
   */
  void setIntVal(BigInteger value);

} // IntegerLiteralExpr
