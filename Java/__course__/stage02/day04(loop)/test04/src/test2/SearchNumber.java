/*
 * ��һ������{2,4,5,6,1,10,12,7,1}��
 * Ҫ���û�����������һ������������ڣ���ӡ�������ֳ��ֵ�λ�ã�
 * ��������ڣ���ӡ-1��
 * �㷨Ҫ���װΪ����
 */

package test2;

import java.util.Scanner;

public class SearchNumber {
	public static void main(String[] args) {
		int[] arr = {2,4,5,6,1,10,12,7,1};  //��ʼ����
		int num = 0;  //���������û���Ҫ�������
		int index = 0;  //���������û���Ҫ�������λ��������±�
		
		System.out.print("��������Ҫ��ѯ�����֣�");
		
		//��ȡ����
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		in.close();
		
		//�����Ӻ�������Ľ����index��ֵ
		index = lineSearch(arr, num);
		
		//������
	    if(index != -1){
			System.out.println("����ѯ������λ�ڸ�����ĵ�" + index + "��λ��");
		} else {
			System.out.println("��������û������������֣����������룡");
		}
	}
	
	//�����Բ��ҷ���λ��Ҫ���ҵ�����
	public static int lineSearch(int[] arr, int num){
		int length = arr.length;  //������������ĳ���
		
		//��ͷ��������ĸ���ֵ������ҵ�Ŀ��ֵ�ͷ���������
		for(int i=0; i<length; i++){
			if(arr[i] == num){
				return i + 1;
			}
		}
		
		//�����ѯ�����������Ŀ��ֵ�������������У��򷵻�-1
		return -1;
	}
	
}
