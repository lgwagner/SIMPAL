package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.ElseBlock;
import com.rockwellcollins.atc.limp.ElseIf;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.Specification;
/**
 * RemoveElseIfs removes ElseIfs and replaces them with embedded Ifs.
 * ElseIfs are nice to support syntactically but they make some transformations
 * more difficult.
 * 
 * So we remove them.
 * 
 * if (w > 0) then {
 * 	x = 1;
 * } else if (w == 0) then {
 *  y = 1;
 * else {
 * 	z = 1;
 * }
 * 
 *  becomes
 * 
 * if (w > 0) then {
 *  x = 1;
 * } else {
 *  if (w == 0) then {
 *  	y = 1;
 *  } else {
 *      z = 1;
 *  }
 * }
 * 
 */
public class RemoveElseIfs {

	private static ElseBlock createEmptyElseBlock() {
		ElseBlock elseBlock = LimpFactory.eINSTANCE.createElseBlock();
		elseBlock.setBlock(LimpFactory.eINSTANCE.createStatementBlock());
		return elseBlock;
	}
	
	public static Specification transform(Specification s) {
		for(ElseIf elseIf : EcoreUtil2.getAllContentsOfType(s, ElseIf.class)) {
			ElseBlock elseBlock = RemoveElseIfs.createEmptyElseBlock();
			elseBlock.getBlock().getStatements().add(elseIf.getIfThenElse());
			EcoreUtil2.replace(elseIf, elseBlock);
		}
		return s;
	}
}
