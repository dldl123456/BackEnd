package com.zhizuobiao.thread;

public class TicketTest {

	public static void main(String[] args) {
		
		
		Ticket2 ticket = new Ticket2();
		
		// 创建5个线程
		Thread t1 = new Thread(ticket);
		Thread t2 = new Thread(ticket);
		Thread t3 = new Thread(ticket);
		Thread t4 = new Thread(ticket);
		Thread t5 = new Thread(ticket);
		
		// 开启线程执行
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
