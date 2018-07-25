package com.zhizuobiao.homework;

public class Work1 {

	// 1.��д����ʵ���߳�ͬ����������Դ �������߳�ͬʱ��Ʊ��1-100��Ʊ��

	public static void main(String[] args) {

		Sale sale = new Sale(); // �̵߳Ĺ���
		Thread t1 = new Thread(sale); // �߳�1
		Thread t2 = new Thread(sale); // �߳�2
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

			// synchronized (obj) { // ͬ�������
			synchronized (this) { // ͬ�������
				if (total > 0) {
					try {
						Thread.sleep(50); // �����ͷ���

						wait(); // ���ͷ����������߳̿��Խ���
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(Thread.currentThread().getName() + " | ��ǰƱ�ţ�" + total);
					total--;
				}
			}

			System.out.println("ʣ�ࣺ" + total + "��Ʊ");
		}
	}
}