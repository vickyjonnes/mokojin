package edu.problem.linkedlist;

public class SwapNodes {

	//this is to swap two nodes in a link list by swaping their links not just values.
	//this require handling multiple cases like both values are not present, one of the value is not present, boundary conditions.
	public static void main(String[] args) {
		int a[]=new int[] {1,2,3,4,5,6,7};
		Node head=LinkedList.createList(a);
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.value+" ");
			temp=temp.next;
		}
		System.out.println();
		
		//printAfterSwap(head, 1, 3);
		System.out.println();
		printAfterSwap(head, 1, 7);
	}
	
	public static void printAfterSwap(Node head, int P, int Q) {
		if(P==Q)
			return;
		//Node head=root;
		Node currP=head, prevP=null;
		Node currQ=head, prevQ=null;
		
		while(currP!=null && currP.value!=P) {
			prevP=currP;
			currP=currP.next;
		}
		
		while(currQ!=null && currQ.value!=Q) {
			prevQ=currQ;
			currQ=currQ.next;
		}
		
		//if any of the elements is not present in list.
		if(currP ==null || currQ==null) {
			System.out.println("One or more elements are not present in the list");
			return;
		}
		
		if(prevP!=null)
			prevP.next=currQ;
		else
			head=currQ;
		
		if(prevQ!=null)
			prevQ.next=currP;
		else
			head=currP;
		
		Node temp = currP.next;
		currP.next = currQ.next;
		currQ.next = temp;
		
		
		while(head!=null) {
			System.out.print(head.value+" ");
			head=head.next;
		}
			
			
	}

}
