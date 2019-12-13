package edu.problem.maths;

public class Find2NonRepeatingNumbers {

	//https://www.geeksforgeeks.org/find-two-non-repeating-elements-in-an-array-of-repeating-elements/
	public static void main(String[] args) {
		int arr[]=new int[] {2, 3, 7, 9, 11, 2, 3, 11};
		print2NonRepeatingNumbers(arr);
		int arr1[] = new int[]{1,2, 4, 5, 6, 2, 4,1};
		print2NonRepeatingNumbers(arr1);
	}
	
	public static void print2NonRepeatingNumbers(int arr[]) {
		int size=arr.length;
		int xor=0;
		for(int i=0;i<size;i++) {
			xor=xor^arr[i];
			//System.out.println("xor "+xor);
		}
		System.out.println("XOR is "+xor);
		int no_with_set_bit = xor & ~(xor-1);
		System.out.println("no is "+no_with_set_bit);
		int x=0,y=0;
		for(int i=0;i<size;i++) {
			if((arr[i] & no_with_set_bit)>0)
				x=x^arr[i];
			else
				y=y^arr[i];
		}
		System.out.println("x "+x+" y "+y);		
	}
	
	

}
