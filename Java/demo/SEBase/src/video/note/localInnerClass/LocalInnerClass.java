/*
 *  局部内部类
 */

package video.note.localInnerClass;

public class LocalInnerClass {
	//测试类
	public static void main(String[] args) {
		//若要执行局部内部类的方法，先要产生一个外部类的对象
		Outer outer = new Outer();
		outer.showOuter();  //先调用外部类的方法
	}
}

class Outer{
	private String name = "zzz";
	private int num1 = 10;
	private static int num2 = 20;
	
	public void showOuter(){
		/*final*/ int num3 = 501;
		//局部内部类不能加访问修饰符
		class Inner{
			private int num4 = 30;
			private int num1 = 20;
			
			public void showInner(){
				System.out.println(num4);  //内部类里面的成员
				//要运行首先创建内部类对象
				System.out.println(num1);  //自己的num1
				//外部类的num1
				System.out.println(Outer.this.num1);
				//外部静态类num2
				System.out.println(Outer.num2);
				//方法体里面，内部类外面，的局部变量，num4
				System.out.println(num3);
				//局部内部类只能访问声明其方法中的常量
				System.out.println(name);
			}
		}
		Inner inner = new Inner();  //实例化对象
		inner.showInner();
	}
}