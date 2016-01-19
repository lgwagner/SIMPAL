package com.rockwellcollins.atc.limp.translate.lustre.limp2lustre;

import java.util.List;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.ChoiceExpr;
import com.rockwellcollins.atc.limp.IntegerWildCardExpr;
import com.rockwellcollins.atc.limp.SecondInit;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.util.LimpSwitch;

/**
 * This class will contain checks to ensure the source file is suitable for translation.
 * 
 * returns True if it compatible, False if incompatible.
 */
public class TranslationInvariant extends LimpSwitch<Boolean> {
	
	public static boolean check(Specification s) {
		return new TranslationInvariant().doSwitch(s);
	}
	
	@Override
	public Boolean caseSpecification(Specification s) {
		
		//checking for unsupported Exprs
		List<ChoiceExpr> choiceExprs = EcoreUtil2.getAllContentsOfType(s,ChoiceExpr.class);
		List<SecondInit> secondInitExprs = EcoreUtil2.getAllContentsOfType(s,SecondInit.class);
		List<IntegerWildCardExpr> wildCardExprs = EcoreUtil2.getAllContentsOfType(s, IntegerWildCardExpr.class);
		
		int number_of_unsupporteds = 
				choiceExprs.size() + 
				secondInitExprs.size() +
				wildCardExprs.size();

		return number_of_unsupporteds == 0;
	}
}
