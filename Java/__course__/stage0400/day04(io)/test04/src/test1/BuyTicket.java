package test1;

/**
 * �ýӿ�ʵ�ֶ��߳�
 */

public class BuyTicket implements Runnable {
	
	private int ticket = 100;  //Ʊ��

	@Override
	public void run() {
		while(true){
			synchronized(this) {  //ͬ����
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
