package com.zhizuobiao.test;

import java.util.Scanner;

public class Test_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		int num = 0;// �û�����
		int index = -1;// ��¼�±�
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫɾ�������֣�");
		num = input.nextInt();
		// 1.����û��
		for (int i = 0; i < arr2.length; i++) {
			if (num == arr2[i]) {
				index = i;// ��¼���ڵ��±�
				break;
			}
		}
		if (index == -1) {
			System.out.println("û��������ݣ�����ɾ����");
			return;
		}
		arr2[index] = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == 0) {
				continue;
			}
			System.out.println(arr2[i]);
		}
	}

}
