/*
 *  打印机
 */

package step3.course.day12_10;

//父类
public class Printer {
	//打印的方法
	public void print(){
		
	}
	
	//构造方法
	public Printer(){
		System.out.println("Printer...");
	}
	
	//代码块
	{
		System.out.println("Printer test...");
	}
	
	//静态类
	static {
		System.out.println("Printer static...");
	}
}
