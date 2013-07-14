package de.unistuttgart.dsa2013.bws2;
/**
 * A node in a quadtree, i.e. a single rectangular cell in a quadtree.
 */
public interface QuadNodeA {
	
	/**
	 * The horizontal position of the top left corner.
	 * 
	 * @return The X position.
	 */
	double getX();
	
	/**
	 * The vertical position of the top left corner.
	 * 
	 * @return The Y position.
	 */
	double getY();
	
	/**
	 * The width of the quadtree cell.
	 * 
	 * @return The width.
	 */
	double getWidth();
	
	/**
	 * The height of the quadtree cell.
	 * 
	 * @return The height.
	 */
	double getHeight();
	
	/**
	 * Checks whether a given location is inside of the cell.
	 * 
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 * @return A value that indicates whether the point is within the quadtree cell.
	 */
	boolean contains(double x, double y);
}