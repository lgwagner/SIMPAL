package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jkind.lustre.Ast;
import jkind.lustre.Constant;
import jkind.lustre.Expr;
import jkind.lustre.Function;
import jkind.lustre.Node;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ArrayTypeDef;
import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.EnumTypeDef;
import com.rockwellcollins.atc.limp.EnumValue;
import com.rockwellcollins.atc.limp.Equation;
import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.RecordFieldType;
import com.rockwellcollins.atc.limp.RecordTypeDef;
import com.rockwellcollins.atc.limp.TypeAlias;
import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 * LimpToLustre is the top level translator for Limp files to
 * an equivalent Lustre representation for analysis.
 */
public class LimpDeclarationToLustreDeclaration extends LimpSwitch<Ast> {
	
	public static VarDecl crunch(GlobalDeclaration gd) {
		return (VarDecl) new LimpDeclarationToLustreDeclaration().doSwitch(gd);
	}

	public static Node crunch(LocalFunction lf) {
		return (Node) new LimpDeclarationToLustreDeclaration().doSwitch(lf);
	}
	
	public static Function crunch(ExternalFunction ef) {
		return (Function) new LimpDeclarationToLustreDeclaration().doSwitch(ef);
	}

	public static Function crunch(ExternalProcedure ep) {
		return (Function) new LimpDeclarationToLustreDeclaration().doSwitch(ep);
	}
	
	public static Function crunch(LocalProcedure lp) {
		return (Function) new LimpDeclarationToLustreDeclaration().doSwitch(lp);
	}
	
	public static TypeDef crunch(TypeAlias ta) {
		return (TypeDef) new LimpDeclarationToLustreDeclaration().doSwitch(ta);
	}
	
	public static TypeDef crunch(EnumTypeDef etd) {
		return (TypeDef) new LimpDeclarationToLustreDeclaration().doSwitch(etd);
	}
	
	public static TypeDef crunch(RecordTypeDef rtd) {
		return (TypeDef) new LimpDeclarationToLustreDeclaration().doSwitch(rtd);
	}
	
	public static TypeDef crunch(ArrayTypeDef atd) {
		return (TypeDef) new LimpDeclarationToLustreDeclaration().doSwitch(atd);
	}

	public static Constant crunch(ConstantDeclaration cd) {
		return (Constant) new LimpDeclarationToLustreDeclaration().doSwitch(cd);
	}
	
	/**
	 * LocalFunctions are directly translated to Lustre nodes.
	 */
	@Override
	public Node caseLocalFunction(LocalFunction lf) {
		String nodeName = lf.getName();
		List<VarDecl> inputs = LimpArgsToVarDecl.crunchInputs(lf.getInputs());
		List<VarDecl> locals = LimpArgsToVarDecl.crunchLocals(lf.getVarBlock());
		List<VarDecl> outputs = LimpArgsToVarDecl.crunchOutput(lf.getOutput());
				
		List<jkind.lustre.Equation> equations = new ArrayList<>();
		for(Equation eq : lf.getEquationBlock().getEquations()) {
			equations.add(LimpStatementToLustreEquation.translate(eq));
		}
		List<String> properties = new ArrayList<>();
		List<Expr> assertions = new ArrayList<>();
		Node n = new Node(nodeName, inputs, outputs, locals, equations, properties, assertions);
		return n;
	}
	
	/**
	 * ExternalFunctions are translated into Lustre uninterpreted functions.
	 */
	@Override
	public Function caseExternalFunction(ExternalFunction ef) {
		List<jkind.lustre.VarDecl> inputs = LimpArgsToVarDecl.crunchInputs(ef.getInputs());
		List<jkind.lustre.VarDecl> outputs = LimpArgsToVarDecl.crunchOutput(ef.getOutput());
		jkind.lustre.Function function = new jkind.lustre.Function(ef.getName(), inputs, outputs);
		return function;
	}

	/**
	 * ExternalProcedures are translated into Lustre uninterpreted functions.
	 */
	@Override
	public Function caseExternalProcedure(ExternalProcedure ep) {
		List<jkind.lustre.VarDecl> inputs = LimpArgsToVarDecl.crunchInputs(ep.getInputs());
		List<jkind.lustre.VarDecl> outputs = LimpArgsToVarDecl.crunchOutputs(ep.getOutputs());
		jkind.lustre.Function function = new jkind.lustre.Function(ep.getName(), inputs, outputs);
		return function;
	}
	
	/**
	 * LocalProcedures are translated into Lustre uninterpreted functions, however they 
	 * should only be encountered if they are called from the main LocalProcedure.
	 */
	@Override
	public Function caseLocalProcedure(LocalProcedure lp) {
		List<jkind.lustre.VarDecl> inputs = LimpArgsToVarDecl.crunchInputs(lp.getInputs());
		List<jkind.lustre.VarDecl> outputs = LimpArgsToVarDecl.crunchOutputs(lp.getOutputs());
		jkind.lustre.Function function = new jkind.lustre.Function(lp.getName(), inputs, outputs);
		return function;
	}

	/**
	 * TypeAlias are translated into Lustre typedefs.
	 */
	@Override
	public TypeDef caseTypeAlias(TypeAlias ta) {
		jkind.lustre.Type t = LimpTypeToLustreType.translateType(ta.getType());
		jkind.lustre.TypeDef typeDef = new jkind.lustre.TypeDef(ta.getName(), t);
		return typeDef;
	}
	
	/**
	 * EnumTypeDefs are translated into Lustre EnumTypes with an associated TypeDef
	 */
	@Override
	public TypeDef caseEnumTypeDef(EnumTypeDef etd) {
		String name = etd.getName();
		List<String> values = new ArrayList<>();
		for(EnumValue ev : etd.getEnumerations()) {
			values.add(ev.getName());
		}
		jkind.lustre.EnumType enumType = new jkind.lustre.EnumType(name,values);
		jkind.lustre.TypeDef typeDef = new jkind.lustre.TypeDef(etd.getName(), enumType);
		return typeDef;
	}
	
	/**
	 * RecordTypeDefs are translated into RecordTypes with an associated TypeDef
	 */
	@Override
	public TypeDef caseRecordTypeDef(RecordTypeDef rtd) {
		Map<String,jkind.lustre.Type> fields = new LinkedHashMap<>();
		for(RecordFieldType rft : rtd.getFields()) {
			String fieldname = rft.getFieldName();
			jkind.lustre.Type fieldType = LimpTypeToLustreType.translateType(rft.getFieldType());
			fields.put(fieldname, fieldType);
		}
		jkind.lustre.RecordType rt = new jkind.lustre.RecordType(rtd.getName(), fields);
		jkind.lustre.TypeDef typeDef = new jkind.lustre.TypeDef(rtd.getName(), rt);
		return typeDef;
	}
	
	/**
	 * ArrayTypeDefs are translated into ArrayTypes with an associated TypeDef
	 */
	@Override
	public TypeDef caseArrayTypeDef(ArrayTypeDef atd) {
		Type baseType = LimpTypeToLustreType.translateType(atd.getBaseType());
		int index = atd.getSize().intValue();	
		jkind.lustre.ArrayType arrayType = new jkind.lustre.ArrayType(baseType, index);
		jkind.lustre.TypeDef typeDef = new jkind.lustre.TypeDef(atd.getName(), arrayType);
		return typeDef;
	}
	
	/**
	 * Limp Constants are translated to Lustre Constants
	 */
	@Override
	public Constant caseConstantDeclaration(ConstantDeclaration cd) {
		jkind.lustre.Expr expr = LimpExprToLustreExpr.translate(cd.getExpr());
		jkind.lustre.Type type = LimpTypeToLustreType.translateType(cd.getType());
		jkind.lustre.Constant constant = new Constant(cd.getName(),type,expr);
		return constant;
	}

	/**
	 * GlobalDeclarations are translated as VarDecls which are input to the main node.
	 */
	@Override
	public VarDecl caseGlobalDeclaration(GlobalDeclaration gd) {
		jkind.lustre.Type t = LimpTypeToLustreType.translateType(gd.getType());
		return new VarDecl(gd.getName(),t);
	}
	
	@Override
	public Ast defaultCase(EObject eo) {
		throw new UnexpectedException("No method declared to handle this argument.");
	}
}
