package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.BreakStatement;
import com.rockwellcollins.atc.limp.ContinueStatement;
import com.rockwellcollins.atc.limp.ElseBlock;
import com.rockwellcollins.atc.limp.ElseIf;
import com.rockwellcollins.atc.limp.ForStatement;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.LabelStatement;
import com.rockwellcollins.atc.limp.NoElse;
import com.rockwellcollins.atc.limp.ReturnStatement;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.WhileStatement;
import com.rockwellcollins.atc.limp.exceptions.UnexpectedException;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.LimpAST;
/**
 * NormalizeStatements turns all control flow statements
 *  
 *  IfThenElse
 *  While
 *  For
 *  Break
 *  Continue
 *  Return
 *  
 *  Into an equivalent program using only
 *  
 *  AssignmentStatement
 *  VoidStatement
 *  GotoStatement
 *  LabelStatement
 *  
 *  Essentially it is spaghetti code. This is executed before we RemoveControl flow and is
 *  a necessary component to creating basic blocks.
 */
public class NormalizeStatements extends LimpSwitch<List<Statement>> {

	private Integer labelSuffix = 0;
	private Set<String> labelIds;
	
	private LabelStatement currentBreakTarget;
	private LabelStatement currentContinueTarget;
	private LabelStatement endTarget;
	
	public NormalizeStatements(LabelStatement program_end) {
		labelIds = new HashSet<>();
		this.endTarget = program_end; 
	}
	
	private void incrementSuffix() {
		labelSuffix++;
	}
	
	private String getUnusedName() {
		String name = "label_" + Integer.toString(labelSuffix);
		incrementSuffix();
		if(labelIds.contains(name)) {
			return getUnusedName();
		} else {
			return name;
		}
	}
	
	@Override
	public List<Statement> caseStatementBlock(StatementBlock sb) {
		List<Statement> statements = new ArrayList<>();
		for(Statement s : sb.getStatements()) {
			List<Statement> st = this.doSwitch(s);
			statements.addAll(st);
		}
		return statements;
	}
	
	@Override
	public List<Statement> caseAssignmentStatement(AssignmentStatement as) {
		List<Statement> statements = new ArrayList<>();
		statements.add(as);
		return statements;
	}
	
	@Override
	public List<Statement> caseVoidStatement(VoidStatement vs) {
		List<Statement> statements = new ArrayList<>();
		statements.add(vs);
		return statements;
	}

	
	@Override
	public List<Statement> caseIfThenElseStatement(IfThenElseStatement ites) {
		List<Statement> statements = new ArrayList<>();
		
		LabelStatement thenLabel = LimpAST.createLabel(this.getUnusedName());
		LabelStatement elseLabel = LimpAST.createLabel(this.getUnusedName());
		LabelStatement endLabel = LimpAST.createLabel(this.getUnusedName());
		
		List<Statement> conditionalStatements = new ArrayList<>();
		conditionalStatements.add(LimpAST.createConditionalGoto(thenLabel, EcoreUtil2.copy(ites.getCond())));
		conditionalStatements.add(LimpAST.createUnconditionalGoto(elseLabel));
		
		List<Statement> thenStatements = new ArrayList<>();
		thenStatements.add(thenLabel);
		thenStatements.addAll(this.doSwitch(ites.getThenBlock()));
		thenStatements.add(LimpAST.createUnconditionalGoto(endLabel));
		
		List<Statement> elseStatements = new ArrayList<>();
		if (ites.getElse() instanceof ElseBlock) {
			ElseBlock elseBlock = (ElseBlock) ites.getElse();
			elseStatements.add(elseLabel);
			elseStatements.addAll(this.doSwitch(elseBlock.getBlock()));
			elseStatements.add(LimpAST.createUnconditionalGoto(endLabel));
		}
		
		if (ites.getElse() instanceof NoElse) {
			elseStatements.add(elseLabel);
			elseStatements.add(LimpAST.createUnconditionalGoto(endLabel));
		}

		if (ites.getElse() instanceof ElseIf) {
			throw new UnexpectedException("ElseIfs should be removed by RemoveForStatements pass prior to this.");
		}
		
		statements.addAll(conditionalStatements);
		statements.addAll(thenStatements);
		statements.addAll(elseStatements);
		statements.add(endLabel);
		return statements;
	}
	
	@Override
	public List<Statement> caseWhileStatement(WhileStatement ws) {
		List<Statement> statements = new ArrayList<>();
		
		LabelStatement conditionLabel = LimpAST.createLabel(getUnusedName());
		LabelStatement bodyLabel = LimpAST.createLabel(getUnusedName());
		LabelStatement endLabel = LimpAST.createLabel(getUnusedName());
		
		LabelStatement oldBreakTarget = this.currentBreakTarget;
		LabelStatement oldContinueTarget = this.currentContinueTarget;
		this.currentBreakTarget = endLabel;
		this.currentContinueTarget = conditionLabel;
		
		List<Statement> conditionBlock = new ArrayList<>();
		conditionBlock.add(conditionLabel);
		conditionBlock.add(LimpAST.createConditionalGoto(bodyLabel, ws.getCond()));
		conditionBlock.add(LimpAST.createUnconditionalGoto(endLabel));
		
		List<Statement> bodyBlock = new ArrayList<>();
		bodyBlock.add(bodyLabel);
		bodyBlock.addAll(this.doSwitch(ws.getBlock()));
		bodyBlock.add(LimpAST.createUnconditionalGoto(conditionLabel));
		
		statements.addAll(conditionBlock);
		statements.addAll(bodyBlock);
		statements.add(endLabel);
		
		this.currentBreakTarget = oldBreakTarget;
		this.currentContinueTarget = oldContinueTarget;
		return statements;
	}
	
	@Override
	public List<Statement> caseForStatement(ForStatement fs) {
		List<Statement> statements = new ArrayList<>();

		LabelStatement conditionLabel = LimpAST.createLabel(getUnusedName());
		LabelStatement bodyLabel = LimpAST.createLabel(getUnusedName());
		LabelStatement iteratorLabel = LimpAST.createLabel(getUnusedName());
		LabelStatement endLabel = LimpAST.createLabel(getUnusedName());

		LabelStatement oldBreakTarget = this.currentBreakTarget;
		LabelStatement oldContinueTarget = this.currentContinueTarget;
		this.currentBreakTarget = endLabel;
		this.currentContinueTarget = iteratorLabel;

		List<Statement> initializeBlock = new ArrayList<>();
		initializeBlock.add(fs.getInitStatement());
		initializeBlock.add(LimpAST.createUnconditionalGoto(conditionLabel));
		
		List<Statement> conditionBlock = new ArrayList<>();
		conditionBlock.add(conditionLabel);
		conditionBlock.add(LimpAST.createConditionalGoto(bodyLabel,fs.getLimitExpr()));
		conditionBlock.add(LimpAST.createUnconditionalGoto(endLabel));
		
		List<Statement> bodyBlock = new ArrayList<>();
		bodyBlock.add(bodyLabel);
		bodyBlock.addAll(this.doSwitch(fs.getBlock()));
		bodyBlock.add(LimpAST.createUnconditionalGoto(iteratorLabel));
		
		List<Statement> incrementBlock = new ArrayList<>();
		incrementBlock.add(iteratorLabel);
		incrementBlock.add(fs.getIncrementStatement());
		incrementBlock.add(LimpAST.createUnconditionalGoto(conditionLabel));
		
		statements.addAll(initializeBlock);
		statements.addAll(conditionBlock);
		statements.addAll(bodyBlock);
		statements.addAll(incrementBlock);
		statements.add(endLabel);
		
		this.currentBreakTarget = oldBreakTarget;
		this.currentContinueTarget = oldContinueTarget;
		return statements;
	}
	
	@Override
	public List<Statement> caseReturnStatement(ReturnStatement rs) {
		return Collections.singletonList((Statement) LimpAST.createUnconditionalGoto(this.endTarget));
	}
	
	@Override
	public List<Statement> caseBreakStatement(BreakStatement bs) {
		return Collections.singletonList((Statement) LimpAST.createUnconditionalGoto(this.currentBreakTarget));
	}
	
	@Override
	public List<Statement> caseContinueStatement(ContinueStatement cs) {
		return Collections.singletonList((Statement) LimpAST.createUnconditionalGoto(this.currentContinueTarget));
	}
	
	@Override
	public List<Statement> caseStatement(Statement s) {
		return Collections.singletonList(s);
	}
}
