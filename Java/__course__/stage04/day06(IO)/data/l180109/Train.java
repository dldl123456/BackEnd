package com.lesson.phase4.l0907.l180109;

public class Train implements Runnable {

	@Override
	public void run() {
		synchronized(this){
			System.out.println(Thread.currentThread().getName() +" 进山洞了。。。。。");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +" 开走了。。。。。");
		}
	}
	
	
	public static void main(String[] args) {
		
		Train train = new Train();
		new Thread(train,"火车1").start();
		new Thread(train,"火车2").start();
		new Thread(train,"火车3").start();
		new Thread(train,"火车4").start();
		new Thread(train,"火车5").start();
		
		
	}
	

}
