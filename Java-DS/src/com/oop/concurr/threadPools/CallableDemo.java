package com.oop.concurr.threadPools;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// callable is used to return some data from current thread
//returned value collected in future
public class CallableDemo {

	
	public static void main(String[] args) {
		
		ExecutorService executor =  Executors.newCachedThreadPool();
		
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				
				Random random = new Random();
				int duration = random.nextInt(4000);
				System.out.println("Starting...");
				
				Thread.sleep(duration);
				
				System.out.println("Finished ...");
				return duration;
			}
		});
		
		executor.shutdown();
		try {
			System.out.println("Result is: "+future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}
