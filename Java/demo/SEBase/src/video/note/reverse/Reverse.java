/*
 *  ����һ�����������������������
 */

package video.note.reverse;

import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		System.out.print("������һ����������");
		
		int num = 0;  //���������û������������
		int res = 0;  //����������������Ľ��
		
		//����
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		in.close();
		
		//�������
		System.out.print("�����������������Ϊ��");
		while(num!=0){
			res = num % 10;
			System.out.print(res);
			num /= 10;
		}
		
	}
}
