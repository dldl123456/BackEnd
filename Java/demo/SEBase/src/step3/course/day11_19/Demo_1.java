/*
 *  �����û������޸�������ĳһ��Ԫ�أ��ĸ�Ԫ�أ��޸ĳ�ʲô��
 *  2���û������±��޸�
 */

package step3.course.day11_19;

import java.util.Scanner;

public class Demo_1 {
	public static void main(String[] args) {
		int[] arr = {10,20,30};  //��ʼ����
		int index = 0;  //��������������±�
		
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
		
		//�޸�����
		Scanner in = new Scanner(System.in);
		
		//�±�
		System.out.print("������Ҫ�޸ĵ�������±꣺");
		index = in.nextInt();
		
		//����
		System.out.print("������Ҫ�޸ĵ�����");
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
