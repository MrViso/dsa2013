package de.unistuttgart.dsa2013.ws6;

import java.util.EnumSet;

/**
 * Soll eine Breitensuche druchfuehren...
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-06-06 MV 1.0
 * @history 2013-06-06 MV 1.0 Erste Version
 * 
 * @param <E>
 *            Der Datentyp der in den Knoten gespeichert wird..
 */
public class WS6GraphNavigator<E> implements GraphNavigator<E> {

	enum Visited {
		UNBESUCHT,
		BESUCHT,
		ABGEARBEITET
	}
	
	class MyGraphNodeVisitor<E> implements GraphNodeVisitor<E>{

		@Override
		public void visit(ImmutableGraphNode<E> node) {
			// TODO Auto-generated method stub
			
		}
		
		/*public Visited[] nodeVisited = Visited[];
		
		@Override
		public void visit(ImmutableGraphNode<E> node) {
			if (getNodeVisited()[node.getId()] == Visited.UNBESUCHT){
				getNodeVisited()[node.getId()] = Visited.BESUCHT;			
			}
			else if (getNodeVisited()[node.getId()] == Visited.BESUCHT){
				getNodeVisited()[node.getId()] = Visited.ABGEARBEITET;
			}
		}*/

		
	}
	
	/**
	 * Tiefensuche .. Fuehrt auf den eingehenden Startnode visitor.visit aus,
	 * damit dieser markiert wird und ruft daraufhin rekursiv alle Kinder auf.
	 * 
	 * @param initialNode
	 *            Ist der zu untersuchende Knoten
	 * @param visitor
	 *            Speichert den Besuchsstatus der Knoten
	 * @throws IllegalArgumentException
	 */
	public void traverse(ImmutableGraphNode<E> initialNode,
			MyGraphNodeVisitor<E> visitor) throws IllegalArgumentException {

		/*if (initialNode == null || visitor == null)
			throw new IllegalArgumentException("Eingehende Parameter sind null");

		visitor.visit(initialNode);
		for (ImmutableGraphNode<E> linkedNode : initialNode.getLinkedNodes()) {
			if (visitor.nodeVisited[linkedNode.getId()] == visitor.Visited
			traverse(linkedNode, visitor);
		}*/

	}

	/**
	 * Gibt einfach an, dass die Methode Tiefensuche ist.
	 */
	public TraversalMethod getTraversalMethod() {
		return TraversalMethod.DEPTH_FIRST;
	}

	@Override
	public void traverse(ImmutableGraphNode<E> initialNode,
			GraphNodeVisitor<E> visitor) {
		// TODO Auto-generated method stub
		
	}

}
