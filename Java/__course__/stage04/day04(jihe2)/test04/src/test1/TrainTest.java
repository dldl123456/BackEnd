/**
 *   ��5����Ҫ��ɽ��,��ȷ��ɽ��ͬʱֻ����һ����ͨ������ɽ����Ҫ2�룩����ӡ�����ͨ����˳��
 *   ����ɽ����˳���ǲ��ɿصģ�ֻҪ��֤ͬһʱ��ֻ��һ������ͨ��ɽ�����ɣ�
 *   ��ʾ��ʹ���߳�ͬ�� 
 */

package test1;

public class TrainTest {
	public static void main(String[] args) {
		//����һ���ӿڵ�ʵ�������
		Train train = new Train();
		
		//�����߳������
		Thread t1 = new Thread(train, "��һ����");
		Thread t2 = new Thread(train, "�ڶ�����");
		Thread t3 = new Thread(train, "��������");
		Thread t4 = new Thread(train, "��������");
		Thread t5 = new Thread(train, "��������");
		
		//�����߳�
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}