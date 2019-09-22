package edu.problem;

import java.util.stream.IntStream;

public class CatalanNumber {

	public static void main(String[] args) {
		System.out.println(catalanNumber(3));
		System.out.println("\n"+dynamicCatalanNumber(4));
	}
	
	
	public static int catalanNumber(int n) {
		int result=0;
		if(n<=1) {
			return 1;
		}
		for(int i=0;i<n;i++) {
			result +=catalanNumber(i)*catalanNumber(n-i-1);
		}
		return result;
	}
	
	public static int dynamicCatalanNumber(int n) {
		int[] catalan=new int[n+1];
		catalan[0]=1;catalan[1]=1;
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<i;j++) {
				catalan[i] += catalan[j]*catalan[i-j-1];
				System.out.println(i+"::"+catalan[i]);
			}
		}
		IntStream.range(0, n+1).forEach(i->System.out.print(catalan[i]+" "));
		return catalan[n];
	}

}
