package com.rockwellcollins.atc.limp.slicer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.rockwellcollins.atc.LimpInjectorUtil;
import com.rockwellcollins.atc.LimpStandaloneSetup;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.TypeDeclaration;
import com.rockwellcollins.atc.limp.utils.SerializerUtil;

/**
 * This class serves as an entry point for the command-line
 * LimpToLustre utility.  You can use this class and create a 
 * runnable JAR by Exporting from the Eclipse workspace and 
 * following the instructions. 
  */
public class MainSlicer {

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

		Slicer myslicer = new Slicer(spec);
		myslicer.doSwitch(spec);
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Globals ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for (GlobalDeclaration gd : myslicer.getGlobals()) {
			System.out.println(SerializerUtil.EObjectToString(gd));
		}

		System.out.println();
		System.out.println();
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Types ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for (TypeDeclaration td : myslicer.getTypeDecls()) {
			System.out.println(SerializerUtil.EObjectToString(td));
		}

		System.out.println();
		System.out.println();
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Accessed Globals ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		for (GlobalDeclaration g : myslicer.getAccessedGlobals()) {
			System.out.println(SerializerUtil.EObjectToString(g));
		}

		System.out.println();
		System.out.println();
		
		System.out.println();
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Accessed Types ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		Iterator<Map.Entry<TypeDeclaration, Set<String>>> it11 = myslicer.getAccessedTypeDecls().entrySet().iterator();
		while (it11.hasNext()) {
			Map.Entry<TypeDeclaration, Set<String>> pair = (Map.Entry<TypeDeclaration, Set<String>>) it11.next();
			System.out.println(SerializerUtil.EObjectToString((EObject) pair.getKey()) + " : " + pair.getValue());
		}
		System.out.println();
		System.out.println();
		
		///////////////////////////////////////////////////////////////////////////////////
		// Remove unaccessed globals and fields and print the resulting spec to a file
		///////////////////////////////////////////////////////////////////////////////////
		myslicer.removeUnaccessedGlobals();
		myslicer.removeUnaccessedFieldsAndElements();
		
		String outfilename = getOutputFilename(filename, "sliced");
	
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outfilename))) {
			bw.write(SerializerUtil.EObjectToString(spec));
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
	/*	
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println("Sliced Spec ::");
		System.out.println("////////////////////////////////////////////////////////////////////////////");
		System.out.println(Util.EObjectToString(spec));
		System.out.println();
		System.out.println();
		*/
		System.exit(0);
	}
	
	private static String getOutputFilename(String filename, String slicerString) {
		int i = filename.lastIndexOf(".");
		String s = filename.substring(0, i) + "." + slicerString + ".limp";
		return s;
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
