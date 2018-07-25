package step3.course.day12_10;

public class BlackPrinter extends Printer {
	//重写方法
	public void print(){
		System.out.println("黑白打印机");
	}
	
	//扩展的方法
	public void test(){
		System.out.println("test");
	}
	
	//构造方法有两个作用，第一是初始化变量，第二是创建对象
	//构造方法是最后执行的，构造方法执行了，对象就创建好了
	//构造方法 3
	public BlackPrinter(){
		System.out.println("BlackPrinter...");
	}
	
	//代码块 2
	{
		System.out.println("test...");
	}
	
	//静态类 1
	static {
		System.out.println("static...");
	}
	
	public static void main(String[] args) {
		new BlackPrinter();  //创建子类对象
//		new BlackPrinter();  //两个对象static只执行1次
		
		//创建子类对象的时候会先创建父类对象
		
		//在父类里面，先执行两个静态类（父再子），再父类的代码块，父类的构造方法，
		//再子类的代码块，子类的构造方法
	}
}
