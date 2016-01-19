package com.rockwellcollins.atc.limp.translate.main;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

import jkind.lustre.Program;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.rockwellcollins.atc.LimpInjectorUtil;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.TranslationInvariant;
import com.rockwellcollins.atc.limp.translate.lustre.transformations.PerformTransformations;
import com.rockwellcollins.atc.limp.utils.LimpUtilities;

/**
 * This class serves as an entry point for the command-line
 * LimpToLustre utility.  You can use this class and create a 
 * runnable JAR by Exporting from the Eclipse workspace and 
 * following the instructions. 
  */
public class Main {
	private static final int IMPROPER_USAGE = -1;
	private static final int FILE_NOT_FOUND = -2;
	private static final int FILE_ISNT_LIMP = -3;
	private static final int PARSE_ERRORS = -4;
	private static final int VALIDATION_ERRORS = -5;
	private static final int NO_MAIN = -6;
	private static final int UNSUPPORTED_ELEMENTS = -7;


	public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			System.err.println("Usage: limp2lustre <limpfile>");
			System.exit(IMPROPER_USAGE);
		}
		
		String filename = args[0];
		
		if (!new File(filename).exists()) {
			System.err.println("File " + filename + " not found.");
			System.exit(FILE_NOT_FOUND);
		}

		if (!filename.endsWith(".limp")) {
			System.err.println("Input file must have a .limp extension.");
			System.exit(FILE_ISNT_LIMP);
		}
		
		LimpInjectorUtil.doStandaloneSetup();
		URI uri = URI.createFileURI(filename);
		ResourceSet set = new ResourceSetImpl();

		// parse
		Resource resource = set.getResource(uri, true);
		checkParseErrors(filename, resource);
		checkValidationErrors(resource);
		Specification specification = (Specification) resource.getContents().get(0);
		

		//check if the spec uses any unsupported language elements
		if(!TranslationInvariant.check(specification)) {
			System.err.println("Spec contains unsupported language elements.");
			System.exit(UNSUPPORTED_ELEMENTS);
		}
		
		Map<String,LocalProcedure> entryPoints = LimpUtilities.getLocalProcedureMap(specification);
		if(entryPoints.isEmpty()) {
			System.err.println("File did not contain any LocalProcedures to use as an analysis entry point.");
			System.exit(NO_MAIN);
		}
				
		Specification spec = EcoreUtil2.copy(specification);

		LocalProcedure main = LimpUtilities.getMainLocalProcedure(spec);

		URI outfileURI = createOutFileName(uri, "", "lus");
		URI stringMapURI = createOutFileName(uri, "", "stringmap");
		URI pdfURI = createOutFileName(uri, "", "pdf");
		URI mangleXMLURI = createOutFileName(uri, "_mangle", "xml");
		URI programXMLURI = createOutFileName(uri, "_program", "xml");
		
		Program program = new PerformTransformations(new File(stringMapURI.toFileString()), uri, new File(pdfURI.toFileString()), new File(programXMLURI.toFileString()), new File(mangleXMLURI.toFileString())).translate(spec, main);
		
		try (FileWriter fw = new FileWriter(outfileURI.toFileString())) {
			fw.write(program.toString());			
			System.out.println("wrote " + outfileURI.toFileString());			
		}
	}

	private static void checkValidationErrors(Resource resource) {
		IResourceValidator validator = LimpInjectorUtil.getInstance(IResourceValidator.class);
		List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		boolean hasErrors = false;
		for (Issue issue : issues) {
			if (issue.getSeverity() == Severity.ERROR) {
				hasErrors = true;
			}
			System.err.println(issue.getSeverity() + ": " + issue.getUriToProblem().lastSegment() + ":" + issue.getLineNumber() + " " + issue.getMessage());
		}
		
		if (hasErrors) {
			System.exit(VALIDATION_ERRORS);
		}
	}

	private static void checkParseErrors(String filename, Resource resource) {
		if (!resource.getErrors().isEmpty()) {
			for (Diagnostic err : resource.getErrors()) {
				System.err.println(filename + ":" + err.getLine() + " "
						+ err.getMessage());
			}
			System.exit(PARSE_ERRORS);
		}
	}
		
	private static URI createOutFileName(URI uri, String suffix, String extension) {
		String filename = uri.lastSegment();
		uri = uri.trimSegments(1);
		int i = filename.lastIndexOf(".");
		uri = uri.appendSegment((filename.substring(0, i) + suffix + "." + extension));
		return uri;
	}
}
