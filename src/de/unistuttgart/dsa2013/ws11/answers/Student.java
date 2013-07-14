package de.unistuttgart.dsa2013.ws11.answers;

import de.unistuttgart.dsa2013.ws11.Table;

/**
 * Implementierung von Multitheading in Java
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-07-11 MV 1.0
 * @history 2013-07-11 MV 1.0 Implementierung der Aufgabe
 * 
 */

public class Student implements Runnable {
	/**
	 * Variablen
	 */
	private String name;
	private Table table;

	/**
	 * Konstruktor der einzelnen Studenten
	 * 
	 * @param name
	 *            Name des Studenten
	 * @param table
	 *            Tisch
	 */
	public Student(String name, Table table) {
		this.name = name;
		this.table = table;
	}

	/**
	 * Die run() Methode ueber welche die Studenten arbeiten sollen. Um die
	 * Schritte alle besser zu verstehen wurden noch eine Textausgabe eingefuegt
	 * mit allen Arbeitsschritten
	 * 
	 */
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(name + " denkt nach.");
				Thread.sleep((long) 300 + (long) (Math.random() * 1000));
				synchronized (table) {
					table.getPencil();
					table.writeLog(name + " fügt eine Lösung hinzu.");
					System.out.println(name
							+ " bekommt den Bleistift und schreibt etwas.");
					Thread.sleep((long) 300 + (long) (Math.random() * 1000));
					table.notifyStudentDone();
					System.out.println(name + " gibt den Bleistift zurueck.");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Die Startmethode ueber welche die Threads erstellt werden.
	 */
	public void startWork() {
		new Thread(this).start();
	}

}
