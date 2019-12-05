package edu.problem;

public class BiggestSquareInMatrix {

	//geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
	public static void main(String[] args) {
		int mat[][]=new int[][] {{0,1,1,0,1},
								  {1,1,0,1,0},
								  {0,1,1,1,0},
								  {1,1,1,1,0},
								  {1,1,1,1,0},
								  {0,0,0,0,0}};
	
	System.out.println(getMaxSquareSize(mat));
	}
	
	
	public static int getMaxSquareSize(int mat[][]) {
		int rows=mat.length;
		int cols=mat[0].length;
		int dyMat[][]=new int[rows][cols];
		int maxLength=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(i==0 || j==0) {
					dyMat[i][j]=mat[i][j];
				}else {
					if(mat[i][j]==0) {
						dyMat[i][j]=mat[i][j];
					}else {
						dyMat[i][j]=1+Math.min(Math.min(dyMat[i][j-1], dyMat[i-1][j]), dyMat[i-1][j-1]);
					}
				}
				maxLength=Math.max(maxLength, dyMat[i][j]);
			}
		}
		return maxLength;
	}

}
