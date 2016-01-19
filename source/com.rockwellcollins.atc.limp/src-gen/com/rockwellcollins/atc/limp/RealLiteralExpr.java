/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Literal Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.RealLiteralExpr#getRealVal <em>Real Val</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getRealLiteralExpr()
 * @model
 * @generated
 */
public interface RealLiteralExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Real Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Real Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Real Val</em>' attribute.
   * @see #setRealVal(String)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRealLiteralExpr_RealVal()
   * @model
   * @generated
   */
  String getRealVal();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RealLiteralExpr#getRealVal <em>Real Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Real Val</em>' attribute.
   * @see #getRealVal()
   * @generated
   */
  void setRealVal(String value);

} // RealLiteralExpr
