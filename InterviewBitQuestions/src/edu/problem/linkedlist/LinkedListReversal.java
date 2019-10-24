package edu.problem.linkedlist;

public class LinkedListReversal {

	public static void main(String[] args) {
		int a[]=new int[] {1,2,3,4,5,6,7};
		Node head=LinkedList.createList(a);
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.value+" ");
			temp=temp.next;
		}
		System.out.println();
		printReversed(head);
		
		
	}
	
	
	public static void printReversed(Node head) {
		Node tempNext=null;
		Node prev=null;
		while(head!=null) {
			tempNext=head.next;
			head.next=prev;
			prev=head;
			head=tempNext;
		}
		head=prev;
		while(head!=null) {
			System.out.print(head.value+" ");
			head=head.next;
		}
	}

}
