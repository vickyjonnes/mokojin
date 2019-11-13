package edu.problem.linkedlist;

public class Mergsort {

	public static void main(String[] args) {
		int a[]=new int[] {5,1,8,9,0,4,14,2};
		Node root=creatList(a);
		root=mergeSort(root);
		while(root!=null) {
			System.out.print(root.value+" ");
			root=root.next;
		}
		
	}
	
	public static Node creatList(int a[]) {
		if(a.length<1)
			return null;
		Node root=new Node(a[0]);
		Node temp=root;
		for(int i=1;i<a.length;i++) {
			Node n=new Node(a[i]);
			temp.next=n;
			temp=temp.next;
		}
		return root;
	} 
	
	
	public static Node merge(Node a, Node b) {
		Node result=null;
		Node root=null;
		if(a==null && b==null)
			return result;
		
		while(a!=null && b!=null) {
			if(a.value<=b.value) {
				if(result==null) {
					result=a;
					root=result;
				}else {
					result.next=a;
					result=result.next;
				}
				a=a.next;
				
			}else {
				if(result==null) {
					result=b;
					root=result;
				}else {
					result.next=b;
					result=result.next;
				}
				b=b.next;
			}
		}
		
		while(a!=null) {
			result.next=a;
			a=a.next;
			result=result.next;
		}
		
		while(b!=null) {
			result.next=b;
			b=b.next;
			result=result.next;
		}
		
		return root;
	}
	
	public static Node mergeSort(Node root) {
		if(root==null || root.next==null) {
			return root;
		}
		
		Node middle=MiddleOfLinkedList.getMidlleNode(root);
		Node middleNext=middle.next;
		middle.next=null;
		
		Node left=mergeSort(root);
		Node right=mergeSort(middleNext);
		return merge(left, right);
		
	}
}
