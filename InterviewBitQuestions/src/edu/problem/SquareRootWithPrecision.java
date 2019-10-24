package edu.problem;

public class SquareRootWithPrecision {

	//https://www.geeksforgeeks.org/find-square-root-number-upto-given-precision-using-binary-search/
	//first find out the integeral part with binary search
	//then look for precision and increment the precesion by 1/10 everytime
	public static void main(String[] args) {
		System.out.println((float)squareRoot(50, 3));
		System.out.println((float)squareRoot(10, 4));

	}
	
	public static double squareRoot(int number, int precesion) {
		int start =0 , end=number;
		double ans=0.0;
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(mid*mid==number) {
				ans=mid;
				break;
			}
			
			if(mid*mid<number) {
				start=mid+1;
				ans=mid;
			}else {
				end=mid-1;
			}
		}
		
		double increment=0.1;
		for(int i=0;i<precesion;i++) {
			while(ans*ans<=number) {
				ans=ans+increment;
			}
			
			ans=ans-increment;
			increment=increment/10;
		}
		
		return ans;
	}

}
