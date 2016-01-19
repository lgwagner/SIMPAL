package com.rockwellcollins.atc.ui.editor.syntaxcoloring;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

public class LimpAntlrTokenToAtrributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String tokenName, int tokenType) {

		if ("RULE_SEMANTIC_COMMENT".equals(tokenName)) {
			return DefaultHighlightingConfiguration.COMMENT_ID;
		}

		return super.calculateId(tokenName, tokenType);
	}
}
