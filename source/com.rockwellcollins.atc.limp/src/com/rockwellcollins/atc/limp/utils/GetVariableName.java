package com.rockwellcollins.atc.limp.utils;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.EnumValue;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 *	GetVariableName is an extension of the LimpSwitch visitor structure and
 *	can be passed any valid Limp EObject.  
 *
 *	If the object is a VariableRef (InputArg, LocalArg, OutputArg, 
 *	ConstantDeclaration, ExternalConstantDeclaration, GlobalDeclaration, 
 *	ExternalGlobalDeclaration) it will return the name of that variable.
 *
 *	If the object is not a VariableRef, it will throw an exception and return
 *	null.
  */
public class GetVariableName extends LimpSwitch<String> {
	
	public static String getName(VariableRef vref) {
		return new GetVariableName().doSwitch(vref);
	}

	private GetVariableName() {
		super();
	}
	
	/**
	 * Return the name of an InputArg.
	 */
	@Override
	public String caseInputArg(InputArg iarg) {
		return iarg.getName();
	}

	/**
	 * Return the name of an LocalArg.
	 */
	@Override
	public String caseLocalArg(LocalArg larg) {
		return larg.getName();
	}

	/**
	 * Return the name of an OutputArg.
	 */
	@Override
	public String caseOutputArg(OutputArg oarg) {
		return oarg.getName();
	}

	/**
	 * Return the name of an ConstantDeclaration.
	 */
	@Override
	public String caseConstantDeclaration(ConstantDeclaration cd) {
		return cd.getName();
	}

	/**
	 * Return the name of an GlobalDeclaration.
	 */
	@Override
	public String caseGlobalDeclaration(GlobalDeclaration gd) {
		return gd.getName();
	}

	@Override
	public String caseEnumValue(EnumValue ev) {
		return ev.getName();
	}
	
	/**
	 * If a non-VariableRef object is encountered, throw an UnexpectedException, and return null
	 */
	@Override
	public String defaultCase(EObject e) {
		try {
			throw new UnexpectedException("unexpected EObject encountered.");
		} catch (UnexpectedException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
