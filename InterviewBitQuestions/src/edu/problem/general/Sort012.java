package edu.problem.general;

public class Sort012 {

	//https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
	//a simple solution would be to count all 0s, 1s 2s and then finally put them in array in order.
	//but this approach is in 1 iteration, idea is to partition the array in 3 parts and start 3 pointers.
	// one will start from start one from mid and one from end. start will increase if 0 is found, mid will increase if 1 is found
	// and end will decrease when 2 is found.
	public static void main(String[] args) {
		int a[]=new int[] {0, 1, 2, 0, 1, 2};
		sortArray(a);

	}
	
	public static void sortArray(int a[]) {
		int start=0, mid=0,end=a.length-1;
		
		while(mid<=end) {
			int temp;
			if(a[mid]==0) {
				temp=a[start];
				a[start]=a[mid];
				a[mid]=temp;
				start++; mid++;
			}else if(a[mid]==1) {
				mid++;
			}else if(a[mid]==2) {
				temp = a[mid];
				a[mid] = a[end];
				a[end] = temp;
				end--;
			}
		}
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
