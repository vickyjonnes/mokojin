package edu.problem.general;

//asked in hoscotch
//ques: find the largest zigzag subsequence. zigzag means a[i+1]>a[i] && a[i+2]<a[i+1]
//sol: printing out the minimum and maximum
public class ZigZagArray {
    public static void main(String[] args) {
        int a[] = {1, 2, 4, 9, 6, 8, 2, 9, 5, 2, 4, 1, 8};
        int a1[] = {1, 3, 6, 9, 7, 2, 4, 7, 9, 3, 7, 4, 8, 19, 11, 13,14};
        int a2[] = {1,2,3,4,5,6,7,8,2,4,6};
        printZigZag(a1);
    }

    public static void printZigZag(int a[]){
        boolean up=true;
        int cur = a[0];
        System.out.println(cur);
        for(int i=1; i<a.length; i++){
            if(a[i]>cur && up){
                cur=a[i];
            }else if(a[i]>cur && !up){
                System.out.println(cur);
                cur=a[i];
                up=true;
            }else if(a[i]<cur && !up){
                cur=a[i];
            }else if(a[i]<cur && up){
                System.out.println(cur);
                cur = a[i];
                up=false;
            }
        }
        System.out.println(cur);
    }
}
