package de.unistuttgart.dsa2013.ws4;

/**
 * A basic implementation of the {@link TreeInfoProvider} interface.
 *
 * @param <T> The data type stored in the tree nodes.
 */
public class DummyTreeInfoProvider<T> implements TreeInfoProvider<T> {

	/**
	 * Returns the horizontal spacing between nodes.
	 * 
	 * @return the horizontal spacing.
	 */
	@Override
	public int getHSpacing() {
		return 0;
	}

	/**
	 * Returns the vertical spacing between nodes.
	 * 
	 * @return the vertical spacing.
	 */
	@Override
	public int getVSpacing() {
		return 0;
	}

	/**
	 * Computes the sizes of all nodes and subtrees.
	 * 
	 * @param sizeStorage The computed sizes are stored in this object.
	 * @param root The root node of the tree.
	 * @throws IllegalArgumentException if any of the arguments is null.
	 */
	@Override
	public void computeSizes(TreeSizeStorage<T> sizeStorage,
			GenericTreeNode<T> root) {
	}

}
