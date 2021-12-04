package edu.problem.general;

public class KnapsackProblem {
    //0-1 knapsack problem
    //https://www.youtube.com/watch?v=8LusJS5-AGo
    public static void main(String[] args) {
        int val[] = new int[]{1,4,5,7};
        int wt[] = new int[]{1,3,4,5};
        int maxW = 7;
        print(val, wt, maxW);
    }

    public static void print(int val[], int wt[], int maxW){
        int n=wt.length;
        int mat[][]=new int[n][maxW+1];

        for(int i=0; i<n;i++){
            for(int j=0;j<=maxW;j++){
                if(j==0)
                    mat[i][j]=0;
                else if(i==0){
                    if(wt[i]>j)
                        mat[i][j]=0;
                    else
                        mat[i][j]=val[i];
                }else{
                    if(wt[i]>j)
                        mat[i][j]=mat[i-1][j];
                    else{
                        mat[i][j]=Math.max(val[i]+mat[i-1][j-wt[i]], mat[i-1][j]);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for (int j=0;j<=maxW; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        System.out.print("Selected Items are=>");
        int maxValue=mat[n-1][maxW];
        int i=n-1, j=maxW;
        while(j>=0 && i>0){
            if(mat[i][j]==mat[i-1][j])
                i--;
            else{
                System.out.print(wt[i] +" ");
                j=j-wt[i];
            }
        }
    }
}
