package step3.course.note.l171212;

public class BirdTest {

	public static final String name;
	
	static {
		name = "张三";
	}
	
	public BirdTest() {
		//name = "张三";
	}
	
	public static void test(String name){
		name = "张三";
		System.out.println(name);
	}
	
	
	public static void main(String[] args) {
		
		//Bird bird = new Bird();
		final String name = "李四";
		test(name);
		System.out.println(name);
		
		
		//InterfaceDemo id = new InterfaceDemo();
		
	}
}
