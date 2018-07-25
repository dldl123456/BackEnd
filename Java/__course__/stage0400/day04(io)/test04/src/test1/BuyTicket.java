package test1;

/**
 * 用接口实现多线程
 */

public class BuyTicket implements Runnable {
	
	private int ticket = 100;  //票数

	@Override
	public void run() {
		while(true){
			synchronized(this) {  //同步锁
				if(ticket>0){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "----" + ticket);
					ticket--;
				} else if(ticket==0) {
					break;
				}
			}
		}
	}
}
