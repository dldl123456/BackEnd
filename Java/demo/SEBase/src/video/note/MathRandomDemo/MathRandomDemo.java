package video.note.MathRandomDemo;

import java.util.Random;

public class MathRandomDemo {
	public static void main(String[] args) {
		//Math
		System.out.println(Math.floor(10.55));  //��������doubleֵ����ֵС�ڵ��ڲ�����������ĳ������
		System.out.println(Math.ceil(-10.55));  //����ȡ��(������ĵ�һ����������ת����double����)
		System.out.println(Math.pow(2, 3));  //2��3�η�
		System.out.println(Math.round(10.6));  //��������
		System.out.println(Math.random());  //0-1֮��������
		
		//Random
		Random random1 = new Random();
		System.out.println(random1.nextInt());  //��������������ȡ�����
		
		Random random2 = new Random(10);  //Random(10)��10�����ӣ�����ÿ�ν����һ��
		System.out.println(random2.nextInt());
		
		Random random3 = new Random(System.currentTimeMillis());  //�����Ǻ������Ļ���Ҳ��һ������������ʱ�ڱ�
		System.out.println(random3.nextInt());  //��������������ȡ�����
		
		Random random4 = new Random();
		System.out.println(random4.nextInt(5));  //��0-4֮����������
		
		Random random5 = new Random();
		System.out.println(random5.nextBoolean());  //true��false���
		
		Random random6 = new Random();
		System.out.println(random6.nextFloat());
		System.out.println(random6.nextDouble());
	}
}
