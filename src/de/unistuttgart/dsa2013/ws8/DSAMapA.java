package de.unistuttgart.dsa2013.ws8;

/**
 * A base interface for maps that allow enumeration of their values.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public interface DSAMapA<K, V> extends Iterable<DSAMapA.KeyValuePair<K, V>> {
	
	/**
	 * A class that stores a value along with its key.
	 *
	 * @param <K> The key type.
	 * @param <V> The value type.
	 */
	public final static class KeyValuePair<K, V> {
		
		/**
		 * Initializes a new instance.
		 * 
		 * @param key The key.
		 * @param value The value.
		 * @throws IllegalArgumentException if key is null.
		 */
		public KeyValuePair(K key, V value) {
			if (key == null) {
				throw new IllegalArgumentException("key must not be null.");
			}
			
			this.key = key;
			this.value = value;
		}
		
		/**
		 * The key.
		 */
		private final K key;
		
		/**
		 * Returns the key.
		 * 
		 * @return The key.
		 */
		public K getKey() {
			return key;
		}
		
		/**
		 * The value.
		 */
		private final V value;
		
		/**
		 * Returns the value.
		 * 
		 * @return The value.
		 */
		public V getValue() {
			return value;
		}
		
		/**
		 * Returns the hash code of the key.
		 */
		@Override
		public int hashCode() {
			return key.hashCode();
		}
	}
}
