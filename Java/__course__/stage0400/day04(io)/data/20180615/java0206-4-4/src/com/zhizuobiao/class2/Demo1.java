package com.zhizuobiao.class2;

/**
 * �߳�
 */
public class Demo1 {

	public static void main(String[] args) {

		test2();
	}

	public static void test2() {

		PrintTest printThread = new PrintTest();
		printThread.start();// �����߳�
		printThread.start();// �����߳�
		
//		printThread.run();
//		printThread.notify();
		

		for (int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}

	}

	public static void test1() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
		}

		for (int i = 0; i < 10000; i++) {
			System.out.println("x:" + i);
		}
	}
}

/**
 * �߳��ࣺ ��ʽһ
 */
class PrintTest extends Thread {

	@Override
	public void run() { // �߳�Ҫ����ʵ�ֵĹ���

		for (int i = 0; i < 10000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("x:" + i);
		}
	}

}