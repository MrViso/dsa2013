package de.unistuttgart.dsa2013.bws1;

/**
 * Provides some utility routines for outputting and debugging array structures.
 */
public class ArrayDisplayUtilities {
	
	/**
	 * Prints the contents of an array to the standard output stream.
	 * Instead of null values, [n] will be output.
	 * 
	 * @param array The array to print.
	 * @throws IllegalArgumentException if array is null.
	 */
	public static <T> void printArray(T[] array) {
		if (array == null) {
			throw new IllegalArgumentException("array must not be null.");
		}
		
		for (T element : array) {
			System.out.print(" " + (element == null ? "[n]" : element.toString()));
		}
		System.out.println();
	}
	
	/**
	 * Prints the contents of a two-dimensional array to the standard output stream.
	 * Instead of null values, [n] will be output.
	 * 
	 * @param array The array to print.
	 * @throws IllegalArgumentException if array is null or if array contains any null elements.
	 */
	public static <T> void printTwoDimArray(T[][] array) {
		if (array == null) {
			throw new IllegalArgumentException("array must not be null.");
		}
		
		int maxWidth = 0;
		for (T[] a : array) {
			if (a == null) {
				throw new IllegalArgumentException("array must not contain any null elements.");
			}
			
			maxWidth = Math.max(maxWidth, a.length);
		}
		
		int maxTextLength = 0;
		if (maxWidth > 0) {
			String[][] strings = new String[array.length][maxWidth];
			
			for (int i = 0; i < array.length; i++) {
				T[] line = array[i];
				for (int j = 0; j < maxWidth; j++) {
					if (j < line.length) {
						if (line[j] == null) {
							strings[i][j] = "[n]";
						} else {
							strings[i][j] = line[j].toString();
						}
					} else {
						strings[i][j] = "[n]";
					}
					maxTextLength = Math.max(maxTextLength, strings[i][j].length());
				}
			}
			
			for (int i = 0; i < strings.length; i++) {
				for (int j = 0; j < strings[i].length; j++) {
					System.out.printf("%1$" + (maxTextLength + 1) + "s", strings[i][j]);
				}
				System.out.println();
			}
		}
	}
}
