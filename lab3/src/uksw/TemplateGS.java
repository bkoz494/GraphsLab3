package uksw;

import java.util.Random;

import org.graphstream.algorithm.Toolkit;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class TemplateGS {
	
	SingleGraph myGraph;
	Random alea;
	
	/**
	 * Constructor of the class
	 * @param args
	 */
	public TemplateGS(String[] args) {
//		fullConnectedGraph(20);
		treeGenerate(300);
	}
	
	
	private void fullConnectedGraph (int n){
		myGraph = new SingleGraph("full-connected");
		myGraph.display();
		//creation of nodes
		for(int i = 0; i<n; i++) {
			myGraph.addNode("n_"+i);
		}
		//creation of edges
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				myGraph.addEdge("E:"+i+"-"+j, "n_"+i, "n_"+j);
			}
		}
	}
	
	private void treeGenerate(int n) {
		myGraph = new SingleGraph("tempale-graph");
		myGraph.display();
		float changeColor = (float)255/(float)n;
		float currentColor = 255;
		myGraph.addNode("0").addAttribute("ui.style", "fill-color:#ff0000;");
		for(Integer i=1; i<n; i++) {
			currentColor -= changeColor;
			String stringColor = Integer.toHexString((int)currentColor);
			if(stringColor.length() == 1) stringColor = "0"+stringColor;
			
			Tools.pause(100);
			Node v = Toolkit.randomNode(myGraph);
			Node w = myGraph.addNode(i.toString());
			w.addAttribute("ui.style", "fill-color:#"+stringColor+"0000;");
			myGraph.addEdge(v.getId()+w.getId(), v, w);
		}
	}
	
	/**
	 * the main just chooses the viewer and instantiates the class
	 * @param args
	 */
	public static void main(String[] args) {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        new TemplateGS(args);
	}

}