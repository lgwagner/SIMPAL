/**
 */
package com.rockwellcollins.atc.limp;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.AbstractType#getAbstractDef <em>Abstract Def</em>}</li>
 * </ul>
 *
 * @see com.rockwellcollins.atc.limp.LimpPackage#getAbstractType()
 * @model
 * @generated
 */
public interface AbstractType extends Type
{
  /**
   * Returns the value of the '<em><b>Abstract Def</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract Def</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract Def</em>' reference.
   * @see #setAbstractDef(AbstractTypeDef)
   * @see com.rockwellcollins.atc.limp.LimpPackage#getAbstractType_AbstractDef()
   * @model
   * @generated
   */
  AbstractTypeDef getAbstractDef();

  /**
   * Sets the value of the '{@link com.rockwellcollins.atc.limp.AbstractType#getAbstractDef <em>Abstract Def</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract Def</em>' reference.
   * @see #getAbstractDef()
   * @generated
   */
  void setAbstractDef(AbstractTypeDef value);

} // AbstractType
