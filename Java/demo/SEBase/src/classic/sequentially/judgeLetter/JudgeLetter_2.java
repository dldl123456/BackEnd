/*
 * �Ӽ�������һ����ĸ���ж���Ϊ��д����Сд��ĸ������ת��Ϊ��Ӧ�Ĵ�Сд��ĸ����� 
 */

package classic.sequentially.judgeLetter;

import java.util.Scanner;

public class JudgeLetter_2 {
	public static void main(String[] args) {
		System.out.print("����������һ����ĸ��");
		char ch = 0;  //��������һ��������ĸ
		
		//����һ��������ĸ
		Scanner in = new Scanner(System.in);
		ch = in.next().charAt(0);
		in.close();
		
		//�жϸ���ĸ�Ĵ�Сд��������ת��Ϊ��Ӧ�Ĵ�Сд�������
		if(Character.isUpperCase(ch)){
			System.out.println("����ĸΪ��д");
			System.out.println("����ĸ��СдΪ��" + (ch += 32));
		} else {
			System.out.println("����ĸΪСд");
			System.out.println("����ĸ�Ĵ�дΪ��" + (ch -= 32));
		}
	}
}
