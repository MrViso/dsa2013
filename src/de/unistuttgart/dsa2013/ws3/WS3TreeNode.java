package de.unistuttgart.dsa2013.ws3;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * The class WS3TreeNode implements a class type which allows zu create and
 * define nodes for a tree. Therefore you can find the class itself and some
 * methodes, which are used to build and define the connections to other nodes
 * of this type.
 * 
 * @param <E>
 *            The type of the values stored in the nodes of the tree.
 */
public class WS3TreeNode<E> {

	/**
	 * Initializes a new instance.
	 * 
	 * @param n
	 *            The maximum number of children.
	 * @throws IllegalArgumentException
	 *             if n is less than one.
	 */
	@SuppressWarnings("unchecked")
	public WS3TreeNode(int n) throws IllegalArgumentException {
		if (n < 1) {
			throw new IllegalArgumentException(
					"Knoten muss wenigstens ein Kind haben können.");
		}

		children = (WS3TreeNode<E>[]) new WS3TreeNode[n];
	}

	/**
	 * Initializes a new instance with a parent node.
	 * 
	 * @param parent
	 *            The parent node.
	 * @param n
	 *            The maximum number of children.
	 * @throws IllegalArgumentException
	 *             if parent is null, or if n is less than one.
	 */
	private WS3TreeNode(WS3TreeNode<E> parent, int n)
			throws IllegalArgumentException {
		this(n);
		if (parent == null) {
			throw new IllegalArgumentException("The parent must not be null.");
		}

		this.parent = parent;
	}

	/**
	 * The parent node.
	 */
	private WS3TreeNode<E> parent;

	/**
	 * Retrieves the parent node.
	 * 
	 * @return the parent node, or null if this is a root node.
	 */
	public WS3TreeNode<E> getParent() {
		return parent;
	}

	/**
	 * Indicates whether the current node is a root node of a tree.
	 * 
	 * @return a value that indicates whether this instance is a root node.
	 */
	public boolean isRoot() {
		return parent == null;
	}

	/**
	 * The array of child nodes.
	 */
	private WS3TreeNode<E>[] children;

	/**
	 * Adds a child node.
	 * 
	 * @param value
	 *            the new child node.
	 * @return The newly added child node.
	 */
	public WS3TreeNode<E> addChild(E value) {
		if (childCount < children.length) {
			WS3TreeNode<E> newNode = new WS3TreeNode<E>(this, children.length);
			newNode.setValue(value);
			children[childCount] = newNode;
			childCount++;
			return newNode;
		} else {
			throw new IllegalStateException(
					"The maximum number of children has already been reached.");
		}
	}

	/**
	 * The number of child nodes.
	 */
	private int childCount = 0;

	/**
	 * Returns the number of child nodes.
	 * 
	 * @return the number of child nodes.
	 */
	public int getChildCount() {
		return childCount;
	}

	/**
	 * Removes a child node at a given position.
	 * 
	 * @param index
	 *            the position of the child node to remove.
	 * @throws IndexOutOfBoundsException
	 *             if index is outside of the valid range.
	 */
	public void removeChildAt(int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= childCount)) {
			throw new IndexOutOfBoundsException(
					"The index is outside of the valid range.");
		}

		childCount--;
		for (int i = index; i < childCount; i++) {
			children[i] = children[i + 1];
		}
		children[childCount] = null;
	}

	/**
	 * Retrieves a child node at a given position.
	 * 
	 * @param index
	 *            the position of the child.
	 * @return the child node at the indicated position.
	 * @throws IndexOutOfBoundsException
	 *             if index is outside of the valid range.
	 */
	public WS3TreeNode<E> getChild(int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= childCount)) {
			throw new IndexOutOfBoundsException(
					"The index is outside of the valid range.");
		}

		return children[index];
	}

	/**
	 * The value of the tree node.
	 */
	private E value;

	/**
	 * Gets the value stored in the tree node.
	 * 
	 * @return the value of the tree node.
	 */
	public E getValue() {
		return value;
	}

	/**
	 * Sets the value stored in the tree node.
	 * 
	 * @param value
	 *            the new value of the tree node.
	 */
	public void setValue(E value) {
		this.value = value;
	}

	/**
	 * Checks if the tree is full oder not.
	 * 
	 * @return value if tree is full
	 */
	public boolean isFull() {
		boolean value = true;
		if (getChildCount() == children.length) {
			for (int i = 1; i <= children.length; i++)
				getChild(i).isFull();
		} else if (getChildCount() == 0) {
			value = true;
		} else {
			value = false;
		}
		return value;
	}
}
