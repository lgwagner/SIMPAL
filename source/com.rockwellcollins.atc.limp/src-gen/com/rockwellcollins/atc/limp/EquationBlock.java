/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.EquationBlock#getEquations <em>Equations</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getEquationBlock()
 * @model
 * @generated
 */
public interface EquationBlock extends EObject
{
  /**
   * Returns the value of the '<em><b>Equations</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.Equation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equations</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getEquationBlock_Equations()
   * @model containment="true"
   * @generated
   */
  EList<Equation> getEquations();

} // EquationBlock
