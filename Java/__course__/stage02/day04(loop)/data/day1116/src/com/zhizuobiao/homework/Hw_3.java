package com.zhizuobiao.homework;

public class Hw_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isPrime=true;//��ʶ�����أ�
		for (int i = 2; i <= 1000; i++) {
			//ֻ�ܱ�1����������������������Ҳ��˵ֻҪ�б�1�ͱ���������������Ͳ���
			for (int j = 2; j < i; j++) {
				if (i % j==0) {
					isPrime=false;
					break;//������ǰѭ��
				}
			}
			if (isPrime) {
				System.out.println(i);
			}
			isPrime=true;//��λ
		}
	}

}
