package com.lesson.phase3.l0907.l171205;

public class Animal {

	private String name;
	private int age;
	
	/*public Animal() {
		System.out.println("animal涙歌。。。。。。。。。。。");
	}*/
	
	public Animal(String name) {
		this.name = name;
		System.out.println("animal...............");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void eat(){
		System.out.println("eat......");
	}
	
}
