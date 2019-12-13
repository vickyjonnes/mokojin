package edu.problem.maths;

public class WorstCaseToPickAllItemsWithKQuantity {

	//there is bag, which has n items and we know the quantity of each. We need to identify the worst case probability 
	//to get all the items at least k quantity, whatever is taken out will not be put again.
	//solution: case 1: min element is less than k then return not possible
	//case 2: min element item is k then return sum of array. because worst case will be to fetch all the elements
	//case 3: min element is > k then return sum - (min element-k)
	public static void main(String[] args) {
		int a[]=new int[] {5,6,7};
		System.out.println(getWorstNoOfPicks(a, 5));
		int a1[]=new int[] {6,7};
		System.out.println(getWorstNoOfPicks(a1, 5));
		int a2[]=new int[] {6,7,8};
		System.out.println(getWorstNoOfPicks(a2, 5));
	}
	
	public static int getWorstNoOfPicks(int a[], int k) {
		int min=Integer.MAX_VALUE,sum=0;
		for(int i=0;i<a.length;i++) {
			sum=sum+a[i];
			min=Math.min(min, a[i]);
		}
		
		if(min<5)
			return -999;
		if(min==5)
			return sum;
		return sum-(min-k);
		
	}

}
