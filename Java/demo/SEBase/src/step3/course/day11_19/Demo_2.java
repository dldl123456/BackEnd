/*
 *  �����û������޸�������ĳһ��Ԫ�أ��ĸ�Ԫ�أ��޸ĳ�ʲô��
 *  �û������ĸ�Ԫ��ȥ���±꣬Ȼ���޸�
 */

package step3.course.day11_19;

import java.util.Scanner;

public class Demo_2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int[] arr = {10,20,30};  //��ʼ����
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
