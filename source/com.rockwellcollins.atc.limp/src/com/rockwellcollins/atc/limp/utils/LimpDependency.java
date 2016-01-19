package com.rockwellcollins.atc.limp.utils;

import java.util.LinkedHashSet;
import java.util.Set;

import com.rockwellcollins.atc.limp.FunctionRef;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.VariableRef;

/**
 * LimpDependency is a data collection class that contains set objects to collect
 * the variables read and written in Limp objects, computed by the ComputeDependencies
 * class.
 */
public class LimpDependency {
	
	private Set<VariableRef> variables_read;
	private Set<VariableRef> variables_written;
	private Set<VariableRef> variables_read_and_written;
	private Set<GlobalDeclaration> globals_read;
	private Set<GlobalDeclaration> globals_written;
	private Set<GlobalDeclaration> globals_read_and_written;
	
	private Set<FunctionRef> functions_called;
	

	/**
	 * Instantiates the LimpDependency object with empty data sets.
	 */
	public LimpDependency() {
		variables_read = new LinkedHashSet<>();
		variables_written = new LinkedHashSet<>();
		variables_read_and_written = new LinkedHashSet<>();
		globals_read = new LinkedHashSet<>();
		globals_written = new LinkedHashSet<>();
		globals_read_and_written = new LinkedHashSet<>();
		functions_called = new LinkedHashSet<>();
	}
	
	/**
	 * Provides access to a the private variables_read field. 
	 */
	public Set<VariableRef> getReadVariables() {
		return variables_read;
	}

	/**
	 * Provides access to a the private variables_written field. 
	 */
	public Set<VariableRef> getWrittenVariables() {
		return variables_written;
	}
	
	/**
	 * Provides access to a the private variables_read_and_written field. 
	 */
	public Set<VariableRef> getReadAndWrittenVariables() {
		return variables_read_and_written;
	}
	
	/**
	 * Provides access to the private globals_read field.
	 */
	public Set<GlobalDeclaration> getReadGlobalVariables() {
		return globals_read;
	}
	
	/**
	 * Provides access to the private globals_written field.
	 */
	public Set<GlobalDeclaration> getWrittenGlobalVariables() {
		return globals_written;
	}
	
	/**
	 * Provides access to the private globals_read_and_written field.
	 */
	public Set<GlobalDeclaration> getReadAndWrittenGlobalVariables() {
		return globals_read_and_written;
	}
	
	/**
	 * Provides access to a the private functions_called field. 
	 */
	public Set<FunctionRef> getCalledFunctions() {
		return functions_called;
	}
	
	/**
	 *	Sets the private variables_read field. 
	 */
	public void setReadVariables(Set<VariableRef> r) {
		variables_read = r;
	}

	/**
	 *	Sets the private variables_written field. 
	 */
	public void setWrittenVariables(Set<VariableRef> w) {
		variables_written = w;
	}

	/**
	 *	Sets the private functions_called field. 
	 */
	public void setCalledFunctions(Set<FunctionRef> cf) {
		functions_called=cf;
	}
	
	/**
	 * Accepts two LimpDependency objects and merges them into a single
	 * object. 
	 */
	public static LimpDependency merge(LimpDependency vd1, LimpDependency vd2) {
		LimpDependency vd = new LimpDependency();
		vd.getReadVariables().addAll(vd1.getReadVariables());
		vd.getReadVariables().addAll(vd2.getReadVariables());
		vd.getWrittenVariables().addAll(vd1.getWrittenVariables());
		vd.getWrittenVariables().addAll(vd2.getWrittenVariables());
		vd.getCalledFunctions().addAll(vd1.getCalledFunctions());
		vd.getCalledFunctions().addAll(vd2.getCalledFunctions());
		vd.getReadGlobalVariables().addAll(vd1.getReadGlobalVariables());
		vd.getReadGlobalVariables().addAll(vd2.getReadGlobalVariables());
		vd.getWrittenGlobalVariables().addAll(vd1.getWrittenGlobalVariables());
		vd.getWrittenGlobalVariables().addAll(vd2.getWrittenGlobalVariables());
		return vd;
	}

	/**
	 * Accepts two LimpDependency objects and merges *just* the globals them into a single
	 * object. 
	 */
	public static LimpDependency justGlobals(LimpDependency vd1) {
		LimpDependency vd = new LimpDependency();
		vd.getReadGlobalVariables().addAll(vd1.getReadGlobalVariables());
		vd.getWrittenGlobalVariables().addAll(vd1.getWrittenGlobalVariables());
		return vd;
	}	
	
	
	/**
	 * In some cases, it is useful to transform a set of VariableRefs to an 
	 * equivalent set of Strings containing only the variable name. 
	 */
	public static Set<String> transformSet(Set<VariableRef> vrSet) {
		Set<String> transformed = new LinkedHashSet<>();
		for(VariableRef vr : vrSet) {
			transformed.add(GetVariableName.getName(vr));
		}
		return transformed;
	}
	
	public Set<VariableRef> getWritten() {
		Set<VariableRef> written = new LinkedHashSet<>();
		written.addAll(this.variables_written);
		written.addAll(this.globals_written);
		return written;
	}
	
	public Set<VariableRef> getRead() {
		Set<VariableRef> read = new LinkedHashSet<>();
		read.addAll(this.variables_read);
		read.addAll(this.globals_read);
		return read;
	}
	
	public void resolveVariables() {
		this.variables_read_and_written = this.variables_written;
		this.variables_read_and_written.retainAll(this.variables_read);
		this.globals_read_and_written = this.globals_written;
		this.globals_read_and_written.retainAll(this.globals_read);
	}
}

