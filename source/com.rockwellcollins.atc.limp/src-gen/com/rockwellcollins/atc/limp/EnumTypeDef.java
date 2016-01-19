/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Type Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.EnumTypeDef#getEnumerations <em>Enumerations</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getEnumTypeDef()
 * @model
 * @generated
 */
public interface EnumTypeDef extends TypeDeclaration
{
  /**
   * Returns the value of the '<em><b>Enumerations</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.EnumValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enumerations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enumerations</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getEnumTypeDef_Enumerations()
   * @model containment="true"
   * @generated
   */
  EList<EnumValue> getEnumerations();

} // EnumTypeDef
