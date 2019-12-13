package edu.problem.general;

public class MaximiseSumWithoutAdjacentEement {

	//https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
	//https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
	//solution is to calculate included or excluded value at every point. Every element we have 2 options, either to include or
	//to exclude
	public static void main(String[] args) {
		int money[]=new int[]{6, 7, 1, 3, 8, 2, 4};
		System.out.println(getMaxAmount(money));
	}

	//in below logic we can initialize incl=a[0] and then start loop with i=1;
	public static int getMaxAmount(int a[]) {
		int n=a.length;
		int incl=0;
		int excl=0;
		int excl_next=0;
		
		for(int i=0;i<n;i++) {
			excl_next=Math.max(incl, excl);
			
			incl = excl+a[i];
			excl=excl_next;
		}
		return Math.max(excl, incl);
	}
}
