/*
 *  静态内部类
 */

package video.note.staticInnerClass;

public class StaticInnerClass {
	public static void main(String[] args) {
		//静态的通过类名.方法名
		//构造一个静态内部类对象
		Outer.Inner inner = new Outer.Inner();
		inner.innerShow();  //调用内部类方法
		
		//调用外部类需先产生外部类对象
		Outer outer = new Outer();
		outer.outerShow();
	}
}

//外部类
class Outer{
	private String name = "张三";
	private int num1 = 10;
	private static int num3 = 10000;
	
	//外部类方法
	public void outerShow(){
		System.out.println(name);
		System.out.println(num1);
		Inner inner = new Inner();  //访问静态内部类非静态成员需先产生对象
		System.out.println(inner.name);  //访问内部类非静态成员
	}
	
	//一个静态内部类
	public static class Inner{
		private String name = "李四";
		private int num2 = 50;
		
		//内部类方法
		public void innerShow(){
			System.out.println(name);
			//System.out.println(Outer.this.num1);
			//静态内部类不能访问外部类的非静态成员
			System.out.println(num2);
			System.out.println(num3);  //可以访问外部静态的成员
			//静态属于类，静态不能用this，只能用类名.
			//等同于Outer.num3
			
			//静态内部类访问外部非静态成员，
			//调用外部类需先产生外部类对象
			Outer outer = new Outer();
			System.out.println(outer.num1);
		}
	}
}
