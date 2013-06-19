package de.unistuttgart.dsa2013.ws8;

import java.util.Iterator;

public class DSAOpenHashmap<K, V> implements DSAMapD<K, V> {
	private final KeyValuePair<K, V>[] table;
	private final int c;

	public DSAOpenHashmap(int size, int c){
		if (c<1)
			throw new IllegalArgumentException("c muss mindestens 1 groß sein");
		this.table = new KeyValuePair[size];
		this.c = c;
		
	}



	@Override
	public Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>>(table);
	}

	@Override
	public V put(K key, V value) {
		int index = getIndex(key);
		if (table[index] == null){
			table[index] = new KeyValuePair<K, V>(key, value);
		}
		
		for (KeyValuePair<K, V> entry : table[index]){
			if (entry.getKey().equals(key)){
				V oldValue  = entry.getValue();
				entry.setValue(value);
				return oldValue;
			}
		}
		table[index].addLast(new KeyValuePair<K,V>(key, value));		
		
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public V get(K key) {
		int index = getIndex(key);
		if (table[index] != null){
			for (KeyValuePair<K, V> entry : table[index]){
				if (entry.getKey().equals(key)){
					return entry.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int index = getIndex(key);
		if (table[index] != null){
			Iterator<de.unistuttgart.dsa2013.ws8.DSAMapA.KeyValuePair<K, V>> it = table[index].iterator();
			
			while (it.hasNext()){
				KeyValuePair<K,V> entry = it.next();
				if (entry.getKey().equals(key)){
					it.remove();
					return entry.getValue();
				}
			}
		}
		
		return null;
	}

	public KeyValuePair<K, V>[] getTable() {
		return table;
	}

	public int getC() {
		return c;
	}

}
