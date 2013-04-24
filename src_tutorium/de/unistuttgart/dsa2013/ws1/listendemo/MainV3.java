package de.unistuttgart.dsa2013.ws1.listendemo;
public class MainV3 {
	public static void main (String[] args) {
		NodeV3<Integer, Boolean> firstNode = new NodeV3<Integer, Boolean>(1, true, new NodeV3<Integer, Boolean>(2, false, new NodeV3<Integer, Boolean>(3, true, null)));
		
		System.out.println(firstNode.value);
		System.out.println(firstNode.next.value);
		System.out.println(firstNode.next.next.value);
		System.out.println(firstNode.value2);
		System.out.println(firstNode.next.value2);
		System.out.println(firstNode.next.next.value2);
		
		
	}
}