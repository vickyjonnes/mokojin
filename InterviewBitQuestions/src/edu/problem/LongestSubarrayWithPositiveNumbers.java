package edu.problem;

public class LongestSubarrayWithPositiveNumbers {

	public static void main(String[] args) {
		int a[]=new int[] {-1,1,2,3,4,5,-1,1,2,3,4};
		longestSubarrayOfNonNegativeNumbers(a);
	}
	
	public static void longestSubarrayOfNonNegativeNumbers(int a[]) {
		int e=0,max=0,max_sofar=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>0) {
				max++;
				if(max>max_sofar) {
					max_sofar=max;
					e=i;
				}
			}else {
				max=0;
			}
		}
		
		for(int i=e-max_sofar+1;i<=e;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
