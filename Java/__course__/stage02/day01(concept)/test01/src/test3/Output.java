/*
 * �Ӽ��������Լ������������䲢��ӡ����
 */

package test3;

import java.util.Scanner;

public class Output {
	public static void main(String[] args) {
		String name = null;  //��������
		int age = 0;  //��������
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("���������֣�");
		name = in.nextLine();
		
		System.out.print("���������䣺");
		age = in.nextInt();
		
		in.close();
		
		//������ֺ�����
		System.out.println("���֣�" + name + ", ���䣺" + age);
	}
}
