package com.rockwellcollins.atc.limp.naming;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

import com.rockwellcollins.atc.limp.EnumValue;

public class LimpQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	public QualifiedName qualifiedName(EnumValue ev) {
		return QualifiedName.create(ev.getName());
	}
}
