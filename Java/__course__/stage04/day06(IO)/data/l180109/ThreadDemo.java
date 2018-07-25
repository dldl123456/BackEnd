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
		
		ThreadDemo td = new ThreadDemo("我的线程");
		td.setName("线程1");
		td.start(); //启动线程
		System.out.println(td.getName());
		//td.run(); //普通方法调用
		
		ThreadDemo td2 = new ThreadDemo("我的线程");
		td2.setName("线程2");
		td2.start(); //启动线程
		
		ThreadDemo td3 = new ThreadDemo("我的线程");
		td3.setName("线程3");
		td3.start(); //启动线程
	}
	
}
