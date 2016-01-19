/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Field Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordFieldExpr#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordFieldExpr#getFieldExpr <em>Field Expr</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordFieldExpr()
 * @model
 * @generated
 */
public interface RecordFieldExpr extends EObject
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordFieldExpr_FieldName()
   * @model
   * @generated
   */
  String getFieldName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RecordFieldExpr#getFieldName <em>Field Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field Name</em>' attribute.
   * @see #getFieldName()
   * @generated
   */
  void setFieldName(String value);

  /**
   * Returns the value of the '<em><b>Field Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Expr</em>' containment reference.
   * @see #setFieldExpr(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordFieldExpr_FieldExpr()
   * @model containment="true"
   * @generated
   */
  Expr getFieldExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RecordFieldExpr#getFieldExpr <em>Field Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field Expr</em>' containment reference.
   * @see #getFieldExpr()
   * @generated
   */
  void setFieldExpr(Expr value);

} // RecordFieldExpr
