package com.rockwellcollins.atc.limp.exceptions;

/**
 * UnsupportedException is used to bookmark code and identify to the user
 * that certain constructs are not yet supported, but potentially could be
 * given further work.  
  */
public class UnsupportedException extends RuntimeException {

	private static final long serialVersionUID = -5977393445829826737L;
	
	public UnsupportedException(String m) {
		super(m);
	}
}
