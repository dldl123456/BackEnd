/*
 *  �Ӽ���������������Ȼ����������� 
 */

package classic.choosing.ascending;

import java.util.Scanner;

public class Ascending {
	public static void main(String[] args) {
		System.out.print("�������������������ÿո������");
		
		int num1 = 0,  //��������һ��������
			num2 = 0;  //��������һ��������
		
		//��������������
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		in.close();
		
		//�Ƚϴ�С���������
		if(num1<num2){
			System.out.println("�������Ϊ��\n" + num1 + "," +num2);
		} else {
			System.out.println("�������Ϊ��\n" + num2 + "," +num1);
		}
	}
}
