package edu.problem.linkedlist;

public class MiddleOfLinkedList {

	//https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
	//solution is to start 2 pointers, increment one single step and other 2 steps. Whene second will reach the end, first will
	//reach the middle
	public static void main(String[] args) {
		Node temp=new Node(3);
		Node root=temp;
		temp=temp.next=new Node(4);
		temp=temp.next=new Node(5);
		temp=temp.next=new Node(6);
		temp=temp.next=new Node(7);
		temp=temp.next=new Node(8);
		temp=temp.next=new Node(9);
		temp=temp.next=new Node(10);
		temp=temp.next=new Node(11);
		System.out.println(getMidlleNode(root).value);
		
	}
	
	
	public static Node getMidlleNode(Node root) {
		Node one=root,two=root;
		while(two.next!=null && two.next.next!=null) {
			two=two.next.next;
			one=one.next;
		}
		return one;
		
	}

}
