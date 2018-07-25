package step3.course.note.l171208;

public class ColorPrinter extends Printer {

	@Override
	public void print() {
		System.out.println("科弼嬉咫字。。。。。。。。。。。");
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
