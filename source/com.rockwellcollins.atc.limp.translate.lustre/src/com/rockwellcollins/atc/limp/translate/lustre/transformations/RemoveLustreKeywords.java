package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.MangleList;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
/**
 * RemoveLustreKeywords removes all identifiers from a Lustre spec that are Lustre keywords.
 * The list of keywords can be found in the keywords set in the getLustreKeywordSet() method. 
  */
public class RemoveLustreKeywords extends LimpSwitch<EObject> {

	public MangleList mangleList = new MangleList();
	
	public Specification transform(Specification s) {
		return (Specification) doSwitch(s);
	}
	
	private final Set<String> keywords;
	
	public RemoveLustreKeywords() {
		keywords = this.getLustreKeywordSet();
	}
	
	/**
	 * This generates the set of Lustre keywords we need to check for.  We only generate this once and save it in a global "keywords"
	 * to reduce computation.  Java doesn't allow you to create Sets of literals and so we have to generate a new set everytime we
	 * call this function.
	 * 
	 * local procedure pre(...) returns (...)
	 * 
	 * local procedure pre_(...) returns (...)
	 * 
	 * local proced pre_a(...) returns (...)
	 * 
	 * local procedure pre_a_
	 * 
	 */
	private Set<String> getLustreKeywordSet() {
		Set<String> keywords = new TreeSet<>();
		keywords.add("then");
		keywords.add("type");
		keywords.add("pre");
		keywords.add("struct");
		keywords.add("true");
		keywords.add("else");
		keywords.add("tel");
		keywords.add("condact");
		keywords.add("let");
		keywords.add("and");
		keywords.add("var");
		keywords.add("floor");
		keywords.add("int");
		keywords.add("if");
		keywords.add("not");
		keywords.add("of");
		keywords.add("subrange");
		keywords.add("real");
		keywords.add("enum");
		keywords.add("assert");
		keywords.add("returns");
		keywords.add("mod");
		keywords.add("const");
		keywords.add("div");
		keywords.add("bool");
		keywords.add("xor");
		keywords.add("false");
		keywords.add("node");
		keywords.add("or");
		return keywords;
	}

	/**
	 * A name is in conflict if it starts with a keyword, or is complete.  Example
	 * 
	 *  the following variables would be conflicts
	 *  
	 *  "let" - it is exactly the same
	 *  "let_" - it starts with the keyword
	 *  "let_a" - it starts with the keyword
	 */
	private boolean checkForConflict(String name) {
		for(String keyword : keywords) {
			if(name.startsWith(keyword)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * For now we're just adding an underscore to the name to avoid making the Lustre untraceable.
	 */
	private String makeNameUnique(String original) {
		return original + "_";
	}
	
	/**
	 * We grab every name in the file and check it.  We do this at the global level so we don't worry about scoping issues. 
	 */
	private List<String> processNames(EObject root) {
		List<String> renamed = new ArrayList<>();
		
		SimpleAttributeResolver<EObject, String> resolver = SimpleAttributeResolver.newResolver(String.class,"name");
		for (EObject e : EcoreUtil2.getAllContentsOfType(root, EObject.class)) {
			String name = resolver.apply(e);
			if (name != null) {
				if (checkForConflict(name)) {
					String uniqueName = makeNameUnique(name);
					renamed.add(uniqueName);
					e.eSet(resolver.getAttribute(e), uniqueName);
					mangleList.addSingleToMangleList(name, uniqueName);
				}
			}
		}
		return renamed;
	}

	@Override
	public Specification caseSpecification(Specification s) {
		this.processNames(s);
		return s;
	}

	public MangleList getMangleList() {
		return mangleList;
	}
}
