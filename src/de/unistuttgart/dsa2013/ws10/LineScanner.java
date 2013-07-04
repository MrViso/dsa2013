package de.unistuttgart.dsa2013.ws10;

/**
 * Objects that implement this interface can scan lines of text for the occurrence of particular substrings.
 */
public interface LineScanner {
	
	/**
	 * Finds all substrings that match the implementation-specific criteria of the line scanner.
	 * 
	 * @param completeLine The complete line.
	 * @return An object that enumerates the discovered substrings.
	 * @throws IllegalArgumentException if completeLine is null.
	 */
	Iterable<String> retrieveStrings(String completeLine);
}
