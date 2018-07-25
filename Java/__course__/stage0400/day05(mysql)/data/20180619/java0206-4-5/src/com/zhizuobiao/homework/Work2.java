package com.zhizuobiao.homework;

public class Work2 {

	// 编一个程序，
	// 实现两个线程 A 和 B 同时启动，
	// A线程每隔5秒显示字符串”AAA”，
	// B线程每隔1秒显示字符‘BBB’。
	public static void main(String[] args) {
		Thread aThread = new Thread(new Runnable() {

			@Override
			public void run() {

				while (true) {
					System.out.println("AAA");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread bThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("BBB");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		aThread.start();
		bThread.start();
	}
}
