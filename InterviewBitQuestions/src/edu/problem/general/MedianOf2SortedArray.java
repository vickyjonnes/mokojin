package edu.problem.general;

public class MedianOf2SortedArray {

	//find median of the 2 sorted array, median means, if the combination of both the arrays lenght is odd then
	//the middle element is media else avg of 2 middle element i median.
	// approach is similar to mergesort but we dont actually merge the arrays here, we just find out the midle element in the
	//combined array if the array got merged.
	public static void main(String[] args) {
		int a[]=new int[] {1,3,5,9,10,11,16};
		int b[]=new int[] {2,4,6,8,15};
		System.out.println(getMedian(a, b));

	}
	
	public static double getMedian(int a[], int b[]) {
		int fLength=a.length+b.length;
		int count=fLength/2;
		if((fLength&1)==1) {
			int result=0, j=0,k=0;
			for(int i=0;i<=count;i++) {
				if(a[j]<=b[k]) {
					result=a[j];
					j++;
				}else {
					result=b[k];
					k++;
				}
			}
			return result;
		}else {
			int x=0,y=0;
			int j=0,k=0;
			if(a[j]<=a[k]) {
				y=a[j];
				j++;
			}else {
				y=b[k];
				k++;
			}
			
			for(int i=0;i<count;i++) {
				x=y;
				if(a[j]<=a[k]) {
					y=a[j];
					j++;
				}else {
					y=b[k];
					k++;
				}
			}
			return (x+y)/2;
		}
	}

}
