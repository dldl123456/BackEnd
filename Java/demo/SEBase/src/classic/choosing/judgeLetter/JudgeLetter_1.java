/*
 *  �Ӽ�������һ���ַ�����ΪСд��ĸ����ת��Ϊ��д��ĸ�����򱣳ֲ��䡣
 */

package classic.choosing.judgeLetter;

import java.util.Scanner;

public class JudgeLetter_1 {
	public static void main(String[] args) {
		System.out.print("����������һ����ĸ��");
		char ch = 0;  //��������һ��������ĸ
		
		//����һ��������ĸ
		Scanner in = new Scanner(System.in);
		ch = in.next().charAt(0);
		in.close();
		
		//�жϸ���ĸ�Ĵ�Сд�������������
		if(Character.isUpperCase(ch)){
			System.out.println("����ĸΪ��д������ĸΪ��" + ch);
		} else {
			System.out.println("����ĸΪСд");
			System.out.println("����ĸ�Ĵ�дΪ��" + (ch -= 32));
		}
	}
}
