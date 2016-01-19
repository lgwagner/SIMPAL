/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Id List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.IdList#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getIdList()
 * @model
 * @generated
 */
public interface IdList extends EObject
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.VariableRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getIdList_Ids()
   * @model
   * @generated
   */
  EList<VariableRef> getIds();

} // IdList
