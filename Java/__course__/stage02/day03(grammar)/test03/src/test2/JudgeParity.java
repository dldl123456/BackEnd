/*
 * дһ������,�Ӽ���������0��100֮�����,�������ӡ��������������ż��.
 */

package test2;

import java.util.Scanner;

public class JudgeParity {
	public static void main(String[] args) {
		System.out.print("������һ��0��100֮���������");
		
		int num = 0;  //���������û����������
		
		//����
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		while(num<0||num>100){
			System.out.print("���������������������룺");
			num = in.nextInt();
		}
		in.close();
		
		//�ж���ż
		if(num%2==0){
			System.out.println("�����������Ϊż����");
		}else{
			System.out.println("�����������Ϊ������");
		}
	}
}
