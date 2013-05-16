package de.unistuttgart.dsa2013.ws4;

import java.awt.Dimension;

/**
 * Implementation fuer optimale Ausgabe der Knoten.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @history 2013-05-15 MV 1.0 
 * @version 2013-05-15 MV 1.0 Erste Version
 * 
 * @param <T>
 *            Der Datentyp der in den Knoten gespeichert wird.
 */
public class MyTreeInfoProvider<T> implements TreeInfoProvider<T> {

	/**
	 * Gibt den horizontalen Abstand zurueck.
	 * 
	 * @return Horizontalabstand
	 */
	@Override
	public int getHSpacing() {
		//TODO
		return 50;
	}

	/**
	 * Gibt den vertikalen Abstand zurueck.
	 * 
	 * @return Vertikalabstand
	 */
	@Override
	public int getVSpacing() {
		//TODO
		return 25;
	}

	/**
	 * Berechnet den Abstand zwischen Knoten und Kindsknoten
	 * 
	 * @param sizeStorage
	 *            Berechnete Groessen die gespeichert werden.
	 * @param root
	 *            Wurzel des Baums
	 * @throws IllegalArgumentException
	 *             Falls eines der Argumente null ist
	 */
	@Override
	public void computeSizes(TreeSizeStorage<T> sizeStorage,
			GenericTreeNode<T> root) {
		Dimension sizeNode = new Dimension();
		Dimension sizeTree = new Dimension();
		sizeNode.height = 20;
		sizeNode.width = 30;
		sizeTree.height = -10;
		sizeTree.width = -10;
		sizeStorage.setNodeSize(root, sizeNode);
		sizeStorage.setSubtreeSize(root, sizeTree);
		
		for (int i = 0; i < root.getChildCount(); i++){
			computeSizes(sizeStorage, root.getChildAt(i));
		}
	}

}
