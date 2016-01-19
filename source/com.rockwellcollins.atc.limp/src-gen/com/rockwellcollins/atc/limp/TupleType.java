/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.TupleType#getTypeList <em>Type List</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getTupleType()
 * @model
 * @generated
 */
public interface TupleType extends Type
{
  /**
   * Returns the value of the '<em><b>Type List</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type List</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getTupleType_TypeList()
   * @model containment="true"
   * @generated
   */
  EList<Type> getTypeList();

} // TupleType
