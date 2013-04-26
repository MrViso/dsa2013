/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

/**
 * Klasse einer generischen Liste bestehend aus Knoten der Klasse Node<T>.
 * Enthaelt Methode prepend und size
 * 
 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
 * @history 2013-04-24 MV 1.0 Implementierung der Liste als Klasse
 * @history 2013-04-25 MV 1.1 Implementierung von prepend und size
 * @history 2013-04-25 MV 1.2 Erweiterung der Kommentare
 * @history 2013-04-25 FM 1.3 Entwicklungsanfang des Iterators
 * @history 2013-04-25 MV 1.4 Implementierung der Methode getElementAt()
 * @history 2013-04-25 MV 1.5 Implementierung des Iterators
 * @history 2013-04-25 MV 1.6 Programmsturktur ueberarbeitet
 * @history 2013-04.25 MV 1.7 Kuerzung wg. Teilaufgabe 1b
 * @history 2013-04.25 MV 1.8 Kuerzung wg. Teilaufgabe 1a
 * @version 2013-04-25 MV 1.8
 * 
 */

public class SpeedListV1<T> implements A1aCollection<T> {

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

		while (zeiger.getAchtNext() != null) {
			i += 8;
			zeiger = zeiger.getAchtNext();
		}

		do {
			i++;
			zeiger = zeiger.next;

		} while (zeiger.next != null);
		return i;

	}

}
