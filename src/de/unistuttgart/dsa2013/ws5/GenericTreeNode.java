package de.unistuttgart.dsa2013.ws5;

/**
 * An interface for tree nodes.
 *
 * @param <T> The data type stored in the tree.
 */
public interface GenericTreeNode<T> {
	
	/**
	 * Returns the parent of the tree node.
	 * 
	 * @return the parent node, or null, if the tree node is the root of the tree.
	 */
	GenericTreeNode<T> getParent();
	
	/**
	 * Returns a child node at a given position in the list of children.
	 * 
	 * @param index The position of the child node.
	 * @return the child node.
	 * @throws IndexOutOfBoundsException index is outside of the range of child indices.
	 */
	GenericTreeNode<T> getChildAt(int index);
	
	/**
	 * Appends a new child node to the end of the child nodes list.
	 * 
	 * @param value The value of the new child node.
	 * @return the newly created child node.
	 * @throws IllegalArgumentException if value is null.
	 * @throws UnsupportedOperationException if the Method is called when the maximum number of child nodes has already been reached. 
	 */
	GenericTreeNode<T> addChild(T value);
	
	/**
	 * Returns the number of child nodes.
	 * 
	 * @return the number of child nodes.
	 */
	int getChildCount();
	
	/**
	 * Returns the maximum allowed number of child nodes.
	 * 
	 * @return the maximum child count.
	 */
	int getMaxChildCount();
	
	/**
	 * Returns an ID of the node that is unique within the tree.
	 * 
	 * @return the unique ID.
	 */
	int getNodeId();
	
	/**
	 * Returns the value of the node.
	 * 
	 * @return the value of the node.
	 */
	T getValue();
	
	/**
	 * Sets the value of the node.
	 * 
	 * @param value the new value of the node.
	 * @throws IllegalArgumentException if value is null.
	 */
	void setValue(T value);
}
