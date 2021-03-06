/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.AttributeBlock;
import com.rockwellcollins.atc.limp.InputArgList;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.OutputArgList;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.VarBlock;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalProcedureImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalProcedureImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalProcedureImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalProcedureImpl#getVarBlock <em>Var Block</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalProcedureImpl#getAttributeBlock <em>Attribute Block</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalProcedureImpl#getStatementblock <em>Statementblock</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LocalProcedureImpl extends DeclarationImpl implements LocalProcedure
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInputs()
   * @generated
   * @ordered
   */
  protected InputArgList inputs;

  /**
   * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputs()
   * @generated
   * @ordered
   */
  protected OutputArgList outputs;

  /**
   * The cached value of the '{@link #getVarBlock() <em>Var Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarBlock()
   * @generated
   * @ordered
   */
  protected VarBlock varBlock;

  /**
   * The cached value of the '{@link #getAttributeBlock() <em>Attribute Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAttributeBlock()
   * @generated
   * @ordered
   */
  protected AttributeBlock attributeBlock;

  /**
   * The cached value of the '{@link #getStatementblock() <em>Statementblock</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatementblock()
   * @generated
   * @ordered
   */
  protected StatementBlock statementblock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LocalProcedureImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return LimpPackage.Literals.LOCAL_PROCEDURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputArgList getInputs()
  {
    return inputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInputs(InputArgList newInputs, NotificationChain msgs)
  {
    InputArgList oldInputs = inputs;
    inputs = newInputs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__INPUTS, oldInputs, newInputs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInputs(InputArgList newInputs)
  {
    if (newInputs != inputs)
    {
      NotificationChain msgs = null;
      if (inputs != null)
        msgs = ((InternalEObject)inputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__INPUTS, null, msgs);
      if (newInputs != null)
        msgs = ((InternalEObject)newInputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__INPUTS, null, msgs);
      msgs = basicSetInputs(newInputs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__INPUTS, newInputs, newInputs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputArgList getOutputs()
  {
    return outputs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutputs(OutputArgList newOutputs, NotificationChain msgs)
  {
    OutputArgList oldOutputs = outputs;
    outputs = newOutputs;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__OUTPUTS, oldOutputs, newOutputs);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutputs(OutputArgList newOutputs)
  {
    if (newOutputs != outputs)
    {
      NotificationChain msgs = null;
      if (outputs != null)
        msgs = ((InternalEObject)outputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__OUTPUTS, null, msgs);
      if (newOutputs != null)
        msgs = ((InternalEObject)newOutputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__OUTPUTS, null, msgs);
      msgs = basicSetOutputs(newOutputs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__OUTPUTS, newOutputs, newOutputs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarBlock getVarBlock()
  {
    return varBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVarBlock(VarBlock newVarBlock, NotificationChain msgs)
  {
    VarBlock oldVarBlock = varBlock;
    varBlock = newVarBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK, oldVarBlock, newVarBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVarBlock(VarBlock newVarBlock)
  {
    if (newVarBlock != varBlock)
    {
      NotificationChain msgs = null;
      if (varBlock != null)
        msgs = ((InternalEObject)varBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK, null, msgs);
      if (newVarBlock != null)
        msgs = ((InternalEObject)newVarBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK, null, msgs);
      msgs = basicSetVarBlock(newVarBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK, newVarBlock, newVarBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeBlock getAttributeBlock()
  {
    return attributeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAttributeBlock(AttributeBlock newAttributeBlock, NotificationChain msgs)
  {
    AttributeBlock oldAttributeBlock = attributeBlock;
    attributeBlock = newAttributeBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK, oldAttributeBlock, newAttributeBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAttributeBlock(AttributeBlock newAttributeBlock)
  {
    if (newAttributeBlock != attributeBlock)
    {
      NotificationChain msgs = null;
      if (attributeBlock != null)
        msgs = ((InternalEObject)attributeBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK, null, msgs);
      if (newAttributeBlock != null)
        msgs = ((InternalEObject)newAttributeBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK, null, msgs);
      msgs = basicSetAttributeBlock(newAttributeBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK, newAttributeBlock, newAttributeBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementBlock getStatementblock()
  {
    return statementblock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatementblock(StatementBlock newStatementblock, NotificationChain msgs)
  {
    StatementBlock oldStatementblock = statementblock;
    statementblock = newStatementblock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK, oldStatementblock, newStatementblock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatementblock(StatementBlock newStatementblock)
  {
    if (newStatementblock != statementblock)
    {
      NotificationChain msgs = null;
      if (statementblock != null)
        msgs = ((InternalEObject)statementblock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK, null, msgs);
      if (newStatementblock != null)
        msgs = ((InternalEObject)newStatementblock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK, null, msgs);
      msgs = basicSetStatementblock(newStatementblock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK, newStatementblock, newStatementblock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case LimpPackage.LOCAL_PROCEDURE__INPUTS:
        return basicSetInputs(null, msgs);
      case LimpPackage.LOCAL_PROCEDURE__OUTPUTS:
        return basicSetOutputs(null, msgs);
      case LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK:
        return basicSetVarBlock(null, msgs);
      case LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK:
        return basicSetAttributeBlock(null, msgs);
      case LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK:
        return basicSetStatementblock(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case LimpPackage.LOCAL_PROCEDURE__NAME:
        return getName();
      case LimpPackage.LOCAL_PROCEDURE__INPUTS:
        return getInputs();
      case LimpPackage.LOCAL_PROCEDURE__OUTPUTS:
        return getOutputs();
      case LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK:
        return getVarBlock();
      case LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK:
        return getAttributeBlock();
      case LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK:
        return getStatementblock();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case LimpPackage.LOCAL_PROCEDURE__NAME:
        setName((String)newValue);
        return;
      case LimpPackage.LOCAL_PROCEDURE__INPUTS:
        setInputs((InputArgList)newValue);
        return;
      case LimpPackage.LOCAL_PROCEDURE__OUTPUTS:
        setOutputs((OutputArgList)newValue);
        return;
      case LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK:
        setVarBlock((VarBlock)newValue);
        return;
      case LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK:
        setAttributeBlock((AttributeBlock)newValue);
        return;
      case LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK:
        setStatementblock((StatementBlock)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case LimpPackage.LOCAL_PROCEDURE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case LimpPackage.LOCAL_PROCEDURE__INPUTS:
        setInputs((InputArgList)null);
        return;
      case LimpPackage.LOCAL_PROCEDURE__OUTPUTS:
        setOutputs((OutputArgList)null);
        return;
      case LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK:
        setVarBlock((VarBlock)null);
        return;
      case LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK:
        setAttributeBlock((AttributeBlock)null);
        return;
      case LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK:
        setStatementblock((StatementBlock)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case LimpPackage.LOCAL_PROCEDURE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case LimpPackage.LOCAL_PROCEDURE__INPUTS:
        return inputs != null;
      case LimpPackage.LOCAL_PROCEDURE__OUTPUTS:
        return outputs != null;
      case LimpPackage.LOCAL_PROCEDURE__VAR_BLOCK:
        return varBlock != null;
      case LimpPackage.LOCAL_PROCEDURE__ATTRIBUTE_BLOCK:
        return attributeBlock != null;
      case LimpPackage.LOCAL_PROCEDURE__STATEMENTBLOCK:
        return statementblock != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //LocalProcedureImpl
