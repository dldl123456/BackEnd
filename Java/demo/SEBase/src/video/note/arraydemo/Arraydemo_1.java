package video.note.arraydemo;

import java.util.Scanner;

public class Arraydemo_1 {
	public static void main(String[] args) {
		//�������󴴽�
		/*int[] array; 
		array = new int[3];*/
		
		//ֱ�Ӵ�����[]Ҳ���Է�array���棬��һ�㲻���飩
		/*int[] array = new int[3];*/
		
		//�������е�ԭ�����и�ֵ(�±�)
		/*array[0] = 1;
		array[2] = 3;*/
		
		//�������е�ԭ�����и�ֵ(ѭ��)
		/*for(int i=0; i<array.length; i++){
			System.out.println(array[i]);
		}*/
		
		//��̬��ʼ��
		// int[] array = {10,20,30};	//�ڶ��ڴ������3������
		// int[] array = new int[]{10,20,30};
		
		//��̬��ʼ��
		int[] array = new int[3];
		Scanner in = new Scanner(System.in);
		in.close();
		for(int i=0; i<array.length; i++){
			array[i] = in.nextInt();
			System.out.print(array[i] + " ");
		}
		
		/*System.out.println(array.length);
		System.out.println(array[0]);*/
	}
}
