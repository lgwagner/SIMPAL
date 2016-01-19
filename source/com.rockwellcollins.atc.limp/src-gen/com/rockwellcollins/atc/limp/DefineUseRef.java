/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Define Use Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.DefineUseRef#getReferenceExpr <em>Reference Expr</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getDefineUseRef()
 * @model
 * @generated
 */
public interface DefineUseRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Reference Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Expr</em>' containment reference.
   * @see #setReferenceExpr(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getDefineUseRef_ReferenceExpr()
   * @model containment="true"
   * @generated
   */
  Expr getReferenceExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.DefineUseRef#getReferenceExpr <em>Reference Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Expr</em>' containment reference.
   * @see #getReferenceExpr()
   * @generated
   */
  void setReferenceExpr(Expr value);

} // DefineUseRef
