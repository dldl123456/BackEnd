/*
 *  �Ӽ�������������������������������� 
 */

package classic.choosing.compare;

import java.util.Scanner;

public class Compare_2 {
	public static void main(String[] args) {
		System.out.println("������������������");
		
		int num1 = 0,  //����������num1
			num2 = 0,  //����������num2
			num3 = 0;  //����������num3
				
		int max = 0;  //���������������е����ֵ
				
		//����������������
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		num3 = in.nextInt();
		in.close();
			
		//�����ֵ
		max = (num1>num2?(num1>num3?num1:num3):(num2>num3?num2:num3));
		
		//������ֵ
		System.out.println(num1 + "," + num2 + "," + num3 + "�����ֵΪ��" + max);
	}
}
