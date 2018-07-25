package step3.course.day12_10;

public class SchoolTest {
	public static void main(String[] args) {
		Printer prin1 = new BlackPrinter();  //(父类引用|指向子类对象)
		Printer prin2 = new ColorPrinter();
		School sch1 = new School(prin1);
		sch1.print();
		
		School sch2 = new School(prin2);
		sch2.print();
	}
}
