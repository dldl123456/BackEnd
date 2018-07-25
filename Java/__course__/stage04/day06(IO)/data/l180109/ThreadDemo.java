package com.lesson.phase4.l0907.l180109;

public class ThreadDemo extends Thread {


	private int num =1;
	
	public ThreadDemo(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() +" thread........."+(num++));
	}
	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() +" thread.........");
		
		ThreadDemo td = new ThreadDemo("�ҵ��߳�");
		td.setName("�߳�1");
		td.start(); //�����߳�
		System.out.println(td.getName());
		//td.run(); //��ͨ��������
		
		ThreadDemo td2 = new ThreadDemo("�ҵ��߳�");
		td2.setName("�߳�2");
		td2.start(); //�����߳�
		
		ThreadDemo td3 = new ThreadDemo("�ҵ��߳�");
		td3.setName("�߳�3");
		td3.start(); //�����߳�
	}
	
}
