/*
 *  �Ӽ�������һ���ٷ��Ʒ���������ת��Ϊ�ȼ��������
 */

package classic.choosing.score;

import java.util.Scanner;

public class Score_2 {
	public static void main(String[] args) {
		System.out.print("��������ķ�����");
		
		double score = 0;  //����������ķ���
		String level = "";  //�ȼ�
		
		//�������
		Scanner in = new Scanner(System.in);
		score = in.nextDouble();
		
		//�ж�����������Ƿ���0-100������
		while(score>100||score<0){
			System.out.print("�����������������룺");
			score = in.nextInt();
		}
		
		in.close();
		
		//����ת���ɵȼ����
		if(score>=90){
			level = "A";
		} else if(score>=80) {
			level = "B";
		} else if(score>=70) {
			level = "C";
		} else if(score>=60) {
			level = "D";
		} else {
			level = "E";
		}
		
		System.out.println("�ȼ�Ϊ��" + level);
	}
}
