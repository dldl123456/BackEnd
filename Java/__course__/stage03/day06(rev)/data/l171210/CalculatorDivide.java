package com.lesson.phase3.l0907.l171210;

public class CalculatorDivide extends Calculator {

	public double getResult(){
		if(getNum2() == 0){
			System.out.println("��ĸ����Ϊ0!");
			return 0.0;
		}
		return getNum1() / getNum2();
	}
	
}