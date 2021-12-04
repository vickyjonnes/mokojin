package edu.problem.general;

public class NQueens {
//https://www.youtube.com/watch?v=jJPtLzq1E-Y
//https://www.youtube.com/watch?v=xouin83ebxE
	public static void main(String[] args) {
		int n=4;
		Position p[]=new Position[n];
		//p[0]=new Position(0,0);
		System.out.println(findPosition(p, 0, n));
		for(Position po:p)
			System.out.println(po.row+","+po.col);
	}
	
	public static boolean findPosition(Position position[],int row,int n) {
		if(n==row)
			return true;
		for(int col=0;col<n;col++) {
			position[row]=new Position(row,col);
			if(isSafe(position, row, col) && findPosition(position, row+1, n)) {
				return true;
			}else {
				position[row]=null;
			}

		}
		return false;

	}
	
	public static boolean isSafe(Position ps[], int row, int col) {
		if(row==0)
			return true;
		for(int queen=0;queen<row;queen++) {
			if(ps[queen].col==col || ps[queen].row+ps[queen].col==row+col || ps[queen].row-ps[queen].col==row-col)
				return false;
		}
		System.out.println("safe:: "+row +","+col);
		return true;
	}

}

class Position{
	public int row;
	public int col;
	Position(int row, int col){
		this.row=row;
		this.col=col;
	}
}
