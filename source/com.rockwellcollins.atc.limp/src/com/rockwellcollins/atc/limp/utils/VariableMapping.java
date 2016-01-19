package com.rockwellcollins.atc.limp.utils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.rockwellcollins.atc.limp.FunctionRef;
import com.rockwellcollins.atc.limp.VariableRef;

public class VariableMapping {

	private Map<FunctionRef,Map<VariableRef,VariableRef>> map; 
	
	public VariableMapping() {
		super();
		map = new LinkedHashMap<>();
	}
	
	public void insert(FunctionRef fr, VariableRef original, VariableRef mapping) {
		Map<VariableRef,VariableRef> fcnMap;
		if(map.containsKey(fr)) {
			fcnMap = map.get(fr);
		} else {
			fcnMap = new LinkedHashMap<>();
		}
		fcnMap.put(original, mapping);
		map.put(fr, fcnMap);
	}
	
	public boolean contains(FunctionRef fr, VariableRef original) {
		if(map.containsKey(fr)) {
			Map<VariableRef,VariableRef> fcnMap = map.get(fr);
			return fcnMap.containsKey(original);
		} else {
			return false;
		}
	}
	
	public Map<VariableRef,VariableRef> getFcnMap(FunctionRef fr) {
		if(this.map.containsKey(fr)) {
			return this.map.get(fr);
		} else {
			return null;
		}
	}
	
	public Collection<Map<VariableRef, VariableRef>> getFunctionMaps() {
		return this.map.values();
	}
	
	public boolean contains(FunctionRef fr) {
		return this.map.containsKey(fr);
	}
	
	public VariableRef getMapping(FunctionRef fr, VariableRef original) {
		if(this.contains(fr, original)) {
			Map<VariableRef,VariableRef> fcnMap = map.get(fr);
			return fcnMap.get(original);
		} else {
			throw new IllegalArgumentException("You must check that this map contains the information using the \"contains\" method.");
		}
	}
	
	public void mergeMap(VariableMapping newMapping) {
		for(FunctionRef functionRef : newMapping.map.keySet()) {
			Map<VariableRef,VariableRef> fcnMap = newMapping.map.get(functionRef);
			for(VariableRef key : fcnMap.keySet()) {
				insert(functionRef,key,fcnMap.get(key));
			}
		}
	}

	public boolean containsKey(VariableRef vr) {
		for(Map<VariableRef,VariableRef> fcnMap : map.values()) {
			if(fcnMap.containsKey(vr)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsKey(String name) {
		for(Map<VariableRef,VariableRef> fcnMap : map.values()) {
			for(VariableRef vr : fcnMap.values()) {
				String vr_name = GetVariableName.getName(vr);
				if(name.equals(vr_name)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString() {
		return this.toString(map);
	}
	
	private String toString(Map<FunctionRef,Map<VariableRef,VariableRef>> map) {
		StringBuffer stringBuffer = new StringBuffer();
		for(FunctionRef key : map.keySet()) {
			String function_string = GetFunctionName.getName(key);
			stringBuffer.append(function_string);
			stringBuffer.append(" :: " );
			stringBuffer.append("\n");
			stringBuffer.append(this.toString(map.get(key),3));
		}
		return stringBuffer.toString();
	}
	
	private String toString(Map<VariableRef,VariableRef> map, int indent) {
		StringBuffer stringBuffer = new StringBuffer();
		for(VariableRef key : map.keySet()) {
			for(int i=0; i<indent; i++) {
				stringBuffer.append(" ");
			}
			String key_string = GetVariableName.getName(key);
			String value_string = GetVariableName.getName(map.get(key));
			stringBuffer.append(key_string);
			stringBuffer.append(" -> ");
			stringBuffer.append(value_string);
			stringBuffer.append("\n");
		}
		return stringBuffer.toString();
	}
}
