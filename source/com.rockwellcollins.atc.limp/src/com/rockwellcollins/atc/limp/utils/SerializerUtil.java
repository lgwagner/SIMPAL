package com.rockwellcollins.atc.limp.utils;

/*
 * The EObjectToString method is used to convert Limp expressions to strings.
 */

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializer;

import com.rockwellcollins.atc.LimpInjectorUtil;

public class SerializerUtil {
	private static ISerializer serializer = LimpInjectorUtil.getInstance(ISerializer.class);

	public static String EObjectToString(EObject e) {
		return serializer.serialize(e);
	}
}
