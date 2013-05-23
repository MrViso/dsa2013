package de.unistuttgart.dsa2013.bws1;

/**
 * Aufgabe 3 des Bonusarbeitsblatts Zwei Funktionen welche zum einen eine
 * 2D-Arraymatrix aufbauen und einzelne Werte nach Wunsch setzen können.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-05-23 MV 1.2
 * @history 2013-05-23 FM 1.0 Implementierung von fillArray und fillArrayInc
 * @history 2013-05-23 MV 1.1 Fehlerkorrektur und Eingabeoptimierung
 * @history 2013-05-23 MV 1.2 fillArray neu implementiert, nach missverstaendnis
 * 
 */
public class Aufgabe3 {

	/**
	 * Fuellt ein Array mit Wert value
	 * 
	 * @param array
	 *            zu bearbeitendes Array
	 * @param value
	 *            einzufuegender Wert
	 */
	public static void fillArray(Integer[][] array, int value) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = value;
			}
		}
	}

	/**
	 * Fuellt ein Array mit den Summen der Linien und Spalten Werte
	 * 
	 * @param array
	 *            zu fuellendes Array
	 */
	public static void fillArrayInc(Integer[][] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = i + j;
			}
		}
	}

	/**
	 * Einfache Ausgabe, fuer das Testprogramm
	 * 
	 * @param array
	 *            auszugebender Array
	 */
	public static void ausgabe(Integer[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	/**
	 * Testprogramm
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[][] array = new Integer[3][5];
		fillArrayInc(array);
		ausgabe(array);

		int value = 10;

		fillArray(array, value);
		ausgabe(array);

	}

}