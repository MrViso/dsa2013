package de.unistuttgart.dsa2013.ws8;

import java.util.Iterator;

/**
 * Implementation der Open Hashmap orientiert an den Vorlesungsfolien
 * V14_Hashing.pdf der aktuellen DSA Vorlesung.
 * 
 * @author Maximilian Visotschnig
 * @author Frank Merkle
 * @author Alessandro Tridico
 * @version 2013-06-20 MV 1.0
 * @history 2013-06-20 MV 1.0 Erste Version
 * 
 * @param <K>
 *            Schluessel Typ
 * @param <V>
 *            Werte Typ
 * 
 */
public class DSAOpenHashmap<K, V> implements DSAMapD<K, V> {
	private final KeyValuePair<K, V>[] table;
	private final int c;

	/**
	 * Initialisiert eine Hashmap
	 * 
	 * @param size
	 *            Anzahl der Elemente
	 * @param c
	 *            Schrittweite
	 * @throws IllegalArgumentException
	 *             if c<1
	 */
	public DSAOpenHashmap(int size, int c) throws IllegalArgumentException {
		if (c < 1)
			throw new IllegalArgumentException("c muss mindestens 1 groß sein");
		table = new KeyValuePair[size];
		this.c = c;

	}

	/**
	 * Iterator
	 * 
	 * @return Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>>
	 *         Den Iterator der genutzt werden soll
	 * 
	 */
	@Override
	public Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>>(table);
	}

	/**
	 * Methode put fuegt einen Wert in die Hashmap hinzu, wenn dieser noch nicht
	 * enthalten ist.
	 * 
	 * @param key
	 *            Der Schluessel des Eintrags
	 * @param value
	 *            der Wert des Eintrags
	 * @throws IllegalArgumentException
	 *             if key or value is null
	 */
	@Override
	public V put(K key, V value) throws IllegalArgumentException {
		if (key == null)
			throw new IllegalArgumentException("Key ist null in V put");
		if (value == null)
			throw new IllegalArgumentException("Value ist null in V put");

		int index = getIndex(key);
		if (table[index] == null) {
			table[index] = new KeyValuePair<K, V>(key, value);
		}

		for (KeyValuePair<K, V> entry : this) {
			if (entry.getKey().equals(key)) {
				V oldValue = entry.getValue();
				entry.setValue(value);
				return oldValue;
			}
		}
		table[index].addLast(new KeyValuePair<K, V>(key, value));

		return null;
	}

	/**
	 * Index des Keys heraussuchen
	 * 
	 * @param key
	 *            der in Index gewandelt werden muss
	 * @return int gesuchter Index fuer die Hashmap
	 * 
	 * @throw IllegalArgumentException wenn key null ist
	 */
	private int getIndex(K key) throws IllegalArgumentException {
		if (key == null)
			throw new IllegalArgumentException("key ist bei int getIndex null");
		return Math.abs(key.hashCode()) % table.length;
	}

	/**
	 * Prueft ob Key vorhanden ist
	 * 
	 * @param key
	 *            nach dem gesucht werden soll
	 * @return Wahrheitswert ob Key vorhanden oder nicht
	 * @throws IllegalArgumentException
	 *             falls Key null ist
	 */
	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		if (key == null)
			throw new IllegalArgumentException(
					"Schluessel ist bei boolean containsKey null");

		Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>> it = this
				.iterator();
		while (it.hasNext()) {
			KeyValuePair<K, V> entry = it.next();
			if (entry.getKey() == key) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gibt einen Wert aus, der nach seinem Key gesucht wird
	 * 
	 * @param key
	 *            der Schluessel des gesuchten Werts
	 * @return der gesuchte Wert
	 * @throws IllegalArgumentException
	 *             wenn key null ist
	 * 
	 */
	@Override
	public V get(K key) throws IllegalArgumentException {
		if (key == null)
			throw new IllegalArgumentException("Schluessel ist bei V get null");
		int index = getIndex(key);
		if (table[index] != null) {
			for (KeyValuePair<K, V> entry : this) {
				if (entry.getKey().equals(key)) {
					return entry.getValue();
				}
			}
		}
		return null;
	}

	/**
	 * Entfernt einen Eintrag ausgehend von seinem Schluessel
	 * 
	 * @param key
	 *            Der Schluessel der auf den zu entfernenden Wert zeigt
	 * @return Den Wert der entfernt werden soll
	 * @throws IllegalArgumentException
	 *             Wenn key null ist
	 * 
	 */
	@Override
	public V remove(K key) throws IllegalArgumentException {
		if (key == null)
			throw new IllegalArgumentException(
					"Schluessel ist bei V remove null");
		int index = getIndex(key);
		if (table[index] != null) {
			Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>> it = this
					.iterator();

			while (it.hasNext()) {
				KeyValuePair<K, V> entry = it.next();
				if (entry.getKey().equals(key)) {
					it.remove();
					return entry.getValue();
				}
			}
		}

		return null;
	}

	/**
	 * Gibt den Table zurueck
	 * 
	 * @return Der auszugebende Table
	 */
	public KeyValuePair<K, V>[] getTable() {
		return table;
	}

	/**
	 * Gibt die Schrittweite c aus
	 * 
	 * @return Schrittweite c
	 */
	public int getC() {
		return c;
	}

}
