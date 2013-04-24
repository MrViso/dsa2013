/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

/**
 * @author Viso
 *
 */
public class SpeedList<T> implements A1aCollection<T> {
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
	
	public void prepend (T item) {
		SpeedList<T> newFirst = new SpeedList<T> (item, firstNode);
		firstNode = newFirst;
	}
	
	public int size() {
		int i = 0;
		SpeedList<T> zeiger = firstNode;
		
		if (zeiger == null)
			return i;
		
		do {
			i++;
			zeiger = zeiger.next;			
		} while (zeiger.next != null);
		
		return i;
		
	}
}


