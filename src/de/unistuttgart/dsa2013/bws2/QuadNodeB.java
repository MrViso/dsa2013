package de.unistuttgart.dsa2013.bws2;

public interface QuadNodeB extends QuadNodeA {
	
	/**
	 * Adds a town to the quadtree.
	 * 
	 * @param town
	 * @throws IllegalArgumentException if town is null.
	 */
	void add(Town town);
	
	/**
	 * Enumerates the towns that are directly in the current quadtree cell.
	 * This method returns an object that enumerates all towns that are immediately stored in the current quadtree cell.
	 * Towns in nested child cells are not considered.
	 * 
	 * @return The towns.
	 */
	Iterable<Town> getTowns();
	
	/**
	 * Enumerates any nested child cells of the current quadtree cell.
	 * 
	 * @return The enumerator object.
	 */
	Iterable<QuadNodeB> getChildren();
	
	/**
	 * Indicates whether the current quadtree cell has any child cells.
	 * 
	 * @return A value that indicates whether the cell has any children.
	 */
	boolean hasChildren();
}
