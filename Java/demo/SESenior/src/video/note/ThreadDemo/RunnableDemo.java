package video.note.ThreadDemo;

public class RunnableDemo {
	public static void main(String[] args) {
		//创建实现接口的实现类
		HelloRunnable h1 = new HelloRunnable();
		
		//产生一个线程类对象
		Thread t1 = new Thread(h1);
		
		//开启线程
		t1.start();
		
		//修改线程名
		Thread t2 = new Thread(h1, "A");
		t2.start();
		
		Thread t3 = new Thread(h1, "B");
		t3.start();
		
	}
}

//用接口避免单继承的局限
//一个类可以实现多个接口，但只能继承一个类
//适合资源的共享

//线程类
class HelloRunnable implements Runnable {
	//重写run方法，线程要做的具体工作
	@Override
	public void run() {
		for(int i=0; i<5; i++){
			//获取当前线程对象的引用，再获取当前线程对象的名字
			System.out.println(Thread.currentThread().getName() + "--" + i);
		}
	}
}