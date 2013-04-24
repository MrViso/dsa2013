package de.unistuttgart.dsa2013.ws1;

/**
 * A very simple list interface that can retrieve
 * elements at a given position.
 *
 * @param <T> The element type of the list.
 */
public interface A1cCollection<T>
		extends A1bCollection<T> {
	
	/**
	 * Retrieves an element at a given position in the
	 * list.
	 * 
	 * @param index The position of the element.
	 * @return The element.
	 * @throws IndexOutOfBoundsException if the index is
	 *   out of range.
	 */
	T getElementAt(int index);
}
