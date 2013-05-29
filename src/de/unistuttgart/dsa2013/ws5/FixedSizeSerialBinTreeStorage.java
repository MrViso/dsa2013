package de.unistuttgart.dsa2013.ws5;

/**
 * An interface for classes that store the values of a binary tree in a sequential way.
 * 
 * @param <T> The data type of the values.
 */
public interface FixedSizeSerialBinTreeStorage<T> {
	
	/**
	 * Returns the number of tree levels for which space has been allocated.
	 * 
	 * @return the number of tree levels.
	 */
	int getLevelCount();
	
	/**
	 * Retrieves the value of an element by its position in the serial storage.
	 * 
	 * @param index The index of the element to retrieve.
	 * @return The element value.
	 * @throws IndexOutOfBoundsException if index is less than zero or greater than the maximum allowed index.
	 */
	T getElement(int index);
	
	/**
	 * Sets the value of an element by its position in the serial storage.
	 * 
	 * @param index The index of the element to store.
	 * @param element The element value to store.
	 * @throws IndexOutOfBoundsException if index is less than zero or greater than the maximum allowed index.
	 */
	void setElement(int index, T element);
}
