/*
 *  �Ӽ�������һ���ַ�����ΪСд��ĸ����ת��Ϊ��д��ĸ;��Ϊ��д��ĸ����ת��ΪСд��ĸ;����ת��ΪASCII����е���һ���ַ���
 */

package classic.choosing.judgeLetter;

import java.util.Scanner;

public class JudgeLetter_3 {
	public static void main(String[] args) {
		System.out.print("������һ���ַ���");
		
		char ch = 0;  //��������һ���ַ�
		
		//����һ���ַ�
		Scanner in = new Scanner(System.in);
		ch = in.next().charAt(0);
		in.close();
		
		//�ж��ַ������������
		if(Character.isUpperCase(ch)){
			System.out.println("����ĸΪ��д");
			System.out.println("����ĸ��СдΪ��" + (ch += 32));
		} else if (Character.isLowerCase(ch)){
			System.out.println("����ĸΪСд");
			System.out.println("����ĸ�Ĵ�дΪ��" + (ch -= 32));
		} else {
			System.out.println("���ַ�������ĸ�����ַ���ASCII������һ���ַ�Ϊ��\"" + (ch += 1) + "\"");
		}
	}
}
