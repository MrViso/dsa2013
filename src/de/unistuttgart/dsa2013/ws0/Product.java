/**
 * 
 */
package de.unistuttgart.dsa2013.ws0;

/**
 * 
 * @author Maximilian Visotschnig, Frank Merkle, Alessandro Tridico
 * @history 2013-04-16 MV 1.0 Erste Version
 * @version 2013-04-16 MV 1.0
 * @see de.unistuttgart.dsa2013.ws0.Manufacturer
 * 
 */
public class Product {
	private String name;
	private String description;
	private int price;
	private Manufacturer manufacturer;

	public Product(String name, int price, Manufacturer manufacturer) {
		this.name = name;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

}
