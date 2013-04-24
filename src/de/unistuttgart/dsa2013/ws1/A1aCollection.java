package de.unistuttgart.dsa2013.ws1;

/**
 * A very simple list interface.
 * 
 * @param <T> The element type of the list.
 */
public interface A1aCollection<T> {
	
	/**
	 * Inserts an item at the beginning of the list.
	 * 
	 * @param item The item to insert.
	 */
	void prepend(T item);
	
	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return The number of elements in the list.
	 */
	int size();
}
