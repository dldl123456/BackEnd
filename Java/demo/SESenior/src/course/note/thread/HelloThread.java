package course.note.thread;

/**
 * 
 * 实现线程方式一：
 * 1.继承Thread类
 * 2.覆写run方法
 * 3.线程中执行的代码，写在run方法里
 *
 */

public class HelloThread extends Thread {  //线程类
	
	@Override
	public void run() {
		
		String ThreadName = Thread.currentThread().getName();
		
		for(int i=1; i<=10; i++){
			try {
				//放里面表示一秒钟执行一次
				Thread.sleep(1000);  //自动醒
				//wait();  //所有对象都有wait方法（等待，（不占cpu）需要notify唤醒）
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(ThreadName + " for i=" + i);
		}
		
		//放外面就是指一秒钟之后全部执行
		/*String ThreadName = Thread.currentThread().getName();
		for(int i=1; i<=10; i++){
			System.out.println(ThreadName + " for i=" + i);
		}*/
	}
	
}
