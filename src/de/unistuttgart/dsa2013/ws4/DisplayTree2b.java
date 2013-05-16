/**
 * 
 */
package de.unistuttgart.dsa2013.ws4;

/**
 * Eine einfache Implementation des grafischen Baums mit eigenem Baumbeispiel
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-05-15 MV 1.0 
 * @history 2013-05-15 MV 1.0 Erste Version
 * 
 */
public class DisplayTree2b {

	/**
	 * Ausfuehrende Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GenericTreeNode<Integer> tree = MyTreeFactory.createTree();
		DummyTreeInfoProvider<Integer> infoProvider = new DummyTreeInfoProvider<Integer>();
		TreeDisplay.showTree(tree, infoProvider);

	}

}
