package com.lesson.phase4.l0907.l180109;

public class Train implements Runnable {

	@Override
	public void run() {
		synchronized(this){
			System.out.println(Thread.currentThread().getName() +" ��ɽ���ˡ���������");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +" �����ˡ���������");
		}
	}
	
	
	public static void main(String[] args) {
		
		Train train = new Train();
		new Thread(train,"��1").start();
		new Thread(train,"��2").start();
		new Thread(train,"��3").start();
		new Thread(train,"��4").start();
		new Thread(train,"��5").start();
		
		
	}
	

}
