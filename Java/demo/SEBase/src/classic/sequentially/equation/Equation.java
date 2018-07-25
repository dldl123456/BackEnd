/*
 *  ��һԪ���η��̵�ʵ������ 
 */

package classic.sequentially.equation;

import java.util.Scanner;

public class Equation {
	public static void main(String[] args) {
		System.out.println("***** ��һԪ���η��̵�ʵ���� *****");
		float a = (float)0.0,  //�������������ϵ��
			  b = (float)0.0,  //��������һ����ϵ��
			  c = (float)0.0;  //�������泣����
		
		float delta = (float)0.0;  //�����жϸ�һԪ���η��̵�ʵ�����ĸ���
		
		@SuppressWarnings("unused")
		float x = (float)0.0,	//�������淽�̵�ʵ����
			  x1 = (float)0.0,	//�������淽�̵�ʵ����
			  x2 = (float)0.0;	//�������淽�̵�ʵ����
		
		//����һԪ���η��̵�����ϵ��
		Scanner in = new Scanner(System.in);
		
		//����һ��������ϵ��
		System.out.print("�����������ϵ��(������ϵ������0)��");
		a = in.nextFloat();
		
		//�ж�����Ķ�����ϵ���Ƿ���ȷ
		while(a<0){
			System.out.println("������ϵ��Ӧ����0�����������룺");
			a = in.nextFloat();
		}
		
		//����һ��һ����ϵ��
		System.out.print("������һ����ϵ����");
		b = in.nextFloat();
		
		//����һ��������
		System.out.print("�����볣���");
		c = in.nextFloat();
		
		//�ر�����
		in.close();
		
		//����delta��ֵ������������ȡ��λ��Ч����
		delta = (float)(Math.round((Math.pow(b,2)-4*a*c)*100)*0.01);
		
		//�жϸ��ĸ���������ֵ
		if(delta>0){
			System.out.println("�÷�������������");
			//����x1��x2��ֵ������������ȡ��λ��Ч����
			x1 = (float)(Math.round(((-b + Math.sqrt(delta))/2*a)*100)*0.01);
			x2 = (float)(Math.round(((-b - Math.sqrt(delta))/2*a)*100)*0.01);
			System.out.println("�÷��̵��������ֱ�Ϊ��" + x1 + "," + x2);
		} else if (delta==0) {
			System.out.println("�÷���ֻ��һ������");
			//����x��ֵ������������ȡ��λ��Ч����
			x = (float)(Math.round((-b/2*a)*100)*0.01);
		} else {
			System.out.println("deltaС��0���÷�����ʵ����");
		}
	}
}
