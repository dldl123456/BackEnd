package com.zhizuobiao.homework;

public class Hw_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isPrime=true;//标识（开关）
		for (int i = 2; i <= 1000; i++) {
			//只能被1和自身整除的数叫素数，也就说只要有被1和本身以外的数整数就不是
			for (int j = 2; j < i; j++) {
				if (i % j==0) {
					isPrime=false;
					break;//跳出当前循环
				}
			}
			if (isPrime) {
				System.out.println(i);
			}
			isPrime=true;//复位
		}
	}

}
