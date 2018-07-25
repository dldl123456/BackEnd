package com.zhizuobiao.thread;

/**
 * 卖票例子，同步方法
 */
public class Ticket2 implements Runnable {

	private int total = 100;

	public Ticket2() {
	}

	/**
	 * 同步代码块
	 */
	@Override
	public void run() {
		// thread[0,1,2,3,4]
		while (total > 0) { // total = 0
			// thread[0,1,2,3,4] 最后一次循环

			
			boolean none = ticket();
			
			if (!none) {
				break;
			}
			

			// while执行结束，把门打开，其他可以进来
		}
		// thread[0]线程结束
	}

	// 静态的同步方法 --> 类名.class对象
	private static synchronized void testLock() {}
	
	private synchronized boolean ticket() { // 同步方法用的是this锁

		// 判断一下
		if (total <= 0) {
			return false;
		}
		
		try {
			Thread.sleep(30); // 不释放锁，wait释放锁
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " 当前票号：" + total + "，剩余" + total + "张票");
		total--;
		
		return true;
	}

	// @Override
	// public void run() {
	// // thread[0,1,2,3,4]
	// synchronized (this) { // 任意对象都可以。这个对象就是锁。
	//
	// // thread[0] 执行，把门关了，谁也进不来
	// while (total > 0) {
	//
	// try {
	// Thread.sleep(30);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	//
	// System.out.println(Thread.currentThread().getName() + " 当前票号：" + total +
	// "，剩余" + total + "张票");
	// total--;
	// }
	// // thread[0] 执行结束，把门打开，其他可以进来，total=0
	// }
	// // thread[0]线程结束
	// }
}
