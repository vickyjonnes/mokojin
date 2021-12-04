package edu.problem.subsequence;

import java.util.HashMap;
import java.util.stream.IntStream;

public class SubArraysWithKOddNumbers {

	public static void main(String[] args) {
		int a[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		printSubarrayWithKOddNumbers(a, 3);
		System.out.println(countSubarraysWithKSum(a, 3));
	}

	//sliding window solution
	public static void printSubarrayWithKOddNumbers(int a[], int k) {
		int i = 0, j = 0, oddCount = 0;

		while (i < a.length) {
			if ((a[i] & 1) == 1) {
				oddCount++;
			}
			
			if(oddCount==k) {
				System.out.println("Subarray has K odd number :"+j+"->"+i);
			}else {
				while(j<=i && oddCount>k) {
					if((a[j]&1)==1) {
						oddCount--;
					}
					j++;
				}
			}
			i++;
		}
	}

	//prefix subarray solution. Convert all odd numbers to 1 and even to 0 then it will become subarray with k sum problem

	public static int countSubarraysWithKSum(int a[], int k){
		IntStream.range(0,a.length).forEach(i->a[i]=a[i]&1);

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0,1);
		int sum=0;
		int count=0;
		for(int i=0;i<a.length; i++){
			sum = sum + a[i];
			if(map.containsKey(sum-k)){
				count = count + map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum,0)+1);
		}
		return count;
	}

}
