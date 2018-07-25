package com.lesson.phase3.l0907.l171208;

public class SchoolTest {

	public static void main(String[] args) {
		
		Printer prin1 = new BlackPrinter();
		Printer prin2 = new ColorPrinter();
		School sch = new School(prin2);
		sch.print();
		
		
	}
}
