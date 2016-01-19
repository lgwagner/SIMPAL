/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalProcedure#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalProcedure#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalProcedure#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalProcedure#getVarBlock <em>Var Block</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalProcedure#getAttributeBlock <em>Attribute Block</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalProcedure#getStatementblock <em>Statementblock</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalProcedure()
 * @model
 * @generated
 */
public interface LocalProcedure extends Declaration, FunctionRef
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalProcedure_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalProcedure#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference.
   * @see #setInputs(InputArgList)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalProcedure_Inputs()
   * @model containment="true"
   * @generated
   */
  InputArgList getInputs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalProcedure#getInputs <em>Inputs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inputs</em>' containment reference.
   * @see #getInputs()
   * @generated
   */
  void setInputs(InputArgList value);

  /**
   * Returns the value of the '<em><b>Outputs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outputs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outputs</em>' containment reference.
   * @see #setOutputs(OutputArgList)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalProcedure_Outputs()
   * @model containment="true"
   * @generated
   */
  OutputArgList getOutputs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalProcedure#getOutputs <em>Outputs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outputs</em>' containment reference.
   * @see #getOutputs()
   * @generated
   */
  void setOutputs(OutputArgList value);

  /**
   * Returns the value of the '<em><b>Var Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Block</em>' containment reference.
   * @see #setVarBlock(VarBlock)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalProcedure_VarBlock()
   * @model containment="true"
   * @generated
   */
  VarBlock getVarBlock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalProcedure#getVarBlock <em>Var Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Block</em>' containment reference.
   * @see #getVarBlock()
   * @generated
   */
  void setVarBlock(VarBlock value);

  /**
   * Returns the value of the '<em><b>Attribute Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute Block</em>' containment reference.
   * @see #setAttributeBlock(AttributeBlock)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalProcedure_AttributeBlock()
   * @model containment="true"
   * @generated
   */
  AttributeBlock getAttributeBlock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalProcedure#getAttributeBlock <em>Attribute Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Block</em>' containment reference.
   * @see #getAttributeBlock()
   * @generated
   */
  void setAttributeBlock(AttributeBlock value);

  /**
   * Returns the value of the '<em><b>Statementblock</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statementblock</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statementblock</em>' containment reference.
   * @see #setStatementblock(StatementBlock)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalProcedure_Statementblock()
   * @model containment="true"
   * @generated
   */
  StatementBlock getStatementblock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalProcedure#getStatementblock <em>Statementblock</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Statementblock</em>' containment reference.
   * @see #getStatementblock()
   * @generated
   */
  void setStatementblock(StatementBlock value);

} // LocalProcedure
