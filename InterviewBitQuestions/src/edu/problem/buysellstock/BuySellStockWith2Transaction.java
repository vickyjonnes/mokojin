package edu.problem.buysellstock;

import java.util.stream.IntStream;

public class BuySellStockWith2Transaction {

	//https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
	//this is tricky and cab approached as below
	//1. make a array profit[] and initialize with 0, profit[i]=0
	//2. traverse right to left and fill profit as proit[i]=max(profit[i+1], max_price-price[i])
	//in step 2 we need to keep track of max_price so far
	//3. traverse left to right and fill profit as profit[i]=max(profit[i-1], profit[i]+price[i]-min_price)
	//in step 3 we need to keep track of min_price.
	//basic idea is to calculate maximum profit in 1 txn in first pass and then max profit in 2 txn in second pass then return profit[n-1].
	public static void main(String[] args) {
		int price[]=new int[] {2,30,15,10,8,25,80};
		System.out.println(maxProfit(price));
		int price1[]=new int[] {10,22,5,75,65,80};
		System.out.println(maxProfit(price1));
	}
	
	
	public static int maxProfit(int price[]) {
		int n=price.length;
		int profit[]=new int[n];
		IntStream.range(0, n).forEach((i)->profit[i]=0);
		
		//step 2
		int max_price=price[n-1];
		for(int i=n-2;i>=0;i--) {
			max_price=Math.max(max_price, price[i]);
			profit[i]=Math.max(profit[i+1], max_price-price[i]);
		}
		
		//step 3
		int min_price=price[0];
		for(int i=1;i<n;i++) {
			min_price=Math.min(min_price, price[i]);
			profit[i]=Math.max(profit[i-1], profit[i]+price[i]-min_price);
		}
		
		IntStream.range(0, n).forEach((i)->System.out.print(profit[i]+" "));
		System.out.println();
		return profit[n-1];
	}
	
	

}
