/*
	��һ������ʵ�������߳� A �� B ��A �� B ͬʱ������A�߳�ÿ��5����ʾ�ַ�����AAA����B�߳�ÿ�� 1����ʾ�ַ���B����
 */

package test2;

public class Test {
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		//ʵ�����߳������
		PrintA Pa = new PrintA();
		PrintB Pb = new PrintB();
		
		//�����̲߳�����
		new Thread(Pa, "PrintA").start();
		new Thread(Pb, "PrintB").start();
	}
}