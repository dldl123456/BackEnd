/*
 *  ����ɾ��
 */

package demo.arr.arrOperation;

import java.util.Scanner;

public class Delete {
	public static void main(String[] args) {
		int[] arr = {1,5,4,6,2};
		int num = 0;// �û�����
		int index = -1;// ��¼�±�
		
		System.out.print("��ʼ����Ϊ��");
		for(int i : arr){
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫɾ�������֣�");
		num = input.nextInt();
		input.close();
		
		// 1.����û��
		for (int i = 0; i < arr.length; i++) {
			if (num == arr[i]) {
				index = i;// ��¼���ڵ��±�
				arr[index] = 0;
				break;
			}
		}
		if (index == -1) {
			System.out.println("û��������ݣ�����ɾ����");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				continue;
			}
			System.out.print(arr[i] + " ");
		}
	}
}
