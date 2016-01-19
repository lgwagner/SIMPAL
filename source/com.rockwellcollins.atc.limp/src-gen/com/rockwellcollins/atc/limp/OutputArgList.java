/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Arg List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.OutputArgList#getOutputArgs <em>Output Args</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getOutputArgList()
 * @model
 * @generated
 */
public interface OutputArgList extends EObject
{
  /**
   * Returns the value of the '<em><b>Output Args</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.OutputArg}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output Args</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getOutputArgList_OutputArgs()
   * @model containment="true"
   * @generated
   */
  EList<OutputArg> getOutputArgs();

} // OutputArgList
