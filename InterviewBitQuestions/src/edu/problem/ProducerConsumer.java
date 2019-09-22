package edu.problem;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		List<Integer> l=new ArrayList<>();
		Producer p=new Producer(l);
		Consumer c=new Consumer(l);
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		t2.start();
		t1.start();
		
	}

}

class Producer implements Runnable{
	List<Integer> l;
	public Producer(List<Integer> list) {
		this.l=list;
	}
	
	@Override
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void produce() throws InterruptedException {
		int i=10;
		while(i>0) {
			synchronized (l) {
				if(l.size()>=1)
					l.wait();
				l.add(1);
				System.out.println("Produced: "+l.get(0));
				l.notify();
			}
			i--;
		}
	}
}

class Consumer implements Runnable{
	List<Integer> l;
	public Consumer(List<Integer> list) {
		this.l=list;
	}

	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void consume() throws InterruptedException {
		int i=10;
		while(i>0){
			synchronized (l) {
				if(l.isEmpty()) {
					l.wait();
				}
				System.out.println("Consumed: "+l.remove(0));
				Thread.sleep(200);
				l.notify();
			}
			i--;
		}

	}
}
