package com.zhizuobiao.demo;

public class Demo_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[4];// new�����[]�����ֲ�д
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };// �������鲢��ÿ��Ԫ�ظ���ʼֵ
		System.out.println("arr2�ĳ��ȣ�" + arr2.length);
		int[] arr3 = new int[] { 1, 2, 3, 4, 5, 6 };//���ں����������Ѿ�����ϸ��Ԫ�ظ������Բ���д����
		int[] arr4=null;//�������飬û�п��ٿռ�
		arr4=arr2;//��ֵ�Ǹ���ʲô������arr4�����õ�ַ��������ʵ�ʵ�����
		for (int i = 0; i < arr4.length; i++) {
			System.out.println(arr4[i]);
		}
	}

}
