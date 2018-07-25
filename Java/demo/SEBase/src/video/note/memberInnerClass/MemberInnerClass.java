/*
 *  成员内部类
 */

package video.note.memberInnerClass;

//测试类
public class MemberInnerClass {
	public static void main(String[] args) {
		//创建外部类对象
		Ouer1 outer = new Ouer1();
		//创建内部类对象(外部类名.内部类名  实例名  = 外部类实例名.new 内部类构造方法(参数))
		//内部类构造方法-->默认无参的构造方法
		Ouer1.Inner1 inner = outer.new Inner1();
		inner.innerShow();  //访问内部类的方法
		
		//外部类调用outerShow方法
		outer.outerShow();
	}
}

//外部类
class Ouer1{
	private String name = "张三";
	private int num1 = 10;
	
	public void outerShow(){
		System.out.println(name);
		System.out.println(num1);
		//System.out.println(num2);  //外部类不能直接访问内部类的成员
		
		//外部类访问成员内部类，必须先产生一个内部类对象
		Inner1 inner1 = new Inner1();
		inner1.innerShow();
	}
	
	//成员内部类（可以是任意访问修饰符）
	public class Inner1{
		private String name = "李四";
		private int num2 = 20;
		private static final int num3 = 50;  //静态常量在内部类中可以
		//private static int num3 = 30;  //在成员内部类中不能声明静态的成员，包括属性和方法
		
		//成员内部类如果是private，则只为其外部类服务，测试类中无法调用
		public void innerShow(){  //不能加static
			System.out.println(name);
			System.out.println(Ouer1.this.name);  //访问外部类的name属性
			System.out.println(num2);
			System.out.println(num3);
			System.out.println(num1);  //可以直接访问外部类私有属性
			// outerShow();  //成员内部类中可以直接访问外部类的属性和方法，包括私有的
			//等同于Outer.this.outerShow(); 因为内部类没有同名方法，所以可以省略
		}
	}
}
