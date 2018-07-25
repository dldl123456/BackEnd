package com.lesson.phase3.l0907.l171205;

public class SmallDog extends Dog {

	/*public SmallDog() {
		System.out.println("smalldog无参。。。。。。。。。。。");
	}*/
	
	public SmallDog(String name) {
		super(name);
		System.out.println("smalldog..............");
	}
	
	public SmallDog(String name , int age) {
		super(name);
		//this(name);
		System.out.println("smalldog..............");
	}
	
	public void eat(){
		super.eat();
		System.out.println("我爱吃牛奶...........");
	}
	
	public void eat(String food){
		super.eat();
		System.out.println("我爱吃"+food+"...........");
	}
	
}
