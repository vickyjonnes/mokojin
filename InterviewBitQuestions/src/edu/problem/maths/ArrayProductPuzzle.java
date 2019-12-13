package edu.problem.maths;

import java.util.Arrays;

public class ArrayProductPuzzle {

	//https://www.geeksforgeeks.org/a-product-array-puzzle/
	// make an array such that a[i]=product of all elements except itself.
	public static void main(String[] args) {
		int[] a=new int[] {1,2,3,4,5};
		int[] a1=new int[] {5};
		Arrays.stream(getResultArray(a)).forEach((i)->System.out.print(i+" "));
		System.out.println();
		Arrays.stream(getResultArray(a1)).forEach((i)->System.out.print(i+" "));
	}
	
	public static int[] getResultArray(int[] a) {
		int n=a.length;
		if(n==1) {
			return a;
		}
		int left[]=new int[n], right[]=new int[n],result[]=new int[n];
		left[0]=1; right[n-1]=1;
		
		for(int i=1;i<n;i++) {
			left[i]=left[i-1]*a[i-1];
		}
		
		for(int i=n-2;i>=0;i--) {
			right[i]=right[i+1]*a[i+1];
		}
		
		for(int i=0;i<n;i++) {
			result[i]=left[i]*right[i];
		}
		return result;
	}

}
