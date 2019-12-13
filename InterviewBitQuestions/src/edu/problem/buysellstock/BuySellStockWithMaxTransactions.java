package edu.problem.buysellstock;

public class BuySellStockWithMaxTransactions {

	//https://www.geeksforgeeks.org/stock-buy-sell/
	//maximize the profit with any number of txn. In this we will identify all the increasing pairs and add thier profits.
	public static void main(String[] args) {
		int price[]=new int[] {100,80,120,130,70,60,100,125};
		System.out.println(maxProfit(price));
		int price1[]=new int[] {2,30,15,10,8,25,80};
		System.out.println(maxProfit(price1));
	}
	
	
	public static int maxProfit(int price[]) {
		int profit=0;
		for(int i=0;i<price.length-1;i++) {
			if(price[i]<price[i+1]) {
				profit=profit+price[i+1]-price[i];
			}
		}
		return profit;
	}

}
