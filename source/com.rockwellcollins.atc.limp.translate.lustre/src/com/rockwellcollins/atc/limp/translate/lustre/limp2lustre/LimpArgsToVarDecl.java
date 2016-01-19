package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.util.ArrayList;
import java.util.List;

import jkind.lustre.VarDecl;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.InputArgList;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.OutputArgList;
import com.rockwellcollins.atc.limp.SomeVarBlock;
import com.rockwellcollins.atc.limp.VarBlock;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.exceptions.UnsupportedException;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
/**
 * Extends the LimpSwitch XText generated VisitorClass to accept a VariableRef
 * and translate it into a VarDecl object in Lustre.
 * 
 *  If anything other than a VariableRef is encountered, it will return null and
 *  throw the UnsupportedException.
 *
 */
public class LimpArgsToVarDecl extends LimpSwitch<VarDecl> {

	public static VarDecl crunch(VariableRef vr) {
		return new LimpArgsToVarDecl().doSwitch(vr);
	}
	
	/**
	 * Transforms an InputArgList to a List<VarDecl> 
	 */
	public static List<VarDecl> crunchInputs(InputArgList ial) {
		List<VarDecl> inputs = new ArrayList<>();
		for(InputArg ia : ial.getInputArgs()) {
			VarDecl vd = crunch(ia);
			inputs.add(vd);
		}
		return inputs;
	}
	
	/**
	 * Transforms an OutputArgList to a List<VarDecl> 
	 */
	public static List<VarDecl> crunchOutputs(OutputArgList oal) {
		List<VarDecl> outputs = new ArrayList<>();
		for(OutputArg oa : oal.getOutputArgs()) {
			VarDecl vd = crunch(oa);
			outputs.add(vd);
		}
		return outputs;
	}
	
	/**
	 * Transforms an OutputArg to a List<VarDecl>
	 */
	public static List<VarDecl> crunchOutput(OutputArg oarg) {
		List<VarDecl> outputs = new ArrayList<>();
		outputs.add(crunch(oarg));
		return outputs;
	}
	
	public static List<VarDecl> crunchLocals(VarBlock vb) {
		List<VarDecl> locals = new ArrayList<>();
		if (locals instanceof SomeVarBlock) {
			SomeVarBlock svb = (SomeVarBlock) locals;
			for(LocalArg larg : svb.getLocals()) {
				VarDecl vd = crunch(larg);
				locals.add(vd);
			}
		}
		return locals;
	}
	
	@Override
	public VarDecl caseInputArg(InputArg iarg) {
		return new VarDecl(iarg.getName(), LimpTypeToLustreType.translate(iarg));
	}
	
	@Override
	public VarDecl caseLocalArg(LocalArg larg) {
		return new VarDecl(larg.getName(), LimpTypeToLustreType.translate(larg));
	}

	@Override
	public VarDecl caseOutputArg(OutputArg oarg) {
		return new VarDecl(oarg.getName(), LimpTypeToLustreType.translate(oarg));
	}
	
	@Override
	public VarDecl caseGlobalDeclaration(GlobalDeclaration gd) {
		return new VarDecl(gd.getName(), LimpTypeToLustreType.translate(gd));
	}
	
	@Override
	public VarDecl defaultCase(EObject o) {
		throw new UnsupportedException("EObject " + o.toString() + " not supported.");
	}
}
