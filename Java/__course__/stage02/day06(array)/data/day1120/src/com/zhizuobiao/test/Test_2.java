package com.zhizuobiao.test;

import java.util.Scanner;

public class Test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ�����飨Ԫ���������������õ�����鿴��������������֣����з����±꣬��û�а��û�������ּӵ������β��
		// �����û������6��û�����6���Ͱ���6�浽��������ĩβ������Ԫ�أ�1��2��3��4��6
		// �½�һ�����飬������������ԭ��������+1���µ���������õ�ַ����ԭ�����ڸ�����֮ǰ�Ȱ��������е�Ԫ�ظ�ֵ���µ�
		int[] arr = { 1, 2, 3, 4 };// 4���±�3
		int num = 0;// ��������
		int index = -1;// �±��¼
		Scanner input = new Scanner(System.in);
		System.out.println("���������֣�");
		num = input.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			System.out.println("�ҵ��ˣ����������е�" + (index + 1) + "λ��");
			return;
		}
		// ����
		// 1.�½�һ�������鳤��+1��������
		int[] newArr = new int[arr.length + 1];
		// 2.���������е����ݸ��Ƹ��µ�����
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];// ��ÿ��Ԫ�ظ�ֵ����������
		}
		// ��û�е����ָ�ֵ���������е�ĩβ
		newArr[arr.length] = num;// ���������±�����ֵ��������ĳ��������������鳤��-1��5���±�4
		// ������������õ�ַ��ֵ��������
		arr = newArr;
		// �������������� for-eachѭ��ֻ�������������������ܶ����������ݽ��иı�
		for (int arr_num : arr) {// ð�����д������������ͺͱ�������ð���ұ�д��Ҫ���������飨�����������磺���顢���ϣ�
			System.out.println(arr_num);
		}
		// ����ĵȼ������
		// for (int i = 0; i < arr.length; i++) {
		// int arr_num=arr[i];
		// System.out.println(arr_num);
		// }
	}

}