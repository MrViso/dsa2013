package de.unistuttgart.dsa2013.bws1;

import java.io.IOException;
import java.util.Arrays;

public class fillArray {
	
	private static void fillArray(Integer[][] array, int value)
			throws IllegalArgumentException, IOException {
		if (array == null) {
			throw new IllegalArgumentException("array must not be null.");
		}

		int column = 0;
		int line = 0;
		int value1 = 0;

		System.out.println("Welchen Wert einfügen?");
		value1 = System.in.read(); // muss man nicht-int eingaben abfangen oder
									// geht des automatisch?

		System.out.println("In welche Zeile einfügen?");
		line = System.in.read();
		if (line > array.length) {
			throw new IllegalArgumentException("array has only " + array.length
					+ " lines");
		}

		System.out.println("In welche Spalte einfügen?");
		column = System.in.read();
		if (column > array[line].length) {
			throw new IllegalArgumentException("array has only "
					+ array[line].length + " columns!");
		}

		array[line][column] = value1;
	}

	private static void fillArrayInc ( Integer [][] array ){
		
		for (int i=0, i < array.size() , i++) {
			for (int j=0, j < array[i].size(), j++) {
				array[i][j] = i + j;
			}
		}
	}
}