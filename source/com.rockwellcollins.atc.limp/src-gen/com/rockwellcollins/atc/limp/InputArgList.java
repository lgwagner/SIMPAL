/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Arg List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.InputArgList#getInputArgs <em>Input Args</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getInputArgList()
 * @model
 * @generated
 */
public interface InputArgList extends EObject
{
  /**
   * Returns the value of the '<em><b>Input Args</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.InputArg}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Args</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getInputArgList_InputArgs()
   * @model containment="true"
   * @generated
   */
  EList<InputArg> getInputArgs();

} // InputArgList
