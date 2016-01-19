/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.EquationBlock;
import com.rockwellcollins.atc.limp.InputArgList;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.VarBlock;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalFunctionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalFunctionImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalFunctionImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalFunctionImpl#getVarBlock <em>Var Block</em>}</li>
 *   <li>{@link com.rockwellcollins.atc.limp.impl.LocalFunctionImpl#getEquationBlock <em>Equation Block</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LocalFunctionImpl extends DeclarationImpl implements LocalFunction
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
   * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutput()
   * @generated
   * @ordered
   */
  protected OutputArg output;

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
   * The cached value of the '{@link #getEquationBlock() <em>Equation Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEquationBlock()
   * @generated
   * @ordered
   */
  protected EquationBlock equationBlock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LocalFunctionImpl()
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
    return LimpPackage.Literals.LOCAL_FUNCTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__INPUTS, oldInputs, newInputs);
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
        msgs = ((InternalEObject)inputs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_FUNCTION__INPUTS, null, msgs);
      if (newInputs != null)
        msgs = ((InternalEObject)newInputs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_FUNCTION__INPUTS, null, msgs);
      msgs = basicSetInputs(newInputs, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__INPUTS, newInputs, newInputs));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputArg getOutput()
  {
    return output;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOutput(OutputArg newOutput, NotificationChain msgs)
  {
    OutputArg oldOutput = output;
    output = newOutput;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__OUTPUT, oldOutput, newOutput);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOutput(OutputArg newOutput)
  {
    if (newOutput != output)
    {
      NotificationChain msgs = null;
      if (output != null)
        msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_FUNCTION__OUTPUT, null, msgs);
      if (newOutput != null)
        msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_FUNCTION__OUTPUT, null, msgs);
      msgs = basicSetOutput(newOutput, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__OUTPUT, newOutput, newOutput));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__VAR_BLOCK, oldVarBlock, newVarBlock);
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
        msgs = ((InternalEObject)varBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_FUNCTION__VAR_BLOCK, null, msgs);
      if (newVarBlock != null)
        msgs = ((InternalEObject)newVarBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_FUNCTION__VAR_BLOCK, null, msgs);
      msgs = basicSetVarBlock(newVarBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__VAR_BLOCK, newVarBlock, newVarBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EquationBlock getEquationBlock()
  {
    return equationBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEquationBlock(EquationBlock newEquationBlock, NotificationChain msgs)
  {
    EquationBlock oldEquationBlock = equationBlock;
    equationBlock = newEquationBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK, oldEquationBlock, newEquationBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEquationBlock(EquationBlock newEquationBlock)
  {
    if (newEquationBlock != equationBlock)
    {
      NotificationChain msgs = null;
      if (equationBlock != null)
        msgs = ((InternalEObject)equationBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK, null, msgs);
      if (newEquationBlock != null)
        msgs = ((InternalEObject)newEquationBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK, null, msgs);
      msgs = basicSetEquationBlock(newEquationBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK, newEquationBlock, newEquationBlock));
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
      case LimpPackage.LOCAL_FUNCTION__INPUTS:
        return basicSetInputs(null, msgs);
      case LimpPackage.LOCAL_FUNCTION__OUTPUT:
        return basicSetOutput(null, msgs);
      case LimpPackage.LOCAL_FUNCTION__VAR_BLOCK:
        return basicSetVarBlock(null, msgs);
      case LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK:
        return basicSetEquationBlock(null, msgs);
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
      case LimpPackage.LOCAL_FUNCTION__NAME:
        return getName();
      case LimpPackage.LOCAL_FUNCTION__INPUTS:
        return getInputs();
      case LimpPackage.LOCAL_FUNCTION__OUTPUT:
        return getOutput();
      case LimpPackage.LOCAL_FUNCTION__VAR_BLOCK:
        return getVarBlock();
      case LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK:
        return getEquationBlock();
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
      case LimpPackage.LOCAL_FUNCTION__NAME:
        setName((String)newValue);
        return;
      case LimpPackage.LOCAL_FUNCTION__INPUTS:
        setInputs((InputArgList)newValue);
        return;
      case LimpPackage.LOCAL_FUNCTION__OUTPUT:
        setOutput((OutputArg)newValue);
        return;
      case LimpPackage.LOCAL_FUNCTION__VAR_BLOCK:
        setVarBlock((VarBlock)newValue);
        return;
      case LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK:
        setEquationBlock((EquationBlock)newValue);
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
      case LimpPackage.LOCAL_FUNCTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case LimpPackage.LOCAL_FUNCTION__INPUTS:
        setInputs((InputArgList)null);
        return;
      case LimpPackage.LOCAL_FUNCTION__OUTPUT:
        setOutput((OutputArg)null);
        return;
      case LimpPackage.LOCAL_FUNCTION__VAR_BLOCK:
        setVarBlock((VarBlock)null);
        return;
      case LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK:
        setEquationBlock((EquationBlock)null);
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
      case LimpPackage.LOCAL_FUNCTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case LimpPackage.LOCAL_FUNCTION__INPUTS:
        return inputs != null;
      case LimpPackage.LOCAL_FUNCTION__OUTPUT:
        return output != null;
      case LimpPackage.LOCAL_FUNCTION__VAR_BLOCK:
        return varBlock != null;
      case LimpPackage.LOCAL_FUNCTION__EQUATION_BLOCK:
        return equationBlock != null;
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

} //LocalFunctionImpl
