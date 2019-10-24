package edu.problem.linkedlist;

public class LinkedList {

	public static Node createList(int a[]) {
		Node head=null;
		Node cur=null;
		for(int i=0;i<a.length;i++) {
			Node n=new Node(a[i]);
			if(cur==null) {
				cur=n;
				head=n;
			}else if(cur!=null) {
				cur.next=n;
				cur=n;
			}
		}
		return head;
	}
}
