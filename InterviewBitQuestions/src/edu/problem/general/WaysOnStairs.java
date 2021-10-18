package edu.problem.general;

//Question: There is a staircase with N steps starting from 0. A climber is given a set of steps which he can take to climb N steps.
//Find the no of different ways a climber can go at the top.
// https://www.youtube.com/watch?v=5o-kdjv7FD0&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev&index=2
//Solution: if climber can take either 1 step or 2 step to climb the staircase then, if there r 0 or 1 steps in the staircase
// there is only 1 way to climb, if there r 2 steps in the staircase there are only 2 ways to climb. Taking this as a base case
// we can drive a recursive solution that numways(n)=numways(n-1)+numways(n-2).
//Similarly if there are more possible steps for example {1,3,5...} a climber can take then similar apporach will be like
//numways(n)=numways(n-1)+numways(n-3)+numways(n-5)....
public class WaysOnStairs {

    public static void main(String arr[]){
        System.out.println(numwaysRecur(4));
        System.out.println(numwaysDp(4));
        System.out.println(numwaysDp(4, new int[]{1,2}));
    }

    //for case where set of steps can be either 1 or 2
    public static int numwaysRecur(int n){
        if(n==0 || n==1) return 1;
        return numwaysRecur(n-1)+numwaysRecur(n-2);
    }

    //dp approach for case where set of steps can be either 1 or 2
    public static int numwaysDp(int n){
        if(n==0 || n==1) return 1;
        int dp[]=new int[n+1];
        dp[0]=1; dp[1]=1;
        for(int i=2; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //dp approach for case where set of steps can be anything in array x
    public static int numwaysDp(int n, int x[]){
        if(n==0) return 1;
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1; i<=n;i++){
            int total = 0;
            for(int j:x){
                if(i-j>=0){
                    total = total+dp[i-j];
                }
            }
            dp[i]=total;
        }
        return dp[n];
    }

}
