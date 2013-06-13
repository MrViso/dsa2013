package de.unistuttgart.dsa2013.ws6;

/**
 * An interface that provides read-only access to a graph node.
 * 
 * @param <E> The value type stored in the graph.
 */
public interface ImmutableGraphNode<E> {
	
	/**
	 * Returns the value of the node.
	 * 
	 * @return the value.
	 */
	E getValue();
	
	/**
	 * Returns an enumeration of all graph nodes linked to this node with edges.
	 * 
	 * @return the linked nodes.
	 */
	Iterable<ImmutableGraphNode<E>> getLinkedNodes();
	
	/**
	 * Returns a unique identifier of the node.
	 * 
	 * @return the identifier.
	 */
	Integer getId();
}
