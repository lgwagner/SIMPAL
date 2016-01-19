/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.GlobalDeclaration#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getGlobalDeclaration()
 * @model
 * @generated
 */
public interface GlobalDeclaration extends Declaration, VariableRef
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(Type)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getGlobalDeclaration_Type()
   * @model containment="true"
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.GlobalDeclaration#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

} // GlobalDeclaration
