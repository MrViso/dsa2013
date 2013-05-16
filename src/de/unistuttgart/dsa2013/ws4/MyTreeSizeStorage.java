package de.unistuttgart.dsa2013.ws4;

import java.awt.Dimension;

/**
 * Speichert die Dimensionsdaten von Knoten und Subtrees und gibt sie auch aus.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-05-16 MV 1.1 
 * @history 2013-05-15 MV 1.0 Erste Version
 * @history 2013-05-16 MV 1.1 Exceptions eingefuegt
 * 
 * @param <T>
 *            Der Datentyp der in den Knoten gespeichert wird..
 */
public class MyTreeSizeStorage<T> implements TreeSizeStorage<T> {

	Dimension nodeSize = new Dimension();
	Dimension subtreeSize = new Dimension();

	/**
	 * Gibt die Groeﬂe des Subtrees ausgehend vom gegebenen Knoten aus.
	 * 
	 * @param root
	 *            Wurzelknoten des Subtrees
	 * @return Die Groesse des Subtrees
	 * @throws IllegalArgumentException
	 *             Falls die Wurzel null ist
	 */
	public Dimension getSubtreeSize(GenericTreeNode<T> root)
			throws IllegalArgumentException {
		// TODO
		if (root == null)
			throw new IllegalArgumentException("Wurzel ist null");
		return subtreeSize;
	}

	/**
	 * Speichert die Groesse des Subtrees ausgehend vom gegeben Knoten.
	 * 
	 * @param root
	 *            Der Wurzelknoten des Subtrees
	 * @param size
	 *            Objekt welches die Groesse des Subtrees enthaelt.
	 * @throws IllegalArgumentException
	 *             If eines der Argumente null ist
	 */
	public void setSubtreeSize(GenericTreeNode<T> root, Dimension size)
			throws IllegalArgumentException {
		if (root == null)
			throw new IllegalArgumentException("Wurzel ist null");
		if (size == null)
			throw new IllegalArgumentException("Size ist null");
		this.subtreeSize = size;
	}

	/**
	 * Gibt die Groesse des gewaehlten Knotens aus.
	 * 
	 * @param node
	 *            Der Knoten
	 * @return Groesse des Knoten
	 * @throws IllegalArgumentException
	 *             Falls der Knoten null ist.
	 */
	public Dimension getNodeSize(GenericTreeNode<T> node)
			throws IllegalArgumentException {
		if (node == null)
			throw new IllegalArgumentException("Knoten ist null");
		// TODO
		return nodeSize;
	}

	/**
	 * Speichert die Groesse des Knotens.
	 * 
	 * @param node
	 *            Der Knoten
	 * @param size
	 *            Die neue Groesse des Knotens
	 * @throws IllegalArgumentException
	 *             Falls eines der Argumente null ist.
	 */
	public void setNodeSize(GenericTreeNode<T> node, Dimension size)
			throws IllegalArgumentException {
		if (node == null)
			throw new IllegalArgumentException("Knoten ist null");
		if (size == null)
			throw new IllegalArgumentException("Size ist null");
		this.nodeSize = size;
	}
}
