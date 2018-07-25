package course.note.thread;

/**
 * 
 * 卖票例子
 * 多个线程运行可能会出现共享数据的问题
 *
 */

public class Ticket2 implements Runnable {
	
	private int total = 100;
	
	public Ticket2() {}

	@Override
	public void run() {
		//循环要放外面
		while(total > 0) {
			boolean none = ticket();
			
			if(!none){
				break;
			}
		}
	}
	
	//同步方法块(默认用this)
	private synchronized boolean ticket(){
		//判断
		if(total <= 0){
			return false;
		}
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + "正在卖票，当前票号" + total + "，剩余" + total + "张票");
		total--;
		
		return true;
	}
	
	//静态的同步方法 -- Class对象
	@SuppressWarnings("unused")
	private static synchronized void testLock(){}
}
