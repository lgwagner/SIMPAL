/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordExpr#getRecordDefinition <em>Record Definition</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.RecordExpr#getFieldExprList <em>Field Expr List</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordExpr()
 * @model
 * @generated
 */
public interface RecordExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Record Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Definition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record Definition</em>' reference.
   * @see #setRecordDefinition(RecordTypeDef)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordExpr_RecordDefinition()
   * @model
   * @generated
   */
  RecordTypeDef getRecordDefinition();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.RecordExpr#getRecordDefinition <em>Record Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record Definition</em>' reference.
   * @see #getRecordDefinition()
   * @generated
   */
  void setRecordDefinition(RecordTypeDef value);

  /**
   * Returns the value of the '<em><b>Field Expr List</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.RecordFieldExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Expr List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field Expr List</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getRecordExpr_FieldExprList()
   * @model containment="true"
   * @generated
   */
  EList<RecordFieldExpr> getFieldExprList();

} // RecordExpr
