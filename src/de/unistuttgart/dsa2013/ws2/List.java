package de.unistuttgart.dsa2013.ws2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Klasse welche mehrere Unterklassen enthält, welche zusammen einen Listentyp
 * ergeben. Ebenfalls enthalten sind zwei Sortieralgorithmen. Einmal die Methode
 * sort, welche nach dem Bubble oder Shakersort Prinzip funktioniert und einmal
 * die Methode selectionSort, welche nach dem Selection Sort Prinzip arbeitet.
 * Es ist ebenfalls ein Iterartor ListIterator fuer die Liste eingebunden.
 * 
 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
 * @history 2013-05-01 FM 1.0 Modifizierung der Datei wg. shakersort
 * @history 2013-05-02 FM 1.1 Erweiterung um Methode selectionSort
 * @history 2013-05-02 MV 1.2 Hinzufuegung der Kommentierung
 * @version 2013-05-02 MV 1.2
 * 
 * @param <T>
 *            Den Typ der Elemente, welche in der Liste gespeichert werden
 */
public class List<T extends Comparable<? super T>> implements Iterable<T> {

	/**
	 * Enthaelt einen Iterator fuer den Listentyp.
	 * 
	 */
	private class ListIterator implements Iterator<T> {

		public ListIterator(Node<T> first) {
			if (first == null) {
				throw new IllegalArgumentException("first must not be null.");
			}

			next = first;
		}

		private Node<T> next;

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public T next() {
			if (next != null) {
				T result = next.getValue();
				next = next.getNext();
				return result;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Unterklasse von List<T> welche die Knotenelemente der Liste definiert.
	 * 
	 * @param <T>
	 *            Definiert den Elementtyp der Knotenwerte.
	 */
	private class Node<T> {

		private T value;

		private Node<T> next, prev;

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getPrev() {
			return prev;
		}

		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}
	}

	private Node<T> first, last;

	private int count;

	/**
	 * Gibt Wert von privater Variable count an.
	 * 
	 * @return Wert der Variable count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Methode welche Knoten in die Liste hinzufuegt.
	 * 
	 * @param value
	 *            Einzutragender Wert, vom Typ T, des neuerzeugten Knotens
	 */
	public void add(T value) {
		if (value == null) {
			throw new IllegalArgumentException("value must not be null.");
		}

		Node<T> newItem = new Node<T>();
		newItem.setValue(value);

		if (first == null) {
			first = newItem;
			last = newItem;
		} else {
			last.next = newItem;
			newItem.setPrev(last);
			last = newItem;
		}
		count++;
	}

	/**
	 * Rueckgabe von Wahrheitswert, ob Liste leer ist.
	 * 
	 * @return Wahrheitswert ob Liste null ist oder nicht.
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Erzeugt neuen ListIterator von erster Stelle der Liste an.
	 */
	public Iterator<T> iterator() {
		return new ListIterator(first);
	}

	/**
	 * Sortiert Liste nach dem Prinzip von Bubblesort oder Shakersort, wenn die
	 * Variable shakerSort auf wahr gesetzt ist
	 * 
	 * @param shakerSort
	 *            Wenn wahr, funktioniert der Algorithmus nach dem Shakersort
	 *            Prinzip, wenn falsch nach dem Bubblesort Prinzip
	 */
	public void sort(boolean shakerSort) {
		if (!isEmpty()) {
			boolean hasChanged;
			do {
				hasChanged = false;

				// Liste vorwaerts sortieren
				for (Node<T> current = first; current.getNext() != null; current = current
						.getNext()) {
					if (current.getValue().compareTo(
							current.getNext().getValue()) > 0) {
						hasChanged = true;

						T buf = current.getValue();
						current.setValue(current.getNext().getValue());
						current.getNext().setValue(buf);
					}
				}

				// Liste rueckwaerts sortieren, wenn sie nicht schon sortiert
				// ist
				// und shakerSort == true
				if (hasChanged && shakerSort) {
					for (Node<T> current = last; current.getPrev() != null; current = current
							.getPrev()) {
						if (current.getValue().compareTo(
								current.getPrev().getValue()) < 0) {
							hasChanged = true;

							T buf = current.getValue();
							current.setValue(current.getPrev().getValue());
							current.getPrev().setValue(buf);
						}
					}
				}
			} while (hasChanged);
		}
	}

	/**
	 * Sortiermethode nach dem Prinzip des Selectionsort.
	 */
	public void selectionSort() {

		if (!isEmpty()) {
			// ab dem letzten Element (ohne last)
			for (Node<T> current = last.prev; current.getPrev() != null; current = current
					.getPrev()) {
				// ab Vorgaenger von current
				for (Node<T> current2 = current.prev; current2.getPrev() != null; current2 = current2
						.getPrev()) {
					// current2 > current? tauschen!
					if (current.getValue().compareTo(current2.getValue()) < 0) {
						T buf = current.getValue();
						current.setValue(current2.getValue());
						current2.setValue(buf);
					}
				}
			}
		}
	}

}