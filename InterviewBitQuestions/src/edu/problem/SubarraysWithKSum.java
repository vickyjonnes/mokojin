package edu.problem;

public class SubarraysWithKSum {

	public static void main(String[] args) {
		int a[]=new int[] {1,2,3,4,5,2};
		int a1[]=new int[] {1,2,3,4,3,6};
		int a2[]=new int[] {1,2,3,4,28,5,1,3};
		System.out.println("First:");
		subarraysWithKSum(a, 7);
		System.out.println("Second:");
		subarraysWithKSum(a1, 7);
		System.out.println("Third:");
		subarraysWithKSum(a2, 9);
	}
	
	public static void subarraysWithKSum(int[] a, int k) {
		int n=a.length;
		int i=0,sum=0,j=0;
		
		while(i<n) {
			sum=sum+a[i];
			if(sum==k) {
				System.out.println("sum "+k+" is made up of elements between "+(j+1)+" and "+(i+1));
				i++;sum=sum-a[j]; j++;
			}else if(sum>k) {
				while(j<=i && sum>k) {
					sum=sum-a[j];
					j++;
				}
				if(sum==k) {
					System.out.println("sum "+k+" is made up of elements between "+(j+1)+" and "+(i+1));
					sum=sum-a[j]; j++;
				}
				i++;
			}else {
				i++;
			}
		}
	}

}
