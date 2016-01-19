package com.rockwellcollins.atc.limp.translate.lustre.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
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
import com.rockwellcollins.atc.limp.translate.lustre.limp2lustre.TranslationInvariant;
import com.rockwellcollins.atc.limp.translate.lustre.transformations.PerformTransformations;
import com.rockwellcollins.atc.limp.translate.lustre.views.JKindResultsView;
import com.rockwellcollins.atc.limp.utils.LimpUtilities;
import com.rockwellcollins.atc.ui.internal.LimpActivator;

import jkind.api.JKindApi;
import jkind.api.results.JKindResult;
import jkind.lustre.Program;
import jkind.results.layout.Layout;
import jkind.results.layout.NodeLayout;


/**
 * This class provides the functionality behind the pull-down
 * "Translate To Lustre" menu found in the Eclipse version of the Limp
 * utilities.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class TranslateLimp2Lustre implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;

	/**
	 * The action has been activated. The argument of the method represents the
	 * 'real' action sitting in the workbench UI.
	 * 
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	@Override
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
				
				if(!TranslationInvariant.check(specification)) {
					MessageDialog.openError(window.getShell(), "Error", "Specification contains unsupported elements.");
				}
				
				LocalProcedure main = LimpUtilities.getMainLocalProcedure(specification);
				if(main == null) {
					MessageDialog.openError(window.getShell(), "Error", "Specification must contain at least one LocalProcedure.");
					return null;
				}
				
				URI final_uri = createURI(state.getURI(), "", "lus");
				URI final_map = createURI(state.getURI(), "", "stringmap");
				URI final_pdf = createURI(state.getURI(), "", "pdf");
				URI programXML = createURI(state.getURI(), "_program", "xml");				
				URI mangleXML = createURI(state.getURI(), "_mangle", "xml");
				
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IResource finalResource = root.getFile(new Path(final_uri.toPlatformString(true)));
				IResource finalStringMap = root.getFile(new Path(final_map.toPlatformString(true)));
				IResource finalPDFResource = root.getFile(new Path(final_pdf.toPlatformString(true)));
				IResource programXMLResource = root.getFile(new Path(programXML.toPlatformString(true)));
				IResource mangleXMLResource = root.getFile(new Path(mangleXML.toPlatformString(true)));
				
				Program p = new PerformTransformations(finalStringMap.getLocation().toFile(), state.getURI(), finalPDFResource.getLocation().toFile(), programXMLResource.getLocation().toFile(), mangleXMLResource.getLocation().toFile()).translate(specification, main);

				// pretty print the Lustre specification
				printResource(finalResource, p.toString());

				// refresh the workspace
				root.refreshLocal(IResource.DEPTH_INFINITE, null);
				
				// compute results and print them to the Results view
				JKindApi api = getCustomJKindApi();
				JKindResult result = new JKindResult("result", p.getMainNode().properties);
				IProgressMonitor monitor = new NullProgressMonitor();
				showView(result, new NodeLayout(p));
				try {
					api.execute(p, result, monitor);
				} catch (Exception e) {
					System.err.println(result.getText());
					throw e;
				}
				return null;
			}
		});
	}

	private static JKindApi getCustomJKindApi() throws Exception {
		URL fileUrl = FileLocator.toFileURL(new URL("platform:/plugin/com.rockwellcollins.atc.limp.translate.lustre/dependencies/jkind-functions.jar"));
		final File jarFile = new File(fileUrl.toURI());
		return new JKindApi() {
			@Override
			protected File findJKindJar() {
				return jarFile;
			}
		};
	}
	
	private void showView(final JKindResult result, final Layout layout) {
		window.getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				try {
					JKindResultsView page = (JKindResultsView) window.getActivePage().showView(JKindResultsView.ID);
					page.setInput(result, layout);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
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
	
	private void printResource(IResource res, String contents) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(res.getRawLocation().toFile()))) {
			bw.write(contents);	
		}
	}

	private static URI createURI(URI baseURI, String suffix, String extension) {
		String filename = baseURI.lastSegment();
		baseURI = baseURI.trimSegments(1);
		int i = filename.lastIndexOf(".");
		baseURI = baseURI.appendSegment((filename.substring(0, i) + suffix + "." + extension));
		return baseURI;
	}


	/**
	 * Selection in the workbench has been changed. We can change the state of
	 * the 'real' action here if we want, but this can only happen after the
	 * delegate has been created.
	 * 
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system resources we previously
	 * allocated.
	 * 
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	@Override
	public void dispose() {
	}

	/**
	 * We will cache window object in order to be able to provide parent shell
	 * for the message dialog.
	 * 
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}