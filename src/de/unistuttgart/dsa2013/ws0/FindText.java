/**
 * 
 */
package de.unistuttgart.dsa2013.ws0;

/**
 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
 * @history 2013-04-16 MV 1.0 Erste Version
 * @history 2013-04-17 MV 1.1 Verbesserung der null Pruefung
 * @history 2014-04-18 MV 1.2 Erweiterung der Kommentare
 * @version 2013-04-18 MV 1.2
 * 
 */
public class FindText {
	/**
	 * Die Methode findText ueberprueft eine Product-Instanz nach dem gesuchten
	 * String searchText und gibt daraufhin die zugehoerige Konstante des
	 * Aufzaehlungstypen ProductFact zurueck. Falls der String nicht gefunden
	 * oder einer der beiden eingehenden Parameter null sein sollte, wird eine
	 * IllegalArgumentException ausgeworfen.
	 * 
	 * @param product
	 *            Eine Instanz vom Typ Product
	 * @param searchText
	 *            Der gesuchte String, der in product gefunden werden soll.
	 * @return Gibt die Konstanten vom Aufzaehlungstyp ProductFact zurueck.
	 * @see de.unistuttgart.dsa2013.ws0.Product
	 * @see de.unistuttgart.dsa2013.ws0.Manufacturer
	 * @see de.unistuttgart.dsa2013.ws0.ProductFact
	 * @throws IllegalArgumentException
	 */
	public static ProductFact findText(Product product, String searchText)
			throws IllegalArgumentException {

		// Pruefung auf null Werte in den Parametern
		if (searchText != null && product != null) {

			// Pruefung: product.name
			if (product.getName() != null) {
				int index = product.getName().indexOf(searchText);
				if (index > -1)
					return ProductFact.NAME;
			}

			// Pruefung: product.description
			if (product.getDescription() != null) {
				int index = product.getDescription().indexOf(searchText);
				if (index > -1)
					return ProductFact.DESCRIPTION;
			}

			// Pruefung: product.manufacturer.name
			if (product.getManufacturer().getName() != null) {
				int index = product.getManufacturer().getName()
						.indexOf(searchText);
				if (index > -1)
					return ProductFact.MANUFACTURER_NAME;
			}

			// Pruefung: product.manufacturer.street
			if (product.getManufacturer().getStreet() != null) {
				int index = product.getManufacturer().getStreet()
						.indexOf(searchText);
				if (index > -1)
					return ProductFact.MANUFACTURER_STREET;
			}

			// Pruefung: product.manufacturer.city
			if (product.getManufacturer().getCity() != null) {
				int index = product.getManufacturer().getCity()
						.indexOf(searchText);
				if (index > -1)
					return ProductFact.MANUFACTURER_CITY;
			}

			// Pruefung: product.manufacturer.country
			if (product.getManufacturer().getCountry() != null) {
				int index = product.getManufacturer().getCountry()
						.indexOf(searchText);
				if (index > -1)
					return ProductFact.MANUFACTURER_COUNTRY;
			}
		}

		// Auswerfen der IllegalArgumentException
		throw new IllegalArgumentException();
	}
}
