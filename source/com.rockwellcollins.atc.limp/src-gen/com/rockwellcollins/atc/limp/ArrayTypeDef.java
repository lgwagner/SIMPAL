/**
 */
package com.rockwellcollins.atc.limp;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.ArrayTypeDef#getBaseType <em>Base Type</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ArrayTypeDef#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getArrayTypeDef()
 * @model
 * @generated
 */
public interface ArrayTypeDef extends TypeDeclaration
{
  /**
   * Returns the value of the '<em><b>Base Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Type</em>' containment reference.
   * @see #setBaseType(Type)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getArrayTypeDef_BaseType()
   * @model containment="true"
   * @generated
   */
  Type getBaseType();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ArrayTypeDef#getBaseType <em>Base Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base Type</em>' containment reference.
   * @see #getBaseType()
   * @generated
   */
  void setBaseType(Type value);

  /**
   * Returns the value of the '<em><b>Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Size</em>' attribute.
   * @see #setSize(BigInteger)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getArrayTypeDef_Size()
   * @model
   * @generated
   */
  BigInteger getSize();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ArrayTypeDef#getSize <em>Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Size</em>' attribute.
   * @see #getSize()
   * @generated
   */
  void setSize(BigInteger value);

} // ArrayTypeDef
