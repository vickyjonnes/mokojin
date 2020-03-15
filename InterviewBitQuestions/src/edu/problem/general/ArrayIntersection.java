package edu.problem.general;

public class ArrayIntersection {

	//https://www.youtube.com/watch?v=B6Tsrmgsy3k
	public static void main(String[] args) {
		int a[]=new int[] {2,6,9,11,13,17};
		int b[]=new int[] {3,6,7,10,13,18};
		int c[]=new int[] {4,5,6,9,11,13};
		printIntersectiion(a, b, c);
	}
	
	public static void printIntersectiion(int a[], int b[], int c[]) {
		int i=0,j=0,k=0;
		while(isInBound(i, a) && isInBound(j, b) && isInBound(k, c)) {
			if(a[i]==b[j] && b[j]==c[k]) {
				System.out.println(a[i]);
				i++;j++;k++;
			}else {
				if(a[i]<b[j]) {
					i++;
				}else if(b[j]<c[k]) {
					j++;
				}else {
					k++;
				}
			}
		}
	}
	
	public static boolean isInBound(int i, int a[]) {
		if(i<a.length)
			return true;
		return false;
	}

}
