/*
	��д����ʵ���߳�ͬ����������Դ �������߳�ͬʱ��Ʊ��1-100��Ʊ��
 */

package test1;

public class Test {
	public static void main(String[] args) {
		BuyTicket buyticket = new BuyTicket();
		new Thread(buyticket, "����1").start();
		new Thread(buyticket, "����2").start();
	}
}
