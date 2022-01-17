package edu.problem.general;

//https://www.youtube.com/watch?v=46zD5d9y9b4
public class AllWaysInMatrix {
    public static void main(String[] args) {
        System.out.println(allWays(3,3));
    }

    public static int allWays(int n, int m){
        if(n==1 || m==1){
            return 1;
        }
        return allWays(n-1, m)+ allWays(n, m-1);
    }
}
