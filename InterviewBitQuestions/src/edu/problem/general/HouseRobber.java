package edu.problem.general;

import java.util.stream.IntStream;

//https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
//https://www.youtube.com/watch?v=xlvhyfcoQa4&t=336s
public class HouseRobber {
    public static void main(String[] args) {
        int wealthPerHome[] = {6,7,1,3,8,2,4};
        System.out.println("Total Robbery=>"+totalRobbery(wealthPerHome));
    }

    public static int totalRobbery(int wealthPerHome[]){
        int n = wealthPerHome.length;
        int dp[] = new int[n];
        dp[0]=wealthPerHome[0];
        dp[1] = Math.max(wealthPerHome[0], wealthPerHome[1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(wealthPerHome[i]+dp[i-2], dp[i-1]);  // maximum of robbery done so far or robbing current house + robbery
                                                                  // done before the previous house.
        }
        return dp[n-1];
    }
}


