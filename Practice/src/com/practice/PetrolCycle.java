package com.practice;

public class PetrolCycle {

	public static void main(String[] args) {
		PetrolPump a[]=new PetrolPump[5];
		a[0]=new PetrolPump(2,4);
		a[1]=new PetrolPump(4,6);
		a[2]=new PetrolPump(6,5);
		a[3]=new PetrolPump(7,3);
		a[4]=new PetrolPump(4,5);
		System.out.println(getStartPoint(a));
		
		PetrolPump a1[]=new PetrolPump[4];
		a1[0]=new PetrolPump(8,2);
		a1[1]=new PetrolPump(3,7);
		a1[2]=new PetrolPump(4,7);
		a1[3]=new PetrolPump(7,5); 
		System.out.println(getStartPoint(a1));
	}
	
	public static int getStartPoint(PetrolPump a[]) {
		int n=a.length;
		int curr_petrol=0;
		for(int i=0;i<n;i++) {
			int start=i;
			curr_petrol=a[start].petrol-a[start].distance;
			int count=1;
			while(curr_petrol>=0) {
				start=(start+1)%n;
				curr_petrol += a[start].petrol-a[start].distance;
				count++;
				if(count==n) {
					System.out.println(a[i].petrol + "::"+a[i].distance);
					return i;
				}
			}
		}
		return -1;
	}

}

class PetrolPump{
	int petrol;
	int distance;
	public PetrolPump(int a,int b) {
		this.petrol=a;
		this.distance=b;
	}
	
	
}
