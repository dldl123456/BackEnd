package course.note.thread;

/**
 * 
 * 卖票例子
 * 多个线程运行可能会出现共享数据的问题
 *
 */

public class Ticket implements Runnable {
	
	private int total = 100;
	
	public Ticket() {}

	@Override
	public void run() {
		/*// thread[0, 1, 2, 3, 4]
		synchronized (this) {  //任何对象都可以，这个对象就是锁（this表示当前类的实例）（对象被多个线程共享，不论有多少个线程，针对括号中的对象，是同一个）
			//变成了单线程
			// thread[0]执行，把门关了，谁也进不来
			while(total > 0) {
				System.out.println(Thread.currentThread().getName() + "正在卖票，当前票号" + total + "，剩余" + total + "张票");
				total--;
			}
			//thread[0]执行结束
		}
		//thread[0]线程结束，把门打开了，其他可以进来，total=0*/
		
		//循环要放外面
		while(total > 0) {
			// 同步代码块
			synchronized (this) {
				if(total <= 0){
					break;
				}
				
				try {
					Thread.sleep(50);  //不释放锁，wait释放
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + "正在卖票，当前票号" + total + "，剩余" + total + "张票");
				total--;
			}
		}
	}
}
