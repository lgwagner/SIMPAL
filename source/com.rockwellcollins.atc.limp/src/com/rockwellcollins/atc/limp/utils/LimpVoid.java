package com.rockwellcollins.atc.limp.utils;

/**
 * @author lgwagner
 *
 * This class is used to avoid stupid behaviors introduced by the LimpSwitch.  If you return null (or Void) it will
 * immediately go to the default case which is quite annoying.
 */

public class LimpVoid {
	
	public static LimpVoid instance = new LimpVoid();

	private LimpVoid() {
		super();
	}
}
