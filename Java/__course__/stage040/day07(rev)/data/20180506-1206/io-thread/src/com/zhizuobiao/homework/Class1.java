package com.zhizuobiao.homework;

// 1.��һ������ʵ�������߳� A �� B ��A �� B ͬʱ������ 
// A�߳�ÿ��5����ʾ�ַ�����AAA����B�߳�ÿ�� 1����ʾ�ַ���B����

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

			// 5��
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
			// 1��
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}