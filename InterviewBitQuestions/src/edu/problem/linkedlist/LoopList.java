package edu.problem.linkedlist;

public class LoopList {

	public static void main(String[] args) {
		int a[]=new int[] {1,2,3,4,5};
		LinkedList l=new LinkedList();
		Node head=l.createList(a);
		//creating a loop
		
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		//making a loop, 5 -> 2
		temp.next=head.next;
		System.out.println(isLoop(head));
		
		if(isLoop(head))
			System.out.println(isLoop(removeLoop(head)));
		Node t=head;
		while(t!=null) {
			System.out.print(t.value+" ");
			t=t.next;
		}

	}
	
	public static boolean isLoop(Node head) {
		Node fast=head,slow=head;
		
		while(fast!=null && slow!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast.value==slow.value)
				return true;
		}
		return false;
		
	}
	
	public static Node removeLoop(Node head) {
		Node fast=head,slow=head;
		
		while(fast!=null && slow!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast.value==slow.value) {
				slow.next=null;
				return head;
			}
		}
		return head;
	}

}
