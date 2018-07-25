package step3.course.note.l171128;

public class Method {

	/*
	 * public:访问修饰符，公共的
	 * static:属于类，生命周期跟类一致。类名. 直接调用
	 * void:返回值类型 (没有返回值)
	 */
	public static void main(String[] args) {
		/*int num = 15;
		show(num);
		System.out.println(num);
		System.out.println(show(num));*/
		
		String name = "zhangsan";
		main(name);
		System.out.println(name);
		
		/*String[] names = {"zhangsan"};
		test(names);
		System.out.println(names[0]);*/
	}
	
	/*public static void show(int num){
		num = 20;
		System.out.println("show....");
	}*/
	
	//值传递(传递副本，值拷贝)
	//基本数据类型：拷贝的值
	public static int show(int num){
		num = 20;
		System.out.println("show....");
		return num;
	}
	
	//String 特殊：final修饰，不能改变
	public static void main(String name) {
		name = "lisi";
		System.out.println("假main方法。。。。");
	}
	
	//引用数据类型：拷贝的地址
	public static void test(String[] name) {
		name[0] = "lisi";
		System.out.println("test方法。。。。");
	}
	
}
