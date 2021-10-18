package edu.problem.general;


//Question: [A-Z] is mapped to [1-26] numbers. If given a string "121" how many possible ways to decode this message.
//Ex: Input "123", decoded string can be ["abc", "lc", "aw"] reason: 1=a and 12 = l, 2=b and 23=w, hence output should be 3
//Input will always contain string of non-negative integer literals.
//https://www.youtube.com/watch?v=qli-JCrSwuk&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev
//Solution: Divide the problem into subproblems and then do ut recursively. To optimize it apply dp
public class DecodeMessage {


    public static void main(String arr[]){
        String input = "11111";
        System.out.println(decodeRecur(input, input.length()));

        int dp[] = new int[input.length()];
        for (int i=0;i<input.length();i++){
            dp[i]=-99;
        }
        System.out.println(decodeDp(input, input.length(), dp));
        for (int i=0;i<input.length();i++){
            System.out.println(dp[i]);
        }

    }
    //recursive approach
    public static int decodeRecur(String input, int lastKdigits){
        if(input.length()==0) return 1;
        int start = input.length()-lastKdigits;
        if(lastKdigits<=1){
            return 1;
        }
        if(input.charAt(start)=='0') return 0;
        int result = decodeRecur(input, lastKdigits-1);
        if(lastKdigits>=2 && Integer.valueOf(input.substring(start, start+2))<=26){
            result = result + decodeRecur(input, lastKdigits-2);
        }
        return result;
    }

    //dp approach
    public static int decodeDp(String input, int lastKdigits, int dp[]){
        if(input.length()==0) return 1;
        int start = input.length()-lastKdigits;
        if(lastKdigits<=1){
            return 1;
        }
        if(lastKdigits!=input.length() && dp[lastKdigits]!=-99) return dp[lastKdigits];
        if(input.charAt(start)=='0') return 0;
        int result = decodeDp(input, lastKdigits-1, dp);
        if(lastKdigits>=2 && Integer.valueOf(input.substring(start, start+2))<=26){
            result = result + decodeDp(input, lastKdigits-2, dp);
        }
        if(lastKdigits!=input.length())
            dp[lastKdigits]=result;
        return result;
    }
}