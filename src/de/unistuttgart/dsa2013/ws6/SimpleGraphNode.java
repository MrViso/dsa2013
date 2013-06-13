package de.unistuttgart.dsa2013.ws6;

import java.util.ArrayList;

/**
 * A simple graph node class.
 *
 * @param <E> The data type stored in the nodes of the graph.
 */
public class SimpleGraphNode<E> implements ImmutableGraphNode<E> {
	
	/**
	 * Initializes a new instance.
	 * 
	 * @param value the value stored in the new node.
	 * @throws IllegalArgumentException if value is null.
	 */
	public SimpleGraphNode(E value) {
		if (value == null) {
			throw new IllegalArgumentException("value must not be null.");
		}
		
		this.value = value;
	}
	
	/**
	 * The value stored in the node.
	 */
	private final E value;
	
	/**
	 * Returns the value of the node.
	 * 
	 * @return the value.
	 */
	public E getValue() {
		return value;
	}
	
	/**
	 * The internal list of linked nodes.
	 */
	private final ArrayList<SimpleGraphNode<E>> linkedNodes = new ArrayList<SimpleGraphNode<E>>();
	
	/**
	 * Adds an edge to a graph node.
	 * 
	 * @param linkedNode the graph node to link to.
	 * @throws IllegalArgumentException if linkedNode is null.
	 */
	public void addEdgeTo(SimpleGraphNode<E> linkedNode) {
		if (linkedNode == null) {
			throw new IllegalArgumentException("linkedNode must not be null.");
		}
		
		linkedNodes.add(linkedNode);
	}
	
	/**
	 * Returns an enumeration of all graph nodes linked to this node with edges.
	 * 
	 * @return the linked nodes.
	 */
	public Iterable<ImmutableGraphNode<E>> getLinkedNodes() {
		return new ArrayList<ImmutableGraphNode<E>>(linkedNodes);
	}
	
	/**
	 * The next ID that will be assigned to a node.
	 */
	private static int nextId = 0;
	
	/**
	 * The ID of the current graph node.
	 */
	private final int id = nextId++;
	
	/**
	 * Returns a unique identifier of the node.
	 * 
	 * @return the identifier.
	 */
	public Integer getId() {
		return id;
	}
}
