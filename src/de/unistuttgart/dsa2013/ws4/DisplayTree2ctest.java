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
 * @version 2013-05-16 MV 1.1 
 * @history 2013-05-15 MV 1.0 Erste Version 
 * @history 2013-05-16 MV 1.1 Fangen der Exception eingefuegt
 * 
 */
public class DisplayTree2ctest {

	/**
	 * Ausfuehrende Methode
	 * 
	 * @param args
	 */
	public static void main(String[] args)  {
		try {
			GenericTreeNode<Integer> tree = TreeFactory.createSmallTree();
			TreeInfoProvider<Integer> infoProvider = new MyTreeInfoProvider<Integer>();
			TreeDisplay.showTree(tree, infoProvider);
		}
		catch (IllegalArgumentException ex){
			System.exit(1);
		}

	}

}
