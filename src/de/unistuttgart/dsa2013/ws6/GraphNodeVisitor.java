package de.unistuttgart.dsa2013.ws6;

/**
 * An interface for classes that process immutable graph nodes.
 * 
 * @param <E> The value type stored in the graph.
 */
public interface GraphNodeVisitor<E> {
	
	/**
	 * Processes a given graph node.
	 * 
	 * @param node the graph node.
	 * @throws IllegalArgumentException if node is null.
	 */
	void visit(ImmutableGraphNode<E> node);
}
