package de.unistuttgart.dsa2013.ws5;

/**
 * An interface for classes that store the values of a binary tree in a sequential way
 * whose number of levels can be changed.
 * 
 * @param <T> The data type of the values.
 */
public interface SerialBinTreeStorage<T> extends FixedSizeSerialBinTreeStorage<T> {
	
	/**
	 * Changes the number of tree levels for which space has been allocated.
	 * 
	 * @param levelCount the new number of tree levels.
	 * @throws IllegalArgumentException if levelCount is less than 1.
	 */
	void setLevelCount(int levelCount);
}
