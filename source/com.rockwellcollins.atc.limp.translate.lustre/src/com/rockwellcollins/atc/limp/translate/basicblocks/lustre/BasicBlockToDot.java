package com.rockwellcollins.atc.limp.translate.basicblocks.lustre;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * This function creates a DOT file that can be used by the graphviz suite of tools
 * to generate a PDF that shows a graphical representation of the BasicBlock linked 
 * list 
  */
public class BasicBlockToDot {
	private StringBuilder result = new StringBuilder();
	private Map<LustreBasicBlock, String> labels = new HashMap<>();
	private Set<LustreBasicBlock> done = new HashSet<>();
	private Queue<LustreBasicBlock> todo = new ArrayDeque<>();
	private int labelCounter = 0;
		
	public static void display(LustreBasicBlock start, File pdfFile) throws Exception {
		Path dot = Files.createTempFile("basicblock", ".dot");
		
		try (FileWriter writer = new FileWriter(dot.toFile())) {
			writer.write(BasicBlockToDot.convert(start));
		}
		ProcessBuilder pb = new ProcessBuilder("dot", "-Tpdf", "-o", pdfFile.toString(), dot.toString());
		pb.start().waitFor();
	}

	public static String convert(LustreBasicBlock start) {
		return new BasicBlockToDot().convertInternal(start);
	}
	
	private String convertInternal(LustreBasicBlock start) {
		result.append("digraph {\n");
		result.append("  node [shape=box];\n");

		todo.add(start);

		while (!todo.isEmpty()) {
			LustreBasicBlock curr = todo.poll();
			if(done.contains(curr)) {
				continue;
			}
			done.add(curr);

			String label = getLabel(curr);

			result.append("  " + label + " [label=\"");
			result.append("[" + Integer.toString(curr.id) + "]\\n");
			for (ExtendedEquation eeq : curr.equations) {
				result.append(eeq.equation + "\\n");
			}
			result.append("\"];\n");

			int condCounter = 0;
			for (LustreBlockEdge ce : curr.conditionalExits) {
				condCounter++;
				String expr = ce.getCondition().toString();
				String destLabel = getLabel(ce.getDestination());
				result.append("  " + label + " -> " + destLabel + " [label=\"" + condCounter + ". " + expr + "\"];\n");
				todo.add(ce.getDestination());
			}

			if (curr.unconditionalExit != null) {
				String destLabel = getLabel(curr.unconditionalExit.getDestination());
				result.append("  " + label + " -> " + destLabel + ";\n");
				todo.add(curr.unconditionalExit.getDestination());
			}
		}

		result.append("}");
		return result.toString();
	}

	public String getLabel(LustreBasicBlock block) {
		String label = labels.get(block);
		if (label == null) {
			label = "n" + labelCounter++;
			labels.put(block, label);
		}
		return label;
	}
}
