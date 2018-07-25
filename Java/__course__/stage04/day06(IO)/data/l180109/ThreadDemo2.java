package com.lesson.phase4.l0907.l180109;

public class ThreadDemo2 implements Runnable {

	private int num =1;
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" thread..........."+(num++));
	}
	
	
	public static void main(String[] args) {
		ThreadDemo2 td = new ThreadDemo2();
		
		Thread t = new Thread(td);
		t.start();
		System.out.println(t.getName());
		
		Thread t2 = new Thread(td);
		t2.start();
		
		Thread t3 = new Thread(td);
		t3.start();
		
		t.start();
		
	}

}
