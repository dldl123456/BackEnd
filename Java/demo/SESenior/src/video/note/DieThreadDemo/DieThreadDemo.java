package video.note.DieThreadDemo;

public class DieThreadDemo {
	public static void main(String[] args) {
		Example explame = new Example();
		
		DieThread1 t1 = new DieThread1(explame);
		t1.start();
		
		DieThread2 t2 = new DieThread2(explame);
		t2.start();
	}
}

//创建2个线程类
class DieThread1 extends Thread{
	private Example explame = null;
	
	public DieThread1(Example explame) {
		this.explame = explame;
	}

	@Override
	public void run() {
		explame.method1();
	}
}

//
class DieThread2 extends Thread{
	private Example explame = null;
	
	public DieThread2(Example explame) {
		this.explame = explame;
	}

	@Override
	public void run() {
		explame.method2();
	}
}

class Example{
	private Object obj1 = new Object();
	private Object obj2 = new Object();
	
	//
	public void method1(){
		//获取对象1的锁
		synchronized(obj1){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//获取对象2的锁
		synchronized(obj2){
			System.out.println("method1");
		}
	}
	
	public void method2(){
		//获取对象2的锁
		synchronized(obj2){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//获取对象1的锁
		synchronized(obj1){
			System.out.println("method2");
		}
	}
}
