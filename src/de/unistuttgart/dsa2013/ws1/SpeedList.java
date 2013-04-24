/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

/**
 * @author Viso
 *
 */
public class SpeedList<T> {
	public T value;
	public SpeedList<T> next = null;
	public SpeedList<T> achtnext = null;
	
	/**
	 *  Constructor fuer die SpeedList.
	 *
	 */
	public SpeedList(T value, SpeedList<T> nextNode) {
		this.value = value;
		this.next = nextNode;
	}
}


