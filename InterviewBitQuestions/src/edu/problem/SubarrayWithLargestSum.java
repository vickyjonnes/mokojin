package edu.problem;

/*
 * Find the contiguous subarray within an array, A of length N which has the largest sum.
*/
public class SubarrayWithLargestSum {

	public static void main(String[] args) {
		SubarrayWithLargestSum s=new SubarrayWithLargestSum();
		System.out.println(s.subArrayMaxSum(new int[] {-150,-20}));
		System.out.println(s.subArrayMaxSum(new int[] {-50}));
		System.out.println(s.subArrayMaxSum(new int[] {1, 2, 3, 4, -10}));
		System.out.println(s.subArrayMaxSum(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
	
	public int subArrayMaxSum(int a[]) {
		int max=Integer.MIN_VALUE,sum=0;
		for(int i=0;i<a.length;i++) {
			sum=sum+a[i];
			if(max<sum)
				max=sum;
			if(sum<0)
				sum=0;
		}
		return max;
	}
	

}
