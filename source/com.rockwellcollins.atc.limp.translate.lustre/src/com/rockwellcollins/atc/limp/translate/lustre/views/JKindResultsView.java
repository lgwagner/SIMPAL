package com.rockwellcollins.atc.limp.translate.lustre.views;


import jkind.api.results.JKindResult;
import jkind.api.ui.results.AnalysisResultTable;
import jkind.results.layout.Layout;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

/**
 * JKindResult is a helper class for performing analysis. 
 */
public class JKindResultsView extends ViewPart {
	public static final String ID = "com.rockwellcollins.atc.limp.translate.lustre.views.jKindResultsView";

	private AnalysisResultTable table;
	private JKindMenuListener menuListener;

	@Override
	public void createPartControl(Composite parent) {
		table = new AnalysisResultTable(parent);
		menuListener = new JKindMenuListener(this.getViewSite().getWorkbenchWindow(), table);
		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(menuListener);
		table.getControl().setMenu(manager.createContextMenu(table.getViewer().getTable()));
	}

	@Override
	public void setFocus() {
		table.getControl().setFocus();
	}

	public void setInput(JKindResult result, Layout layout) {
		table.setInput(result);
		menuListener.setLayout(layout);
	}
}
