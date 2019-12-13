package edu.problem.general;

import java.util.LinkedList;
import java.util.Queue;

public class TimetoRotOranges {

	//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
	//https://www.youtube.com/watch?v=Oretv1SSXmk
	public static void main(String[] args) {
		TimetoRotOranges timeToRotOranges = new TimetoRotOranges();
		int matrix[][]=new int[][] {{2,1,0,2,1},
									{1,0,1,2,1},
									{1,0,0,2,1}};
									
		int matrix2[][]=new int[][] {{2, 1, 0, 2, 1},
            						 {0, 0, 1, 2, 1},
            						 {1, 0, 0, 2, 1}};
            						 
		System.out.println(timeToRotOranges.bfs(matrix));
		System.out.println(timeToRotOranges.bfs(matrix2));
		
	}
	
	public int bfs(int matrix[][]) {
		int rows=matrix.length;
		int cols=matrix[0].length;
		int result=0;
		Queue<Orange> q=new LinkedList<Orange>();
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(matrix[i][j]==2) {
					q.add(new Orange(i, j, 0));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Orange orange=q.poll();
			result=Math.max(result, orange.timeframe);
			
			//top
			if(isInsideGrid(matrix,orange.x-1, orange.y) && matrix[orange.x-1][orange.y]==1) {
				q.add(new Orange(orange.x-1,orange.y,orange.timeframe+1));
				matrix[orange.x-1][orange.y]=2;
			}
			
			//right
			if(isInsideGrid(matrix,orange.x, orange.y+1) && matrix[orange.x][orange.y+1]==1) {
				q.add(new Orange(orange.x,orange.y+1,orange.timeframe+1));
				matrix[orange.x][orange.y+1]=2;
			}
			
			//bottom
			if(isInsideGrid(matrix,orange.x+1, orange.y) && matrix[orange.x+1][orange.y]==1) {
				q.add(new Orange(orange.x+1,orange.y,orange.timeframe+1));
				matrix[orange.x+1][orange.y]=2;
			}
			
			//left
			if(isInsideGrid(matrix,orange.x, orange.y-1) && matrix[orange.x][orange.y-1]==1) {
				q.add(new Orange(orange.x,orange.y-1,orange.timeframe+1));
				matrix[orange.x][orange.y-1]=2;
			}
			
			
		}
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(matrix[i][j]==1) {
					return -1;
				}
			}
		}
		
		return result;
	}
	
	public boolean isInsideGrid(int matrix[][], int x, int y) {
		if(x<0 || y<0 || x>=matrix.length || y>=matrix[0].length)
			return false;
		return true;
	}

}


class Orange{
	int x;
	int y;
	int timeframe;
	
	Orange(int x, int y, int timeframe){
		this.x=x;
		this.y=y;
		this.timeframe=timeframe;
	}
}
