package de.unistuttgart.dsa2013.bws1;

import java.util.ArrayList;
import java.util.Iterator;


public class aufgabe1 {

	/**
	 * 
	 * @param eingang
	 */
	static void forSchleife(ArrayList<String> eingang) {
		ArrayList<String> items = eingang;

		for (String item : items) {
			processValue(item);
		}
	}

	/**
	 * 
	 * @param eingang
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
	 * 
	 * @param eingang
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
	 * 
	 * @param eingang
	 */
	static void forSchleifeC(ArrayList<String> eingang) {
		ArrayList<String> items = eingang;
		// ArrayList <String> items = new ArrayList <String>();
		Iterator<String> itemIterator = items.iterator();
		for (int i = 0; i < items.size(); i++){
			String item = itemIterator.next();
			processValue(item);
		}
		
	}

	private static void processValue(String item) {
		System.out.println(item);
	}

	public static void main(String[] args) {
		ArrayList<String> eingang = new ArrayList<String>();
		eingang.add("1");
		eingang.add("2");
		eingang.add("3");
		eingang.add("4");
		eingang.add("5");
		System.out.println("Ausgangs for-schleife");
		forSchleife(eingang);
		System.out.println("Aufgabe 1a: While Schleife mit Index");
		whileSchleifeA(eingang);
		System.out.println("Aufgabe 1b: While Schleife mit Iterator");
		whileSchleifeB(eingang);
		System.out.println("Aufgabe 1c: For Schleife mit Iterator");
		forSchleifeC(eingang);
	}
}
