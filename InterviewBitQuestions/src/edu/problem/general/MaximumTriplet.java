package edu.problem.general;

import java.util.stream.IntStream;

//https://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
// Question: Find the maximum product of 3 numbers from a given array. Array can have -ve numbers.
//Solution: Find out the 3 maximum numbers in the array and multiply them all. But for -ve numbers, we have to find 3 smallest num
//as well. Product of 2 smallest -ve numbers will be highest. Hence need to find max of [product of 3 maximum numbers, product of 2
// smallest and 1 maximum number]
public class MaximumTriplet {

    public static void main(String[] args) {
        System.out.println(findMaxProduct(new int[]{-10, -3, -5, -6, -20}));
    }

    public static int findMaxProduct(int arr[]){
        int x=Integer.MIN_VALUE,y=Integer.MIN_VALUE,z=Integer.MIN_VALUE;
        int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE;

        for(int i=0;i<arr.length; i++){
            if(x<arr[i]){
                z=y;
                y=x;
                x=arr[i];
            }else if(y<arr[i]){
                z=y;
                y=arr[i];
            }else if(z<arr[i]){
                z=arr[i];
            }

            if(a>arr[i]){
                b=a;
                a=arr[i];
            }else if(b>arr[i]){
                b=arr[i];
            }
        }
        return Math.max(x*y*z, a*b*x);
    }

}
