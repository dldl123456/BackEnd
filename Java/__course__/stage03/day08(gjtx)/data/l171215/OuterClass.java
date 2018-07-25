package com.lesson.phase3.l0907.l171215;

public class OuterClass {
	
	public static String name ="zhangsan" ;
	private int age = 20;

	public void test(){
		InnerClass inner = new InnerClass();
		inner.test();
		
		class  Test{
			
		}
		
		/*System.out.print(name);
		System.out.println(age);*/
	}
	
	
	//内部类
	public class InnerClass{
		
		public String name = "李四";
		private int age = 30;
		
		public void test(){
			System.out.println(OuterClass.this.name);
			System.out.println(OuterClass.this.age);
		}
		
		
		private class Inner{
			
		}
		
	}
	
	public static class StaticInnerClass{
		
		public void test(){
			System.out.println(name);
			//System.out.println(age);
		}
		
	}
	
	public static void main(String[] args) {
		
		OuterClass outer = new OuterClass();
		outer.test();
		
		/*InnerClass inner = new OuterClass().new InnerClass();
		inner.test();*/
		
		//匿名内部类
		OuterInterface ou = new OuterInterface(){

			@Override
			public void test() {
				System.out.println("test.......");
				
			}
			
			public void show(){
				System.out.println("show...........");
			}
			
			
		};//最后的分号不能忘
		ou.test();
		ou.test();
		
		new OuterInterface(){

			@Override
			public void test() {
				System.out.println("test.......");
				
			}
			
			public void show(){
				System.out.println("show...........");
			}
			
			
		}.show();
	}
	
	
}

//此类不是内部类
class OuterTest{
	
}

abstract class OuterAbs{
	public abstract void test();
}

interface OuterInterface{
	void test();
}

