package com.lesson.phase3.l0907.l171219;

import java.util.Random;

public class MathDemo {

	public static void main(String[] args) {
		
		//Math
		
		System.out.println(Math.ceil(12.3));
		System.out.println(Math.floor(12.3));
		System.out.println(Math.max(15, 12));
		
		System.out.println(Math.pow(2, 3));
		System.out.println(Math.random());
		
		System.out.println(Math.round(12.3));
		System.out.println(Math.round(12.5));
		
		
		//Random
		
		Random ran = new Random();
		System.out.println(ran.nextInt());
		System.out.println(ran.nextInt(10));
		
	}

}
