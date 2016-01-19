package com.rockwellcollins.atc.limp.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.eclipse.xtext.util.SimpleAttributeResolver;

/**
 * The default Xtext serializer requires all EObjects to be contained in
 * resources so that all cross references can be serialized with respect to file
 * structure. Since our language only has simple cross references, we can
 * override the cross reference serializer to just output the 'name' attribute
 * on an object. This lets us avoid putting all EObjects into resources.
 */
@SuppressWarnings("restriction")
public class LimpCrossReferenceSerializer implements ICrossReferenceSerializer {
	@Override
	public boolean isValid(EObject context, CrossReference crossref, EObject target, INode node,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		return true;
	}

	@Override
	public String serializeCrossRef(EObject context, CrossReference crossref, EObject target,
			INode node, ISerializationDiagnostic.Acceptor errorAcceptor) {
		return SimpleAttributeResolver.NAME_RESOLVER.apply(target);
	}
}
