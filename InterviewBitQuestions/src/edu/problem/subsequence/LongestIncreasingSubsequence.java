package edu.problem.subsequence;

import java.util.stream.IntStream;

/*
 * input [3,4,-1,0,6,2,3]
 * output 4
 * Subsequence may not be continuous 
*/
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int a[]=new int[] {3,4,-1,0,6,2,3};
		int a1[]=new int[] {12, 11, 40, 5, 3, 1};
		int a2[]=new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int a3[]=new int[] {3, 2};
		System.out.println(longestSubsequence(a));
		System.out.println(longestSubsequence(a1));
		System.out.println(longestSubsequence(a2));
		System.out.println(longestSubsequence(a3));

	}
	
	public static int longestSubsequence(int a[]) {
		int n=a.length;
		int b[]=new int[n];
		int maxLength=1;
		//IntStream.range(0, n).forEach(i->b[i]=1);
		for(int i=0;i<n;i++) {
			b[i]=1;  //this is just to reduce time. otherwise its cleaner to fill array with 1 separately before this loop.
			for(int j=0;j<i;j++) {
				if(a[j]<a[i]) {
					b[i]=Math.max(b[i], b[j]+1);
					if(b[i]>maxLength)
						maxLength=b[i];
				}
			}
		}
		
		return maxLength;
	}

}
