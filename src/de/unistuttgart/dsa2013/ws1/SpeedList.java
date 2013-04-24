/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

/**
 * @author Viso
 *
 */
public class SpeedList<T> implements A1aCollection<T> {

	SpeedNode<T> firstNode;
	
	public void prepend (T item) {
		SpeedNode<T> newFirst = new SpeedNode<T> (item, firstNode);
		firstNode = newFirst;
	}
	
	public int size() {
		int i = 0;
		SpeedNode<T> zeiger = firstNode;
		
		if (zeiger == null)
			return i;
		
		do {
			i++;
			zeiger = zeiger.next;			
		} while (zeiger.next != null);
		
		return i;
		
	}
}


