package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import jkind.lustre.Program;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.slicer.Slicer;
import com.rockwellcollins.atc.limp.translate.basicblocks.limp.BasicBlock;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.LimpToLustre;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.MangleList;
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.Pair;
import com.rockwellcollins.atc.limp.translate.lustre.transformations.RemoveAbstractTypes;
import com.rockwellcollins.atc.limp.translate.lustre.transformations.RemoveControlFlow;
import com.rockwellcollins.atc.limp.translate.lustre.transformations.RemoveElseIfs;
import com.rockwellcollins.atc.limp.translate.lustre.transformations.RemoveLustreKeywords;
import com.rockwellcollins.atc.limp.translate.lustre.transformations.RemoveStrings;
import com.rockwellcollins.atc.limp.translate.lustre.transformations.RemoveUnspecifiedConstants;
import com.rockwellcollins.atc.limp.utils.ImportExpansion;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class PerformTransformations {

	public PerformTransformations(File stringMapFile, URI uri, File pdfFile,
			File programXMLFile, File mangleXMLFile) {
		super();
		this.stringMapFile = stringMapFile;
		this.uri = uri;
		this.pdfFile = pdfFile;
		this.programXMLFile = programXMLFile;
		this.mangleXMLFile = mangleXMLFile;
		this.createDebugFiles = false;
	}


	File stringMapFile;
	URI uri;
	File pdfFile;
	File programXMLFile;
	File mangleXMLFile;
	Boolean createDebugFiles;
	
	
	public Program translate(Specification specification, LocalProcedure main) throws Exception, IOException {
		int idx = 0;
		
		Specification spec = EcoreUtil2.copy(specification);	
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);
 				
		/* the ordering of these transformations should be preserved
		 * especially using ImportExpansion as the first transform */
		spec = ImportExpansion.transform(spec,main);
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);
		
		spec = Slicer.transform(spec);
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);
		
		spec = RemoveUnspecifiedConstants.transform(spec);
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);
				
		RemoveLustreKeywords removeLustreKeywords = new RemoveLustreKeywords();
		spec = removeLustreKeywords.transform(spec);
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);
		MangleList rlkMangleList = removeLustreKeywords.getMangleList();
		
		spec = RemoveAbstractTypes.transform(spec);
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);
		
		spec = RemoveElseIfs.transform(spec);
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);
		
		//Remove Strings needs to provide the updated spec and the map.
		RemoveStrings removeStrings = new RemoveStrings();
		spec = removeStrings.transform(spec);
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);
		try (FileWriter writer = new FileWriter(stringMapFile)) {
			writer.write(RemoveStrings.mapToString(removeStrings.map));
			System.out.println("wrote " + stringMapFile.toString());
		}
		MangleList remStringsMangleList = removeStrings.getMangleList();
		
		/* This must be the last transform */
		spec = RemoveControlFlow.transform(spec);
		printLimpFile(getOutputURI(uri, Integer.toString(idx++)), spec);

		MangleList l2lMangleList = new MangleList();
		Pair<BasicBlock, Program> pair = LimpToLustre.translate(spec, pdfFile, l2lMangleList);
		Program program = pair.y;
		System.out.println("wrote " + pdfFile.toString());
		
		// Write the Lustre Program object to an xml file for future processing
		XStream xstream = new XStream(new DomDriver());
		xstream.setMode(XStream.XPATH_ABSOLUTE_REFERENCES);
		
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(programXMLFile), "UTF-8")) {
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			writer.write(xstream.toXML(program));
			System.out.println("wrote " + programXMLFile.toString());
		}
		
		 Map<String, Object> outMap = new LinkedHashMap<>();
		 outMap.put("mangleList-Limp2Lustre", l2lMangleList);
		 outMap.put("mangleList-RemoveStrings", remStringsMangleList);
		 outMap.put("mangleList-RemoveLustreKeywords", rlkMangleList);
		 
		 try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(mangleXMLFile), "UTF-8")) {
			 writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
			 writer.write(xstream.toXML(outMap));
			 System.out.println("wrote " + mangleXMLFile.toString());
		 }

		return program;
	}
	
	private void printLimpFile(URI uri, Specification s) throws Exception {
		if (createDebugFiles) {
			Resource res = new ResourceSetImpl().createResource(uri);
			res.getContents().add(s);
			res.save(null);
		}
	}
	
	private static URI getOutputURI(URI uri, String pass) {
		String filename = uri.lastSegment();
		uri = uri.trimSegments(1);
		int i = filename.lastIndexOf(".");
		if(pass != null) {
			uri = uri.appendSegment(filename.substring(0, i) + "." + pass + ".limp");	
		} else {
			uri = uri.appendSegment(filename.substring(0, i) + ".final.limp");
		}
		return uri;
	}
}


