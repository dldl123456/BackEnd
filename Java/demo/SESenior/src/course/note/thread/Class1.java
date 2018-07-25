package course.note.thread;

/**
 * 
 * java线程Thread
 *
 */

public class Class1 {
	/*
	 *  线程的生命周期
	 	创建 -- 就绪 -- 执行 -- 销毁
					      -- 睡眠 -- 执行 -- 销毁
	    				  -- 阻塞 -- 唤醒 -- 就绪 -- 执行 -- 销毁
	 
	 */
	/**
	 * test
	 * @param args
	 */
	//主函数入口
	public static void main(String[] args) {
		//demo1();
		
		//调用线程
		//demo2();
		
		demo3();
		System.out.println("main线程结束");
	}
	
	//当前线程的名字
	public static void demo1(){
		System.out.println(Thread.currentThread().getName());
	}
	
	//启动线程类
	public static void demo2(){
		//如果用循环（n）包住下面两句话，就会开n个线程
		//一个对象一个star方法
		HelloThread ht = new HelloThread();
		ht.start();  //启动线程,java线程自动执行run方法
		
		//主线程（主函数同名的线程main线程）
		String ThreadName = Thread.currentThread().getName();
		for(int i=50; i<=60; i++){
			System.out.println(ThreadName + " for i=" + i);
		}
	}
	
	//启动线程接口
	public static void demo3(){
		Thread thread = new Thread(new HelloRunnable());
		thread.start();
		
		//主线程（主函数同名的线程main线程）
		String ThreadName = Thread.currentThread().getName();
		for(int i=100; i>=80; i--){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ThreadName + "：" + i);
		}
	}
}
