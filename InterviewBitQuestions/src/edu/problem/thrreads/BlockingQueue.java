package edu.problem.thrreads;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	List queue=new LinkedList<>();
	int limit;
	
	public BlockingQueue(int limit) {
		this.limit=limit;
	}
	
	public synchronized void enqueue(Object item) throws InterruptedException {
		while(queue.size()==this.limit) {
			wait();
		}
		if(queue.isEmpty()) {
			notifyAll();
		}
		queue.add(item);
	}
	
	public synchronized Object dequeue() throws InterruptedException {
		while(queue.isEmpty()) {
			wait();
		}
		if(queue.size()==limit) {
			notifyAll();
		}
		return queue.remove(0);
	}
}
