/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalFunction#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalFunction#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalFunction#getOutput <em>Output</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalFunction#getVarBlock <em>Var Block</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.LocalFunction#getEquationBlock <em>Equation Block</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalFunction()
 * @model
 * @generated
 */
public interface LocalFunction extends Declaration, FunctionRef
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalFunction_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalFunction#getName <em>Name</em>}' attribute.
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalFunction_Inputs()
   * @model containment="true"
   * @generated
   */
  InputArgList getInputs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalFunction#getInputs <em>Inputs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Inputs</em>' containment reference.
   * @see #getInputs()
   * @generated
   */
  void setInputs(InputArgList value);

  /**
   * Returns the value of the '<em><b>Output</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output</em>' containment reference.
   * @see #setOutput(OutputArg)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalFunction_Output()
   * @model containment="true"
   * @generated
   */
  OutputArg getOutput();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalFunction#getOutput <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output</em>' containment reference.
   * @see #getOutput()
   * @generated
   */
  void setOutput(OutputArg value);

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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalFunction_VarBlock()
   * @model containment="true"
   * @generated
   */
  VarBlock getVarBlock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalFunction#getVarBlock <em>Var Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Block</em>' containment reference.
   * @see #getVarBlock()
   * @generated
   */
  void setVarBlock(VarBlock value);

  /**
   * Returns the value of the '<em><b>Equation Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equation Block</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equation Block</em>' containment reference.
   * @see #setEquationBlock(EquationBlock)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getLocalFunction_EquationBlock()
   * @model containment="true"
   * @generated
   */
  EquationBlock getEquationBlock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.LocalFunction#getEquationBlock <em>Equation Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Equation Block</em>' containment reference.
   * @see #getEquationBlock()
   * @generated
   */
  void setEquationBlock(EquationBlock value);

} // LocalFunction
