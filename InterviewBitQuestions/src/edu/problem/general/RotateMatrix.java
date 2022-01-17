package edu.problem.general;

//https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
public class RotateMatrix {
    public static void main(String[] args) {
        int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
        //rotateClockwise(mat);
        rotateAntiClockWise(mat);
    }

    //idea is to first do the transpose of matrix and then reverse it the row-wise
    public static void rotateClockwise(int mat[][]){
        for(int i=0;i<mat.length; i++){
            for(int j=i; j<mat[i].length; j++){
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        for(int i=0;i<mat.length; i++){
            for(int j=0; j<mat[i].length/2; j++){
                int temp = mat[i][j];
                mat[i][j]=mat[i][mat[i].length-1-j];
                mat[i][mat[i].length-1-j]=temp;
            }
        }

        for(int i=0;i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    //idea is to first do the transpose of matrix and then reverse it the column wise
    public static void rotateAntiClockWise(int mat[][]){
        int n=mat.length, m=n;
        for(int i=n-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        for(int j=0;j<m; j++){
            for(int i=0; i<n/2; i++){
                int temp = mat[i][j];
                mat[i][j]=mat[n-1-i][j];
                mat[n-1-i][j]=temp;
            }
        }

        for(int i=0;i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
