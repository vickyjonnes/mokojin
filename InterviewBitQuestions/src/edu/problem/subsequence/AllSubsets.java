package edu.problem.subsequence;

//Question: Given array of integeres write down all the possible subsets in that array.
//Ex: [1,2] => [{},{1},{2},{1,2}]. Total no of subsets will be 2^n.
//https://www.youtube.com/watch?v=bGC2fNALbNU&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev&index=8

import java.util.HashSet;
import java.util.Iterator;

public class AllSubsets {

    public static void main(String arr[]){
        int input[]=new int[]{1,2};
        int subset[] = new int[input.length];
       // printAllSubsets(new int[]{1,2},subset, 0);
        printIterative(new int[]{1,3,5,7});
    }

    //recurrsive method
    public static void printAllSubsets(int array[], int subset[], int start) {
        if(start==array.length)
            printSubset(subset);
        else{
            subset[start] = -99;
            printAllSubsets(array, subset, start+1);
            subset[start] = array[start];
            printAllSubsets(array, subset, start+1);
        }
    }

    public static void printSubset(int subset[]){
        boolean isPrsent = false;
        for (int i=0;i<subset.length;i++){
            if(subset[i]>=0){
                System.out.print(" "+subset[i]);
                isPrsent = true;
            }
        }
        if(!isPrsent){
            System.out.print("EMPTY_SET");
        }
        System.out.println();
    }

    //iterative approach, create an array of 0,1 for every number to be picked from subset.
    //ex: [1,2]-> possible subsets are 2^n=4 (where n=2). Hence posible binary arrays will be {[0,0],[0,1],[1,0],[1,1]}
    public static void printIterative(int arr[]) {
        int totalPossibleSubset = (int)Math.pow(2, arr.length);
        for (int i = 0; i <= totalPossibleSubset; i++) {
            String subset = "";
            for (int j = 0; j < arr.length; j++) {
                if (isBitSet(i, j)) {
                    subset = subset + "," + String.valueOf(arr[j]);
                }
            }
            System.out.println(subset);
        }
    }

    public static boolean isBitSet(int num, int index) {
        int temp = 1 << index;
        temp = temp & num;
        return temp == 0 ? false : true;
    }


}
