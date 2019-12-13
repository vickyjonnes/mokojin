package edu.problem.general;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		List<ArrayList<Integer>> matrix=new ArrayList<>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(1); list.add(2); list.add(3);
		matrix.add(list);
		list=new ArrayList<Integer>();
		list.add(4);list.add(5); list.add(6);
		matrix.add(list);
		list=new ArrayList<Integer>();
		list.add(7);list.add(8);list.add(9);
		matrix.add(list);
		//matrix.add(new ArrayList<Integer>)
		//int matrix[][]= {{1,2,3},{4,5,6},{7,8,9}};
		printSpiralMatrix(matrix);

	}
	
	public static void printSpiralMatrix(List<ArrayList<Integer>> matrix) {
		int rows=matrix.size();
		int cols=matrix.get(0).size();
		int r=0,c=0;
		ArrayList<Integer> list=new ArrayList<>();
		while(r<=rows && c<=cols) {
			for(int i=r;i<cols;i++) {
				System.out.print(matrix.get(r).get(i)+" ");
				list.add(matrix.get(r).get(i));
			}
			r++;
			for(int i=r;i<rows;i++) {
				System.out.print(matrix.get(i).get(cols-1)+" ");
				list.add(matrix.get(i).get(cols-1));
			}
			cols--;
			for(int i=cols-1;i>=c;i--) {
				System.out.print(matrix.get(rows-1).get(i)+" ");
				list.add(matrix.get(rows-1).get(i));
			}
			rows--;
			for(int i=rows-1;i>=r;i--) {
				System.out.print(matrix.get(i).get(c)+" ");
				list.add(matrix.get(i).get(c));
			}
			c++;
		}
	}

}
