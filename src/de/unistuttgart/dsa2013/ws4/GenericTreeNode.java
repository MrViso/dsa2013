package de.unistuttgart.dsa2013.ws4;

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
	 */
	GenericTreeNode<T> addChild(T value);
	
	/**
	 * Returns the number of child nodes.
	 * 
	 * @return the number of child nodes.
	 */
	int getChildCount();
	
	/**
	 * Returns the unique ID of the node.
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
}
