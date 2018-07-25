package classic.choosing.calculation;

import java.util.Scanner;

public class Calculation {
	public static void main(String[] args) {
		double num1 = 0.0;
		double num2 = 0.0;
		char c = ' ';
		
		System.out.println("请分别输入两个整数及一个运算符，其中运算符在两个整数之间输入：");
		
		Scanner in = new Scanner(System.in);
		num1 = in.nextDouble();
		c = in.next().charAt(0);
		num2 = in.nextDouble();
		in.close();
		
		switch(c){
		case '+':
			System.out.print(num1 + num2);
			break;
		case '-':
			System.out.print(num1 - num2);
			break;
		case '*':
			System.out.print(num1 * num2);
			break;
		case '/':
			System.out.print(num1 / num2);
			break;
		default:
			System.out.println("您的输入有误");
		}
	}
}
