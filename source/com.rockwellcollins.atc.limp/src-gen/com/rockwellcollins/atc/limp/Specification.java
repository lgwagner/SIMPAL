/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.Specification#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends EObject
{
  /**
   * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.Declaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarations</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getSpecification_Declarations()
   * @model containment="true"
   * @generated
   */
  EList<Declaration> getDeclarations();

} // Specification
