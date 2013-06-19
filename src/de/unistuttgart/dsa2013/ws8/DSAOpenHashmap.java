package de.unistuttgart.dsa2013.ws8;

import java.util.Iterator;

public class DSAOpenHashmap <K, V> implements DSAMapD<K, V> {


	
	
	public DSAOpenHashmap(int size, int c){
		this.table = KeyValuePair<K,V>[size];
		this.c = c;
		
	}
	
	private final KeyValuePair<K,V>[] table;

	private final int c;
	
	
	@Override
	public Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	public KeyValuePair<K, V>[] getTable() {
		return table;
	}

	public int getC() {
		return c;
	}
	
	
}
