package com.rockwellcollins.atc.limp.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.Type;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 *	GetVariableType is an extension of the LimpSwitch visitor structure and
 *	can be passed any valid Limp EObject.  
 *
 *	If the object is a VariableRef (InputArg, LocalArg, OutputArg, 
 *	ConstantDeclaration, ExternalConstantDeclaration, GlobalDeclaration, 
 *	ExternalGlobalDeclaration) it will return the Limp type of that variable.
 *
 *	If the object is not a VariableRef, it will throw an exception and return
 *	null.
  */
public class GetVariableType extends LimpSwitch<Type> {
	
	public static Type getType(VariableRef vr) {
		return new GetVariableType().doSwitch(vr);
	}
	
	private GetVariableType() {
		super();
	}
	
	/**
	 * Return the type of an InputArg.
	 */
	@Override
	public Type caseInputArg(InputArg iarg) {
		return EcoreUtil2.copy(iarg.getType());
	}

	/**
	 * Return the type of an LocalArg.
	 */
	@Override
	public Type caseLocalArg(LocalArg larg) {
		return EcoreUtil2.copy(larg.getType());
	}

	/**
	 * Return the type of an OutputArg.
	 */
	@Override
	public Type caseOutputArg(OutputArg oarg) {
		return  EcoreUtil2.copy(oarg.getType());
	}

	/**
	 * Return the type of an ConstantDeclaration.
	 */
	@Override
	public Type caseConstantDeclaration(ConstantDeclaration cd) {
		return  EcoreUtil2.copy(cd.getType());
	}

	/**
	 * Return the type of an GlobalDeclaration.
	 */
	@Override
	public Type caseGlobalDeclaration(GlobalDeclaration gd) {
		return  EcoreUtil2.copy(gd.getType());
	}

	/**
	 * If the object encountered is a non-VariableRef object, an UnexpectedException is thrown
	 * and null is returned.
	 */
	@Override
	public Type defaultCase(EObject e) {
		try {
			throw new UnexpectedException("unexpected EObject encountered.");
		} catch (UnexpectedException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
