/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.ExternalFunction#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ExternalFunction#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ExternalFunction#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalFunction()
 * @model
 * @generated
 */
public interface ExternalFunction extends Declaration, FunctionRef
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalFunction_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ExternalFunction#getName <em>Name</em>}' attribute.
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalFunction_Inputs()
   * @model containment="true"
   * @generated
   */
  InputArgList getInputs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ExternalFunction#getInputs <em>Inputs</em>}' containment reference.
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalFunction_Output()
   * @model containment="true"
   * @generated
   */
  OutputArg getOutput();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ExternalFunction#getOutput <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output</em>' containment reference.
   * @see #getOutput()
   * @generated
   */
  void setOutput(OutputArg value);

} // ExternalFunction
