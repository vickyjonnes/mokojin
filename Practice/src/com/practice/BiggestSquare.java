package com.practice;

public class BiggestSquare {

	public static void main(String[] args) {
		int mat[][]=new int[][] {
			  {0,1,1,0,1},
			  {1,1,0,1,0},
			  {0,1,1,1,0},
			  {1,1,1,1,0},
			  {1,1,1,1,0},
			  {0,0,0,0,0}
			  };
			  
			  int mat1[][]=new int[][] {{1,1,1},{0,0,0}};

			  System.out.println(maxSquare(mat));

			  System.out.println(maxSquare(mat1));
	}
	
	public static int maxSquare(int mat[][]) {
		int rows=mat.length;
		int cols=mat[0].length;
		int tempMat[][]=new int[rows][cols];
		int max=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(i==0 || j==0 || mat[i][j]==0) {
					tempMat[i][j]=mat[i][j];
				}else {
					tempMat[i][j]=1+Math.min(Math.min(tempMat[i][j-1], tempMat[i-1][j]), tempMat[i-1][j-1]);
				}
				
				max=Math.max(max, tempMat[i][j]);
			}
			
		}
		return max;
	}

}
