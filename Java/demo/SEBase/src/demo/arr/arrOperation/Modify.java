/*
 *  �����޸�
 */

package demo.arr.arrOperation;

import java.util.Scanner;

public class Modify {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int[] arr = {1,5,4,6,2};  //��ʼ����
		int index = -1;  //��������������±�
		int num = 0;  //���������û��������
		
		//�����ʼ����
		System.out.print("��ʼ����Ϊ��");
		for(int i=0; i<arr.length; i++){
			if(i != arr.length-1){
				System.out.print(arr[i] + ",");
			}else{
				System.out.print(arr[i]);
			}
		}
		
		System.out.println("\n");
		
		System.out.print("��������Ҫ�޸ĵ�����");
		
		//�޸�����
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		
		//�û���������Ƿ�����������ڣ�����������Ǿ�Ҫ�����û�����������Ǿ�Ҫ��¼���Ԫ�ص��±�
		for(int i=0; i<arr.length; i++){
			if(num == arr[i]){
				index = i;
				System.out.println("�����������е�" + (index+1) + "��λ��\n");
				break;
			}
		}
		
		//����index�е�ֵ�ж��Ƿ����
		if(index == -1){
			System.out.println("û�и�����");
			return;
		}
		
		//����
		System.out.print("�������޸ĺ�����֣�");
		arr[index] = in.nextInt();
		
		in.close();
		
		//����,����޸ĺ������
		System.out.print("�޸ĺ������Ϊ��");
		for(int i=0; i<arr.length; i++){
			if(i != arr.length-1){
				System.out.print(arr[i] + ",");
			}else{
				System.out.print(arr[i]);
			}
		}
	}
}
