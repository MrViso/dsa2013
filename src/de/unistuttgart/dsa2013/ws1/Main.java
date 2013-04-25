/**
 * 
 */
package de.unistuttgart.dsa2013.ws1;

/**
 * @author Viso
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpeedList<Integer> liste = new SpeedList<Integer>();
		
		for (int i = 1999; i >= 1; i--){
			liste.prepend(i);	
		}
		
		int anzahl = liste.size();
		System.out.println(anzahl);
		
		
	}

}
