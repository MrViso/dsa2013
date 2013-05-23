package de.unistuttgart.dsa2013.bws1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Aufgabe 2 des Bonusarbeitsblatts Zwei Funktionen welche zum einen eine
 * 2D-Arraymatrix aufbauen und einzelne Werte nach Wunsch setzen können.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-05-23 MV 1.1
 * @history 2013-05-23 FM 1.0 Implementierung von fillArray und fillArrayInc
 * @history 2013-05-23 MV 1.1 Fehlerkorrektur und Eingabeoptimierung
 * 
 */
public class Aufgabe2 {

	public static void fillArray (Integer[][] array, int value){
		for (int i= 0; i < array.length; i++){
			for (int j = 0; j <array[i].length; j++){
				array[i][j] = value;
			}
		}
	}

	public static void fillArrayInc(Integer[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = i + j;
			}
		}
	}

	/**
	 * Ermoeglicht es direkt ein Feld im Array anzusteuern und zu aendern.
	 * 
	 * @param array
	 * @param value
	 * @throws IllegalArgumentException
	 *             Wirft Fehler bei falschen Argumenten aus
	 * @throws IOException
	 *             Wirft Fehler bei der Texteingabe aus
	 */
	private static void setArrayField(Integer[][] array, int value)
			throws IllegalArgumentException, IOException {
		if (array == null) {
			throw new IllegalArgumentException("array must not be null.");
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int column = 0;
		int line = 0;
		int value1 = 0;

		System.out.println("Welchen Wert einfügen?");

		value1 = Integer.parseInt(br.readLine());

		System.out.println("In welche Zeile einfügen?");
		line = Integer.parseInt(br.readLine());
		if (line > array.length || line < 1) {
			throw new IllegalArgumentException("array has only " + array.length
					+ " lines");
		}

		System.out.println("In welche Spalte einfügen?");
		column = Integer.parseInt(br.readLine());
		if (column > array[line].length || column < 1) {
			throw new IllegalArgumentException("array has only "
					+ array[line].length + " columns!");
		}

		// Um die Zeilennummer anzupassen (Zeile/Spalte 1 ist ja als 0 im Array
		// eingelesen)
		column--;
		line--;

		array[line][column] = value1;

	}

	public static void ausgabe(Integer[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Integer[][] array = new Integer[3][5];
		fillArrayInc(array);
		ausgabe(array);
		
		int value = 10;
		
		fillArray(array, value);
		ausgabe(array);

		try {
			setArrayField(array, 5);
			ausgabe(array);
		} catch (IllegalArgumentException ex) {
			System.exit(0);
		} catch (IOException ex) {
			System.exit(0);
		}

	}

}