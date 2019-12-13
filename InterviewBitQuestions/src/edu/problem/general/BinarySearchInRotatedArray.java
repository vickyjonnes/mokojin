package edu.problem.general;

public class BinarySearchInRotatedArray {

	//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
	//first of all we need to find the point where array was rotated then we can just do binary search in one of the subarray, either left
	//or right.
	public static void main(String[] args) {
		int arr[]=new int[] {3,4,5,6,7,8,9,1,2};
		System.out.println(getIndexOfElement(arr, 10));
	}
	
	//return index of num else -1
	public static int getIndexOfElement(int arr[], int num) {
		int pivotPoint=getPivotPoint(arr);
		int start=0,end=arr.length-1;
		if(num<arr[0]) {
			start=pivotPoint+1;	
		}else if(num>arr[0]){
			end=pivotPoint;
		}else {
			return 0;
		}
		
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==num) {
				return mid;
			}else if(arr[mid]>num) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return -1;
	}
	
	
	//getting the pivot element, where the rotation happened
	public static int getPivotPoint(int arr[]) {
		int start=0, end=arr.length-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]>arr[mid+1]) {
				return mid;
			}else {
				if(arr[mid]>arr[end]) {
					start=mid+1;
				}else if(arr[mid]<arr[start]) {
					end=mid-1;
				}else {
					break;
				}
				
			}
		}
		return 0;
	}

}
