package de.unistuttgart.dsa2013.ws2;

import java.io.IOException;

public class Main {

	/**
	Main zum Testen der Methode shakerSort
	 */
	public static void main(String[] args) throws IOException {
		 List<Integer> myList = null;
		 Integer Number = 0;
		 Integer Value = null;
		 System.out.println("Wieviele Elemente?:");
		 try {
			Number = System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 /**
		 for (int i = 1; i < Number; i++){
			 System.out.println("Eingabe des " + i + "ten Wertes:");
					Value = System.in.read();
			 myList.setValue(Value);
			 myList = myList.getNext;

		 }*/
		 
		 myList.add(5);
		 myList.add(10);
		 myList.add(2);
		 myList.add(95);
		 myList.add(3);
		 
	}
}

