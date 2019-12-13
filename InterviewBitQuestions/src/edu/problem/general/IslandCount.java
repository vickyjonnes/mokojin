package edu.problem.general;

public class IslandCount {

	//https://www.geeksforgeeks.org/find-number-of-islands/
	//https://www.youtube.com/watch?v=o8S2bO3pmO4
	public static void main(String[] args) {
		int matrix[][]=new int[][]{{1,1,0,0,0},
									{0,1,0,0,1},
									{1,0,0,1,1},
									{0,0,0,0,0},
									{1,0,1,0,1}};
									
		System.out.println(getCount(matrix));
	}
	
	
	public static int getCount(int matrix[][]) {
		int count=0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				count = count+dfs(matrix, i, j);
			}
		}
		return count;
	}
	
	public static int dfs(int matrix[][], int i, int j) {
		if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]==0)
			return 0;
		matrix[i][j]=0;
		dfs(matrix, i, j+1);
		dfs(matrix, i+1, j+1);
		dfs(matrix, i+1, j);
		dfs(matrix, i+1, j-1);
		dfs(matrix, i, j-1);
		dfs(matrix, i-1, j-1);
		dfs(matrix, i-1, j);
		dfs(matrix, i-1, j+1);
		return 1;
	}

}
