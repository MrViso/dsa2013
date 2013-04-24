package de.unistuttgart.dsa2013.ws1.interfacedemo;

import java.util.ArrayList;

public class Minibar {
	public static void main(String[] args) {
		ArrayList<Drinkable> drinks  = new ArrayList<Drinkable>();
		drinks.add(new Beer());
		drinks.add(new Beer());
		drinks.add(new Water());
		
		for (Drinkable drink : drinks) {
			drink.drink();
		}
	
	}
}