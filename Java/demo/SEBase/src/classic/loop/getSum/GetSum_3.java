/*
 *  �Ӽ�������һ��������n����1+2+3+...+n֮�Ͳ������
 */

package classic.loop.getSum;

import java.util.Scanner;

public class GetSum_3 {
	public static void main(String[] args) {
		System.out.print("������һ����������");
		
		int num = 0;  //���������û������������
		int sum = 0;  //����������͵Ľ��
		
		//����
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		in.close();
		
		//���
		for(int i=1; i<=num; i++){
			System.out.print(i > 1 ? " + " + i : i);
			sum += i;
		}
		
		//���
		System.out.println(" = " + sum);
	}
}
