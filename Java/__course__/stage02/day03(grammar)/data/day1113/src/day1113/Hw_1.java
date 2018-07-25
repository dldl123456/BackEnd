package day1113;

import java.util.Scanner;

public class Hw_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//从键盘输入两个整数，分别求出其和差积商
		int num_1=0;//值1
		int num_2=0;//值2
		Scanner input=new Scanner(System.in);
		System.out.println("请输入两个数：");
		num_1=input.nextInt();
		num_2=input.nextInt();
		System.out.println("和："+(num_1+num_2));
		System.out.println("差："+(num_1-num_2));
		System.out.println("积："+(num_1*num_2));
		if (num_2==0) {
			System.out.println("分母不能为0！");
			return;
		}
		System.out.println("商："+((double)num_1/num_2));
	}

}
