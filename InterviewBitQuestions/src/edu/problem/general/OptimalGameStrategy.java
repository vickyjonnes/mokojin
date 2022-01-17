package edu.problem.general;

//https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/
//https://www.youtube.com/watch?v=ww4V7vRIzSk
//Question: coins with different value are placed in an array, both players can pick coins from either start or end.
//Assume u have got the first chance then maximise your coins and value.
// Sol: i=0, j=n if u took 1 coin from start opponent is left with (i+1 to j) array or if u took from end then opponent is left with
// (i to j-1) array. now opponent will pick and after his chance you will be left with array either (i+2 to j) or (i+1, j-1) or
//(i+1, j-1) or (i, j-2). Now because opponent is as good as you in the game, you have to choose such that after his chance
//you will be left with minimum value, and similarly you should chose.
// so if you chose a[i] then you will get a[i]+min(fn(i+2, j), fn(i+1, j-1))
//or if you chose a[j] then you will get a[j]+min(fn(i+1, j-1), fn(i, j-2))
// so you should chose for the max of these 2 values = max{(a[i]+min(fn(i+2, j), fn(i+1, j-1))),(a[j]+min(fn(i+1, j-1), fn(i, j-2)))}
public class OptimalGameStrategy {
    public static void main(String[] args) {
        int a[] = {20,30,2,10};
        System.out.println(getMaxSum(a));
    }

    public static int getMaxSum(int a[]){
        int n = a.length;
        int mat[][] = new int[n][n];
        for(int g=0;g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                if(g==0){
                    mat[i][j]=a[i];
                }else if(g==1){
                    mat[i][j]=Math.max(a[i],a[j]);
                }else{
                    int first = a[i]+Math.min(mat[i+2][j], mat[i+1][j-1]);
                    int second = a[j]+Math.min(mat[i+1][j-1],mat[i][j-2]);
                    mat[i][j]=Math.max(first, second);
                }
            }
        }
        return mat[0][n-1];
    }
}
