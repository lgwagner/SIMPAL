package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.LabelStatement;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.LimpAST;
/**
 * RemoveControlFlow calls NormalizeStatements and creates an :END label that
 * is placed after the last statement in the program. This allows us to 
 * support return statements. 
 *
 * This pass *MUST* be run prior to creating basic blocks.
 */
public class RemoveControlFlow extends LimpSwitch<EObject> {

	public static Specification transform(Specification s) {
		return (Specification) new RemoveControlFlow().doSwitch(s);
	}
	
	@Override
	public Specification caseSpecification(Specification s) {
		for(LocalProcedure lp : EcoreUtil2.getAllContentsOfType(s, LocalProcedure.class)) {
			this.doSwitch(lp);
		}
		return s;
	}
	
	@Override
	public LocalProcedure caseLocalProcedure(LocalProcedure lp) {
		LabelStatement program_end = LimpAST.createLabel("end");
		NormalizeStatements normalize = new NormalizeStatements(program_end);
		List<Statement> statements = normalize.doSwitch(lp.getStatementblock());
		statements.add(program_end);
		StatementBlock sb = LimpAST.statementBlock(statements);
		lp.setStatementblock(sb);
		return lp;
	}
}
