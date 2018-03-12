package com.oop.concurr.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

//credits cave of programming
class Processor {

	private Queue<Integer> q = new LinkedList<>();

	private final int LIMIT = 10;

	private Object lock = new Object();

	public void produce() throws InterruptedException {

		Random random = new Random();

		while (true) {
			synchronized (lock) {

				while (q.size() == LIMIT) {
					lock.wait();
				}

				q.add(random.nextInt(100));
			}
		}
	}

	public void consume() throws InterruptedException {
		Random random = new Random();
		while (true) {
			synchronized (lock) {
				
				while (q.size() == 0) {
					lock.wait();
				}
				
				System.out.print("Q size is: "+q.size());
				int val = q.remove();
				System.out.println("; taken value is: "+val);
				lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}

	}

}

public class ProdConsWaitNotifyDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		Processor processor = new Processor();
		
		Thread prod = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread cons = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		prod.start();
		cons.start();
		
		//wait for threads to die
		prod.join();
		cons.join();
	
		
	}
	
}
