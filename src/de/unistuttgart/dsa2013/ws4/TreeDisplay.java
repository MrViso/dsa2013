package de.unistuttgart.dsa2013.ws4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public final class TreeDisplay {
	
	private static class TreeInfoStorage<T> implements TreeSizeStorage<T>, TreeLocationStorage<T> {
		
		private class NodeInfo {
			
			private Dimension nodeSize = new Dimension();
			
			private Dimension subtreeSize = new Dimension();
			
			private Point nodeLocation = new Point();

			public Dimension getNodeSize() {
				return nodeSize;
			}

			public void setNodeSize(Dimension nodeSize) {
				if (nodeSize == null) {
					throw new IllegalArgumentException("The new value must not be null.");
				}
				
				this.nodeSize = nodeSize;
			}

			public Dimension getSubtreeSize() {
				return subtreeSize;
			}

			public void setSubtreeSize(Dimension subtreeSize) {
				if (subtreeSize == null) {
					throw new IllegalArgumentException("The new value must not be null.");
				}
				
				this.subtreeSize = subtreeSize;
			}

			public Point getNodeLocation() {
				return nodeLocation;
			}

			public void setNodeLocation(Point nodeLocation) {
				if (nodeLocation == null) {
					throw new IllegalArgumentException("The new value must not be null.");
				}
				
				this.nodeLocation = nodeLocation;
			}
		}
		
		private final Map<Integer, NodeInfo> data = new HashMap<Integer, NodeInfo>();
		
		private NodeInfo retrieveInfo(GenericTreeNode<T> node) {
			if (node == null) {
				throw new IllegalArgumentException("The supplied node must not be null.");
			}
			
			NodeInfo result = data.get(node.getNodeId());
			if (result == null) {
				result = new NodeInfo();
				data.put(node.getNodeId(), result);
			}
			return result;
		}

		@Override
		public Point getNodeLocation(GenericTreeNode<T> node) {
			return retrieveInfo(node).getNodeLocation();
		}

		@Override
		public void setNodeLocation(GenericTreeNode<T> node, Point location) {
			retrieveInfo(node).setNodeLocation(location);
		}

		@Override
		public Dimension getSubtreeSize(GenericTreeNode<T> root) {
			return retrieveInfo(root).getSubtreeSize();
		}

		@Override
		public void setSubtreeSize(GenericTreeNode<T> root, Dimension size) {
			if (sizesReadOnly) {
				throw new UnsupportedOperationException();
			}
			
			retrieveInfo(root).setSubtreeSize(size);
		}

		@Override
		public Dimension getNodeSize(GenericTreeNode<T> node) {
			return retrieveInfo(node).getNodeSize();
		}

		@Override
		public void setNodeSize(GenericTreeNode<T> node, Dimension size) {
			if (sizesReadOnly) {
				throw new UnsupportedOperationException();
			}
			
			retrieveInfo(node).setNodeSize(size);
		}
		
		private boolean sizesReadOnly;

		public void setSizesReadOnly(boolean sizesReadOnly) {
			this.sizesReadOnly = sizesReadOnly;
		}
	}
	
	@SuppressWarnings("serial")
	private static class TreePanel<T> extends JPanel {
		
		public TreePanel(TreeInfoProvider<T> infoProvider) {
			if (infoProvider == null) {
				throw new IllegalArgumentException();
			}
			
			this.infoProvider = infoProvider;
		}
		
		private final TreeInfoProvider<T> infoProvider;
		
		private GenericTreeNode<T> tree;
		
		public void setTree(GenericTreeNode<T> tree) {
			if (this.tree != tree) {
				this.tree = tree;
				reloadTree();
			}
		}
		
		private TreeInfoStorage<T> infoStorage;
		
		private void reloadTree() {
			if (tree != null) {
				infoStorage = new TreeInfoStorage<T>();
				
				infoProvider.computeSizes(infoStorage, tree);
				infoStorage.setSizesReadOnly(true);
				computeLocations(infoStorage, infoStorage, tree);
			} else {
				infoStorage = null;
			}
			
			repaint();
		}
		
		private void computeLocations(TreeLocationStorage<T> locationStorage,
				TreeSizeStorage<T> sizeStorage, GenericTreeNode<T> root) {
			computeLocations(locationStorage, sizeStorage, root, 50, 50);
		}
		
		private void computeLocations(TreeLocationStorage<T> locationStorage, TreeSizeStorage<T> sizeStorage, GenericTreeNode<T> node, int parentX, int parentY) {
			Dimension subtreeSize = sizeStorage.getSubtreeSize(node);
			Dimension nodeSize = sizeStorage.getNodeSize(node);
			
			locationStorage.setNodeLocation(node, new Point(parentX + subtreeSize.width / 2, parentY));
			
			int x = parentX;
			for (int i = 0; i < node.getChildCount(); i++) {
				GenericTreeNode<T> child = node.getChildAt(i);
				subtreeSize = sizeStorage.getSubtreeSize(child);
				
				computeLocations(locationStorage, sizeStorage, child, x, parentY + nodeSize.height + infoProvider.getVSpacing());
				x += infoProvider.getHSpacing();
				x += subtreeSize.width;
			}
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			Queue<GenericTreeNode<T>> nodesToProcess = new LinkedList<GenericTreeNode<T>>();
			
			g.setColor(Color.DARK_GRAY);
			nodesToProcess.add(tree);
			while (!nodesToProcess.isEmpty()) {
				GenericTreeNode<T> node = nodesToProcess.poll();
				
				if (node.getParent() != null) {
					Point parentLoc = infoStorage.getNodeLocation(node.getParent());
					Point childLoc = infoStorage.getNodeLocation(node);
					
					g.drawLine(parentLoc.x, parentLoc.y, childLoc.x, childLoc.y);
				}
				
				for (int i = 0; i < node.getChildCount(); i++) {
					nodesToProcess.add(node.getChildAt(i));
				}
			}
			
			nodesToProcess.add(tree);
			while (!nodesToProcess.isEmpty()) {
				GenericTreeNode<T> node = nodesToProcess.poll();
				
				Point nodeLocation = infoStorage.getNodeLocation(node);
				Dimension nodeSize = infoStorage.getNodeSize(node);
				
				g.setColor(Color.BLUE);
				g.fillOval(nodeLocation.x - nodeSize.width / 2,
						nodeLocation.y - nodeSize.height / 2,
						nodeSize.width,
						nodeSize.height);
				
				g.setColor(Color.YELLOW);
				g.drawString(node.getValue().toString(), nodeLocation.x - nodeSize.width / 3, nodeLocation.y + nodeSize.height / 3);
				
				for (int i = 0; i < node.getChildCount(); i++) {
					nodesToProcess.add(node.getChildAt(i));
				}
			}
		}
	}
	
	private TreeDisplay() {
	}
	
	/**
	 * Displays a window that shows a tree graphically.
	 * 
	 * @param <E> The data type stored in the tree.
	 * @param tree The root node of the tree to show.
	 * @param infoProvider An object that provides some measurement information about the tree.
	 * @throws IllegalArgumentException if any of the arguments is null.
	 */
	public static <E> void showTree(GenericTreeNode<E> tree, TreeInfoProvider<E> infoProvider) {
		if (tree == null) {
			throw new IllegalArgumentException("tree must not be null.");
		}
		if (infoProvider == null) {
			throw new IllegalArgumentException("infoProvider must not be null.");
		}
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = new JFrame("Tree Display");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenSize.width / 2, screenSize.height / 2);
		frame.setLocation(screenSize.width / 4, screenSize.height / 4);
		
		TreePanel<E> tp = new TreePanel<E>(infoProvider);
		tp.setTree(tree);
		frame.add(tp);
		
		frame.setVisible(true);
	}
}
