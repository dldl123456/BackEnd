/*
 *  �Զ���װ��
 */

package video.note.autoBoxDemo;

public class AutoBoxDemo {
	public static void main(String[] args) {
		int i = 10;
		double d = 10.5;
		
		//�ѻ������͸�ֵ���������ͣ��������ͻ��ڱ����ʱ���Զ�װ��
		Integer num1 = i;  //��װ��
		Double num2 = d;
		
		System.out.println(num1);  //num1.intValue();
		System.out.println(num2);  //num2.doubleValue();
		
		//�Ѱ�װ��(��������)��ֵ���������ͣ����Զ�������
		int j = num1;  //int j = num1.intValue();
		double dd = num2;  //double dd = num2.doubleValue();
		
		System.out.println(j);
		System.out.println(dd);
		
		//�����������ã��Ȱ��Լ�����(��װ)Ϊ��֮��Ӧ�������������ͻ��߰�װ��
		Object o = i;  //Object o = new Integer(i);
		//�Զ���װ����֮��Ӧ�İ�װ��
		//oָ���˸�������ñ�������������ñ�����������Ķ���
		Integer b = (Integer)o;
		System.out.println(b);
		System.out.println(o);
	}
}
