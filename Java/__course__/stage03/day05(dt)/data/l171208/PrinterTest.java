package com.lesson.phase3.l0907.l171208;

public class PrinterTest {

	public static void main(String[] args) {
		
		//�����滻ԭ�򣺸�����ֵĵط����������������滻��
		
		//Printer �Ǳ���ʱ���� 
		//BlackPrinter ������ʱ����
		Printer black = new BlackPrinter(); //����ת��
		black.print();
		
		/* �����������з���
		BlackPrinter b = (BlackPrinter)black;
		b.test();*/
		
		Printer color = new ColorPrinter();
		color.print();
		 /**/
		
		
		/*
		Object obj = new Integer(123); //����ת��
		if(obj instanceof String){
			String str = (String)obj;  //����ת��
			System.out.println(str);
		}
		System.out.println(obj);
		*/
		
		
		/*
		String str = "123";
		int num = Integer.parseInt(str) + 100;

		
		 ��װ��
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
