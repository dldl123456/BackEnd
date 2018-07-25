package com.zhizuobiao.homework;

// 1.编一个程序，实现两个线程 A 和 B ，A 和 B 同时启动， 
// A线程每隔5秒显示字符串”AAA”，B线程每隔 1秒显示字符‘B’。

public class Class1 {

	public static void main(String[] args) {

		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();

		threadA.start();
		threadB.start();
	}
	
	Runnable rA = new Runnable() {
		
		@Override
		public void run() {
			
		}
	};
	
	Runnable rB = new Runnable() {
		
		@Override
		public void run() {
			
		}
	};
}

class ThreadA extends Thread {

	@Override
	public void run() {

		while (true) {
			System.out.println("A");

			// 5秒
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class ThreadB extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("B");
			// 1秒
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}