/*
 * �����Լ����������Ա���������õĳɼ�������ӡ 
 */

package video.note.prcin;

import java.util.Scanner;

public class Prcin {
	public static void main(String[] args) {
		String name = null;	//����
		char sex = 0;	//�Ա�
		byte age = 0;	//����
		float score = (float) 0.0;	//���õĳɼ�
		
		System.out.println("�����������������Ա���������õĳɼ���");
		
		Scanner in = new Scanner(System.in);
		name = in.next();
		sex = in.next().charAt(0);
		age = in.nextByte();
		score = in.nextFloat();
		in.close();
		
		System.out.println("���������ǣ�" + name);
		System.out.println("�����Ա��ǣ�" + sex);
		System.out.println("���������ǣ�" + age);
		System.out.println("�����õĳɼ��ǣ�" + score);
	}
}
