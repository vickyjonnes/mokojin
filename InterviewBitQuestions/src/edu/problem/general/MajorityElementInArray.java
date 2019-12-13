package edu.problem.general;

public class MajorityElementInArray {

	//majority Element means if an element is n/2 times in an array.
	//one way to solve, sort the element in o(nlogn) then if there is a majority element in array it will be at the mid position
	// so compare mid,mid+1 and mid,mid-1, if any thing return true then mid is the majority element, if both false then
	//there is no majority elemement.
	/*
	 * below code is a different approach called Moore's Voting algorithm. It has 2 steps and O(n) complexity
	 * Step 1: Find majority Candidate Step 2: Check if it is majority element
	 * The core idea of this algorithm is to cancel every item with every other item and whatever is left may be a majority element.
	*/
	public static void main(String[] args) {
		int a[]=new int[] {3, 3, 4, 2, 4, 4, 2, 4, 4};
		System.out.println(getMajorityElement(a));
		int a1[]=new int[] {2,1,2,4,7};
		System.out.println(getMajorityElement(a1));
		int a2[]=new int[] {4,7,4,4,7,4,4,9,4,3};
		System.out.println(getMajorityElement(a2));
	}
	
	public static int getMajorityElement(int a[]) {
		//to get majority candidate
		int count=0,candidate=0;
		for(int i=0;i<a.length;i++) {
			if(count==0) {
				candidate=a[i];
				count++;
			}else {
				if(candidate==a[i])
					count++;
				else
					count--;
			}
		}
		//now if the count comes out to be 0 then there is not majority candidate
		if(count==0){
			return -99;
		}else {
			//to check whether the given num is n/2 times or not.
			count=0;
			for(int i=0;i<a.length;i++) {
				if(candidate==a[i])
					count++;
			}
			if(count>a.length/2)
				return candidate;
			else
				return -99;
		}
	}
	
	

}
