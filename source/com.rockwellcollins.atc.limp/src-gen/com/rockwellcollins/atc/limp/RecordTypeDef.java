/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Type Def</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordTypeDef#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordTypeDef()
 * @model
 * @generated
 */
public interface RecordTypeDef extends TypeDeclaration
{
  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.RecordFieldType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordTypeDef_Fields()
   * @model containment="true"
   * @generated
   */
  EList<RecordFieldType> getFields();

} // RecordTypeDef
