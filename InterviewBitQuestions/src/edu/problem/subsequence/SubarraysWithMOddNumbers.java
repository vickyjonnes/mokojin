package edu.problem.subsequence;

public class SubarraysWithMOddNumbers {

	public static void main(String[] args) {
		int t[]=new int[] {1,2,3,4,5,6,7,8,9,10};
		System.out.println(beautifulSubarrays(t, 3));
	}

	static long beautifulSubarrays(int[] a, int m) {
	    long count = 0; 
	        int n=a.length;
	        int prefix[] = new int[n]; 
	        int odd = 0; 
	      
	        for (int i = 0; i < n; i++) 
	        { 
	            prefix[odd]++; 
	            if ((a[i] & 1) == 1) 
	                odd++; 
	            if (odd >= m) 
	                count += prefix[odd - m]; 
	            System.out.println("c "+count);
	        } 
	      
	        return count;
	}
}
