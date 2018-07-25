package com.zhizuobiao.homework;

public class Work1 {

	// 1.编写代码实现线程同步，保护资源 【两个线程同时买票，1-100张票】

	public static void main(String[] args) {

		Sale sale = new Sale(); // 线程的功能
		Thread t1 = new Thread(sale); // 线程1
		Thread t2 = new Thread(sale); // 线程2
		t1.start();
		t2.start();

	}

}

class Sale implements Runnable {

	private int total = 100;

	@Override
	public void run() {

		while (total > 0) {

			Object obj = new Object();

			// synchronized (obj) { // 同步代码块
			synchronized (this) { // 同步代码块
				if (total > 0) {
					try {
						Thread.sleep(50); // 不会释放锁

						wait(); // 会释放锁，其他线程可以进入
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName() + " | 当前票号：" + total);
					total--;
				}
			}

			System.out.println("剩余：" + total + "张票");
		}
	}
}