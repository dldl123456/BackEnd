/*
 * �Ӽ������������������ֱ������Ͳ����
 */

package test2;

import java.util.Scanner;

public class Calculation {
	public static void main(String[] args) {
		int num1 = 0,  //����������num1
			num2 = 0;  //����������num2
		
		int sum = 0,  //��������������֮��
			diff = 0,  //��������������֮��
			product = 0;  //��������������֮��
		
		double quotient = 0.0;  //��������������֮��
		
		System.out.print("������2���������ÿո������");
		
		//����������������
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		in.close();
		
		sum = num1 + num2;  //���
		diff = num1 - num2;  //���
		product = num1 * num2;  //���
		
		//���̲���������ȡ��λ��Ч��Ч����
		quotient = Math.round((double)num1/num2*100)*0.01;
		
		/*double quotientResult= (double)num1 / num2; 
		String quotient = String.format("%.2f", quotientResult);*/
		
		//����������������ĺͲ���̵Ľ��
		System.out.println("num1��num2��������֮��ĺ�Ϊ��" + sum);
		System.out.println("num1��num2��������֮��Ĳ�Ϊ��" + diff);
		System.out.println("num1��num2��������֮��Ļ�Ϊ��" + product);
		System.out.println("num1��num2��������֮�����Ϊ��" + quotient);
	}
}
