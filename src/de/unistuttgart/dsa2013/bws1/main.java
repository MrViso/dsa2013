package de.unistuttgart.dsa2013.bws1;

import java.util.ArrayList;
import java.util.Iterator;

public class main {
	
	void forSchleife (){
		ArrayList <String> items = new ArrayList <String>();
		
		for (String item : items){
			processValue(item);
		}
	}
	
	void whileSchleifeA (){
		ArrayList <String> items = new ArrayList <String>();
		int i = 0;
		while (i < items.size()){
			processValue(items.get(i));		
		}
		
	}
	
	void whileSchleifeB (){
		ArrayList <String> items = new ArrayList <String>();
		Iterator<String> itemIterator = items.iterator();
		while (itemIterator.hasNext()){
			processValue(itemIterator.next());		
		}
		
	}
	
	

}
