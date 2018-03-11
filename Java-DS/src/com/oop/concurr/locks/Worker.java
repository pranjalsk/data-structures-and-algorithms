package com.oop.concurr.locks;

import java.util.ArrayList;
import java.util.Random;

public class Worker {

	private static ArrayList<Integer> list1 = new ArrayList<>();
	private static ArrayList<Integer> list2 = new ArrayList<>();
	
	private static Object lock1 = new Object();
	
	static Random random = new Random();
	
	public static void stageOne(){
		
		synchronized (lock1) {

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			list1.add(random.nextInt(100));	
		}
	}
	
	
	public static synchronized void stageTwo(){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list2.add(random.nextInt(100));
	}
	
	public static void process(){
		for(int i=0;i<100;i++){
			stageOne();
			stageTwo();
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Starting...");
		long start = System.currentTimeMillis();
		
		Thread t1 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		t1.start();

		Thread t2 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				process();
			}
		});
		
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration: "+ (end-start));
		System.out.println("List1: "+list1.size());
		System.out.println("List2: "+list2.size());
		
		
	}
	
	
}
