package de.unistuttgart.dsa2013.ws6;

/**
 * This class provides an exemplary graph.
 */
public final class ExampleGraphFactory {
	
	/**
	 * Hidden constructor.
	 */
	private ExampleGraphFactory() {
	}
	
	/**
	 * Creates a rather small example graph.
	 * 
	 * @return the example graph.
	 */
	public static ImmutableGraphNode<String> createSmallGraph() {
		SimpleGraphNode<String> nodeA = new SimpleGraphNode<String>("A");
		SimpleGraphNode<String> nodeB = new SimpleGraphNode<String>("B");
		SimpleGraphNode<String> nodeC = new SimpleGraphNode<String>("C");
		SimpleGraphNode<String> nodeD = new SimpleGraphNode<String>("D");
		SimpleGraphNode<String> nodeE = new SimpleGraphNode<String>("E");
		SimpleGraphNode<String> nodeF = new SimpleGraphNode<String>("F");
		SimpleGraphNode<String> nodeG = new SimpleGraphNode<String>("G");
		SimpleGraphNode<String> nodeH = new SimpleGraphNode<String>("H");
		
		nodeG.addEdgeTo(nodeF);
		nodeF.addEdgeTo(nodeG);
		nodeE.addEdgeTo(nodeF);
		nodeE.addEdgeTo(nodeB);
		nodeB.addEdgeTo(nodeE);
		nodeC.addEdgeTo(nodeE);
		nodeA.addEdgeTo(nodeB);
		nodeC.addEdgeTo(nodeA);
		nodeA.addEdgeTo(nodeC);
		nodeC.addEdgeTo(nodeH);
		nodeH.addEdgeTo(nodeC);
		nodeD.addEdgeTo(nodeH);
		nodeA.addEdgeTo(nodeD);
		
		return nodeA;
	}
}
