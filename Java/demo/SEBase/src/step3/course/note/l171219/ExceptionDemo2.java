package step3.course.note.l171219;

import java.util.Scanner;

@SuppressWarnings("unused")
public class ExceptionDemo2 {

	public static void main(String[] args)  {
		
		Integer i = new Integer(123);
		Integer i2 =new Integer(123);
		
		System.out.println(i==i2);
		
		
		
		try {
			test();
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("test.........");
		
	}
	
	
	public static void test() throws MyException  {
		throw new MyException("¥ÌŒÛ–≈œ¢°£°£°£°£");
	}
	
	
}
