package com.lesson.phase3.l0907.l171212;

public class BirdTest {

	public static final String name;
	
	static {
		name = "����";
	}
	
	public BirdTest() {
		//name = "����";
	}
	
	public static void test(String name){
		name = "����";
		System.out.println(name);
	}
	
	
	public static void main(String[] args) {
		
		//Bird bird = new Bird();
		final String name = "����";
		test(name);
		System.out.println(name);
		
		
		//InterfaceDemo id = new InterfaceDemo();
		
	}
}
