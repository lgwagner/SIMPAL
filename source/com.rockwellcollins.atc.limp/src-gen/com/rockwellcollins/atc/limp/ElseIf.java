/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.ElseIf#getIfThenElse <em>If Then Else</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getElseIf()
 * @model
 * @generated
 */
public interface ElseIf extends Else
{
  /**
   * Returns the value of the '<em><b>If Then Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>If Then Else</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>If Then Else</em>' containment reference.
   * @see #setIfThenElse(IfThenElseStatement)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getElseIf_IfThenElse()
   * @model containment="true"
   * @generated
   */
  IfThenElseStatement getIfThenElse();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ElseIf#getIfThenElse <em>If Then Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If Then Else</em>' containment reference.
   * @see #getIfThenElse()
   * @generated
   */
  void setIfThenElse(IfThenElseStatement value);

} // ElseIf
