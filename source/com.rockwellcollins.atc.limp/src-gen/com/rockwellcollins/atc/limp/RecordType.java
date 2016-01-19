/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordType#getRecordDef <em>Record Def</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordType()
 * @model
 * @generated
 */
public interface RecordType extends Type
{
  /**
   * Returns the value of the '<em><b>Record Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Def</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record Def</em>' reference.
   * @see #setRecordDef(RecordTypeDef)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordType_RecordDef()
   * @model
   * @generated
   */
  RecordTypeDef getRecordDef();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RecordType#getRecordDef <em>Record Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record Def</em>' reference.
   * @see #getRecordDef()
   * @generated
   */
  void setRecordDef(RecordTypeDef value);

} // RecordType
