package com.lesson.phase3.l0907.l171203;

public class SingleTest {

	public static void main(String[] args) {
		
		SingleDemo sin = SingleDemo.getInstance();
		System.out.println(sin);
		SingleDemo sin2 = SingleDemo.getInstance();
		System.out.println(sin2);
		SingleDemo sin3 = SingleDemo.getInstance();
		System.out.println(sin3);
		SingleDemo sin4 = SingleDemo.getInstance();
		System.out.println(sin4);
		
	}
}
