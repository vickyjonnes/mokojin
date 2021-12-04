package edu.problem.general;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
public class PairSum {
    public static void main(String[] args) {
        int a[]={ 1, 4, 45, 6, 10, 8 };
        printPair(a, 16);
        int b[]={1,5,7,-1,5};
        printCount(b, 6);
    }

    public static void printPair(int a[], int sum){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<a.length; i++){
            int temp=sum-a[i];
            if(set.contains(temp)){
                System.out.println("Pair: "+a[i]+":"+temp);
            }else{
                set.add(a[i]);
            }
        }
    }

    //https://www.geeksforgeeks.org/count-pairs-with-given-sum/
    public static void printCount(int a[], int sum){
        Map<Integer, Integer> map =new HashMap<>();

        for(int i=0;i<a.length; i++){
            if(map.get(a[i])==null){
                map.put(a[i], 1);
            }else{
                map.put(a[i], map.get(a[i])+1);
            }
        }

        int count=0;

        for(int i=0;i<a.length; i++){
            if(map.get(sum-a[i])!=null){
                count = count+map.get(sum-a[i]);
            }
            if(sum-a[i]==a[i])
                count--;
        }
        System.out.println(count/2);
    }
}
