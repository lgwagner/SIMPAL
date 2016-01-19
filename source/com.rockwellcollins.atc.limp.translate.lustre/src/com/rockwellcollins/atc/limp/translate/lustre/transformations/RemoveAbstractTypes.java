package com.rockwellcollins.atc.limp.translate.lustre.transformations;

import org.eclipse.xtext.EcoreUtil2;

import com.rockwellcollins.atc.limp.AbstractType;
import com.rockwellcollins.atc.limp.AbstractTypeDef;
import com.rockwellcollins.atc.limp.IntegerType;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.Specification;
/**
 * RemoveAbstractTypes removes all abstract types and replaces them as integer types.
 * This sort of abstraction seems to work for abstract analysis but it's very coarse and 
 * not appropriate for many situations. 
 */
public class RemoveAbstractTypes {

	public static Specification transform(Specification s) {
		for (AbstractType at : EcoreUtil2.getAllContentsOfType(s, AbstractType.class)) {
			IntegerType it = LimpFactory.eINSTANCE.createIntegerType();
			EcoreUtil2.replace(at, it);
		}

		for (AbstractTypeDef atd : EcoreUtil2.getAllContentsOfType(s, AbstractTypeDef.class)) {
			EcoreUtil2.remove(atd);
		}
		return s;
	}
}
