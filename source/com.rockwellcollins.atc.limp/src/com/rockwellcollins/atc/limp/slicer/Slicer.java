package com.rockwellcollins.atc.limp.slicer;

/////////////////////////////////////////////////////////////////////////////////
// The removeUnaccessedGlobals and removeUnaccessedFieldsAndElements methods
// defined in this class are used to slice the state of a Limp file by 
// removing all unreferenced type declarations as well as unreferenced fields
// and elements from arrays. If any element of an array is indexed, the type of 
// that array is left unchanged. 
//
// When an array type is not indexed but is referenced, the base type is changed to
// boolean and the size to 1. When no fields of a record type are referenced but 
// a record of that type is, then the type is changed to include a single dummy
// field of boolean type.
/////////////////////////////////////////////////////////////////////////////////

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayType;
import com.rockwellcollins.atc.limp.ArrayTypeDef;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.InitExpr;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordFieldType;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.RecordTypeDef;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.Type;
import com.rockwellcollins.atc.limp.TypeDeclaration;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.reasoning.visitor.LimpVisitor;
import com.rockwellcollins.atc.limp.reasoning.visitor.Unit;
import com.rockwellcollins.atc.limp.utils.GetType;

public class Slicer extends LimpVisitor {
	
	public static Specification transform(Specification s) {
		Slicer myslicer = new Slicer(s);
		myslicer.doSwitch(s);
		myslicer.removeUnaccessedGlobals();
		myslicer.removeUnaccessedFieldsAndElements();
		return s;	
	}
	
	private List<GlobalDeclaration> globals = new ArrayList<>();
	private List<TypeDeclaration> types = new ArrayList<>();
	private Set<GlobalDeclaration> accessedGlobals = new HashSet<>();
	private Map<TypeDeclaration, Set<String>> accessedTypeDecls = new LinkedHashMap<>();
	private LimpFactory f = LimpFactory.eINSTANCE;
	private GetType getType = new GetType();

	public Slicer(Specification spec) {
		globals = EcoreUtil2.getAllContentsOfType(spec, GlobalDeclaration.class);
		types = EcoreUtil2.getAllContentsOfType(spec, TypeDeclaration.class);
	}
	
	public List<GlobalDeclaration> getGlobals() {
		return globals;
	}
		
	public List<TypeDeclaration> getTypeDecls() {
		return types;
	}
	
	public Set<GlobalDeclaration> getAccessedGlobals() {
		return accessedGlobals;
	}
	
	public Map<TypeDeclaration, Set<String>> getAccessedTypeDecls() {
		return accessedTypeDecls;
	}

	//////////////////////////////////////////////////////////////////////////////
	//Define helper methods to add a set of field names or a single field name to 
	// the set of accessed fields for a given type declaration
	// For arrays, I don't have field names but just the string "used".
	//////////////////////////////////////////////////////////////////////////////
	
	private Void updateAccessedFieldsOrElements(TypeDeclaration td, Set<String> stringsToAdd) {
		if (!accessedTypeDecls.containsKey(td)) {
			accessedTypeDecls.put(td, new HashSet<String>());
		}		
		// If the referenced field type is a record type or an array type,
		//   add its declaration to the map
		if (td instanceof RecordTypeDef) {
			EList<RecordFieldType> fields = ((RecordTypeDef) td).getFields();
			for (RecordFieldType rft : fields) {
				if (stringsToAdd.contains(rft.getFieldName())) {
					if (rft.getFieldType() instanceof RecordType) {
						RecordTypeDef rtd = ((RecordType) rft.getFieldType()).getRecordDef();
						if (!accessedTypeDecls.containsKey(rtd)) {
							accessedTypeDecls.put(rtd, new HashSet<String>());
						}
					} else if (rft.getFieldType() instanceof ArrayType) {
						ArrayTypeDef atd = ((ArrayType) rft.getFieldType()).getArrayDef();
						if (!accessedTypeDecls.containsKey(atd)) {
							accessedTypeDecls.put(atd, new HashSet<String>());
						}
					}
					
				}
			}
		// If the base type of the array is a record type or an array type, 
		//   add its declaration to the map
		} else if (td instanceof ArrayTypeDef) {
			Type baseType = ((ArrayTypeDef) td).getBaseType();
			if (baseType instanceof RecordType) {
				RecordTypeDef rtd = ((RecordType) baseType).getRecordDef();
				if (!accessedTypeDecls.containsKey(rtd)) {
					accessedTypeDecls.put(rtd, new HashSet<String>());
				}
			} else if (baseType instanceof ArrayType) {
				ArrayTypeDef atd1 = ((ArrayType) baseType).getArrayDef();
				if (!accessedTypeDecls.containsKey(atd1)) {
					accessedTypeDecls.put(atd1, new HashSet<String>());
				}
			}
		}
		//Get the current set of accessed fields from the map
		Set<String> fieldSet = accessedTypeDecls.get(td); 
		//Add the fields in fieldsToAdd to the set of accessed fields
		fieldSet.addAll(stringsToAdd);
		//Update the map with the new list
		accessedTypeDecls.put(td, fieldSet);
		return null;
	}
	
	//This function is for convenience so I can call updateAccessedFieldsOrElements with a single string, 
	//  rather than creating a set of one string just to call this method.
	private Void updateAccessedFieldsOrElements(TypeDeclaration td, String stringToAdd) {
		//Put the single string in a set and call updateAccessedFieldsOrElements with that set of strings
		Set<String> stringsToAdd = new HashSet<String>();
		stringsToAdd.add(stringToAdd);
		updateAccessedFieldsOrElements(td, stringsToAdd);
		return null;
	}

	//////////////////////////////////////////////////////////////////////////////
	//Define switch for collecting accessed globals in a set of GlobalDeclarations and 
	// accessed fields in a set per record TypeDeclaration
	//////////////////////////////////////////////////////////////////////////////
	
	private Unit addTypeDeclForIdtoAccessedTypeDecls(VariableRef vref) {
		if (getType.doSwitch(vref) instanceof RecordType) {
			RecordTypeDef rtd = (RecordTypeDef) ((RecordType) getType.doSwitch(vref)).getRecordDef();
			//Add the record type decl to accessedTypeDecls if it's not already there, but don't list any fields
			// since we haven't touched any specific fields.
			if (!accessedTypeDecls.containsKey(rtd)) {
				accessedTypeDecls.put(rtd, new HashSet<String>());
			}
		} else if (getType.doSwitch(vref) instanceof ArrayType) {
			ArrayTypeDef atd = (ArrayTypeDef) ((ArrayType) getType.doSwitch(vref)).getArrayDef();
			//Add the array type decl to accessedTypeDecls if it's not already there, but don't list an index
			// since we haven't touched any specific elements.
			if (!accessedTypeDecls.containsKey(atd)) {
				accessedTypeDecls.put(atd, new HashSet<String>());
			}
		}
		return Unit.UNIT;
	}
	
	@Override
	public Unit caseIdList(IdList il) {
		for (VariableRef vref : il.getIds()) {
			if (vref instanceof GlobalDeclaration) {
				accessedGlobals.add((GlobalDeclaration) vref);
			}
			addTypeDeclForIdtoAccessedTypeDecls(vref);
		}
		return Unit.UNIT;
	}
	
	@Override
	public Unit caseRecordExpr(RecordExpr re) {
		RecordTypeDef rtd = (RecordTypeDef) (re.getRecordDefinition());
		
		// Add all the fields of the RecordExpr to the set of accessed fields for this type decl. 
		Set<String> fieldsToAdd = new HashSet<String>();
		for (RecordFieldType rft : rtd.getFields()) {
			fieldsToAdd.add(rft.getFieldName());
		}
		updateAccessedFieldsOrElements(rtd, fieldsToAdd);
		
		//Call the switch on the children		
		for (RecordFieldExpr rfe : re.getFieldExprList()) {
			doSwitch(rfe.getFieldExpr());
		}
		
		return Unit.UNIT;
	}
	
	@Override
	public Unit caseArrayExpr(ArrayExpr ae) {
		ArrayTypeDef atd = (ArrayTypeDef) (ae.getArrayDefinition());
		//Mark the array type decl. as used.
		updateAccessedFieldsOrElements(atd, "used");	
		//Call the switch on the children
		for (EObject sub : ae.eContents()) {
			doSwitch(sub);
		}
		
		return Unit.UNIT;
	}
	
	@Override
	public Unit caseRecordUpdateExpr(RecordUpdateExpr rue) {
		RecordTypeDef rtd = ((RecordType) getType.doSwitch(rue.getRecord())).getRecordDef();		
		//Add the field in the RecordUpdateExpr to the set of accessed fields for the type decl.
		updateAccessedFieldsOrElements(rtd, rue.getField());		
		//Call the switch on the children
		doSwitch(rue.getRecord());
		doSwitch(rue.getValue());	
		
		return Unit.UNIT;
	}
	
	@Override
	public Unit caseArrayUpdateExpr(ArrayUpdateExpr aue) {
		ArrayTypeDef atd = ((ArrayType) getType.doSwitch(aue.getAccess().getArray())).getArrayDef();
		//Mark the array type decl. as used.
		updateAccessedFieldsOrElements(atd, "used");
		//Call the switch on the children
		for (EObject sub : aue.eContents()) {
			doSwitch(sub);
		}
		return Unit.UNIT;
	}
	
	@Override
	public Unit caseRecordAccessExpr(RecordAccessExpr rae) {
		RecordTypeDef rtd = ((RecordType) getType.doSwitch(rae.getRecord())).getRecordDef();				
		//Add the field in the RecordUpdateExpr to the set of accessed fields for the type decl.
		updateAccessedFieldsOrElements(rtd, rae.getField());
		//Call the switch on the children
		doSwitch(rae.getRecord());		
		return Unit.UNIT;
	}
	
	@Override 
	public Unit caseArrayAccessExpr(ArrayAccessExpr aue) {
		ArrayTypeDef atd = ((ArrayType) getType.doSwitch(aue.getArray())).getArrayDef();
		//Mark the array type decl. as used.
		updateAccessedFieldsOrElements(atd, "used");
		//Call the switch on the children
		for (EObject sub : aue.eContents()) {
			doSwitch(sub);
		}
		return Unit.UNIT;
	}
	
	@Override
	public Unit caseInitExpr(InitExpr ie) {
		if (ie.getId() instanceof GlobalDeclaration) {
			GlobalDeclaration gd = (GlobalDeclaration) ie.getId();
			accessedGlobals.add(gd);
		}
		addTypeDeclForIdtoAccessedTypeDecls(ie.getId());
		return Unit.UNIT;
	}
	
	@Override
	public Unit caseIdExpr(IdExpr id) {
		if (id.getId() instanceof GlobalDeclaration) {
			GlobalDeclaration gd = (GlobalDeclaration) id.getId();
			accessedGlobals.add(gd);
		}
		addTypeDeclForIdtoAccessedTypeDecls(id.getId());
		return Unit.UNIT;
	}
	
	//////////////////////////////////////////////////////////////////////////////
	// Remove the declarations of globals that are never accessed from the spec
	//////////////////////////////////////////////////////////////////////////////
	
	public Void removeUnaccessedGlobals() {
		for (GlobalDeclaration gd : globals) {
			if (!accessedGlobals.contains(gd)) {
				EcoreUtil.remove(gd);
			}
		}
		return null;
	}
	
	//////////////////////////////////////////////////////////////////////////////
	// Remove record and array type definitions that are never referenced.
	// Remove unreferenced fields from the corresponding record type definitions.
	// If none of the individual fields of a record type are referenced, add a 
	//  dummy field of boolean type.
	// If none of the elements of an array type are ever referenced, then
	//  change the base type to boolean and change the size of the array to 1.
	//////////////////////////////////////////////////////////////////////////////
	
	public Void removeUnaccessedFieldsAndElements() {
		for (TypeDeclaration td : types) {
			if (td instanceof RecordTypeDef) {
				EList<RecordFieldType> rftl = ((RecordTypeDef) td).getFields();			
				// Remove the type declaration if it is unreferenced
				if (!accessedTypeDecls.containsKey(td)) {
					EcoreUtil.remove(td);
				} else { 
					// Remove all unreferenced fields from the record type declaration
					Set<String> fieldSet = accessedTypeDecls.get(td);
					List<RecordFieldType> recordFieldTypesToRemove = new ArrayList<>();
					for (RecordFieldType rft : rftl) {
						if (!fieldSet.contains(rft.getFieldName())) {
							recordFieldTypesToRemove.add(rft);
						}
					}
					rftl.removeAll(recordFieldTypesToRemove);
					// If there are no fields left in the record type, add a dummy field of boolean type
					if (rftl.size() == 0) {
						RecordFieldType rftdummy = f.createRecordFieldType();
						rftdummy.setFieldName("dummyField");
						rftdummy.setFieldType(f.createBoolType());
						rftl.add(rftdummy);
					}
				}
			} else if (td instanceof ArrayTypeDef) {
				ArrayTypeDef atd = (ArrayTypeDef) td;
				// Remove the type declaration if it is unreferenced
				if (!accessedTypeDecls.containsKey(td)) {
					EcoreUtil.remove(td);
				} else {
					//If none of the elements of the array are referenced, 
					// change the base type to boolean and change the size of the array to 1.
					Set<String> usedQ = accessedTypeDecls.get(td);
					if (!usedQ.contains("used")) {
						atd.setBaseType(f.createBoolType());
						atd.setSize(BigInteger.ONE);
					}
				}
			} //Otherwise, td must be an AbstractTypeDef. Leave it alone for now.
		}
		return null;
	}

}
