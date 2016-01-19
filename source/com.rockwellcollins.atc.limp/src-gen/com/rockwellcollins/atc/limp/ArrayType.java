/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.ArrayType#getArrayDef <em>Array Def</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getArrayType()
 * @model
 * @generated
 */
public interface ArrayType extends Type
{
  /**
   * Returns the value of the '<em><b>Array Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Array Def</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Array Def</em>' reference.
   * @see #setArrayDef(ArrayTypeDef)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getArrayType_ArrayDef()
   * @model
   * @generated
   */
  ArrayTypeDef getArrayDef();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ArrayType#getArrayDef <em>Array Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Array Def</em>' reference.
   * @see #getArrayDef()
   * @generated
   */
  void setArrayDef(ArrayTypeDef value);

} // ArrayType
