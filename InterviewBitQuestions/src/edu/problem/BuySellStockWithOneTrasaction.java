package edu.problem;

public class BuySellStockWithOneTrasaction {

	//this problem is simple and can be approached like below
	//max diff between 2 numbers such that larger number appear after smaller number
	//https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
	public static void main(String[] args) {
		int a[]=new int[] {10,22,5,75,65,80};
		System.out.println(maxDiff(a));
		int a1[]=new int[] {12,14,17,10,14,13,12,15};
		System.out.println(maxDiff(a1));
		
	}
	
	public static int maxDiff(int a[]) {
		int maxDiff=0;
		int min=a[0];
		for(int i=1;i<a.length;i++) {
			maxDiff=Math.max(maxDiff, a[i]-min);
			min=Math.min(a[i], min);
		}
		return maxDiff;
	}
}
