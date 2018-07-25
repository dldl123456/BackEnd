package course.note.thread;

public class TicketTest {
	public static void main(String[] args) {
		Ticket2 ticket = new Ticket2();
		
		// 创建5个线程，并开启线程
		new Thread(ticket, "窗口1").start();
		new Thread(ticket, "窗口2").start();
		new Thread(ticket, "窗口3").start();
		new Thread(ticket, "窗口4").start();
		new Thread(ticket, "窗口5").start();
	}
}
