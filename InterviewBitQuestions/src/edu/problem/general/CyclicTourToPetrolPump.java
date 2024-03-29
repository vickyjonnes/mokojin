package edu.problem.general;

public class CyclicTourToPetrolPump {

	//https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
	// solution is based on 2 pointers, we will keep adding end node until curr becomes negative or array finish
	//if curr become negative than we will keep removing start until curr become positive or queue goes empty.
	public static void main(String[] args) {
		PetrolPump a[]=new PetrolPump[5];
		a[0]=new PetrolPump(2,4);
		a[1]=new PetrolPump(4,6);
		a[2]=new PetrolPump(6,5);
		a[3]=new PetrolPump(7,3);
		a[4]=new PetrolPump(4,5);
		System.out.println(getStart(a));
		
		
		PetrolPump a1[]=new PetrolPump[4];
		a1[0]=new PetrolPump(8,2);
		a1[1]=new PetrolPump(3,7);
		a1[2]=new PetrolPump(4,7);
		a1[3]=new PetrolPump(7,5);
		System.out.println(getStart(a1));
	}
	
	
	public static int getStartPoint(PetrolPump a[]) {
		int n=a.length;
		int start=0, end=1;
		int curr_petrol=a[start].petrol-a[start].distance;
		
		while(curr_petrol<0 || start != end) {
			
			while(curr_petrol<0 && start !=end) {
				//curr_petrol= curr_petrol-(a[start].petrol-a[start].distance);
				//start = (start+1)%n;
				curr_petrol=0;
				start = end;
				//if 0th element is considered again then there is no tour possible
				if(start == 0)
					return -1;
			}
			
			curr_petrol = curr_petrol+(a[end].petrol-a[end].distance);
			end = (end +1)% n;
		}
		return start;
	}


	//single iteration approach. first we will convert the array of coardinates into the array of numbers by (petrol-distance).
	// then we will traverse from 0 and keep on adding the next element. If the sum become -ve at any point we will keep the value
	//in a variable called balance then start from the next index. at the end if total sum + balance >0 then we will print the start
	//index else there is no starting index
	public static int getStart(PetrolPump pumps[]){
		int a[]=new int[pumps.length];
		for(int i=0;i<pumps.length; i++){
			a[i]=pumps[i].petrol-pumps[i].distance;
		}
		int balance = 0;
		int start=0;
		int sum=0;
		for(int i=0;i<a.length; i++){
			sum = sum+a[i];
			if(sum<0){
				balance=balance+sum;
				sum=0;
				start=i+1;
			}
		}
		if(sum+balance>=0){
			return start;
		}else{
			return -1;
		}
	}
}

class PetrolPump{
	int petrol;
	int distance;
	public PetrolPump(int a, int b) {
		petrol=a;
		distance=b;
	}
}
