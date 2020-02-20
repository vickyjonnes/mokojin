package com.practice;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		Thread produce=new Thread(new Producer(list),"produce");
		Thread consume = new Thread(new Consumer(list),"consume");
		produce.start();consume.start();
	}

}

class Producer implements Runnable{

	List<Integer> list=new ArrayList<>();
	
	public Producer(List<Integer> list) {
		this.list=list;
	}
	
	public void produce() throws InterruptedException {
		int i=0;
		while(i<=10) {
			synchronized (list) {
				while(list.size()>=1)
					list.wait();
				list.add(i=i+1);
				System.out.println("Produce "+list.get(0));
				Thread.sleep(400);
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

	List<Integer> list=new ArrayList<>();
	
	public Consumer(List<Integer> list) {
		this.list=list;
	}
	
	public void consume() throws InterruptedException {
		int i=0;
		while(i<=10) {
			synchronized (list) {
				while(list.size()<1)
					list.wait();
				System.out.println("Consume : "+list.get(0));
				list.remove(list.get(0));
				i++;
				Thread.sleep(400);
				list.notify();
			}
		}
	}
	
	@Override
	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
