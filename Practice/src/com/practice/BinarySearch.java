package com.practice;

public class BinarySearch {

	public static void main(String[] args) {
		int a[]=new int[] {1,2,3,4,5,6,7,8,9};
		System.out.println(findIndex(a, 4));
	}
	
	public static int findIndex(int a[], int num) {
		int start=0, end=a.length;
		if(num<a[start] || num>a[end-1]) return -1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			if(num>a[mid]) {
				start=mid+1;
			}else if(num<a[mid]) {
				end=mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}
