package de.unistuttgart.dsa2013.ws4;

/**
 * Erschafft einen Baum bestehend aus elf Knoten
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @history 2013-05-15 MV 1.0 
 * @version 2013-05-15 MV 1.0 Erste Version
 * 
 */
public final class MyTreeFactory {
	
	/**
	 * Hidden constructor.
	 */
	private MyTreeFactory() {
	}
	
	/**
	 * Erschafft den Baum mit elf Knoten
	 * 
	 * @return Ein eigener Beispielsbaum
	 */
	public static GenericTreeNode<Integer> createTree() {
		GenericTreeNode<Integer> root = new WS4TreeNode<Integer>(2, 19);
		
		GenericTreeNode<Integer> c1 = root.addChild(12);
		GenericTreeNode<Integer> c2 = root.addChild(85);
		
		c1.addChild(10);
		c1.addChild(16);
		
		c1.getChildAt(0).addChild(9);
		c1.getChildAt(0).addChild(11);
	
		
		c2.addChild(40);
		c2.addChild(95);
		
		c2.getChildAt(0).addChild(26);
		c2.getChildAt(0).addChild(44);
		
		return root;
	}
}
