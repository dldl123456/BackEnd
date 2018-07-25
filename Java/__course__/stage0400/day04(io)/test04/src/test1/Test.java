/*
	编写代码实现线程同步，保护资源 【两个线程同时买票，1-100张票】
 */

package test1;

public class Test {
	public static void main(String[] args) {
		BuyTicket buyticket = new BuyTicket();
		new Thread(buyticket, "窗口1").start();
		new Thread(buyticket, "窗口2").start();
	}
}
