/*
 *  �Ӽ�������һ���������������׳˲������
 */

package classic.loop.factorial;

import java.util.Scanner;

public class Factorial_2 {
	public static void main(String[] args) {
		System.out.print("������һ����������");
		
		int n = 0;  //���������û������������
		int res = 1;  //�����������Ľ��
		
		//����
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		in.close();
		
		//������
		for(int i=1; i<=n; i++){
			System.out.print(i > 1 ? " * " + i : i);
			res *= i;
		}
		
		//���
		System.out.println(" = " + res);
	}
}
