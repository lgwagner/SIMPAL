/**
 */
package com.rockwellcollins.atc.limp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Some Var Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.SomeVarBlock#getLocals <em>Locals</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getSomeVarBlock()
 * @model
 * @generated
 */
public interface SomeVarBlock extends VarBlock
{
  /**
   * Returns the value of the '<em><b>Locals</b></em>' containment reference list.
   * The list contents are of type {@link com.rockwellcollins.atc.limp.LocalArg}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Locals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Locals</em>' containment reference list.
   * @see com.rockwellcollins.atc.limp.LimpPackage#getSomeVarBlock_Locals()
   * @model containment="true"
   * @generated
   */
  EList<LocalArg> getLocals();

} // SomeVarBlock
