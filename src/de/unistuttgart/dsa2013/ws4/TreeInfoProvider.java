package de.unistuttgart.dsa2013.ws4;

/**
 * An interface for classes that provide size and location information about trees and tree nodes.
 *
 * @param <E> The data type stored in the graph.
 */
public interface TreeInfoProvider<E> {
	
	/**
	 * Returns the horizontal spacing between nodes.
	 * 
	 * @return the horizontal spacing.
	 */
	int getHSpacing();
	
	/**
	 * Returns the vertical spacing between nodes.
	 * 
	 * @return the vertical spacing.
	 */
	int getVSpacing();
	
	/**
	 * Computes the sizes of all nodes and subtrees.
	 * 
	 * @param sizeStorage The computed sizes are stored in this object.
	 * @param root The root node of the tree.
	 * @throws IllegalArgumentException if any of the arguments is null.
	 */
	void computeSizes(TreeSizeStorage<E> sizeStorage, GenericTreeNode<E> root);
}
