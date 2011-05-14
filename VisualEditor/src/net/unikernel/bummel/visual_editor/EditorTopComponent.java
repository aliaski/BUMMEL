/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.unikernel.bummel.visual_editor;

import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.handler.mxKeyboardHandler;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxMultiplicity;
import java.util.Arrays;
import net.unikernel.bummel.jgraph.ElementModel;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//net.unikernel.bummel.visual_editor//Editor//EN",
					 autostore = false)
@TopComponent.Description(preferredID = "EditorTopComponent",
						  //iconBase="SET/PATH/TO/ICON/HERE", 
						  persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "net.unikernel.bummel.visual_editor.EditorTopComponent")
@ActionReference(path = "Menu/Window", position = 0)
@TopComponent.OpenActionRegistration(displayName = "#CTL_NewEditorAction"/*,
									 preferredID = "EditorTopComponent"*/)
public final class EditorTopComponent extends TopComponent
{
	/**
	 * Counter of opened top components.
	 */
	static int counter = 0;
	public EditorTopComponent()
	{
		initComponents();
		setName(NbBundle.getMessage(EditorTopComponent.class, "CTL_EditorTopComponent", ++counter));
		setToolTipText(NbBundle.getMessage(EditorTopComponent.class, "HINT_EditorTopComponent"));
		//putClientProperty(TopComponent.PROP_CLOSING_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_DRAGGING_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_MAXIMIZATION_DISABLED, Boolean.TRUE);
		putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);
		
		
		mxGraph graph = graphComponent.getGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			ElementModel em1 = new ElementModel("Hello", new mxGeometry(20, 20, 100, 100), "", 2, 1);
			ElementModel em2 = new ElementModel("Hello", new mxGeometry(200, 20, 100, 100), "", 2, 1);
			graph.addCell(em1, parent);
			graph.addCell(em2, parent);
			
			graph.insertEdge(parent, null, "", em1.getOutputPort(0), em2.getInputPort(0));
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxMultiplicity[] multiplicities = new mxMultiplicity[3];

	
		// Output nodes needs 1..2 connected Inputs
		multiplicities[0] = new mxMultiplicity(true, "Output", null, null, 0,
				null, Arrays.asList(new String[] { "Input" }),
				"", //"Output Must Connect to 0 or 'n' Inputs",	//if to specify this then mfGraph.java: 4987 - there is no control check for unlimited
				"Output Must Connect to Input", true);
		// Output node does not want any incoming connections
		multiplicities[1] = new mxMultiplicity(false, "Output", null, null, 0,
				"0", null, "Output Must Have No Incoming Edge", null, true); // Type does not matter
		// Input needs one or no incoming connection from Output
		multiplicities[2] = new mxMultiplicity(false, "Input", null, null, 0,
				"1", Arrays.asList(new String[] { "Output" }),
				"Input Must Have 1 Output", "Input Must Connect From Output",
				true);

		graph.setMultiplicities(multiplicities);

		//graphComponent = new mxGraphComponent(graph);
		//graphComponent.setGraph(graph);
		graph.setMultigraph(false);
		graph.setAllowDanglingEdges(false);
		graphComponent.setConnectable(true);
		graphComponent.setToolTips(true);

		// Enables rubberband selection
		new mxRubberband(graphComponent);
		new mxKeyboardHandler(graphComponent);

		// Installs automatic validation (use editor.validation = true
		// if you are using an mxEditor instance)
		graph.getModel().addListener(mxEvent.CHANGE, new mxIEventListener()
		{
			@Override
			public void invoke(Object sender, mxEventObject evt)
			{
				graphComponent.validateGraph();
				//System.out.println(evt.getName());
			}
		});

		// Initial validation
		graphComponent.validateGraph();
	}
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphComponent = new com.mxgraph.swing.mxGraphComponent();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graphComponent, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graphComponent, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mxgraph.swing.mxGraphComponent graphComponent;
    // End of variables declaration//GEN-END:variables
	@Override
	public void componentOpened()
	{
		// TODO add custom code on component opening
	}
	@Override
	public void componentClosed()
	{
		counter--;
		// TODO add custom code on component closing
	}
	void writeProperties(java.util.Properties p)
	{
		// better to version settings since initial version as advocated at
		// http://wiki.apidesign.org/wiki/PropertyFiles
		p.setProperty("version", "1.0");
		// TODO store your settings
	}
	void readProperties(java.util.Properties p)
	{
		String version = p.getProperty("version");
		// TODO read your settings according to their version
	}
}
