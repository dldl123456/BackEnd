package com.zhizuobiao;

public class Test {

	public static void main(String[] args) {
		Object o2 = new Object();
		MyThread my = new MyThread(o2);
		MyThread2 my2 = new MyThread2(o2);

		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		Thread t3 = new Thread(my);
		Thread t4 = new Thread(my);
		Thread t5 = new Thread(my);

		Thread t11 = new Thread(my2);
		Thread t22 = new Thread(my2);

		t1.start();
		// t2.start();
		// t3.start();
		// t4.start();
		// t5.start();

		t11.start();
		// t22.start();

	}
}

class MyThread2 implements Runnable {
	private Object o2;

	public MyThread2(Object o2) {
		this.o2 = o2;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (o2) {

			System.out.println("MyThread2 run 3000");

		}

	}
}

class MyThread implements Runnable {

	private Object o1 = new Object();
	private Object o2;

	public MyThread(Object o2) {
		this.o2 = o2;
	}

	@Override
	public void run() {

		synchronized (o1) {

			System.out.println(Thread.currentThread().getName() + " : o1");

			synchronized (o2) {

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + " : o2");
			}

		} // o1  Õ∑≈À¯
	}

}
