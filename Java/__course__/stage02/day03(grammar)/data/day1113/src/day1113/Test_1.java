package day1113;

import java.util.Scanner;

public class Test_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double score = 0;// �ɼ�
		char level = 0;// �Ǽ�
		Scanner input = new Scanner(System.in);
		System.out.println("������ɼ���");
		score = input.nextDouble();
		if (score > 100 || score < 0) {
			System.out.println("��������");
			return;
		}
		if (score>=90) {
			level = 'A';
		}else if (score>=80) {
			level='B';
		}else if (score>=70) {
			level='C';
		}else if (score>=60) {
			level='D';
		}else{
			level='E';
		}
		System.out.println("�ȼ�Ϊ��"+level);
	}

}
