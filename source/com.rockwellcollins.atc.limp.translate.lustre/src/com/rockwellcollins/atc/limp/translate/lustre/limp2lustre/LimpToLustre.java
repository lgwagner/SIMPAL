package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkind.lustre.Constant;
import jkind.lustre.Function;
import jkind.lustre.Location;
import jkind.lustre.Node;
import jkind.lustre.Program;
import jkind.lustre.Type;
import jkind.lustre.TypeDef;
import jkind.lustre.VarDecl;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.ArrayTypeDef;
import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.EnumTypeDef;
import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.RecordTypeDef;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.TypeAlias;
import com.rockwellcollins.atc.limp.exceptions.UnsupportedException;
import com.rockwellcollins.atc.limp.translate.basicblocks.limp.BasicBlock;
import com.rockwellcollins.atc.limp.translate.lustre.procedure.Procedure;
import com.rockwellcollins.atc.limp.translate.lustre.utils.PLTL;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.LimpUtilities;
import com.rockwellcollins.atc.limp.utils.LimpVoid;

/**
 * LimpToLustre is the top most class for translating a Limp file to a Lustre file.
 * 
 * The process of translating Limp file is:
 *  1. identify the entry point (main LocalProcedure)
 *  2. translates all of the Limp declarations to Lustre declarations
 *  3. translates the main LocalProcedure to BasicBlocks, and then generates Lustre nodes for each BasicBlock
 *  4. translate the main LocalProcedure to execute the BasicBlocks in correct order for the program. 
 */
public class LimpToLustre extends LimpSwitch<LimpVoid> {

	public static Pair<BasicBlock, Program> translate(Specification s, File pdfFile, MangleList mangleList) {
		LimpToLustre limp2Lustre = new LimpToLustre(pdfFile, mangleList);
		limp2Lustre.doSwitch(s);
		Pair<BasicBlock,Program> pair = new Pair<BasicBlock,Program>(limp2Lustre.basicBlock,limp2Lustre.getProgram());
		return pair;
	}
	
	public LocalProcedure main;
	public Map<String, Type> globals = new LinkedHashMap<>();
	public Map<String, Type> typedefs = new LinkedHashMap<>();
	public Map<String, Constant> constants = new LinkedHashMap<>();
	public Map<String, Node> nodes = new LinkedHashMap<>();
	public Map<String, Function> functions = new LinkedHashMap<>();
	public Map<String, Procedure> procedures = new LinkedHashMap<>();
	public MangleList mangleList;

	private Program program;
	private File pdfFile;
	
	public BasicBlock basicBlock;

	public LimpToLustre(File pdfFile, MangleList mangleList) {
		this.pdfFile=pdfFile;
		this.mangleList = mangleList;
	}
	
	private static List<TypeDef> convert(Map<String, Type> typedefs) {
		List<TypeDef> list = new ArrayList<>();
		for (String id : typedefs.keySet()) {
			list.add(new TypeDef(id, typedefs.get(id)));
		}
		return list;
	}

	@Override
	public LimpVoid caseSpecification(Specification s) {
		this.nodes.putAll(PLTL.getAllPLTL());
		
		List<Declaration> sorted = LimpUtilities.getSortedDeclarations(s);
		main = LimpUtilities.getMainLocalProcedure(s);
		for (Declaration d : sorted) {
			this.doSwitch(d);
		}
		
		Pair<BasicBlock, List<Node>> pair = LocalProcedureToLustre.translateLocalProcedure(main, this, pdfFile, mangleList);
		List<Node> nodelist = pair.y;
		
		for (Node n : nodelist) {
			this.nodes.put(n.id, n);
		}

		List<TypeDef> typedef_list = convert(typedefs);
		List<Constant> constant_list = new ArrayList<>(constants.values());
		List<Function> function_list = new ArrayList<>(functions.values());
		List<Procedure> procedure_list = new ArrayList<>(procedures.values());
		List<Node> node_list = new ArrayList<>(nodes.values());
		
		
		List<Function> all_functions = new ArrayList<>(function_list);
		for(Procedure p : procedure_list) {
			all_functions.add(p.getFunction());
		}
		
		String name = main.getName();
		
		program = new Program(Location.NULL, typedef_list, constant_list, all_functions, node_list, name);
		basicBlock = pair.x;
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseTypeAlias(TypeAlias ta) {
		TypeDef td = LimpDeclarationToLustreDeclaration.crunch(ta);
		typedefs.put(td.id, td.type);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseEnumTypeDef(EnumTypeDef etd) {
		TypeDef td = LimpDeclarationToLustreDeclaration.crunch(etd);
		typedefs.put(td.id, td.type);
		return LimpVoid.instance;
	}
	
	@Override
	public LimpVoid caseRecordTypeDef(RecordTypeDef rtd) {
		TypeDef td = LimpDeclarationToLustreDeclaration.crunch(rtd);
		typedefs.put(td.id, td.type);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseArrayTypeDef(ArrayTypeDef atd) {
		TypeDef td = LimpDeclarationToLustreDeclaration.crunch(atd);
		typedefs.put(td.id, td.type);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseGlobalDeclaration(GlobalDeclaration gd) {
		VarDecl vd = LimpDeclarationToLustreDeclaration.crunch(gd);
		globals.put(vd.id, vd.type);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseConstantDeclaration(ConstantDeclaration cd) {
		Constant c = LimpDeclarationToLustreDeclaration.crunch(cd);
		constants.put(c.id, c);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseExternalFunction(ExternalFunction ef) {
		Function f = LimpDeclarationToLustreDeclaration.crunch(ef);
		functions.put(f.id, f);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseLocalFunction(LocalFunction lf) {
		Node n = LimpDeclarationToLustreDeclaration.crunch(lf);
		nodes.put(n.id, n);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseExternalProcedure(ExternalProcedure ep) {
		Procedure p = Procedure.crunch(ep,this, mangleList);
		procedures.put(p.getFunction().id, p);
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid caseLocalProcedure(LocalProcedure lp) {
		if(!lp.equals(main)) {
			Procedure p = Procedure.crunch(lp,this, mangleList);
			procedures.put(p.getFunction().id, p);
		}
		return LimpVoid.instance;
	}

	@Override
	public LimpVoid defaultCase(EObject e) {
		throw new UnsupportedException(e.toString() + " is not supported.");
	}

	public Program getProgram() {
		return program;
	}
	
	public Set<String> getGlobalUsedIds() {
		Set<String> usedIds = new HashSet<>();
		for(String id : globals.keySet()) {
			usedIds.add(id);
		}
		
		for(String id : typedefs.keySet()) {
			usedIds.add(id);
		}
		
		for(String id : constants.keySet()) {
			usedIds.add(id);
		}
		
		for(String id : functions.keySet()) {
			usedIds.add(id);
		}
		
		for(String id : procedures.keySet()) {
			usedIds.add(id);
		}
		return usedIds;
	}
	
	public String getUniqueID(String id, Set<String> usedIds) {
		String name = id;
		Integer current = 0;
		while(usedIds.contains(name)) {
			name = id + "_" + current;
		}
		if (id.compareTo(name) != 0) {
			this.mangleList.addSingleToMangleList(id, name);
		}
		return name;
	}	
}
