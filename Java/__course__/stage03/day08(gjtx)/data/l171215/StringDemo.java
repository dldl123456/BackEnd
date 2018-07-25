package com.lesson.phase3.l0907.l171215;

public class StringDemo {

	public static void main(String[] args) {
		
		//String
		
		//线程安全，效率低
		//StringBuffer sb = new StringBuffer();
		StringBuilder sb = new StringBuilder();
		sb.append("str");
		sb.append(123);
		sb.append(true);
		sb.append(12.5);
		System.out.println(sb);
		
		//StringBuilder 非线程安全， 效率更高，(优先采用) 
		
	}
	
}
