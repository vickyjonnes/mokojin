package edu.problem;

public class BuySellStockWithKTransactions {

	// this is probably the most difficult problem on buy/sell stock to maximize the
	// profit problem.
	// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
	// https://www.youtube.com/watch?v=oDhu5uGq_ic&t=562s
	//
	public static void main(String[] args) {
		int price[] = new int[] { 2, 5, 7, 1, 4, 3, 1, 3 };
		System.out.println(maxProfit(price, 3));

		int price2[] = new int[] { 10, 22, 5, 75, 65, 80 };
		System.out.println(maxProfit(price2, 2));

		int price3[] = new int[] { 12, 14, 17, 10, 14, 13, 12, 15 };
		System.out.println(maxProfit(price3, 3));
		System.out.println();
		System.out.println(slowMaxProfit(price3, 3));
	}

	// total complexity of this algo is O(n*m)
	public static int maxProfit(int price[], int m) {
		int n = price.length;
		int profit[][] = new int[m + 1][n];

		
		for (int i = 1; i < m+1; i++) {
			int max_diff = -price[0];
			for (int j = 1; j < n; j++) {
				max_diff = Math.max(max_diff, profit[i - 1][j - 1] - price[j - 1]);
				profit[i][j] = Math.max(profit[i][j - 1], price[j] + max_diff);
			}
		}

		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(profit[i][j] + " ");
			}
			System.out.println();
		}

		return profit[m][n - 1];
	}
	
	//this is another apprach where complexity is O(n square m)
	public static int slowMaxProfit(int price[], int m) {
		int n=price.length;
		int profit[][]=new int[m+1][n];
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n;j++) {
				int tempValue=0;
				for(int k=0;k<j;k++) {
					tempValue=Math.max(tempValue, price[j]-price[k]+profit[i-1][k]);
				}
				profit[i][j]=Math.max(profit[i][j-1], tempValue);
			}
		}
		
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(profit[i][j] + " ");
			}
			System.out.println();
		}
		
		return profit[m][n-1];
	}

}
