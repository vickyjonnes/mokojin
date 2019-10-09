package edu.problem;

public class LinkedListReversal {

	public static void main(String[] args) {
		int a[]=new int[] {1,2,3,4,5,6,7};
		Node head=createList(a);
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.value+" ");
			temp=temp.ptr;
		}
		System.out.println();
		printReversed(head);
		
		
	}
	
	private static Node createList(int a[]) {
		Node head=null;
		Node cur=null;
		for(int i=0;i<a.length;i++) {
			Node n=new Node(a[i]);
			if(cur==null) {
				cur=n;
				head=n;
			}else if(cur!=null) {
				cur.ptr=n;
				cur=n;
			}
		}
		return head;
	}
	
	
	public static void printReversed(Node head) {
		Node tempNext=null;
		Node prev=null;
		while(head!=null) {
			tempNext=head.ptr;
			head.ptr=prev;
			prev=head;
			head=tempNext;
		}
		head=prev;
		while(head!=null) {
			System.out.print(head.value+" ");
			head=head.ptr;
		}
	}

}

class Node{
	int value;
	Node ptr;
	
	public Node(int i) {
		this.value=i;
		this.ptr=null;
	}
}
