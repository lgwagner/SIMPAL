package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.Comment;
import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.StringLiteralExpr;
import com.rockwellcollins.atc.limp.StringType;
import com.rockwellcollins.atc.limp.TypeAlias;
import com.rockwellcollins.atc.limp.TypeDeclaration;
import com.rockwellcollins.atc.limp.NamedType;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.MangleList;

/**
 * RemoveStrings removes all string literals, variables, and types from the model and replaces them
 * with integer literals, integer variables, and integer types.
 * 
 * String literals are replaced with integer literals. All unique strings will be assigned a unique
 * integer literal. This abstraction works for simple string operations like comparisons, however it
 * does not support more advanced operations such as string concatenation.
  */
public class RemoveStrings {

	private static final String COMMA = ",";
	private static final String CLOSE_BRACKET = "]";
	private static final String OPEN_BRACKET = "[";
	private static final String NEWLINE = "\n";
	public MangleList mangleList = new MangleList();
	
	public static String mapToString(Map<String,BigInteger> map) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(OPEN_BRACKET);
		buffer.append(NEWLINE);
		
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			BigInteger value = map.get(key);
			buffer.append(OPEN_BRACKET);
			buffer.append(value);
			buffer.append(COMMA);
			buffer.append(key);
			buffer.append(CLOSE_BRACKET);
			
			if(iterator.hasNext()) {
				buffer.append(COMMA);
				buffer.append(NEWLINE);
			}
		}
		
		buffer.append(NEWLINE);
		buffer.append(CLOSE_BRACKET);
		
		return buffer.toString();
	}
	
	public Map<String,BigInteger> map = new LinkedHashMap<>();
	
	BigInteger StringToInt (String str)
	{
		// Leave the beginning " to support length extension and remove the trailing " to support counterexamples 
		String subString = str.substring(0, str.length() - 1);
		BigInteger result = new BigInteger((subString).getBytes());
		return result;
	}
	
	public Specification transform(Specification s) {
		for(StringLiteralExpr sle : EcoreUtil2.getAllContentsOfType(s, StringLiteralExpr.class)) {
			String slVal = sle.getStringVal();
			if(!map.containsKey(slVal)) {
				map.put(slVal, StringToInt(slVal));	
			}

			IntegerLiteralExpr ile = LimpFactory.eINSTANCE.createIntegerLiteralExpr();
			ile.setIntVal(map.get(sle.getStringVal()));
			EcoreUtil2.replace(sle, ile);
		}
		
		List<String> typeNames = new ArrayList<>();
	    for(TypeDeclaration td : EcoreUtil2.getAllContentsOfType(s, TypeDeclaration.class)){
	    	String typeName = td.getName();
	    	if (!typeNames.contains(typeName)){
	    		typeNames.add(typeName);
	    	}
	    }
	    
	    String newStringTypeName = "wasAString";
	    while(typeNames.contains(newStringTypeName)){
	    	newStringTypeName += "_";
	    }
		
	    TypeAlias newStringAlias = LimpFactory.eINSTANCE.createTypeAlias();
	    newStringAlias.setName(newStringTypeName);
	    newStringAlias.setType(LimpFactory.eINSTANCE.createIntegerType());
	    s.getDeclarations().add(0, newStringAlias);
	    mangleList.addSingleToMangleList("", newStringTypeName);
	    
		for(StringType st : EcoreUtil2.getAllContentsOfType(s, StringType.class)) {
		    NamedType nt = LimpFactory.eINSTANCE.createNamedType();
		    nt.setAlias(newStringAlias);	    	    
			EcoreUtil2.replace(st, nt);
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("/#" + System.lineSeparator());
		buffer.append("Integer to String mapping : " + System.lineSeparator());
		for(String key : map.keySet()) {
			buffer.append("  " + map.get(key) + " -> " + key + System.lineSeparator());
			mangleList.addSingleToMangleList(key, (map.get(key).toString()));
		}
		buffer.append("#/");
		
		Comment comment = LimpFactory.eINSTANCE.createComment();
		comment.setComment(buffer.toString());
		s.getDeclarations().add(0, comment);		
		return s;
	}

	public MangleList getMangleList() {
		return mangleList;
	}

}
