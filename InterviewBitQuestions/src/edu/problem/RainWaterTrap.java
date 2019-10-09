package edu.problem;

public class RainWaterTrap {

	//https://www.geeksforgeeks.org/trapping-rain-water/
	public static void main(String[] args) {
		int a[]=new int[] {2,0,2};
		System.out.println(unitsOfWaterTrapped(a));
		
		int a1[]=new int[] {3, 0, 0, 2, 0, 4};
		System.out.println(unitsOfWaterTrapped(a1));
		
		int a2[]=new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(unitsOfWaterTrapped(a2));
	}
	
	public static int unitsOfWaterTrapped(int a[]) {
		int n = a.length;
		int left[]=new int[n];
		int right[]=new int[n];
		
		left[0]=a[0]; right[n-1]=a[n-1];
		
		//fill left array with the max_height so far, left to right
		for(int i=1;i<n;i++) {
			left[i]=Math.max(left[i-1], a[i]);
		}
		
		//fill right array with max_height so far, right to left
		for(int i=n-2;i>=0;i--) {
			right[i]=Math.max(right[i+1], a[i]);
		}
		
		//now at any position water trapped can be Minimum of both the max heights minus original height.
		int sum=0;
		for(int i=0;i<n;i++) {
			sum=sum+(Math.min(left[i], right[i]))-a[i];
		}
		
		return sum;
	}

}
