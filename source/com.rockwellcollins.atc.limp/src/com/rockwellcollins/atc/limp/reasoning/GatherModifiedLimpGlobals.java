package com.rockwellcollins.atc.limp.reasoning;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.util.LimpSwitch;
import com.rockwellcollins.atc.limp.utils.GetVariableName;

public class GatherModifiedLimpGlobals extends LimpSwitch<Void> {

	public List<GlobalDeclaration> globals;
	public List<Statement> statements;
	public List<VariableRef> modified_variable_refs;
	public List<String> modified_variable_refs_w_proc_name;
	public List<VariableRef> modified_variable_refs_tmp;
	public List<VariableRef> modified_globals;
	public List<RecordFieldExpr> record_field_exprs;
	public List<String> modified_record_field_names;
	
	@Override
	public Void caseSpecification(Specification s) {
		globals = new ArrayList<>();
		statements = new ArrayList<>();
		modified_variable_refs_tmp = new ArrayList<>();
		modified_variable_refs = new ArrayList<>();
		modified_variable_refs_w_proc_name = new ArrayList<>();
		modified_globals = new ArrayList<>();
		record_field_exprs = new ArrayList<>();
		modified_record_field_names = new ArrayList<>();
		
		List<Declaration> decls = s.getDeclarations();
		for(Declaration d : decls) {
			this.doSwitch(d);
		}	
		
		for(VariableRef mvr : modified_variable_refs) {
			if (mvr instanceof GlobalDeclaration) {
				modified_globals.add(mvr);
			}
		}
		
		return null;
	}
	
	@Override
	public Void caseGlobalDeclaration(GlobalDeclaration gd) {
		globals.add(gd);
		return null;
	}
	
	@Override
	public Void caseLocalProcedure(LocalProcedure lp) {
		statements.clear();
		statements.addAll(lp.getStatementblock().getStatements());
		for (Statement s : statements) {
			this.doSwitch(s);
		}
		return null;
	}
	
	@Override
	public Void caseAssignmentStatement(AssignmentStatement as) {
		modified_variable_refs_tmp.clear();
		modified_variable_refs_tmp.addAll(as.getIds().getIds());
		for (VariableRef vref : modified_variable_refs_tmp) {
			// Process updates like grec2 = record animal {color = grec2.color, size = 5, species = 21, pop = 14};
			if (as.getRhs() instanceof RecordExpr) {
				record_field_exprs = (((RecordExpr) as.getRhs()).getFieldExprList());
				for (RecordFieldExpr rfe : record_field_exprs) {
					modified_record_field_names.add(((LocalProcedure) as.eContainer().eContainer()).getName() + ":  " + GetVariableName.getName(vref) + "." + rfe.getFieldName());
				}
			} else {
				//Process updates like grec1 = grec1 {color := 3} {size := 20} {pop := 6};
				if (as.getRhs() instanceof RecordUpdateExpr) {
					RecordUpdateExpr rue = (RecordUpdateExpr) as.getRhs();
					modified_record_field_names.add(((LocalProcedure) as.eContainer().eContainer()).getName() + ":  " + GetVariableName.getName(vref) + "." + rue.getField());
					// Continue processing until there are no more RecordUpdateExpr expressions.
					while (rue.getRecord() instanceof RecordUpdateExpr) {
						rue = (RecordUpdateExpr) rue.getRecord();
						modified_record_field_names.add(((LocalProcedure) as.eContainer().eContainer()).getName() + ":  " + GetVariableName.getName(vref) + "." + rue.getField());
					}		
				}
			}
		}
											
		modified_variable_refs.addAll(as.getIds().getIds());
		for (VariableRef mvr : modified_variable_refs_tmp) {
			modified_variable_refs_w_proc_name.add(((LocalProcedure) as.eContainer().eContainer()).getName() + ":  " + GetVariableName.getName(mvr));
		}
		return null;
	}
	
	@Override
	public Void defaultCase(EObject eo) {
		return null;
	}
}
