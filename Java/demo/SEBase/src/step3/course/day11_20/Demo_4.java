/*
 *  ����һ�����飬�����û�������鿴�������������֣�
 *  ���з����±꣬���û�У�
 *  ��������ּӵ������β��
 */

package step3.course.day11_20;

import java.util.Scanner;

public class Demo_4 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };// 4���±�3
		int num = 0;// ��������
		int index = -1;// �±��¼
		Scanner input = new Scanner(System.in);
		System.out.println("���������֣�");
		num = input.nextInt();
		input.close();
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
			System.out.print(arr_num + " ");
		}
		// ����ĵȼ������
		// for (int i = 0; i < arr.length; i++) {
		// int arr_num=arr[i];
		// System.out.println(arr_num);
		// }
	}
}
