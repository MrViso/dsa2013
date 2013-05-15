package de.unistuttgart.dsa2013.ws4;

import java.awt.Point;

/**
 * An interface for objects that store the location of tree nodes.
 *
 * @param <T> The data type stored in the tree.
 */
public interface TreeLocationStorage<T> {
	
	Point getNodeLocation(GenericTreeNode<T> node);
	
	void setNodeLocation(GenericTreeNode<T> node, Point location);
}
