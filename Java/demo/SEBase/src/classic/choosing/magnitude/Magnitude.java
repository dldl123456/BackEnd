/*
 *  �Ӽ�������һ��ʵ�����������ֵ������� 
 */

package classic.choosing.magnitude;

import java.util.Scanner;

public class Magnitude {
	public static void main(String[] args) {
		System.out.print("������һ������ʵ����");
		double num = 0.0;
		double numAbs = 0.0;
		
		//����һ������ʵ��
		Scanner in = new Scanner(System.in);
		num = in.nextDouble();
		in.close();
		
		//���ʵ���ľ���ֵ
		numAbs = Math.abs(num);
		
		//�����ʵ���ľ���ֵ
		System.out.println("��ʵ���ľ���ֵ�ǣ�" + numAbs);
	}
}
