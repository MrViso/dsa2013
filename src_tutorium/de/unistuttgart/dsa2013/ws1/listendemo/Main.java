package de.unistuttgart.dsa2013.ws1.listendemo;
public class Main {
	public static void main (String[] args) {
		Node firstNode = new Node(1, null);
		//firstNode.value = 1;
		
		Node secondNode = new Node(2, null);
		//secondNode.value = 2;
		
		firstNode.next = secondNode;
		
		Node thirdNode = new Node(3, null);
		//thirdNode.value = 3;
		
		secondNode.next = thirdNode;
		
		System.out.println(firstNode.value);
		System.out.println(firstNode.next.value);
		System.out.println(firstNode.next.next.value);
	}
}