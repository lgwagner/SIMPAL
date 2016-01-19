/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Access Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordAccessExpr#getRecord <em>Record</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordAccessExpr#getField <em>Field</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordAccessExpr()
 * @model
 * @generated
 */
public interface RecordAccessExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record</em>' containment reference.
   * @see #setRecord(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordAccessExpr_Record()
   * @model containment="true"
   * @generated
   */
  Expr getRecord();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RecordAccessExpr#getRecord <em>Record</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record</em>' containment reference.
   * @see #getRecord()
   * @generated
   */
  void setRecord(Expr value);

  /**
   * Returns the value of the '<em><b>Field</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' attribute.
   * @see #setField(String)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordAccessExpr_Field()
   * @model
   * @generated
   */
  String getField();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RecordAccessExpr#getField <em>Field</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' attribute.
   * @see #getField()
   * @generated
   */
  void setField(String value);

} // RecordAccessExpr
