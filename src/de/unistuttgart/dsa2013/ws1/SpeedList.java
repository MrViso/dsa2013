/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

import java.util.Iterator;

/**
 * @author Viso
 * 
 */

public class SpeedList<T> implements A1aCollection<T>, A1bCollection<T>,
		A1cCollection<T> {

	SpeedNode<T> firstNode;

	/**
	 * Erstellung eines Knotens an der ersten Stelle.
	 */
	public void prepend(T item) {
		SpeedNode<T> newFirst = new SpeedNode<T>(item, firstNode);
		firstNode = newFirst;
	}

	/**
	 * Pruefung der Listenlaenge.
	 */
	public int size() {
		int i = 0;
		SpeedNode<T> zeiger = firstNode;
		if (zeiger != null) {
			i++;
		} else {
			i++;
			return i;
		}

		if (zeiger.next == null)
			return i;

		while (zeiger.achtnext != null) {
			i += 8;
			zeiger = zeiger.achtnext;
		}

		do {
			i++;
			zeiger = zeiger.next;

		} while (zeiger.next != null);
		return i;

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> skippingIterator(int n) {
		// TODO Auto-generated method stub
		return null;
	}
}
