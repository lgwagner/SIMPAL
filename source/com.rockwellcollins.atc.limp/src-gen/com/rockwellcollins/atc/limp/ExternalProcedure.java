/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.ExternalProcedure#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ExternalProcedure#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ExternalProcedure#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.ExternalProcedure#getAttributeBlock <em>Attribute Block</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalProcedure()
 * @model
 * @generated
 */
public interface ExternalProcedure extends Declaration, FunctionRef
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalProcedure_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ExternalProcedure#getName <em>Name</em>}' attribute.
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalProcedure_Inputs()
   * @model containment="true"
   * @generated
   */
  InputArgList getInputs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ExternalProcedure#getInputs <em>Inputs</em>}' containment reference.
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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalProcedure_Outputs()
   * @model containment="true"
   * @generated
   */
  OutputArgList getOutputs();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ExternalProcedure#getOutputs <em>Outputs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Outputs</em>' containment reference.
   * @see #getOutputs()
   * @generated
   */
  void setOutputs(OutputArgList value);

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
   * @see com.rockwellcollins.atc.limp.LimpPackage#getExternalProcedure_AttributeBlock()
   * @model containment="true"
   * @generated
   */
  AttributeBlock getAttributeBlock();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.ExternalProcedure#getAttributeBlock <em>Attribute Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Attribute Block</em>' containment reference.
   * @see #getAttributeBlock()
   * @generated
   */
  void setAttributeBlock(AttributeBlock value);

} // ExternalProcedure
