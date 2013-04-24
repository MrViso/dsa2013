package de.unistuttgart.dsa2013.ws1.listendemo;
public class MainV2 {
	public static void main (String[] args) {
		NodeV2<Integer> firstNode = new NodeV2<Integer>(1, new NodeV2<Integer>(2, new NodeV2<Integer>(3, null)));
		
		System.out.println(firstNode.value);
		System.out.println(firstNode.next.value);
		System.out.println(firstNode.next.next.value);
		
		
		NodeV2<Boolean> firstNode1 = new NodeV2<Boolean>(true, new NodeV2<Boolean>(false, new NodeV2<Boolean>(true, null)));
		
		System.out.println(firstNode1.value);
		System.out.println(firstNode1.next.value);
		System.out.println(firstNode1.next.next.value);
		
		/*NodeV2<NodeV2> firstNode11 = new NodeV2<Node>(new NodeV2<Node>(null, new NodeV2<Node>(null, null)), new NodeV2<Node>(null, new NodeV2<Node>(null, null)));

		System.out.println(firstNode11.value);
		System.out.println(firstNode11.next.value);
		System.out.println(firstNode11.next.next.value); */
		
		
	}
}