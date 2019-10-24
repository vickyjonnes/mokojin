package edu.problem;

public class EggDroping {

	//https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
	//https://www.youtube.com/watch?v=3hcaVyX00_4
	public static void main(String[] args) {
		System.out.println("max drops required are: "+maxDrops(4, 8));
	}
	
	//max drop required in worst case
	public static int maxDrops(int eggs, int floors) {
		int mat[][]=new int[eggs+1][floors+1];
		//for 1 egg
		for(int f=1;f<=floors;f++) {
			mat[1][f]=f;
		}
		
		for(int e=2;e<=eggs;e++) {
			for(int f=1;f<=floors;f++) {
				if(e>f) {
					mat[e][f]=mat[e-1][f];
				}else {
					int k=1;
					int temp=Integer.MAX_VALUE;
					while(k<=f) {
						temp=Math.min(temp, 1+Math.max(mat[e-1][k-1], mat[e][f-k]));
						k++;
					}
					mat[e][f]=temp;
				}
			}
		}
		
		for(int i=0;i<=eggs;i++) {
			for(int j=0;j<=floors;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		return mat[eggs][floors];
	}

}
