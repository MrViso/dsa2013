package de.unistuttgart.dsa2013.ws8;

/**
 * An interface for maps.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public interface DSAMapD<K, V> extends DSAMapC<K, V> {
	
	/**
	 * Removes a value from the map.
	 * 
	 * @param key The key of the value to remove.
	 * @return The value.
	 * @throws IllegalArgumentException if key is null or if key is not in the map.
	 */
	public V remove(K key);
}
