package com.zhizuobiao.test;

public class Test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// __*
		// _* *
		// * * *

		// **
		// *
		// 
		for (int i = 1; i < 6; i++) {//行数
			for (int j = 5 - i; j > 0; j--) {//空格数
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {//*号数
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
