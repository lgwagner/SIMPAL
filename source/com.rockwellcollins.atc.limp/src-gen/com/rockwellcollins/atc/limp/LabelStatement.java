/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.LabelStatement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getLabelStatement()
 * @model
 * @generated
 */
public interface LabelStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLabelStatement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LabelStatement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // LabelStatement
