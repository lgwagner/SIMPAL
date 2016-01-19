package com.rockwellcollins.atc.limp.reasoning;

import java.io.File;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.rockwellcollins.atc.LimpInjectorUtil;
import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordFieldType;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.utils.GetVariableName;
import com.rockwellcollins.atc.limp.utils.LimpConverters;
import com.rockwellcollins.atc.limp.utils.SerializerUtil;
import com.rockwellcollins.atc.limp.utils.SimplifyExpressions;

/**
 * This class serves as an entry point for the command-line
 * LimpToLustre utility.  You can use this class and create a 
 * runnable JAR by Exporting from the Eclipse workspace and 
 * following the instructions. 
  */
public class MainProcEnvList {

	public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			System.out.println("Usage: limp2lustre <limpfile>");
			System.exit(-1);
		}
		
		String filename = args[0];
		
		if (!new File(filename).exists()) {
			System.out.println("File " + filename + " not found.");
			System.exit(-1);
		}
		
		if (!filename.endsWith(".limp")) {
			System.out.println("File must have a .limp extension.");
			System.exit(-1);
		}
		
		LimpInjectorUtil.doStandaloneSetup();
		URI uri = URI.createFileURI(filename);
		ResourceSet set = new ResourceSetImpl();

		// parse
		Resource resource = set.getResource(uri, true);
		checkParseErrors(filename, resource);
		checkValidationErrors(resource);
		Specification spec = (Specification) resource.getContents().get(0);

		//copy the spec so the world doesn't end.
		//spec = EcoreUtil2.copy(spec);
		
		GatherProcedureEnvironments gather = new GatherProcedureEnvironments();
		//StringHack stringHack = new StringHack();
		//stringHack.doSwitch(spec);
		gather.doSwitch(spec);
		
		LimpFactory f = LimpFactory.eINSTANCE;
		EqualityHelper helper = new EcoreUtil.EqualityHelper();
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Globals (Baby Step 1) ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for(GlobalDeclaration gd : gather.globals) {
			System.out.println(GetVariableName.getName(gd));
		}

		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Modified Globals by Procedure Name (Baby Step 2) ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for(ModifiedGlobals lplist : gather.getModifiedGlobalsList().getModifiedGlobalsList()) {
			System.out.print("PROCEDURE " + lplist.getLocalProcedureName().toString() + ":  ");
			System.out.println(lplist.getModifiedGlobals());
		}
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Modified Global Record Fields by Procedure Name (Baby Step 3) ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for(ModifiedGlobals lplist : gather.getModifiedGlobalsListwFields().getModifiedGlobalsList()) {
			System.out.print("PROCEDURE " + lplist.getLocalProcedureName().toString() + ":  ");
			System.out.println(lplist.getModifiedGlobals());
		}
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Modified Global Array Index Values by Procedure Name,  Where All the Terminal Expressions in the Index Expression \n are Integer Literals, Constants, or Procedure Input Arguments (Baby Step 4) ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for(ModifiedGlobals lplist : gather.getModifiedGlobalsListwIndices().getModifiedGlobalsList()) {
			System.out.print("PROCEDURE " + lplist.getLocalProcedureName().toString() + ":  ");
			System.out.println(lplist.getModifiedGlobals());
		}
			
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Modified Variables by Procedure Name with Values ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for(ProcedureEnvironment pe : gather.getProcedureEnvironmentList().getProcedureEnvironmentList()) {
			System.out.println("PROCEDURE " + pe.getLocalProcedureName().toString() + ":  ");
			Iterator<Map.Entry<VariableRef, Expr>> it = pe.pvsMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<VariableRef, Expr> pair = (Map.Entry<VariableRef, Expr>) it.next();
				System.out.println(SerializerUtil.EObjectToString((EObject) pair.getKey()) + " = " + SerializerUtil.EObjectToString((EObject) pair.getValue()));
			}
			System.out.println();
			System.out.println();
		}
		
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Modified Record Fields by Procedure Name (SE only--excludes updates in For and While statements) ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for(ProcedureEnvironment pe : gather.getProcedureEnvironmentList().getProcedureEnvironmentList()) {
			System.out.println("PROCEDURE " + pe.getLocalProcedureName().toString() + ":  ");
			Iterator<Map.Entry<VariableRef, Expr>> it = pe.pvsMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<VariableRef, Expr> pair = (Map.Entry<VariableRef, Expr>) it.next();
				SimplifyExpressions se = new SimplifyExpressions();
				IdExpr mylhsid = f.createIdExpr();
				mylhsid.setId(EcoreUtil.copy(pair.getKey()));
				
				if (se.isOfRecordType(mylhsid)) {
					
					System.out.println(SerializerUtil.EObjectToString((EObject) pair.getKey()) + ":");
					
					if (pair.getValue() instanceof RecordExpr) {
						RecordExpr re = (RecordExpr) pair.getValue();						
					
						for (RecordFieldExpr rfe : re.getFieldExprList()) {
							if (rfe.getFieldExpr() instanceof RecordAccessExpr) {
								RecordAccessExpr rae = (RecordAccessExpr) rfe.getFieldExpr();
								if (rae.getRecord() instanceof IdExpr) {
									IdExpr rhsRaeRecId = (IdExpr) rae.getRecord();
									if (helper.equals(rhsRaeRecId.getId(), mylhsid.getId()) && rae.getField().equals(rfe.getFieldName())) {
										//print nothing (no change made to this field by the procedure)
									} else {
										System.out.println(rfe.getFieldName());
									}
								} else {
									System.out.println(rfe.getFieldName());
								}
							} else {
								System.out.println(rfe.getFieldName());
							}
						}
					} else {
						EList<RecordFieldType> rftl = LimpConverters.getRecordFieldTypeList(mylhsid);
						for (RecordFieldType rft : rftl) {
							System.out.println(rft.getFieldName());
						}
					}
				}
			}
			System.out.println();
			System.out.println();
		}
		
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Modified Array Elements by Procedure Name (SE only--excludes updates in For and While statements) ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for(ProcedureEnvironment pe : gather.getProcedureEnvironmentList().getProcedureEnvironmentList()) {
			System.out.println("PROCEDURE " + pe.getLocalProcedureName().toString() + ":  ");
			Iterator<Map.Entry<VariableRef, Expr>> it = pe.pvsMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<VariableRef, Expr> pair = (Map.Entry<VariableRef, Expr>) it.next();
				SimplifyExpressions se = new SimplifyExpressions();
				IdExpr mylhsid = f.createIdExpr();
				mylhsid.setId(EcoreUtil.copy(pair.getKey()));
				
				if (se.isOfArrayType(mylhsid)) {
					
					System.out.println(SerializerUtil.EObjectToString((EObject) pair.getKey()) + ":");
					
					if (pair.getValue() instanceof ArrayExpr) {
						ArrayExpr ae = (ArrayExpr) pair.getValue();				
						
						int i = 0;
						for (Expr e : ae.getExprList()) {
							if (e instanceof ArrayAccessExpr) {
								ArrayAccessExpr aae = (ArrayAccessExpr) e;
								if (aae.getArray() instanceof IdExpr) {
									IdExpr rhsAaeArrayId = (IdExpr) aae.getArray();
									if (helper.equals(rhsAaeArrayId.getId(), mylhsid.getId())) {
										//print nothing (no change made to this element by the procedure)
									} else {
										System.out.println(i);
									}
								} else {
									//TODO: What if only some things have changed even though the array is not an IdExpr? (Think nested data structures.)
									System.out.println(i);
								}
							} else {
								//TODO: What if only some things have changed even though it's not an ArrayAccessExpr? (Think nested data structures.)
								System.out.println(i);
							}
							i++;
						}
					} else {
						BigInteger bigSize = se.getArraySize(mylhsid);
						int size = bigSize.intValue();
						for (int i = 0; i < size; i++) {
							System.out.println(i);
						}
					}
				}
			}
		
			System.out.println();
			System.out.println();
		}
		
		/*
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Modified Record Fields by Procedure Name with Values ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for(ProcedureEnvironment pe : gather.getProcedureEnvironmentList().getProcedureEnvironmentList()) {
			System.out.println("PROCEDURE " + pe.getLocalProcedureName().toString() + ":  ");
			Iterator<Map.Entry<VariableRef, Map<String,Expr>>> it = pe.getProgramEnvironment().prfMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<VariableRef, Map<String,Expr>> pair = (Map.Entry<VariableRef, Map<String,Expr>>) it.next();
				System.out.println(Util.EObjectToString((EObject) pair.getKey()));
				Iterator<Map.Entry<String, Expr>> itinner = pair.getValue().entrySet().iterator();
				while (itinner.hasNext()) {
					Map.Entry<String, Expr> pairinner = (Map.Entry<String, Expr>) itinner.next();
					System.out.println(pairinner.getKey() + " = " + Util.EObjectToString((EObject) pairinner.getValue()));
				}
				
				it.remove();
			}
			System.out.println();
		}
		*/
		System.exit(0);
	}

	private static void checkValidationErrors(Resource resource) {
		IResourceValidator validator = LimpInjectorUtil.getInstance(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		boolean hasErrors = false;
		for (Issue issue : issues) {
			if (issue.getSeverity() == Severity.ERROR) {
				hasErrors = true;
			}
			System.out.println(issue.getSeverity() + ": " + issue.getUriToProblem().lastSegment() + ":" + issue.getLineNumber() + " " + issue.getMessage());
		}
		
		if (hasErrors) {
			System.exit(-1);
		}
	}

	private static void checkParseErrors(String filename, Resource resource) {
		if (!resource.getErrors().isEmpty()) {
			for (Diagnostic err : resource.getErrors()) {
				System.out.println(filename + ":" + err.getLine() + " "
						+ err.getMessage());
			}
			System.exit(-1);
		}
	}
	
	@SuppressWarnings("unused")
	private static URI createOutFile(URI uri) {
		String filename = uri.lastSegment();
		uri = uri.trimSegments(1);
		int i = filename.lastIndexOf(".");
		uri = uri.appendSegment((filename.substring(0, i) + ".lus"));
		return uri;
	}
}
