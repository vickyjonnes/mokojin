package edu.problem.general;

public class InterleavingString {

	//https://www.geeksforgeeks.org/find-if-a-string-is-interleaved-of-two-other-strings-dp-33/
	//https://www.youtube.com/watch?v=ih2OZ9-M3OM
	//dp problem: fill up the matrix with T F based on the  formula if c[i+j]==a[i] then mat[i][j]=mat[i-1][j] else if
	// c[i+j]==b[j] then mat[i][j]=mat[i][j-1]. with additional care for edge conditions.
	public static void main(String[] args) {
		System.out.println(isInterleaved("XXZ","XXY", "XXYXXZ"));
		System.out.println(isInterleaved("XXX","XXY", "XXYXXZ"));
		System.out.println(isInterleaved("XXZ","XXY", "XXYXXXZ"));
		System.out.println(isInterleaved("AAB","AXY", "AAXABY"));
	}
	
	public static boolean isInterleaved(String a, String b, String c) {
		int m=a.length();
		int n = b.length();
		if(m+n!=c.length())
			return false;
		
		boolean mat[][]=new boolean[m+1][n+1];
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0 && j==0) {
					mat[i][j]=true;
				}else if(i==0) {
					//means a is empty
					if(c.charAt(j-1)==b.charAt(j-1)) {
						mat[i][j]=mat[i][j-1];
					}else {
						mat[i][j]=false;
					}
				}else if(j==0) {
					//means b is empty
					if(c.charAt(i-1)==a.charAt(i-1)) {
						mat[i][j]=mat[i-1][j];
					}else {
						mat[i][j]=false;
					}
				}else {
					if(c.charAt(i+j-1)==a.charAt(i-1) && c.charAt(i+j-1)!=b.charAt(j-1)) {
						mat[i][j]=mat[i-1][j];
					}else if(c.charAt(i+j-1)==b.charAt(j-1) && c.charAt(i+j-1)!=a.charAt(i-1)) {
						mat[i][j]=mat[i][j-1];
					}else if(c.charAt(i+j-1)==a.charAt(i-1) || c.charAt(i+j-1)==b.charAt(j-1)) {
						mat[i][j]=mat[i-1][j] || mat[i][j-1];
					}else {
						mat[i][j]=false;
					}
				}
			}
		}
		return mat[m][n];
	}

}
