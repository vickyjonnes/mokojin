package edu.problem;

public class StringPermutations {

	public static void main(String[] args) {
		
	}

	public static void printAllPermutation(String str) {
		for(int i=0;i<str.length();i++) {
			
		}
	}
	
	private static String swap(String str, int i, int j) {
		char[] a=str.toCharArray();
		char t=a[i];
		a[i]=a[j];
		a[j]=t;
		return String.valueOf(a);
	}
}
