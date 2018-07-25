package video.note.ThreadDemo;

public class ThreadDemo {
	public static void main(String[] args) {
		//产生一个线程类的对象
		HelloThread h1 = new HelloThread();
		h1.start();  //启动线程
		
		//更改默认线程对象
		h1.setName("线程1");
		
		//一个线程类可以创建多个线程
		HelloThread h2 = new HelloThread();
		h2.start();  //启动线程
		
		//更改默认线程对象
		h1.setName("线程2");
		
		//创建线程并制定名字
		HelloThread h3 = new HelloThread("A");
		HelloThread h4 = new HelloThread("B");
		h3.start();
		h4.start();
		
		//线程一旦开启，很难控制，每次执行的结果不一样
	}
}

//线程类
class HelloThread extends Thread{
	public HelloThread(){
		
	}
	
	public HelloThread(String name){
		super(name);
	}
	
	//重写run方法，线程要做的具体工作
	@Override
	public void run() {
		for(int i=0; i<5; i++){
			//System.out.println(i);
			
			//打印线程名字
			System.out.println(this.getName() + ":" + i);
		}
	}
}