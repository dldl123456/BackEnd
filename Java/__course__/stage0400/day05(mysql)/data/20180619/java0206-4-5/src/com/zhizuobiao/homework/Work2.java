package com.zhizuobiao.homework;

public class Work2 {

	// ��һ������
	// ʵ�������߳� A �� B ͬʱ������
	// A�߳�ÿ��5����ʾ�ַ�����AAA����
	// B�߳�ÿ��1����ʾ�ַ���BBB����
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
