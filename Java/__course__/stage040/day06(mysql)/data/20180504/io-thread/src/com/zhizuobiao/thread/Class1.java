package com.zhizuobiao.thread;

/**
 * java线程
 */
public class Class1 {

	// 线程生命周期
	// 创建 -- 就绪 -- 执行 -- 销毁
	// 	                  -- 睡眠 -- 执行 -- 销毁
	// 	                  -- 阻塞 -- 唤醒 -- 就绪 -- 执行 -- 销毁
 	
	// 主函数同名的线程main线程
	public static void main(String[] args) {

		// 调用线程
		// demo2();
		demo3();

		System.out.println("main线程结束");
	}

	/**
	 * Runnable接口启动线程方式
	 */
	public static void demo3() {
		Thread thread = new Thread(new HelloRunnable());
		thread.start();

		String threadName = Thread.currentThread().getName();
		for (int i = 100; i > 80; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + "：" + i);
		}
	}

	public static void demo2() {
		// 启动线程
		// 调用线程类的start方法，开启线程。java线程自动执行run方法。
		// for (int i = 0; i < 10; i++) {
		HelloThread helloThread = new HelloThread();

		helloThread.start(); // 启动，线程就开始执行
		// }
		// 注意出错的地方，切记，不要手动调用run方法。(不正确的线程开启，如下)
		// helloThread.run(); // 是普通的方法调用，不是开启线程执行。

		// main线程 执行的代码
		String threadName = Thread.currentThread().getName();
		for (int i = 50; i < 60; i++) {
			System.out.println(threadName + " for i=" + i);
		}

	}

	public static void demo1() {
		System.out.println(Thread.currentThread().getName());
	}
}
