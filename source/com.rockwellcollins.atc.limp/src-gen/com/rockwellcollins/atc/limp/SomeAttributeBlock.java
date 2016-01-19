/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Some Attribute Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.SomeAttributeBlock#getAttributeList <em>Attribute List</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getSomeAttributeBlock()
 * @model
 * @generated
 */
public interface SomeAttributeBlock extends AttributeBlock
{
  /**
   * Returns the value of the '<em><b>Attribute List</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attribute List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute List</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getSomeAttributeBlock_AttributeList()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributeList();

} // SomeAttributeBlock
