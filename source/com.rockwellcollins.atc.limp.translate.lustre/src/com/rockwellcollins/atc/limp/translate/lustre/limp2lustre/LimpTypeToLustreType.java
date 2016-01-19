package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import jkind.lustre.Type;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ArrayType;
import com.rockwellcollins.atc.limp.BoolType;
import com.rockwellcollins.atc.limp.EnumType;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.IntegerType;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.NamedType;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.RealType;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.exceptions.UnsupportedException;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
/**
 * LimpTypeToLustreType translates Limp types to Lustre types. All of the type translations
 * are very straightforward because the Limp type system was built in the image of the
 * Lustre type system. 
 */
public class LimpTypeToLustreType extends LimpSwitch<Type> {

	public static Type translate(InputArg iarg) {
		return new LimpTypeToLustreType().doSwitch(iarg.getType());
	}
	
	public static Type translate(LocalArg larg) {
		return new LimpTypeToLustreType().doSwitch(larg.getType());
	}

	public static Type translate(OutputArg oarg) {
		return new LimpTypeToLustreType().doSwitch(oarg.getType());
	}
	
	public static Type translate(GlobalDeclaration global) {
		return new LimpTypeToLustreType().doSwitch(global.getType());
	}
	
	public static Type translateType(com.rockwellcollins.atc.limp.Type t) {
		return new LimpTypeToLustreType().doSwitch(t);
	}
	
	@Override
	public Type caseBoolType(BoolType bt) {
		return jkind.lustre.NamedType.BOOL;
	}

	@Override
	public Type caseIntegerType(IntegerType it) {
		return jkind.lustre.NamedType.INT;
	}

	@Override
	public Type caseRealType(RealType rt) {
		return jkind.lustre.NamedType.REAL;
	}
	
	@Override
	public Type caseNamedType(NamedType nt) {
		jkind.lustre.NamedType lustreNamedType = new jkind.lustre.NamedType(nt.getAlias().getName());
		return lustreNamedType;
	}
	
	@Override
	public Type caseEnumType(EnumType et) {
		return new jkind.lustre.NamedType(et.getEnumDef().getName());
	}
	
	@Override
	public Type caseArrayType(ArrayType at) {
		return new jkind.lustre.NamedType(at.getArrayDef().getName());
	}
	
	@Override
	public Type caseRecordType(RecordType rt) {
		return new jkind.lustre.NamedType(rt.getRecordDef().getName());
	}
	
	@Override
	public Type defaultCase(EObject eo) {
		throw new UnsupportedException("LimpTypeToLustreType does not support " + eo.toString() + " objects.");
	}
}
