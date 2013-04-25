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
		
		if (nextNode == null)
			this.achtnext = null;
		else {
			SpeedNode<T> zeiger = nextNode;
			int i = 1;
			while ((i < 9 && zeiger.next != null) | (i == 8 && zeiger != null) ){
				if (i == 8 && zeiger != null)
					this.achtnext = zeiger;
				i++;
				zeiger = zeiger.next;
			}
		}
		
	}
	
}
