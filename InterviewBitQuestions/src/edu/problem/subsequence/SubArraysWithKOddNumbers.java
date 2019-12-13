package edu.problem.subsequence;

public class SubArraysWithKOddNumbers {

	public static void main(String[] args) {
		int a[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		printSubarrayWithKOddNumbers(a, 3);
	}

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

}
