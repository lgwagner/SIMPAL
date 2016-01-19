/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Field Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordFieldType#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordFieldType#getFieldType <em>Field Type</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordFieldType()
 * @model
 * @generated
 */
public interface RecordFieldType extends EObject
{
  /**
   * Returns the value of the '<em><b>Field Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Name</em>' attribute.
   * @see #setFieldName(String)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordFieldType_FieldName()
   * @model
   * @generated
   */
  String getFieldName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RecordFieldType#getFieldName <em>Field Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field Name</em>' attribute.
   * @see #getFieldName()
   * @generated
   */
  void setFieldName(String value);

  /**
   * Returns the value of the '<em><b>Field Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Type</em>' containment reference.
   * @see #setFieldType(Type)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordFieldType_FieldType()
   * @model containment="true"
   * @generated
   */
  Type getFieldType();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RecordFieldType#getFieldType <em>Field Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field Type</em>' containment reference.
   * @see #getFieldType()
   * @generated
   */
  void setFieldType(Type value);

} // RecordFieldType
