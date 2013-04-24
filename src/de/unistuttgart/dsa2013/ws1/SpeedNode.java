/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

/**
 * @author Viso
 *
 */
public class SpeedNode<T> {
	public T value;
	public SpeedNode<T> next = null;
	public SpeedNode<T> achtnext = null;
	
	/**
	 *  Constructor fuer die SpeedList.
	 *
	 */
	public SpeedNode(T value, SpeedNode<T> nextNode) {
		this.value = value;
		this.next = nextNode;
	}
	
}
