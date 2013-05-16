/**
 * 
 */
package de.unistuttgart.dsa2013.ws4;

/**
 * Eine einfache Implementation des grafischen Baums
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @history 2013-05-15 MV 1.0 
 * @version 2013-05-15 MV 1.0 Erste Version
 * 
 */
public class DisplayTree2c {

	/**
	 * Ausfuehrende Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GenericTreeNode<Integer> tree = MyTreeFactory.createTree();
		TreeInfoProvider<Integer> infoProvider = new MyTreeInfoProvider<Integer>();
		TreeDisplay.showTree(tree, infoProvider);

	}

}
