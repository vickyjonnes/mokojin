package edu.problem;

import java.text.DecimalFormat;
import java.util.Arrays;

public class FractionKnapsackProblem {

	//https://www.geeksforgeeks.org/fractional-knapsack-problem/
	//the best way to solve this problem is greedy approach, and identify the profit/weight value
	public static void main(String[] args) {
		int w[]= new int[] {2,3,5,7,1,4,1};
		int p[]=new int[] {10,5,15,7,6,18,3};
		int maxWeight=15;
		final DecimalFormat df=new DecimalFormat("#0.000");
		System.out.println(df.format(getMaxProfit(w, p, maxWeight)));
		
		
		int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 40, 100, 120}; 
        int capacity = 50; 
        
        System.out.println(getMaxProfit(wt, val, capacity));

	}
	
	
	public static double getMaxProfit(int w[], int p[], double maxW) {
		Item items[]=new Item[w.length];
		for(int i=0;i<w.length;i++) {
			items[i]=new Item(w[i],p[i]);
		}
		
		Arrays.sort(items, (a,b)->Double.compare(b.cost, a.cost));
		//Arrays.asList(items).stream().forEach((a)->System.out.print(a.cost+" "));
		
		double maxProfit=0;
		for(Item i:items) {
			if(maxW-i.w>=0) {
				maxW=maxW-i.w;
				maxProfit=maxProfit+i.p;
			}else {
				double fraction=(maxW/i.w);
				maxW=maxW-(fraction*i.w);
				maxProfit=maxProfit+(fraction*i.p);
			}
		}
		
		return maxProfit;
	} 

}

class Item{
	double w;
	double p;
	double cost;
	
	Item(double w, double p){
		this.w=w;
		this.p=p;
		cost = p/w;
	}
}
