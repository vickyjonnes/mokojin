package edu.problem.subsequence;

import java.util.HashMap;

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
		int a3[]={3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
		System.out.println(countSubArraysWithKSum(a3, 5));
	}

	//sliding window approach
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

	//prefix sub array approach: if given sum is k then keep adding all the numbers as we increment i and check if sum[i]-k is present
	//in prefix or not. if yes then add one to the frequence of sum[i]-k
	// ex: if k=5, if first 3 numbers has sum 4 and first 6 numbers has sum 9, then 9-4=5 means till 6th index we have found 1 subarray
	//with sum 5

	public static int countSubArraysWithKSum(int a[], int k){
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum=0;
		int count=0;
		map.put(0,1);
		for(int i=0;i<a.length; i++){
			sum = sum+a[i];
			if(map.containsKey(sum-k)){
				count=count+map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return count;
	}

}
