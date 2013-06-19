package de.unistuttgart.dsa2013.ws8;

/**
 * An interface for maps that allow only insertion of values.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public interface DSAMapB<K, V> extends DSAMapA<K, V> {
	
	/**
	 * Stores a value in the map.
	 * 
	 * @param key The key of the new value.
	 * @param value The new value.
	 * @return The previous value stored for key, or null if there was no previous value.
	 * @throws IllegalArgumentException if key is null.
	 * @throws IllegalStateException if there is no space left in the table.
	 */
	public V put(K key, V value);
}
