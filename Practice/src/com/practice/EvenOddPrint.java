package com.practice;

public class EvenOddPrint {

	public static void main(String[] args) {
		EvenOdd eo=new EvenOdd();
		Thread t1=new Thread(eo, "even");
		Thread t2=new Thread(eo, "odd");
		t1.start(); t2.start();
	}

}

class EvenOdd implements Runnable{

	Integer i=1;
	
	public synchronized void printEven() throws InterruptedException {
		if((i&1)==1)
			wait();
		System.out.println("Even : "+i);
		i=i+1;
		Thread.sleep(500);
		notify();
	}
	
	public synchronized void printOdd() throws InterruptedException {
		if((i&1)==0)
			wait();
		System.out.println("Odd : "+i);
		i=i+1;
		Thread.sleep(500);
		notify();
	}
	
	@Override
	public void run() {
		try{
			while(i<=10) {
				if(Thread.currentThread().getName().equalsIgnoreCase("even"))
					printEven();
				else
					printOdd();
			}
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
