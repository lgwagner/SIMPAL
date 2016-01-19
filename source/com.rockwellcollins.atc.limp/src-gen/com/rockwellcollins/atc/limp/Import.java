/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.Import#getImportURI <em>Import URI</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getImport()
 * @model
 * @generated
 */
public interface Import extends Declaration
{
  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getImport_ImportURI()
   * @model
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.Import#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

} // Import
