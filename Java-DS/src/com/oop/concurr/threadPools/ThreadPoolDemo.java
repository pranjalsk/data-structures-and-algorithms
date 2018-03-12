package com.oop.concurr.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//credits: cave of programming

class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Started: " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Complted: " + id);
	}

}

public class ThreadPoolDemo {

	public static void main(String[] args) {

		// create a thread pool
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// create bunch of tasks to do
		// submit each task to executor framework
		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}

		// shoutdown executor when all task are finished
		executor.shutdown();
		System.out.println("All task submiteed");

		try {
			executor.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// we can give termination timeout -- so either all task finished or
		// time out happens, code below executes
		System.out.println("All task completed");
	}

}
