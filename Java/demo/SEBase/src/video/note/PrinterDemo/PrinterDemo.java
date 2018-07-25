/*
 * 多态用到的知识点：
 * 父类的引用变量可以引用子类对象
 * 抽象类的引用变量可以引用子类对象
 * 接口类的引用变量可以引用实现类对象
 * 重写
 */

package video.note.PrinterDemo;

public class PrinterDemo {
	public static void main(String[] args) {
		ColorPrinter cp = new ColorPrinter("惠普");
		BlackPrinter bp = new BlackPrinter("戴尔");
		
		School school = new School();
		Teacher tcr = new Teacher("张三" , 30);
		school.setPrinter(cp);
		
		school.print(tcr);
		school.print(school);
		
		
		School school1 = new School();
		Teacher tcr1 = new Teacher("张三" , 30);
		school1.setPrinter(bp);
		
		school1.print(tcr1);
		school1.print(school1);
		
		/*School school1 = new School();
		school1.setPrinter(bp);
		school1.print("hello,oracle");
		
		School school2 = new School();
		school2.setPrinter(cp);
		school2.print("hello,java");*/
		
	}
}

//输出详细信息接口
interface IInfo{
	//声明抽象方法(要被打印的具体内容)
	/*public abstract*/ String detail();
}

//父类（打印机）
//抽象类
abstract class Printer{
	//私有变量
	private String brand;  //品牌
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	//构造函数初始化私有变量
	public Printer(String brand){
		this.brand = brand;
	}
	
	//打印的方法应该由子类来具体地实现
	/*public void print(String content){  //打印内容
		System.out.println("这是给父类打印的方法");
	}*/
	//抽象方法
	public abstract void print(String content);
}

//子类（学校）
//调用接口
class School implements IInfo{
	private Printer p = null;  //安装打印机
	
	//安装打印机
	public void setPrinter(Printer p){
		this.p = p;
	}
	
	/*//打印的方法
	public void print(String content){
		//交给中心所安装的彩色打印机来打印
		p.print(content);
	}*/
	//多态，程序设计的时候，主体框架要用接口或抽象类，使程序有很好的扩展性和可维护性
	public void print(IInfo info){
		p.print(info.detail());
	}
	
	public String detail(){
		return "hello,hello";
	}
}

//子类（彩色打印机）
class ColorPrinter extends Printer{
	public ColorPrinter(String brand) {
		super(brand);
	}
	
	//对父类方法进行重写
	public void print(String content){
		System.out.println(this.getBrand() + "彩色打印：" + content);
	}
}

//子类（黑白打印机）
class BlackPrinter extends Printer{
	public BlackPrinter(String brand) {
		super(brand);
	}
	
	//对父类方法进行重写
	public void print(String content){
		System.out.println(this.getBrand() + "黑白打印：" + content);
	}
}

//教员类
class Teacher implements IInfo{
	private String name;
	private int age;
	
	public Teacher(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//重写接口里的方法
	public String detail(){
		return "你好，我的名字叫：" + name + ",我的年龄是" + age;
	}
}

