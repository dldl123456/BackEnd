package com.zhizuobiao.class2;

/**
 * 线程
 */
public class Demo2 {

	public static void main(String[] args) {

		test1();
	}

 

	public static void test1() {
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
		}

		ShowTest st = new ShowTest();
		 
		// Thread start()
		Thread thread = new Thread(st);
		thread.start();
		 
	}
}

/**
 * 线程： 方式二
 */
class ShowTest implements Runnable {

	@Override
	public void run() { // 线程要具体实现的功能

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