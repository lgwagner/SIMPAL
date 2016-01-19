package com.rockwellcollins.atc;

import com.google.inject.Injector;

public class LimpInjectorUtil {
	private static Injector injector;
	
	public static void setInjector(Injector injector) {
		LimpInjectorUtil.injector = injector;
	}
	
	public static void doStandaloneSetup() {
		injector = new LimpStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public static <T> T getInstance(Class<T> type) {
		if (injector == null) {
			throw new IllegalArgumentException("InjectorUtil must be initialized correctly");
		}
		return injector.getInstance(type);
	}
}
