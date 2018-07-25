/*
 *  学校中心配备一台打印机（可以是黑白打印机，也可以是彩色打印机）。
 *  中心可以通过打印机打印学员的个人信息（张三和李四等）。
 *  通过继承和多态来设计这个程序，使程序具有更好的扩展性和维护性。
 */

package test2;

public class Printer {
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
	public void print(String content){  //打印内容
		System.out.println("这是给父类打印的方法");
	}
	
	//主方法（程序入口、测试类）
	public static void main(String[] args) {
		ColorPrinter cp = new ColorPrinter("惠普");
		BlackPrinter bp = new BlackPrinter("戴尔");
		
		School school1 = new School();
		school1.setPrinter(bp);
		school1.print("张三");
		
		School school2 = new School();
		school2.setPrinter(cp);
		school2.print("李四");
		
	}
}
