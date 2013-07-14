package de.unistuttgart.dsa2013.bws2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Displays a quadtree of towns.
 */
public final class QuadTreeDisplay {
	
	@SuppressWarnings("serial")
	private static class QuadTreePanel extends JPanel {
		
		public QuadTreePanel(QuadNodeB root) {
			if (root == null) {
				throw new IllegalArgumentException("root must not be null.");
			}
			
			this.root = root;
			this.offsetX = -root.getX();
			this.offsetY = -root.getY();
		}
		
		private final QuadNodeB root;
		
		private final double offsetX, offsetY;
		
		private void paintQuad(Graphics g, Dimension size, double xScale, double yScale, QuadNodeB quad) {
			if (quad.hasChildren()) {
				for (QuadNodeB child : quad.getChildren()) {
					paintQuad(g, size, xScale, yScale, child);
				}
			} else {
				g.setColor(Color.BLUE);
				Rectangle r = new Rectangle((int)Math.round((quad.getX() + offsetX) * xScale),
						(int)Math.round((quad.getY() + offsetY) * yScale),
						(int)Math.round(quad.getWidth() * xScale),
						(int)Math.round(quad.getHeight() * yScale));
				g.drawRect(r.x,
						size.height - r.y - r.height,
						r.width,
						r.height);
				
				g.setColor(Color.RED);
				for (Town t : quad.getTowns()) {
					Point pt = new Point((int)Math.round((t.getLongitude() + offsetX) * xScale),
							(int)Math.round((t.getLatitude() + offsetY) * yScale));
					
					g.fillOval(pt.x, size.height - pt.y, 2, 2);
				}
			}
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			Dimension size = this.getSize();
			double xScale = size.getWidth() / root.getWidth();
			double yScale = size.getHeight() / root.getHeight();
			
			paintQuad(g, size, xScale, yScale, root);
		}
	}
		
	/**
	 * Hidden constructor.
	 */
	private QuadTreeDisplay() {
	}
	
	/**
	 * Shows a window that displays a quadtree and the contained towns.
	 * Note that the map will be displayed in the correct orientation if the Eastern
	 * longitude as a positive value is used as the X position, and if the Northern
	 * latitude as a positive value is used as the Y position.
	 * 
	 * @param root The root cell of the quadtree.
	 * @throws IllegalArgumentException if root is null.
	 */
	public static void displayQuadTree(QuadNodeB root) {
		if (root == null) {
			throw new IllegalArgumentException("root must not be null.");
		}
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		JFrame frame = new JFrame("Quadtree Display");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenSize.width / 3, screenSize.height / 3 * 2);
		frame.setLocation(screenSize.width / 4, screenSize.height / 4);
		
		QuadTreePanel qtp = new QuadTreePanel(root);
		frame.add(qtp);
		
		frame.setVisible(true);
	}
}
