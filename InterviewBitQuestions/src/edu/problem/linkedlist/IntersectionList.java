package edu.problem.linkedlist;

public class IntersectionList {

	public static void main(String[] args) {
		int a1[]=new int[] {1,2,3,4,5,6};
		int a2[]=new int[] {7,8,9,11};
		//creating 2 lists intersecting each other
		Node head1=LinkedList.createList(a1);
		Node head2=LinkedList.createList(a2);
		
		Node ptr1=head1,ptr2=head2;
		while(ptr2.next!=null) {
			ptr1=ptr1.next;
			ptr2=ptr2.next;
		}
		ptr2.next=ptr1; //created intersection by connecting 11 -> 4
		
		Node intrsc=intersectingNode(head1, head2);
		if(intrsc!=null)
			System.out.println(intrsc.value);
		else
			System.out.println("No intersection");
		
	}
	
	public static Node intersectingNode(Node head1, Node head2) {
		int l1=0,l2=0;
		Node ptr1=head1,ptr2=head2;
		while(ptr1!=null) {
			ptr1=ptr1.next;
			l1++;
		}
		System.out.println("length 1: "+l1);
		while(ptr2!=null) {
			ptr2=ptr2.next;
			l2++;
		}
		
		System.out.println("length 2: "+l2);
		
		ptr1=head1;ptr2=head2;
		int k=0;
		if(l1>=l2) {
			while(ptr1!=null) {
				if(ptr2.value==ptr1.value)
					return ptr1;
				if(l1-l2<=k) {
					ptr2=ptr2.next;
				}
				ptr1=ptr1.next;
				k++;
			}
		}else {
			while(ptr2!=null) {
				if(ptr2.value==ptr1.value)
					return ptr2;
				if(l2-l1<=k) {
					ptr1=ptr1.next;
				}
				ptr2=ptr2.next;
				k++;
			}
		}
		
		return null;
		
	}

}
