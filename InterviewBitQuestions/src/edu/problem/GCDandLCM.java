package edu.problem;

public class GCDandLCM {

	public static void main(String[] args) {
		int a=8, b=6;
		System.out.println(gcd(a, b));
		System.out.println(lcm(a, b));

	}
	
	
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		return gcd(b, a%b);
	}
	
	
	public static int lcm(int a, int b) {
		return (a*b)/gcd(a, b);
	}

}
