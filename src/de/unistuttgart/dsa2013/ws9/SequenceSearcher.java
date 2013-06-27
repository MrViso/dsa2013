package de.unistuttgart.dsa2013.ws9;

/**
 * An interface for objects that scan a sequence of elements for occurrences of a sub-pattern.
 *
 * @param <E> The element type of the sequence.
 */
public interface SequenceSearcher<E> {
	
	/**
	 * Finds the first occurrence of a pattern in a sequence.
	 * 
	 * @param sequence The sequence to scan.
	 * @param pattern The pattern to find.
	 * @return The index of the first element of the pattern in the first occurrence of the pattern in the sequence, or a negative value if the pattern was not found.
	 */
	int find(E[] sequence, E[] pattern);
}
