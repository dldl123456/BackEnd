package com.zhizuobiao.thread;

// * 实现线程方式一：
// * 1. 继承Thread类
// * 2. 覆写run方法
// * 3. 线程中执行的代码，写在run方法里面

public class HelloThread extends Thread { // 线程类

	// java 单继承，多实现 
	
	@Override
	public void run() {

		Object object;
		
		String threadName = Thread.currentThread().getName();
		for (int i = 0; i < 10; i++) {
			
			try {
				Thread.sleep(1000); // 会自动醒过来
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(threadName + " for i=" + i);
		}
	}
}
