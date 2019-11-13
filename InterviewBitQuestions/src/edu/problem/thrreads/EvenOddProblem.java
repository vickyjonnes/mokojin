package edu.problem.thrreads;

public class EvenOddProblem {

	public static void main(String[] args) {
		EvenOddPrinter eop=new EvenOddPrinter();
		Thread t1=new Thread(eop, "even");
		Thread t2=new Thread(eop, "odd");
		t1.start();t2.start();

	}

}

class EvenOddPrinter implements Runnable{

	Integer i=1;

	public synchronized void printEven() throws InterruptedException {
			if((i&1)==1) 
				wait();

			System.out.println(Thread.currentThread().getName()+" : "+i);
			i=i+1;
			Thread.sleep(200);
			notify();
	}

	public synchronized void printOdd() throws InterruptedException {
			if((i&1)==0) 
				wait();

			System.out.println(Thread.currentThread().getName()+" : "+i);
			i=i+1;
			Thread.sleep(200);
			notify();

	}

	@Override
	public void run() {
		try {
			while(i<=10) {
				if(Thread.currentThread().getName().equalsIgnoreCase("even")) {
					printEven();
				}else {
					printOdd();
				}
			}
		}catch(Exception e) {
			System.out.println("Exception"+ e);
		}


	}

}
