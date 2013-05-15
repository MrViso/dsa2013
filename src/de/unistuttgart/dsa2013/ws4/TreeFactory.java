package de.unistuttgart.dsa2013.ws4;

/**
 * A container for ready-made trees. 
 */
public final class TreeFactory {
	
	/**
	 * Hidden constructor.
	 */
	private TreeFactory() {
	}
	
	/**
	 * Creates a sample tree comprising of seven nodes.
	 * 
	 * @return the sample tree.
	 */
	public static GenericTreeNode<Integer> createSmallTree() {
		GenericTreeNode<Integer> root = new WS4TreeNode<Integer>(4, 50);
		
		GenericTreeNode<Integer> c1 = root.addChild(4);
		c1.addChild(83);
		c1.addChild(9);
		c1.addChild(18);
		
		root.addChild(6);
		root.addChild(56);
		
		return root;
	}
}
