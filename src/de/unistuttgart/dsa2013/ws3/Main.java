/**
 * 
 */
package de.unistuttgart.dsa2013.ws3;

/**
 * @author Viso
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WS3TreeNode<Integer> baum = new WS3TreeNode<Integer>(3);
		baum.addChild(10);
		baum.addChild(15);
		baum.addChild(20);
		//baum.getChild(1).addChild(25);
		System.out.println(baum.getChild(2).getValue());
		System.out.println(baum.isFull());
	}

}
