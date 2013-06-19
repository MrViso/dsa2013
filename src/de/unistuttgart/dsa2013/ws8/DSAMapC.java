package de.unistuttgart.dsa2013.ws8;

/**
 * An interface for maps that allow the insertion and the retrieval of values.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public interface DSAMapC<K, V> extends DSAMapB<K, V> {
	
	/**
	 * Checks whether a given key is in the map.
	 * 
	 * @param key The key to find.
	 * @return A value that indicates whether the map contains the specified key.
	 * @throws IllegalArgumentException if key is null.
	 */
	public boolean containsKey(K key);
	
	/**
	 * Retrieves a value by its key.
	 * 
	 * @param key The key.
	 * @return The value.
	 * @throws IllegalArgumentException if key is null or if key is not in the map.
	 */
	public V get(K key);
}
