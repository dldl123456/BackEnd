/*
 *  �Ӽ�������һ���ٷ��Ʒ���������ת��Ϊ�ȼ��������
 */

package classic.choosing.score;

import java.util.Scanner;

public class Score_1 {
	public static void main(String[] args) {
		System.out.print("��������ķ�����");
		
		int score = 0;  //����������ķ���
		
		//�������
		Scanner in = new Scanner(System.in);
		score = in.nextInt();
		in.close();
		
		//����ת���ɵȼ����
		int grade = 0;
		grade = score/10;
		
		switch(grade){
			case 10:
			case 9:
				System.out.println("A");
				break;
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			case 6:
				System.out.println("D");
				break;
			default:
				System.out.println("E");
		}
	}
}
