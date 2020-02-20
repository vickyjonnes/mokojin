package com.practice;

import java.util.HashMap;

public class ArrayRotation {

	public static void main(String[] args) {
		int aray[]=new int[] {1,2,3,4,5,6,7,8};
		int a[]=rotateArray(aray, 3);
		HashMap<String, Integer> map=new HashMap<>();
		String str="abcc";
		for(int j=0;j<str.length();j++){
            if(map.containsKey(str.charAt(j)+"")){
                map.put(str.charAt(j)+"",map.get(str.charAt(j)+"")+1);
            }else{
                map.put(str.charAt(j)+"",1);
            }
        }
		System.out.println("size"+map.size());
		/*for(int i: a) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(rotationPoint(a));
		System.out.println(findIndexOfNumber(a, 8, rotationPoint(a)));*/
	}
	
	public static int[] rotateArray(int a[], int d) {
		for(int i=0;i<d;i++) {
			int temp=a[0];
			for(int j=0;j<a.length;j++) {
				if(j==a.length-1)
					a[j]=temp;
				else
					a[j]=a[j+1];
			}
		}
		return a;
	}
	
	public static int rotationPoint(int a[]) {
		int start=0, end = a.length-1;
		while(start<=end) {
			int mid=(start+end+1)/2;
			if(a[mid]<a[mid+1] && a[mid]>a[end]) {
				start=mid+1;
			}else if(a[mid]>a[mid-1] && a[mid]<a[start]) {
				end=mid-1;
			}else {
				return mid;
			}
		}
		return 0;
	}
	
	public static int findIndexOfNumber(int a[], int num, int rotPoint) {
		int start=0,end=0;
		if(num<=a[rotPoint] && num>a[0]) {
			start=0; end=rotPoint;
		}
		if(num<a[rotPoint] && num<a[0]) {
			start=rotPoint+1;end=a.length-1;
		}
		
		while(start<=end) {
			int mid=(start+end)/2;
			if(num<a[mid]) {
				end=mid-1;
			}else if(num>a[mid]) {
				start=mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}
