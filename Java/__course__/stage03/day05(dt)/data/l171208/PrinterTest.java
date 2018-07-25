package com.lesson.phase3.l0907.l171208;

public class PrinterTest {

	public static void main(String[] args) {
		
		//里氏替换原则：父类出现的地方都可以用子类来替换。
		
		//Printer 是编译时类型 
		//BlackPrinter 是运行时类型
		Printer black = new BlackPrinter(); //向上转型
		black.print();
		
		/* 调用子类特有方法
		BlackPrinter b = (BlackPrinter)black;
		b.test();*/
		
		Printer color = new ColorPrinter();
		color.print();
		 /**/
		
		
		/*
		Object obj = new Integer(123); //向上转型
		if(obj instanceof String){
			String str = (String)obj;  //向下转型
			System.out.println(str);
		}
		System.out.println(obj);
		*/
		
		
		/*
		String str = "123";
		int num = Integer.parseInt(str) + 100;

		
		 包装类
		 char  -- Character
		 byte
		 short
		 int   -- Integer
		 long
		 float
		 double
		 
		 boolean
		 */
		
	}
	
	
	

}
