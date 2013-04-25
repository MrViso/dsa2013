/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

import java.util.Iterator;

/**
 * Klasse einer generischen Liste bestehend aus Knoten der Klasse Node<T>.
 * Enthaelt Methode prepend, size und getElementAt, sowie eine innere Klasse
 * Iterator.
 * 
 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
 * @history 2013-04-24 MV 1.0 Implementierung der Liste als Klasse
 * @history 2013-04-25 MV 1.1 Implementierung von prepend und size
 * @history 2014-04-25 MV 1.2 Erweiterung der Kommentare
 * @history 2014-04-25 FM 1.3 Entwicklungsanfang des Iterators
 * @history 2014-04-25 MV 1.4 Implementierung der Methode getElementAt()
 * @version 2013-04-25 MV 1.4
 * 
 */

public class SpeedList<T> implements A1aCollection<T>, A1bCollection<T>,
		A1cCollection<T> {

	Node<T> firstNode;

	/**
	 * Erstellung eines Knotens des Typs Node<T> an der ersten Stelle der Liste
	 * des Typs SpeedList<T>
	 * 
	 * @param item
	 *            ein generischer Wert, welcher bei der Erstellung des Knotens
	 *            gesetzt wird.
	 */
	public void prepend(T item) {
		Node<T> newFirst = new Node<T>(item, firstNode);
		firstNode = newFirst;
	}

	/**
	 * Pruefung der Liste auf ihre Laenge
	 */
	public int size() {
		int i = 0;
		Node<T> zeiger = firstNode;
		if (zeiger != null) {
			i++;
		} else {
			i++;
			return i;
		}

		if (zeiger.next == null)
			return i;

		while (zeiger.getAchtnext() != null) {
			i += 8;
			zeiger = zeiger.getAchtnext();
		}

		do {
			i++;
			zeiger = zeiger.next;

		} while (zeiger.next != null);
		return i;

	}


	/**
	 * Sucht das Element an der Stelle index und gibt dessen Wert aus. Nach
	 * Moeglichkeit werden Spruenge um acht Stellen genutzt.
	 * 
	 * @param index
	 *            Gibt die gesuchte Stelle der Liste an, deren Wert
	 *            zurueckgegeben werden soll
	 */
	public T getElementAt(int index) throws IndexOutOfBoundsException {
		Node<T> zeiger = firstNode;
		if (size() >= index) {
			while (index > 0) {
				if (index > 1) {
					if (index > 8) {
						zeiger = zeiger.getAchtnext();
						index -= 8;
					} else {
						zeiger = zeiger.next;
						index--;
					}
				} else {
					return zeiger.value;
				}

			}
		}
		throw new IndexOutOfBoundsException("Index zu groﬂ fuer Listenlaenge");
	}

	// Methode um jedes nte Element auszugeben ()
	/*
	 * public Iterator<T> skippingIterator(Node<T> node) throws Exception {
	 * 
	 * Integer counter = 0; Integer n;
	 * System.out.println("Waehle n um jedes nte Element auszugeben: "); n =
	 * System.in.read(); if (n instanceof Integer && n != null && n > 0) {
	 * System.out.println(node.value); while (node.next != null) { if (counter %
	 * n == 0) { return node; } counter++;
	 * 
	 * } } else throw new IllegalArgumentException("n is IllegalArgument"); }
	 */
	
	/**
	 * 
	 * @author
	 * 
	 * @param <T>
	 */
	public class Iterator<T> {

	}

	private final Exception IllegalArgumentException = null;

	public Boolean hasNext(Node<T> n) {
		if (n.next != null)
			return true;
		else
			return false;
	}
	
	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.Iterator<T> skippingIterator(int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
