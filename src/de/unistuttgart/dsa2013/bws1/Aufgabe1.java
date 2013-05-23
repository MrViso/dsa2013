package de.unistuttgart.dsa2013.bws1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implementierung von verschiedenen Schleifen
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-05-23 MV 1.0
 * @history 2013-05-23 MV 1.0 Implementierung der Schleifen
 * 
 */
public class Aufgabe1 {

	/**
	 * Urspruengliche Vorgabe in einer Methode umgesetzt.
	 * 
	 * ArrayList <String> items = new ArrayList <String>(); wurde zum Besseren
	 * Testen zum Kommentar gemacht und in die main gezogen.
	 * 
	 * 
	 * @param eingang
	 */
	static void forSchleife(ArrayList<String> eingang) {
		ArrayList<String> items = eingang;
		// ArrayList <String> items = new ArrayList <String>();

		for (String item : items) {
			processValue(item);
		}
	}

	/**
	 * Aufgabe 1a: Implementierung einer While Schleife mit Index i, welcher
	 * alle Elemente des Arrays durchgeht und weitergibt.
	 * 
	 * ArrayList <String> items = new ArrayList <String>(); wurde zum Besseren
	 * Testen zum Kommentar gemacht und in die main gezogen.
	 * 
	 * @param eingang
	 *            einlesen eines String Arrays
	 */
	static void whileSchleifeA(ArrayList<String> eingang) {
		ArrayList<String> items = eingang;
		// ArrayList <String> items = new ArrayList <String>();
		int i = 0;
		while (i < items.size()) {
			processValue(items.get(i));
			i++;
		}

	}

	/**
	 * Aufgabe 1b: Implementierung einer whileSchleife, welche mit Hilfe eines
	 * Iterators alle ArrayList Elemente durchgeht und an processValue
	 * uebergibt.
	 * 
	 * ArrayList <String> items = new ArrayList <String>(); wurde zum Besseren
	 * Testen zum Kommentar gemacht und in die main gezogen.
	 * 
	 * @param eingang
	 *            einlesen eines String Arrays
	 */
	static void whileSchleifeB(ArrayList<String> eingang) {
		ArrayList<String> items = eingang;
		// ArrayList <String> items = new ArrayList <String>();
		Iterator<String> itemIterator = items.iterator();
		while (itemIterator.hasNext()) {
			processValue(itemIterator.next());
		}

	}

	/**
	 * Aufgabe 1c: Implementierung einer For-Schleife welche mit Hilfe eines
	 * Iterators den naechsten Wert ausliest und daraufhin in eine Variable
	 * speichert
	 * 
	 * ArrayList <String> items = new ArrayList <String>(); wurde zum Besseren
	 * Testen zum Kommentar gemacht und in die main gezogen.
	 * 
	 * @param eingang
	 *            einlesen eines String Arrays
	 */
	static void forSchleifeC(ArrayList<String> eingang) {
		ArrayList<String> items = eingang;
		// ArrayList <String> items = new ArrayList <String>();
		Iterator<String> itemIterator = items.iterator();
		for (int i = 0; i < items.size(); i++) {
			String item = itemIterator.next();
			processValue(item);
		}

	}

	/**
	 * Eine einfache implementation der Methode, welches erlaubt die Elemente
	 * direkt auszugeben.
	 * 
	 * @param item
	 *            Auszugebendes Element.
	 */
	private static void processValue(String item) {
		System.out.println(item);
	}

	/**
	 * Main Methode, welche alle Methoden der Klasse testet.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Hier findet sich die erste Zeile der Quelltextvorgabe!!
		ArrayList<String> items = new ArrayList<String>();

		// Array mit Werten vorsorgen
		items.add("1");
		items.add("2");
		items.add("3");
		items.add("4");
		items.add("5");

		// Test der vorgegebenen for-Schleife
		System.out.println("Ausgangs for-schleife");
		forSchleife(items);
		System.out.println("--");

		// Test der While Schleife mit Index
		System.out.println("Aufgabe 1a: While Schleife mit Index");
		whileSchleifeA(items);
		System.out.println("--");

		// Test der While Schleife mit Iterator
		System.out.println("Aufgabe 1b: While Schleife mit Iterator");
		whileSchleifeB(items);
		System.out.println("--");

		// Test der For Schleife mit Iterator
		System.out.println("Aufgabe 1c: For Schleife mit Iterator");
		forSchleifeC(items);
		System.out.println("--");
	}
}
