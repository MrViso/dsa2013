package de.unistuttgart.dsa2013.ws6;

/**
 * An interface for classes that traverse a graph and invoke a visitor.
 * 
 * @param <E> The value type stored in the graph.
 */
public interface GraphNavigator<E> {
	
	/**
	 * Traverses the graph and invokes {@link GraphNodeVisitor.visit} for each node.
	 * 
	 * @param initialNode the graph node at which traversal starts.
	 * @param visitor the visitor object to invoke.
	 * @throws IllegalArgumentException if any of the arguments is null.
	 */
	void traverse(ImmutableGraphNode<E> initialNode, GraphNodeVisitor<E> visitor);
	
	/**
	 * Indicates the traversal method used by {@link traverse}.
	 * 
	 * @return the traversal method.
	 */
	TraversalMethod getTraversalMethod();
}
