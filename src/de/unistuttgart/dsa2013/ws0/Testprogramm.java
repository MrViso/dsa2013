package de.unistuttgart.dsa2013.ws0;

/**
 * 
 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
 * @history 2013-04-17 MV 1.0 Erste Version
 * @history 2013-04-17 MV 1.1 Erweiterung um weitere Tests
 * @version 2013-04-17 MV 1.1
 * 
 */
public class Testprogramm {
	/**
	 * Testprogramm um die Methode FindText.findText und die Typen Product,
	 * Manufacturer, ProductFact zu testen.
	 * 
	 * @param args
	 * @see de.unistuttgart.dsa2013.ws0.Product
	 * @see de.unistuttgart.dsa2013.ws0.Manufacturer
	 * @see de.unistuttgart.dsa2013.ws0.ProductFact
	 * @see de.unistuttgart.dsa2013.ws0.FindText
	 */
	public static void main(String[] args) {

		try {

			Manufacturer daimler = new Manufacturer();

			daimler.setName("Daimler AG");
			daimler.setStreet("Bela-Barenyi-Strasse");
			daimler.setCity("Sindelfingen");
			daimler.setCountry("Deutschland");

			Product ware1 = new Product("A-Klasse", 25000, daimler);
			// ware1.setDescription("Nettes Mittelklasse Auto!");

			// Test 1: Product.Name
			System.out.println("Suche: Klasse");
			ProductFact FACT = FindText.findText(ware1, "Klasse");
			System.out.println("Ausgabe: " + FACT);

			// Test 2: Product.Manufacturer.Name
			System.out.println("Suche: Daimler");
			FACT = FindText.findText(ware1, "Daimler");
			System.out.println("Ausgabe: " + FACT);

			// Test 3: Exception: String nicht vorhanden
			System.out.println("Suche: BMW");
			FACT = FindText.findText(ware1, "BMW");
			System.out.println("Ausgabe: " + FACT);

		} catch (IllegalArgumentException ex) {
			System.out.println("String wurde nicht gefunden.");
			System.exit(1);
		}

	}

}
