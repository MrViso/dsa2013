package de.unistuttgart.dsa2013.bws2;

/**
 * Represents a town.
 */
public class Town {
	
	/**
	 * Initializes a new instance.
	 * 
	 * @param name The name of the town.
	 * @param latitude The latitude of the town.
	 * @param longitude The longitude of the town.
	 * @throws IllegalArgumentException if name is null.
	 */
	public Town(String name, double latitude, double longitude) {
		if (name == null) {
			throw new IllegalArgumentException("name must not be null.");
		}
		
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * Stores the name of the town.
	 */
	private final String name;
	
	/**
	 * Returns the name of the town.
	 * @return The name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Stores the latitude of the town.
	 */
	private final double latitude;
	
	/**
	 * The latitude of the town.
	 * @return The latitude.
	 */
	public double getLatitude() {
		return latitude;
	}
	
	/**
	 * Stores the longitude of the town.
	 */
	private final double longitude;
	
	/**
	 * The longitude of the town.
	 * @return The longitude.
	 */
	public double getLongitude() {
		return longitude;
	}
}
