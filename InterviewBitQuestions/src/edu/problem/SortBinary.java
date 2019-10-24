package edu.problem;

public class SortBinary {

	//https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
	//A simple solution would be to count all 0s and 1s and then next loop to put all 0s at begining followed by all the 1s
	//this approach is to sort in 1 single iteration. Idea is to iterate from 0 and n-1 and swap if 1 is found at 0 else increment.
	public static void main(String[] args) {
		int a[]=new int[] {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		sortArray(a);
		System.out.println();
		int a1[]=new int[] {0,0,0,1,1,1,1};
		sortArray(a1);
		System.out.println();
		int a2[]=new int[] {1,1,1,1,1};
		sortArray(a2);
	}
	
	public static void sortArray(int a[]) {
		int start=0; int end=a.length-1;
		while(start<end) {
			if(a[start]==0)
				start++;
			if(a[end]==1)
				end--;
			if(a[start]>a[end]) {
				int temp=a[end];
				a[end]=a[start];
				a[start]=temp;
			}
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
