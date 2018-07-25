package step3.course.course.day11_13;

import java.util.Scanner;

public class Demo_4 {
	public static void main(String[] args) {
		int num1 = 0,
			num2 = 0,
			num3 = 0,
			max = 0;
		
		System.out.print("请输入3个数：");
		
		Scanner in = new Scanner(System.in);
		num1 = in.nextInt();
		num2 = in.nextInt();
		num3 = in.nextInt();
		in.close();
		
		max = num1;
		
		if(num2>num1){
			max = num2;
		}
		
		if(num3>max){
			max = num3;
		}
		
		System.out.println("最大值是：" + max);
		
		
		
	}
}
