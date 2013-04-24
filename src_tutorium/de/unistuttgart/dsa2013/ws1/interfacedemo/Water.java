package de.unistuttgart.dsa2013.ws1.interfacedemo;

public class Water implements Drinkable {

	@Override
	public void drink() {
		System.out.println("Wasser, erfrischend");
	}
}