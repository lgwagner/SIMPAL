/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.NamedType#getAlias <em>Alias</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getNamedType()
 * @model
 * @generated
 */
public interface NamedType extends Type
{
  /**
   * Returns the value of the '<em><b>Alias</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alias</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alias</em>' reference.
   * @see #setAlias(TypeAlias)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getNamedType_Alias()
   * @model
   * @generated
   */
  TypeAlias getAlias();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.NamedType#getAlias <em>Alias</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alias</em>' reference.
   * @see #getAlias()
   * @generated
   */
  void setAlias(TypeAlias value);

} // NamedType
