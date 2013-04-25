/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

import java.util.NoSuchElementException;

/**
 * Klasse einer generischen Liste bestehend aus Knoten der Klasse Node<T>.
 * Enthaelt Methode prepend, size und getElementAt, sowie eine innere Klasse
 * Iterator.
 * 
 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
 * @history 2013-04-24 MV 1.0 Implementierung der Liste als Klasse
 * @history 2013-04-25 MV 1.1 Implementierung von prepend und size
 * @history 2013-04-25 MV 1.2 Erweiterung der Kommentare
 * @history 2013-04-25 FM 1.3 Entwicklungsanfang des Iterators
 * @history 2013-04-25 MV 1.4 Implementierung der Methode getElementAt()
 * @history 2013-04-25 MV 1.5 Implementierung des Iterators
 * @history 2013-04-25 MV 1.6 Programmsturktur ueberarbeitet
 * @version 2013-04-25 MV 1.6
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

	/**
	 * Innere Klasse des Iterators
	 * 
	 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
	 * 
	 * @param <T>
	 */
	class Iterator<T> implements java.util.Iterator<T> {

		Node<T> zeiger;

		public Iterator(Node<T> zeiger) {
			super();
			this.zeiger = zeiger;
		}

		public boolean hasNext() {
			if (zeiger.next != null)
				return true;
			else
				return false;
		}

		public boolean hasAchtNext() {
			if (zeiger.getAchtNext() != null)
				return true;
			else
				return false;
		}

		public T next() throws NoSuchElementException {
			if (hasNext()) {
				return zeiger.next.value;
			} else {
				throw new NoSuchElementException("Keine weiteren Elemente");
			}

		}

		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException(
					"Operation wird nicht unterstützt.");
		}
	}

	/**
	 * Erstellt skippingIterator der immer um n-1 Stellen springt und die nte
	 * ausgibt.
	 * 
	 * @param n
	 *            Die Anzahl der uebersprungenen Elemente + 1
	 * @return skipIt den erstellten Iterator.
	 * @throws IllegalArgumentException
	 *             Falls n kleiner als 1 ist
	 */
	public Iterator<T> skippingIterator(int n) throws IllegalArgumentException {
		if (n >= 1) {
			Iterator<T> skipIt = new Iterator<T>(firstNode);
			int listsize = size();
			while (listsize > 0) {
				int z = n - 1;
				while (z >= 8) {
					if (skipIt.hasAchtNext())
						skipIt.zeiger = skipIt.zeiger.getAchtNext();
					z -= 8;
				}
				while (z > 0) {
					if (skipIt.hasNext())
						skipIt.zeiger = skipIt.zeiger.next;
					z--;
				}
				System.out.println(skipIt.next());
			}

			return skipIt;
		} else {
			throw new IllegalArgumentException("N < 1");
		}

	}

	//Iterator<T> iter;

	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
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
						zeiger = zeiger.getAchtNext();
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
		throw new IndexOutOfBoundsException("Index zu groß fuer Listenlaenge");
	}

}
