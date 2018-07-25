/*
 *  方法重载,和返回类型无关
 */

package video.note.overloadDemo;

public class OverloadDemo {
	public static void main(String[] args) {
		//没有无参的构造方法，所以要写参数
		Printer p1 = new Printer(1000);  //实例化对象
		p1.print("hello");
		p1.print(123123);
		p1.print("cmcc", 132);
		
		Printer p2 = new Printer("戴尔", 1000);  //实例化对象
		p2.print("---");
		Printer p3 = new Printer(1000);  //实例化对象
		p3.print("---");
		Printer p4 = new Printer("吉他");  //实例化对象
		p4.print("---");
	}
}

class Printer{
	//定义私有变量
	private String brand = "惠普";
	private double price = 10086;
	
	//一个参数的构造方法
	public Printer(String brand){
		this.brand = brand;
		System.out.println(brand + "--" + price);
	}
	
	//一个参数的构造方法
	public Printer(double price){
		this.price = price;
		System.out.println(brand + "--" + price);
	}
	
	//两个参数的构造方法
	public Printer(String brand, double price){
		this.brand = brand;
		this.price = price;
		System.out.println(brand + "--" + price);
	}
	
	//一个参数，字符串
	public void print(String content){
		System.out.println("字符串" + content);
	}
	
	//一个参数，整型
	public void print(int content){
		System.out.println("整型" + content);
	}
	
	//两个个参数
	public void print(String str, int content){
		System.out.println(str + "---" + content);
	}
}
