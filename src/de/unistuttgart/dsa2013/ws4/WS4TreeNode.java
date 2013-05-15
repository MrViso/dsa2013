package de.unistuttgart.dsa2013.ws4;

/**
 * Represents a node in an n-ary tree.
 *
 * @param <E> The type of the values stored in the nodes of the tree.
 */
public class WS4TreeNode<E> implements GenericTreeNode<E> {
	
	/**
	 * Stores the unique ID for the next instance of the class.
	 */
	private static int nextNodeId = Integer.MIN_VALUE;
	
	/**
	 * Stores the unique ID of the node.
	 */
	private final int nodeId = nextNodeId++;
	
	/**
	 * Returns the unique ID of the node.
	 * 
	 * @return the unique ID.
	 */
	public int getNodeId() {
		return nodeId;
	}
	
	/**
	 * Initializes a new instance.
	 * 
	 * @param n The maximum number of children.
	 * @param value The value of the new node.
	 * @throws IllegalArgumentException if n is less than one, or if value is null.
	 */
	@SuppressWarnings("unchecked")
	public WS4TreeNode(int n, E value) {
		if (n < 1) {
			throw new IllegalArgumentException("The maximum number of children cannot be less than one.");
		}
		if (value == null) {
			throw new IllegalArgumentException("The value cannot be null.");
		}
		
		children = (WS4TreeNode<E>[])new WS4TreeNode[n];
		this.value = value;
	}
	
	/**
	 * Initializes a new instance with a parent node.
	 * 
	 * @param parent The parent node.
	 * @param n The maximum number of children.
	 * @param value The value of the new node.
	 * @throws IllegalArgumentException if parent is null, or if n is less than one, or if value is null.
	 */
	private WS4TreeNode(WS4TreeNode<E> parent, int n, E value) {
		this(n, value);
		if (parent == null) {
			throw new IllegalArgumentException("The parent must not be null.");
		}
		
		this.parent = parent;
	}
	
	/**
	 * The parent node.
	 */
	private WS4TreeNode<E> parent;
	
	/**
	 * Retrieves the parent node.
	 * 
	 * @return the parent node, or null if this is a root node.
	 */
	public WS4TreeNode<E> getParent() {
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
	private WS4TreeNode<E>[] children;
	
	/**
	 * Adds a child node.
	 * 
	 * @param value the new child node.
	 * @return The newly added child node.
	 * @throws IllegalArgumentException if the value is null.
	 */
	public WS4TreeNode<E> addChild(E value) {
		if (value == null) {
			throw new IllegalArgumentException("The value cannot be null.");
		}
		
		if (childCount < children.length) {
			WS4TreeNode<E> newNode = new WS4TreeNode<E>(this, children.length, value);
			children[childCount] = newNode;
			childCount++;
			return newNode;
		} else {
			throw new IllegalStateException
					("The maximum number of children has already been reached.");
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
	 * @param index the position of the child node to remove.
	 * @throws IndexOutOfBoundsException if index is outside of the valid range.
	 */
	public void removeChildAt(int index) {
		if ((index < 0) || (index >= childCount)) {
			throw new IndexOutOfBoundsException("The index is outside of the valid range.");
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
	 * @param index the position of the child.
	 * @return the child node at the indicated position.
	 * @throws IndexOutOfBoundsException if index is outside of the valid range.
	 */
	public WS4TreeNode<E> getChildAt(int index) {
		if ((index < 0) || (index >= childCount)) {
			throw new IndexOutOfBoundsException("The index is outside of the valid range.");
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
	 * @param value the new value of the tree node.
	 * @throws IllegalArgumentException if the value is null.
	 */
	public void setValue(E value) {
		if (value == null) {
			throw new IllegalArgumentException("The value cannot be null.");
		}
		
		this.value = value;
	}
}
