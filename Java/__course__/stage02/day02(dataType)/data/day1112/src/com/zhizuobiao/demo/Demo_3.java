package com.zhizuobiao.demo;

import java.util.Scanner;

public class Demo_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����û��ṩ�Ĵ�д��ĸ��������Ӧ��Сд
		char c = 0;// ��������������ֵ
		System.out.println("������һ����д��ĸ��");
		// ˼������ô�����أ�Scanner����һ���ࣩ
		// 1.new��ʵ������
		Scanner input = new Scanner(System.in);// ׼������
		// 2.���ö���ʹ�����ķ���
		c = input.next().charAt(0);// �û��������ĸ��ֵ��c
		// ������ļ����Ǵ�0�����������䵹��ʱ
		// input.close();// һ�㲻��
		c = (char) (c + 32);// �Ѵ�д��ĸת����Сд��ĸ
		System.out.println("Сд��ĸ��" + c);
	}

}
