package edu.problem.general;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Upstox
//Question: board of NxN is given and a starting index is given and a ending index is given find minimum moves required to reach
//destination. Moves are One: 2 steps in row and 1 in column or Two: 2 steps in column or 1 steps in row
public class MinimumWaysOnChessToReachDestination {
    public static void main(String[] args) {
        int n = 9;
        int dp[][] = new int[n][n];
        for(int i=0;i<n; i++){
            for(int j=0;j<n; j++){
                dp[i][j]=0;
            }
        }
        System.out.println(findMinimumWays(9, 4,4,4,8, dp));

        for(int i=0;i<n; i++){
            for(int j=0;j<n; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static int findMinimumWays(int n, int i, int j, int r, int c, int dp[][]){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        dp[i][j]=0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            if(x==r && y==c)
                break;     // this is just to reduce time, as soon as we found the index then no need to find others.
            if(x+2<n && y+1<n && dp[x+2][y+1]==0){
                dp[x+2][y+1]=1+dp[x][y];
                q.add(new Pair(x+2, y+1));
            }
            if(x+2<n && y-1>=0 && dp[x+2][y-1]==0){
                dp[x+2][y-1]=1+dp[x][y];
                q.add(new Pair(x+2, y-1));
            }
            if(x-2>=0 && y+1<n && dp[x-2][y+1]==0){
                dp[x-2][y+1]=1+dp[x][y];
                q.add(new Pair(x-2, y+1));
            }
            if(x-2>=0 && y-1>=0 && dp[x-2][y-1]==0){
                dp[x-2][y-1]=1+dp[x][y];
                q.add(new Pair(x-2, y-1));
            }


            if(x+1<n && y+2<n && dp[x+1][y+2]==0){
                dp[x+1][y+2]=1+dp[x][y];
                q.add(new Pair(x+1, y+2));
            }
            if(x-1>=0 && y+2<n && dp[x-1][y+2]==0){
                dp[x-1][y+2]=1+dp[x][y];
                q.add(new Pair(x-1, y+2));
            }
            if(x+1<n && y-2>=0 && dp[x+1][y-2]==0){
                dp[x+1][y-2]=1+dp[x][y];
                q.add(new Pair(x+1, y-2));
            }

            if(x-1>=0 && y-2>=0 && dp[x-1][y-2]==0){
                dp[x-1][y-2]=1+dp[x][y];
                q.add(new Pair(x-1, y-2));
            }

        }
        return dp[r][c];
    }

    static class Pair{
        int x;
        int y;
        public Pair(int l, int m){
            x=l;
            y=m;
        }
    }
}
