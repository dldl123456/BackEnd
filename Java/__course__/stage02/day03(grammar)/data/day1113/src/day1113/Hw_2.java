package day1113;

import java.util.Scanner;

public class Hw_2 {
	
	public static void main(String[] args) {
		int num_1=0;//ֵ1
		int num_2=0;//ֵ2
		int num_3=0;//ֵ3
		int max=0;//���ֵ
		Scanner input=new Scanner(System.in);
		System.out.println("������3������");
		num_1=input.nextInt();
		num_2=input.nextInt();
		num_3=input.nextInt();
		max=num_1;
		if (num_2>num_1) {
			max=num_2;
		}
		if (num_3>max) {
			max=num_3;
		}
		System.out.println("���ֵ��"+max);
	}

}
