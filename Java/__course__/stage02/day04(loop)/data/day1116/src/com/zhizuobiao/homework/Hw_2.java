package com.zhizuobiao.homework;

import java.util.Scanner;

public class Hw_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("input:");
		int num=0;
		num=input.nextInt();
		if (num<0||num>100) {
			System.out.println("erro !");
			return;
		}
		if (num%2==0) {
			System.out.println("Å¼Êý");
		}else{
			System.out.println("ÆæÊý");
		}
	}

}
