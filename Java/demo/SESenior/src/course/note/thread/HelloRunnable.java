package course.note.thread;

/**
 *
 * 线程实现方法二：
 * 1.实现Runnable接口
 * 2.覆写run方法
 * 3.启动方式，调用Thread类中的start方法
 *
 */

public class HelloRunnable implements Runnable {

	@Override
	public void run() {
		
		int count = 0;
		//线程执行逻辑
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("计数：" + count++);
		}
	}

}
