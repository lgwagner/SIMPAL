/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.ArrayExpr#getArrayDefinition <em>Array Definition</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ArrayExpr#getExprList <em>Expr List</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getArrayExpr()
 * @model
 * @generated
 */
public interface ArrayExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Array Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array Definition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Definition</em>' reference.
   * @see #setArrayDefinition(ArrayTypeDef)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getArrayExpr_ArrayDefinition()
   * @model
   * @generated
   */
  ArrayTypeDef getArrayDefinition();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ArrayExpr#getArrayDefinition <em>Array Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array Definition</em>' reference.
   * @see #getArrayDefinition()
   * @generated
   */
  void setArrayDefinition(ArrayTypeDef value);

  /**
   * Returns the value of the '<em><b>Expr List</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.Expr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr List</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getArrayExpr_ExprList()
   * @model containment="true"
   * @generated
   */
  EList<Expr> getExprList();

} // ArrayExpr
