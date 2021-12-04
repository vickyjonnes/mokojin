package edu.problem.subsequence;

import java.util.stream.IntStream;

/*
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * input: ABCDGH and AEDFHR
 * output: ADH of length 3
*/
public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String a="AEDFHR";
		String b="ABCDGH";
		System.out.println(longestSubsequence(a, b));
	}
	
	
	//the only problem in this is to maintain index of 2 strings and matrix together, complicated!
	public static String longestSubsequence(String a, String b) {
		int r=a.length()+1;
		int c=b.length()+1;
		int mat[][]=new int[r][c];
		int maxLength=0;
		IntStream.range(0, r).forEach(i->mat[i][0]=0);
		IntStream.range(0, c).forEach(i->mat[0][i]=0);
		for(int i=1,ai=0;i<r;i++,ai++) {
			for(int j=1,bi=0;j<c;j++,bi++) {
				if(a.charAt(ai)==b.charAt(bi))
					mat[i][j]=mat[i-1][j-1]+1;
				else
					mat[i][j]=Math.max(mat[i-1][j], mat[i][j-1]);
				
				
				if(maxLength<mat[i][j])
					maxLength=mat[i][j];
			}
		}
		System.out.print("Length of Longest Common Subsequence is: "+maxLength+" ");
		
		int i=r-1,j=c-1,bi=j-1;
		StringBuilder build=new StringBuilder();
		while(mat[i][j]>0) {
			if(mat[i][j]!=mat[i-1][j] && mat[i][j]!=mat[i][j-1]) {
				build.append(b.charAt(bi));
				j--;i--;bi--;
			}else if(mat[i][j]==mat[i-1][j]) {
				i--;
			}else if(mat[i][j]==mat[i][j-1]) {
				j--;bi--;
			}
		}
		return build.reverse().toString();
	}

	public static int lengthOfCommonSubsequence(String first, String second){
		int n = first.length();
		int m = second.length();
		int mat[][]=new int[n][m];

		for(int i=0;i<n; i++){
			for(int j=0;j<m;j++){
				if(i==0 && j==0){
					if(first.charAt(i)==second.charAt(j))
						mat[i][j]=1;
					else
						mat[i][j]=0;
				}else{
					if(first.charAt(i)==second.charAt(j)){
						int dia = (i-1>=0 && j-1>=0) ? mat[i-1][j-1] : 0;
						mat[i][j] = 1+dia;
					}else{
						int top = (i-1)>=0 ? mat[i-1][j] : 0;
						int left = (j-1)>=0 ? mat[i][j-1] : 0;
						mat[i][j] = Math.max(top, left);
					}
				}
			}
		}
		return mat[n-1][m-1];
	}

}
