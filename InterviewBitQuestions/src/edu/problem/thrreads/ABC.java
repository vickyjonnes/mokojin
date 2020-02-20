package edu.problem.thrreads;

public class ABC {

	public static void main(String[] args) {
		ABCPrinter printer=new ABCPrinter();

		Thread t1=new Thread(printer, "A");
		Thread t2=new Thread(printer, "B");
		Thread t3=new Thread(printer, "C");
		t1.start();t2.start();t3.start();
	}

}

class ABCPrinter implements Runnable{
	String str="A";
	int i=0;
	public synchronized void printA() throws InterruptedException {
		while(str.equals("B") || str.equals("C"))
			wait();
		System.out.println("1 : "+str);
		str="B";
		Thread.sleep(300);
		notifyAll();
	}

	public synchronized void printB() throws InterruptedException {
		while(str.equals("A") || str.equals("C"))
			wait();
		System.out.println("2 : "+str);
		str="C";
		Thread.sleep(300);
		notifyAll();
	}

	public synchronized void printC() throws InterruptedException{
		while(str.equals("A") || str.equals("B"))
			wait();
		System.out.println("3 : "+str);
		str="A";
		Thread.sleep(300);
		notifyAll();
	}

	@Override
	public void run() {
		try {
			while(i<12) {
				if(Thread.currentThread().getName().equals("A"))
					printA();
				else if(Thread.currentThread().getName().equals("B"))
					printB();
				else if(Thread.currentThread().getName().equals("C"))
					printC();
				else
					throw new InterruptedException("hello");
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
