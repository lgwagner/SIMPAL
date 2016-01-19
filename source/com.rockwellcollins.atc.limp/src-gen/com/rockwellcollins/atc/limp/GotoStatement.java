/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goto Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.GotoStatement#getLabel <em>Label</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.GotoStatement#getWhenExpr <em>When Expr</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getGotoStatement()
 * @model
 * @generated
 */
public interface GotoStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Label</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' reference.
   * @see #setLabel(LabelStatement)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getGotoStatement_Label()
   * @model
   * @generated
   */
  LabelStatement getLabel();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.GotoStatement#getLabel <em>Label</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' reference.
   * @see #getLabel()
   * @generated
   */
  void setLabel(LabelStatement value);

  /**
   * Returns the value of the '<em><b>When Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>When Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>When Expr</em>' containment reference.
   * @see #setWhenExpr(Expr)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getGotoStatement_WhenExpr()
   * @model containment="true"
   * @generated
   */
  Expr getWhenExpr();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.GotoStatement#getWhenExpr <em>When Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When Expr</em>' containment reference.
   * @see #getWhenExpr()
   * @generated
   */
  void setWhenExpr(Expr value);

} // GotoStatement
