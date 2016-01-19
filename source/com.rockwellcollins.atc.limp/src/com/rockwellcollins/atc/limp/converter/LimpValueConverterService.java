package com.rockwellcollins.atc.limp.converter;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;

import com.google.inject.Inject;

public class LimpValueConverterService extends AbstractDeclarativeValueConverterService {

	@Inject
	private STRINGValueConverter stringValueConverter;
	
	@ValueConverter(rule = "STRING")
	public IValueConverter<String> STRING() {
		return stringValueConverter;
	}
}
