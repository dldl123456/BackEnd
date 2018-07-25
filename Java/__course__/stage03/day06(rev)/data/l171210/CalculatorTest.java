package com.lesson.phase3.l0907.l171210;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		String operator = input.next();
		Calculator cal = null;
		switch(operator){
		case "+":
			cal = new CalculatorAdd();
			break;
		case "-":
			cal = new CalculatorMinus();
			break;
		case "*":
			cal = new CalculatorMulti();
			break;
		case "/":
			cal = new CalculatorDivide();
			break;
			
		}
		cal.setNum1(num1);
		cal.setNum2(num2);
		System.out.println(cal.getResult());
		


		
		
	}
	
}
