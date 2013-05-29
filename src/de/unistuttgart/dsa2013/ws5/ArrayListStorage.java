package de.unistuttgart.dsa2013.ws5;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of {@see SerialBinTreeStorage} using {@see ArrayList}.
 * 
 * @param <T> The data type of the values.
 */
public class ArrayListStorage<T> implements SerialBinTreeStorage<T> {
	
	/**
	 * Initializes a new instance.
	 */
	public ArrayListStorage() {
		levelCount = 1;
		items.add(null);
	}
	
	/**
	 * The current number of levels.
	 */
	private int levelCount;
	
	/**
	 * The items storage.
	 */
	private final List<T> items = new ArrayList<T>();
	
	/**
	 * Returns the number of tree levels for which space has been allocated.
	 * 
	 * @return the number of tree levels.
	 */
	@Override
	public int getLevelCount() {
		return levelCount;
	}

	/**
	 * Changes the number of tree levels for which space has been allocated.
	 * 
	 * @param levelCount the new number of tree levels.
	 * @throws IllegalArgumentException if levelCount is less than 1.
	 */
	@Override
	public void setLevelCount(int levelCount) {
		if (levelCount < 1) {
			throw new IllegalArgumentException("There must be at least one level.");
		}
		
		if (levelCount != this.levelCount) {
			int lastLevelSize = (int)Math.pow(2, this.levelCount - 1);
			while (this.levelCount > levelCount) {
				for (int i = 0; i < lastLevelSize; i++) {
					items.remove(items.size() - 1);
				}
				lastLevelSize /= 2;
				this.levelCount--;
			}
			while (this.levelCount < levelCount) {
				lastLevelSize *= 2;
				for (int i = 0; i < lastLevelSize; i++) {
					items.add(null);
				}
				this.levelCount++;
			}
		}
	}

	/**
	 * Retrieves the value of an element by its position in the serial storage.
	 * 
	 * @param index The index of the element to retrieve.
	 * @return The element value.
	 * @throws IndexOutOfBoundsException if index is less than zero or greater than the maximum allowed index.
	 */
	@Override
	public T getElement(int index) {
		return items.get(index);
	}

	/**
	 * Sets the value of an element by its position in the serial storage.
	 * 
	 * @param index The index of the element to store.
	 * @param element The element value to store.
	 * @throws IndexOutOfBoundsException if index is less than zero or greater than the maximum allowed index.
	 */
	@Override
	public void setElement(int index, T element) {
		items.set(index, element);
	}

}
