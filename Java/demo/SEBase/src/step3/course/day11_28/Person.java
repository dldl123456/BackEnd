

package step3.course.day11_28;

public class Person {
	/*
	 *  public:访问修饰符，公共的
	 *  static:属于类，生命周期跟类一致
	 *  void:返回值类型（没有返回值）
	 *  main:方法名
	 *  String[] args:形参
	 */
	//修饰符，返回值，变量名（参数列表）{方法体}
	public static void main(String[] args) {
		//在同类中 调用静态方法可以省略类名直接方法名调用
		main();  //等同Person.main();
	}
	
	//方法名可以一致
	//有static修饰说明是同类,没有用static修饰说明是对象
	public static void main(){
		System.out.println("假main方法。。。。");
	}
}
