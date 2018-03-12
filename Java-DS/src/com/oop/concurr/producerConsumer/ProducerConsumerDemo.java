package com.oop.concurr.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//credits: cave of programming
public class ProducerConsumerDemo {

	
	private static BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10); 
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread prod = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread cons = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					consumer();
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
	
	
	public static void producer() throws InterruptedException{
		Random random = new Random();
		while (true) {
			bq.put(random.nextInt(100));
		}
	}
	
	public static void consumer() throws InterruptedException{
		Random random = new Random();
		
		while (true) {
			Thread.sleep(100);
			if(random.nextInt(10) == 0){
				Integer val = bq.take();  //unlike poll, take methods waits until item is available
				
				System.out.println("Taken val: "+val+"\t Q size is: "+bq.size());
			}
		}
	}
	
}
