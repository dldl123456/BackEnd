/*
 * �Ӽ���������������������ϴ���������� 
 */

package classic.choosing.compare;

import java.util.Scanner;

public class Compare_1 {
	public static void main(String[] args) {
		int num1 = 0,  //��������һ��������
			num2 = 0;  //��������һ��������
		
		int max = 0;  //��������ϴ��������
		
		System.out.println("�������������������ÿո������");
		
		//��������������
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		in.close();
		
		//�Ƚ������������Ĵ�С
		max = num1 > num2 ? num1 : num2;
		
		//����ϴ����
		System.out.println("�ϴ����Ϊ��" + max);
	}
}
