/*
 * ����3����������3�������ĺ͡����ֵ��ƽ��ֵ
 */

package test1;

import java.util.Scanner;

public class Evaluation {
	public static void main(String[] args) {
		int num1 = 0,  //����������num1
			num2 = 0,  //����������num2
			num3 = 0;  //����������num3
		
		int sum = 0,  //����������������֮��
			max = 0;  //���������������е����ֵ
		double average = 0.0;  ////������������������ƽ����
		
		System.out.print("������3���������ÿո������");
		
		//����������������
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		num3 = in.nextInt();
		in.close();
		
		sum = num1 + num2 + num3;  //���
		max = (num1>num2?(num1>num3?num1:num3):(num2>num3?num2:num3));  //�����ֵ
		
		//��ƽ����������������ȡ��λ��Ч����
		average = Math.round((double)sum/3*100)*0.01;
		
		/*double averageResult = (double)sum / 3;
		String average = String.format("%.2f", averageResult);*/
		
		//����������������ĺ͡����ֵ��ƽ��ֵ
		System.out.println("num1��num2��num3���Ϊ��" + sum);
		System.out.println("num1��num2��num3ƽ����Ϊ��" + average);
		System.out.println("num1��num2��num3�����ֵΪ��" + max);
	}
}
