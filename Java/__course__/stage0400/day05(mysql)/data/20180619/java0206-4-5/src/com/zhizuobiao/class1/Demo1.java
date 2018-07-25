package com.zhizuobiao.class1;

/**
 * 线程同步
 */
public class Demo1 {

	// (Demo1.class) 是关键，如何判断和选择？
	// 对于线程而言（执行同一方法或代码的线程），相同的对象，才能同步。

	public static void main(String[] args) throws ClassNotFoundException {

		// Class.forName("");

		// 两种方式同步
		// 1、同步代码块
		synchronized (Demo1.class) {

		}

		StringBuffer buffer = null; // 安全
		StringBuilder builder = null; // 不安全
	}

	// 2、同步方法
	public synchronized void play() { // 锁=this

	}
}
