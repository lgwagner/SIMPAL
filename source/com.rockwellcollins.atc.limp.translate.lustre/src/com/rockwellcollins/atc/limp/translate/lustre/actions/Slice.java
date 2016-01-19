package com.rockwellcollins.atc.limp.translate.lustre.actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Injector;
import com.rockwellcollins.atc.LimpInjectorUtil;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.slicer.Slicer;
import com.rockwellcollins.atc.limp.utils.LimpUtilities;
import com.rockwellcollins.atc.ui.internal.LimpActivator;

/**
 * This class provides the functionality behind the pull-down
 * "Translate To Lustre" menu found in the Eclipse version of the Limp
 * utilities.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class Slice implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	/**
	 * The action has been activated. The argument of the method represents the
	 * 'real' action sitting in the workbench UI.
	 * 
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		LimpInjectorUtil.setInjector(LimpActivator.getInstance().getInjector(LimpActivator.COM_ROCKWELLCOLLINS_ATC_LIMP));
		
		IEditorPart editor = window.getActivePage().getActiveEditor();
		if (!(editor instanceof XtextEditor)) {
			MessageDialog.openError(window.getShell(), "Error", "Only Limp files can be translated to Lustre.");
			return;
		}

		XtextEditor xte = (XtextEditor) editor;
		IXtextDocument doc = xte.getDocument();

		doc.readOnly(new IUnitOfWork<Void, XtextResource>() {

			@Override
			public java.lang.Void exec(XtextResource state) throws Exception {

				Specification specification = (Specification) state.getContents().get(0);

				if(hasErrors(specification.eResource())) {
					MessageDialog.openError(window.getShell(), "Error", "Specification has errors.");
					return null;
				}
				
				LocalProcedure main = LimpUtilities.getMainLocalProcedure(specification);
				if(main == null) {
					MessageDialog.openError(window.getShell(), "Error", "Specification must contain at least one LocalProcedure.");
					return null;
				}
				
				Specification spec = EcoreUtil.copy(specification);
				spec = Slicer.transform(spec);
				
				// pretty print the Lustre specification
				URI final_uri = createURI(state.getURI(), ".sliced.limp");
				
				ResourceSet set = new ResourceSetImpl();
				Resource res = set.createResource(final_uri);
				res.getContents().add(spec);
				res.save(null);

				// refresh the workspace
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
				
				return null;
			}
		});
	}

	protected boolean hasErrors(Resource res) {
		Injector injector = LimpActivator.getInstance().getInjector(LimpActivator.COM_ROCKWELLCOLLINS_ATC_LIMP);
		IResourceValidator resourceValidator = injector.getInstance(IResourceValidator.class);
		
		for (Issue issue : resourceValidator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl)) {
			if (issue.getSeverity() == Severity.ERROR) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	private void printResource(IResource res, String contents) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(res.getRawLocation().toFile()))) {
			bw.write(contents);	
		}
	}

	private URI createURI(URI baseURI, String extension) {
		String filename = baseURI.lastSegment();
		baseURI = baseURI.trimSegments(1);
		int i = filename.lastIndexOf(".");
		baseURI = baseURI.appendSegment((filename.substring(0, i) + extension));
		return baseURI;
	}

	/**
	 * Selection in the workbench has been changed. We can change the state of
	 * the 'real' action here if we want, but this can only happen after the
	 * delegate has been created.
	 * 
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system resources we previously
	 * allocated.
	 * 
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to be able to provide parent shell
	 * for the message dialog.
	 * 
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}