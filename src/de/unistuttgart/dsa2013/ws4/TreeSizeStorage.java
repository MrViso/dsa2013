package de.unistuttgart.dsa2013.ws4;

import java.awt.Dimension;

/**
 * An interface for objects that store the bounding box size of tree nodes and subtrees.
 *
 * @param <T> The data type stored in the tree.
 */
public interface TreeSizeStorage<T> {
	
	/**
	 * Returns the size of the subtree starting at the given node.
	 * 
	 * @param root The root node of the subtree.
	 * @return An object that contains the size of the subtree.
	 * @throws IllegalArgumentException if root is null.
	 */
	Dimension getSubtreeSize(GenericTreeNode<T> root);
	
	/**
	 * Stores the size of the subtree starting at a given node.
	 * 
	 * @param root The root node of the subtree.
	 * @param size An object that contains the size of the subtree.
	 * @throws IllegalArgumentException if any of the arguments is null.
	 */
	void setSubtreeSize(GenericTreeNode<T> root, Dimension size);
	
	/**
	 * Returns the size of the given node.
	 * 
	 * @param node The node.
	 * @return the size of the node.
	 * @throws IllegalArgumentException if node is null.
	 */
	Dimension getNodeSize(GenericTreeNode<T> node);
	
	/**
	 * Stores the size of the given node.
	 * 
	 * @param node The node.
	 * @param size The new size of the node.
	 * @throws IllegalArgumentException if any of the arguments is null.
	 */
	void setNodeSize(GenericTreeNode<T> node, Dimension size);
}
