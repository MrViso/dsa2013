package de.unistuttgart.dsa2013.bws1;

import java.util.ArrayList;
import java.util.Iterator;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class main {
	
	void forSchleife (){
		ArrayList <String> items = new ArrayList <String>();
		
		for (String item : items){
			processValue(item);
		}
	}
	

	static void whileSchleifeA (ArrayList <String> eingang){
		ArrayList <String> items = eingang;
		//ArrayList <String> items = new ArrayList <String>();
		int i = 0;
		while (i < items.size()){
			processValue(items.get(i));	
			i++;
		}
		
	}
	
	static void whileSchleifeB (ArrayList <String> eingang){
		ArrayList <String> items = eingang;
		//ArrayList <String> items = new ArrayList <String>();
		Iterator<String> itemIterator = items.iterator();
		while (itemIterator.hasNext()){
			processValue(itemIterator.next());		
		}
		
	}
	
	

	private static void processValue(String item) {
		// TODO Auto-generated method stub
		System.out.println(item);
	}
	
	public static void main(String[] args){
		ArrayList <String> eingang = new ArrayList <String>();
		eingang.add("1");
		eingang.add("2");
		eingang.add("3");
		eingang.add("4");
		eingang.add("5");
		whileSchleifeA(eingang);
		whileSchleifeB(eingang);
	}
}
