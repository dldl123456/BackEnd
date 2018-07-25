package step3.course.note.l171208;

public class SchoolTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Printer prin1 = new BlackPrinter();
		Printer prin2 = new ColorPrinter();
		School sch = new School(prin2);
		sch.print();
		
		
	}
}
