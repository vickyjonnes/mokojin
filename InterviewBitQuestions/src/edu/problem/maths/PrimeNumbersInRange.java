package edu.problem.maths;

import java.util.Arrays;

public class PrimeNumbersInRange {

	public static void main(String[] args) {
		int a=1, b=50;
		for(int i=a;i<=b;i++) {
			if(isPrime(i))
				System.out.print(i+" ");
		}
		System.out.println();
		allPrimesInRange(b);
		

	}
	
	public static boolean isPrime(int n) {
		if(n<=1)
			return false;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}

	public static void allPrimesInRange(int n){
		boolean prime[] = new boolean[n+1];
		Arrays.fill(prime, true);
		prime[0]=false; prime[1]=false;
		for(int i=2; i*i<=n; i++){
			if(prime[i]){
				for(int j=2*i; j<=n; j=j+i){
					prime[j]=false;
				}
			}
		}
		for(int i=0;i<n+1; i++){
			if(prime[i])
				System.out.print(i+" ");
		}

	}

}
