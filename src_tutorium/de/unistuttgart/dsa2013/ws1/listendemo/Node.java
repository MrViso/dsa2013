/**
 * Erklärung  wie man eine Klasse erstellt, welche eine Liste beschreibt.
 * Java Alternativen:
 * ArrayList<T>
 *
 * Generisch: Einfach ein "egal" Typ. => <T>
 *
 *
 *
 *
 */

package de.unistuttgart.dsa2013.ws1.listendemo;

public class Node {
	public int value;
	public Node next = null;

	/**
	 * Constructor.
	 * 
	 */
	public Node(int value, Node next) {
		this.value = value;
		this.next = next;
	}

}