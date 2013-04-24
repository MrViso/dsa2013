/**
 * Erklärung  wie man eine Klasse erstellt, welche eine Liste beschreibt.
 * Java Alternativen:
 * ArrayList<T>
 *
 * Generisch: Einfach ein "egal" Typ. => <T>
 * Generische Typen immer in Eckigen Klamern
 * lässt sich dann mit Node<Integer> aufrufen bzw. anpassen.
 * 
 *
 *
 *
 */

package de.unistuttgart.dsa2013.ws1.listendemo;

public class NodeV3<T, U> {
	public T value;
	public U value2;
	public NodeV3<Integer,Boolean> next = null;
	
	/**
	 *  Konstruktor.
	 *
	 */
	public NodeV3(T value, U value2, NodeV3<Integer,Boolean> nodeV3) {
		this.value = value;
		this.value2 = value2;
		this.next = nodeV3;
	}

}