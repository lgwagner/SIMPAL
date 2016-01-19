/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Uses</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.Uses#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getUses()
 * @model
 * @generated
 */
public interface Uses extends Attribute
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.DefineUseRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getUses_Elements()
   * @model containment="true"
   * @generated
   */
  EList<DefineUseRef> getElements();

} // Uses
