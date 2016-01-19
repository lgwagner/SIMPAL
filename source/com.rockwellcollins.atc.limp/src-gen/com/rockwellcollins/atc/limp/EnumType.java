/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.EnumType#getEnumDef <em>Enum Def</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getEnumType()
 * @model
 * @generated
 */
public interface EnumType extends Type
{
  /**
   * Returns the value of the '<em><b>Enum Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum Def</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Def</em>' reference.
   * @see #setEnumDef(EnumTypeDef)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getEnumType_EnumDef()
   * @model
   * @generated
   */
  EnumTypeDef getEnumDef();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.EnumType#getEnumDef <em>Enum Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum Def</em>' reference.
   * @see #getEnumDef()
   * @generated
   */
  void setEnumDef(EnumTypeDef value);

} // EnumType
