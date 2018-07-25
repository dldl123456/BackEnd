package video.note.ThreadDemo;

public class ShareDataThreadDemo {
	public static void main(String[] args) {
		/*//创建2个线程类对象
		TicketThread s1 = new TicketThread("1号窗口");
		s1.start();
		
		TicketThread s2 = new TicketThread("2号窗口");
		s2.start();*/
		
		//创建一个接口的实现类对象(因为他只产生了一个对象，实现数据的共享)
		TicketRunnable runnable = new TicketRunnable();
		
		//产生线程类对象
		Thread t1 = new Thread(runnable, "一号窗口");
		t1.start();
		Thread t2 = new Thread(runnable, "二号窗口");
		t2.start();
	}
}

class TicketRunnable implements Runnable{
	private int ticket = 5;  //5张票
	
	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread().getName() + ":" + (ticket--));
			if(ticket<1){
				break;
			}
		}
	}
}


//不适合用继承
/*class TicketThread extends Thread{
	private int ticket = 5;
	
	public TicketThread(String name){
		super(name);
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println(this.getName() + ":" + (ticket--));
			if(ticket<1){
				break;
			}
		}
	}
}*/