package com.lesson.phase3.l0907.l171208;

public class ColorPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("��ɫ��ӡ������������������������");
	}
	
	public ColorPrinter(){
		System.out.println("ColorPrinter........");
	}
	
	{
		System.out.println("test...........");
	}
	
	static {
		System.out.println("static...........");
	}
	
	
	public static void main(String[] args) {
		new ColorPrinter();
		new ColorPrinter();
	}
	
}
