package com.rockwellcollins.atc.limp.exceptions;

/**
 * UnexpectedException is used to denote when an unexpected Limp
 * construct is encountered by a transformative pass during processing.
 * 
 *  For example, this would be used when an AssignmentStatement is passed
 *  to a method designed to process a VariableRef.
  */
public class UnexpectedException extends RuntimeException {

	private static final long serialVersionUID = 7098828603843473249L;

	public UnexpectedException(String m) {
		super(m);
	}
	
}
