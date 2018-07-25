package video.note.abstractDemo;

public class EmployeeDemo {
	public static void main(String[] args) {
		// JavaTeacher jta = new JavaTeacher(1, "小三", 200);
		Employee jta = new JavaTeacher(1, "小三", 200);  //也可以用抽象类来声明jta这个变量
		//父类的引用变量也可以引用子类对象，实现多态
		jta.work();  //调用抽象方法
		
		Leader led = new Leader(2, "小白", 250, 1000000);
		led.work();  //调用抽象方法
		
		//抽象类不能进行实例化
		//Employee emp = new Employee();
	}
}

//抽象类，也是父类
abstract class Employee{
	//共性
	@SuppressWarnings("unused")
	private int number;
	@SuppressWarnings("unused")
	private String name;
	@SuppressWarnings("unused")
	private double salary;
	
	//构造方法
	public Employee(int number, String name, double salary){
		this.number = number;
		this.name = name;
		this.salary = salary;
	}
	
	//抽象方法的声明（抽象类）
	public abstract void work();
	
	//抽象类里面可以有方法的实现和空方法
	public void aa(){
		System.out.println("aa");
	}
}

//继承
//一旦一个类去继承了抽象类，那么这个类就要么去实现抽象类中的抽象方法
//要么继续抽象下去
class JavaTeacher extends Employee{
	public JavaTeacher(int number, String name, double salary){
		super(number, name, salary);
	}

	//public abstract void work();
	
	//抽象方法的实现
	public void work(){
		System.out.println("JavaTeacher上java课");
	}
}

//子类2(总监)
class Leader extends Employee{
	@SuppressWarnings("unused")
	private double allowance;  //津贴
	
	public Leader(int number, String name, double salary, double allowance){
		super(number, name, salary);
		this.allowance = allowance;
	}
	
	//抽象方法的实现
	public void work(){
		System.out.println("Leader培训新员工");
		System.out.println("Leader设计教学体系");
	}
}
