/*
 *  ��������
 */

package demo.arr.arrOperation;

import java.util.Scanner;

public class Added {
	public static void main(String[] args) {
		int[] arr = {1,5,4,6,2};
		int num;
		
		//������ʼ����
		System.out.print("��ʼ����Ϊ��");
		for(int i : arr){
			System.out.print(i + " ");
		}
		
		//����
		System.out.println();
		
		//������������
		System.out.print("��������Ҫ����������");
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		in.close();
		
		// ����
		int[] newArr = new int[arr.length + 1];  // 1.�½�һ�������鳤��+1��������
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];  // ��ÿ��Ԫ�ظ�ֵ����������
		}
		newArr[arr.length] = num;  // ��û�е����ָ�ֵ���������е�ĩβ
		arr = newArr;  // ������������õ�ַ��ֵ��������
		
		// �������������
		for (int arr_num : arr) {
			System.out.print(arr_num + " ");
		}
	}
}
