package edu.problem.general;

import java.util.stream.IntStream;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms=new MergeSort();
		int c[]=ms.mergeSort(new int[] {2,4,1,6,8,5,3,7});
		IntStream.of(c).forEach(System.out::print);
	}


	public int[] mergeSort(int c[]) {
		int n=c.length;
		if(n<2) return c;
		int mid=n/2;
		int left[]=new int[mid];
		int right[]=new int[n-mid];
		IntStream.range(0, mid).forEach(i->left[i]=c[i]); 
		IntStream.range(mid, n).forEach(i->right[i-mid]=c[i]); 
		mergeSort(left);
		mergeSort(right);
		merge(left, right, c);
		return c;
	} 


	public int[] merge(int[] a, int b[], int c[]) {
		int i=0,k=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i]<=b[j]) {
				c[k]=a[i];
				k++;i++;
			}else {
				c[k]=b[j];
				k++; j++;
			}
		}
		while(i<a.length) {
			c[k]=a[i];
			k++;i++;
		}
		while(j<b.length) {
			c[k]=b[j];
			k++;j++;
		}

		return c;
	}
}
