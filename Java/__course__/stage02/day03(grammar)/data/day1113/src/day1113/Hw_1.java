package day1113;

import java.util.Scanner;

public class Hw_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�Ӽ������������������ֱ������Ͳ����
		int num_1=0;//ֵ1
		int num_2=0;//ֵ2
		Scanner input=new Scanner(System.in);
		System.out.println("��������������");
		num_1=input.nextInt();
		num_2=input.nextInt();
		System.out.println("�ͣ�"+(num_1+num_2));
		System.out.println("�"+(num_1-num_2));
		System.out.println("����"+(num_1*num_2));
		if (num_2==0) {
			System.out.println("��ĸ����Ϊ0��");
			return;
		}
		System.out.println("�̣�"+((double)num_1/num_2));
	}

}
