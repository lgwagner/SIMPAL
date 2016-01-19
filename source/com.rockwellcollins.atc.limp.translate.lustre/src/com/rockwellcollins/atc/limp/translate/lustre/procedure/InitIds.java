package com.rockwellcollins.atc.limp.translate.lustre.procedure;

/**
 * InitIds is a simple utility that prepends 'init#' in front of all identifiers
 * that appear inside of Limp InitId expressions. This is so they can be easily
 * identify in the Lustre after it is transformed into BasicBlocks. 
  */
public class InitIds {

	public static final String INIT_TAG = "init#";
	
	public static String encode(String name) {
		return INIT_TAG + name; 
	}
	
	public static String decode(String id) {
		if(isEncoded(id)) {
			return id.substring(INIT_TAG.length());	
		}
		throw new IllegalArgumentException(id + " is not legal InitID");
	}
	
	public static boolean isEncoded(String id) {
		return id.startsWith(INIT_TAG);
	}
}
