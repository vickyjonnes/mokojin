package edu.problem.general;

//https://www.youtube.com/watch?v=J2eoCvk59Rc
//https://www.geeksforgeeks.org/coin-change-dp-7/
public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {1,5,6,9};
        int sum = 10;
        System.out.println("Count=>"+ countMinCoins(coins, sum));

        int coins1[] = {1,5,6,9};
        int sum1 = 11;
        System.out.println("Count=>"+ countMinCoins(coins1, sum1));

        int coins2[] = {1,2,3};
        int sum2 = 6;
        System.out.println("Total ways=>"+ countTotalWays(coins2, coins2.length-1, sum2, createDP(coins2, sum2)));
    }

    public static int countMinCoins(int coins[], int sum){
        int mat[][]=new int[coins.length][sum+1];

        for(int i=0;i<coins.length; i++){
            for (int j=0;j<=sum; j++){
                if(j==0){
                    mat[i][j]=0;
                }else if(coins[i]==j){
                    mat[i][j]=1;
                }else if(coins[i]>j){
                    mat[i][j] = (i-1>=0)?mat[i-1][j] : 0;
                }else{
                    int top = (i-1>=0)?mat[i-1][j] : Integer.MAX_VALUE;
                    mat[i][j] = Math.min(top, 1+mat[i][j-coins[i]]);
                }
            }
        }

        for (int i=0;i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        return mat[coins.length-1][sum];
    }

    //count all the possible ways to get desired sum.
    public static int countTotalWays(int coins[], int n, int sum, int dp[][]){
        if(n<0 && sum>0)
            return 0;
        if(sum<0)
            return 0;
        if(sum==0)
            return 1;
        if(dp[n][sum]!=-1) return dp[n][sum];
        return dp[n][sum] = countTotalWays(coins, n-1, sum, dp) + countTotalWays(coins, n, sum-coins[n], dp);
    }

    public static int[][] createDP(int coins[], int sum){
        int n = coins.length;
        int dp[][] = new int[n][sum+1];
        for(int i=0;i<n;i++){
            for (int j=0;j<=sum; j++){
                dp[i][j]=-1;
            }
        }
        return dp;
    }
}
