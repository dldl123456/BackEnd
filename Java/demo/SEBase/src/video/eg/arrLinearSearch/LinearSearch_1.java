/*
 *  ���Բ��ҷ���
 *  ����ָ�������������г��ֵ�λ�ã��ҵ������±꣬�Ҳ�������-1
 */

package video.eg.arrLinearSearch;

import java.util.Scanner;

public class LinearSearch_1 {
	public static void main(String[] args) {
		int[] array = {10, 100, 80, 50, 70, 60, 90};  //�����ʼ����
		int index = -1;  //�����ҵ������������е��±꣬�Ҳ�������-1
		int number = 0;  //�û�Ҫ�������
		
		//����
		System.out.print("��������Ҫ���ҵ�����");
		Scanner in = new Scanner(System.in);
		number = in.nextInt();
		in.close();
		
		for(int i=0; i<array.length; i++){
			if(array[i] == number){
				index = i + 1;
				break;
			}
		}
		
		if(index != -1){
			System.out.println("�����ҵ������������еĵ� " + index + " ��λ��");
		} else {
			System.out.println("��Ҫ���ҵ��������ڣ�");
		}
	}
}
