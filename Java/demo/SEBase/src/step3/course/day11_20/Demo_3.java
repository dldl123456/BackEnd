/*
 *  �������е�Ԫ��ɾ����Ҫɾ����Ԫ�ظ�ֵ���������͵�Ĭ��ֵ����
 *  Ȼ���ٱ��������Ĭ��ֵ��Ԫ��
 */

package step3.course.day11_20;

import java.util.Scanner;

public class Demo_3 {
	public static void main(String[] args) {
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		int num = 0;// �û�����
		int index = -1;// ��¼�±�
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫɾ�������֣�");
		num = input.nextInt();
		input.close();
		
		// 1.����û��
		for (int i = 0; i < arr2.length; i++) {
			if (num == arr2[i]) {
				index = i;// ��¼���ڵ��±�
				arr2[index] = 0;
				break;
			}
		}
		if (index == -1) {
			System.out.println("û��������ݣ�����ɾ����");
			return;
		}
		
		// arr2[index] = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] == 0) {
				continue;
			}
			System.out.print(arr2[i]);
		}
	}
}
