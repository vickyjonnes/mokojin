package edu.problem.general;

import java.util.Arrays;

//https://www.geeksforgeeks.org/largest-area-possible-after-removal-of-a-series-of-horizontal-vertical-bars/
//
public class LargestArea {
    public static void main(String[] args) {
        int n = 3; int m=2;
        int h[] = {1,2,3};
        int v[] = {1,2};
        System.out.println(getMax(h, n)*getMax(v, m));

    }

    public static int getMax(int a[], int n){
        Arrays.sort(a);
        int row[] = new int[n+1];
        int k=0;
        int maxH=Integer.MIN_VALUE;
        for(int i=0;i<row.length; i++){
            if(k<a.length && i==a[k]){
                row[i]=0;
                k++;
            }else{
                row[i]=1;
            }
        }
        int count=0;
        for(int i=0;i<row.length; i++){
            if(row[i]==0){
                count++;
            }else{
                count=0;
            }
            maxH = Math.max(count, maxH);
        }
        return maxH+1;
    }
}
