package com.rockwellcollins.atc.limp.translate.lustre.views;

import jkind.api.ui.counterexample.CounterexampleTreeViewer;
import jkind.results.Counterexample;
import jkind.results.layout.Layout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * JKindCounterexampleView is a view.
 */
public class JKindCounterexampleView extends ViewPart {
	public static final String ID = "com.rockwellcollins.atc.limp.translate.lustre.views.jKindCounterexampleView";

	private CounterexampleTreeViewer tree;

	@Override
	public void createPartControl(Composite parent) {
		tree = new CounterexampleTreeViewer(parent);
	}

	@Override
	public void setFocus() {
		tree.setFocus();
	}

	public void setInput(Counterexample cex, Layout layout) {
		tree.setInput(cex, layout);
	}
}
