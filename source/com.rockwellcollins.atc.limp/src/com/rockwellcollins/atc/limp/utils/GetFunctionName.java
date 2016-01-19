package com.rockwellcollins.atc.limp.utils;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.FunctionRef;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 *	GetFunctionName is an extension of the LimpSwitch visitor structure and
 *	can be passed any valid Limp EObject.  
 *
 *	If the object is a FunctionRef (ExternalFunction, ExternalProcedure, 
 *	LocalFunction, LocalProcedure) it will return the name of that function.
 *
 *	If the object is not a FunctionRef, it will throw an exception and return
 *	null.
  */
public class GetFunctionName extends LimpSwitch<String> {
	
	public static String getName(FunctionRef fr) {
		return new GetFunctionName().doSwitch(fr);
	}
	
	private GetFunctionName() {
		super();
	}
	
	/**
	 * return the name of an ExternalFunction
	 */
	@Override
	public String caseExternalFunction(ExternalFunction ef) {
		return ef.getName();
	}

	/**
	 * return the name of an ExternalProcedure
	 */
	@Override
	public String caseExternalProcedure(ExternalProcedure ep) {
		return ep.getName();
	}

	/**
	 * return the name of an LocalFunction
	 */
	@Override
	public String caseLocalFunction(LocalFunction lf) {
		return lf.getName();
	}

	/**
	 * return the name of an LocalProcedure
	 */
	@Override
	public String caseLocalProcedure(LocalProcedure lp) {
		return lp.getName();
	}
	
	/**
	 * Throw an UnexpectedException, and return null in the case we are 
	 * provided a non-FunctionRef object.
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
