package edu.problem.thrreads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		Producer p=new Producer(list);
		Consumer c=new Consumer(list);
		Thread produce=new Thread(p);
		Thread consumer=new Thread(c);
		produce.start();consumer.start();

	}

}

class Producer implements Runnable{

	private List<Integer> list;
	
	public Producer(List<Integer> list) {
		this.list=list;
	}
	
	public void produce() throws InterruptedException {
		int i=1;
		while(i<10) {
			synchronized (list) {
				if(list.size()>=1)
					list.wait();
				list.add(i);
				System.out.println("Produce: "+list.get(0));
				
				i++;
				Thread.sleep(200);
				list.notify();
			}
		}
	}
	
	@Override
	public void run() {
		try {
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

class Consumer implements Runnable{

private List<Integer> list;
	
	public Consumer(List<Integer> list) {
		this.list=list;
	}
	
	public void consume() throws InterruptedException {
		int i=1;
		while(i<10) {
			synchronized (list) {
				if(list.isEmpty())
					list.wait();
				System.out.println("Consume: "+list.get(0));
				list.remove(0);
				i++;
				Thread.sleep(200);
				list.notify();
			}
		}
	}
	
	@Override
	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
