package de.unistuttgart.dsa2013.ws1;

import java.util.*;

/**
 * A very simple list interface that provides some
 * iterators.
 * 
 * @param <T> The element type of the list.
 */
public interface A1bCollection<T>
		extends A1aCollection<T>, Iterable<T> {
	
	/**
	 * Returns an iterator that enumerates every nth
	 * element in the collection, starting with the
	 * first element.
	 *
	 * @param n The number of skipped elements + 1.
	 * @return The iterator.
	 * @throws IllegalArgumentException if n is less than 1.
	 */
	Iterator<T> skippingIterator(int n);
}
