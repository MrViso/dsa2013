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

public class NodeV2<T> {
	public T value;
	public NodeV2<T> next = null;
	
	/**
	 *  Konstruktor.
	 *
	 */
	public NodeV2(T value, NodeV2<T> nextNode) {
		this.value = value;
		this.next = nextNode;
	}

}