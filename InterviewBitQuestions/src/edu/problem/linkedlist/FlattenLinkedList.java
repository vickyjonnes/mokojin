package edu.problem.linkedlist;

public class FlattenLinkedList {

	//https://www.geeksforgeeks.org/flattening-a-linked-list/
	public static void main(String[] args) {
		//int a[][]=new int[][] {{5,7,8,30},{10,20},{19,22,50},{28,35,40,45}};
		int a[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		//DNode root=createDoubleList(a);
		DNode root=createDList(a);
		printNonFlatenedList(root);
		root=flatten(root);
		System.out.println();
		printFlattenedList(root);

	}

	public static DNode createDList(int a[][]){
		int n=a.length;
		int m=a[0].length;
		DNode root=null;
		DNode nA[][]=new DNode[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				nA[i][j]=new DNode(a[i][j]);
				if(i==0 && j==0){
					root = nA[i][j];
				}
				if(j-1>=0){
					nA[i][j-1].right=nA[i][j];
				}
				if(i-1>=0){
					nA[i-1][j].down=nA[i][j];
				}
			}
		}
		return root;
	}

	public static DNode createDoubleList(int a[][]) {
		DNode root=null,resultRight=null;
		if(a.length<1)
			return root;
		root=new DNode(a[0][0]);
		resultRight=root;
		for(int i=0;i<a.length;i++) {
			if(i!=0) {
				resultRight.right=new DNode(a[i][0]);
				resultRight=resultRight.right;
			}
			DNode resultDown=resultRight;
			for(int j=1;j<a[i].length;j++) {
				DNode temp=new DNode(a[i][j]);
				resultDown.down=temp;
				resultDown=resultDown.down;
			}
		}

		return root;
	}

	public static void printNonFlatenedList(DNode root) {
		while(root!=null) {
			System.out.print(root.value+" ");
			DNode right=root.right;
			while(right!=null) {
				System.out.print(right.value+" ");
				right=right.right;
			}
			root=root.down;
			System.out.println();
		}
	}
	
	public static DNode merge(DNode a, DNode b) {
		if(a==null)
			return b;
		if(b==null)
			return a;
		DNode result=null;
		if(a.value<=b.value) {
			result=a;
			result.down=merge(a.down,b);
		}else {
			result=b;
			result.down=merge(a,b.down);
		}
		return result;
	}
	
	public static DNode flatten(DNode root) {
		if(root==null || root.right==null)
			return root;
		DNode result=root;
		DNode headFlat=result;
		while(result!=null) {
			result=merge(result, result.right);
			result=result.right;
		}
		return headFlat;
	}
	
	public static void printFlattenedList(DNode root) {
		while(root!=null) {
			System.out.print(root.value+" ");
			root=root.down;
		}
	}

}

class DNode{
	int value;
	DNode right;
	DNode down;
	DNode(int value){
		this.value=value;
		right=null;
		down=null;
	}
}
