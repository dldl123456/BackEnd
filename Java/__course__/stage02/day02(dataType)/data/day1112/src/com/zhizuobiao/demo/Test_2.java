package com.zhizuobiao.demo;

import java.util.Scanner;

public class Test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����Լ����������Ա���������õĳɼ���Ȼ���ڿ���̨��ʾ
		String name = null;// ����
		char sex = 0;// �Ա�
		int age = 0;// ����
		double score = 0.0;// �ɼ�
		Scanner input=new Scanner(System.in);
		System.out.println("�������Լ����������Ա�����ͳɼ���");
		name=input.next();
		sex=input.next().charAt(0);
		age=input.nextInt();
		score=input.nextDouble();
		System.out.println("���֣�"+name+"\n���䣺"+age+"\n�Ա�"+sex+"\n�ɼ���"+score);
	}

}
