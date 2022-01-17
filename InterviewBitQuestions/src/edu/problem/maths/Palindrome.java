package edu.problem.maths;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1223221));
    }

    public static boolean isPalindrome(int num){
        int rev=0;
        int temp = num;
        while(temp>0){
            int lastDigit = temp%10;
            rev = rev*10 + lastDigit;
            temp = temp/10;
        }
        return rev == num;
    }
}
