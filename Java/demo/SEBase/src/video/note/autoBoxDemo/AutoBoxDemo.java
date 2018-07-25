/*
 *  自动拆装箱
 */

package video.note.autoBoxDemo;

public class AutoBoxDemo {
	public static void main(String[] args) {
		int i = 10;
		double d = 10.5;
		
		//把基本类型赋值给引用类型，基本类型会在编译的时候自动装箱
		Integer num1 = i;  //包装类
		Double num2 = d;
		
		System.out.println(num1);  //num1.intValue();
		System.out.println(num2);  //num2.doubleValue();
		
		//把包装类(引用类型)赋值给基本类型，会自动做拆箱
		int j = num1;  //int j = num1.intValue();
		double dd = num2;  //double dd = num2.doubleValue();
		
		System.out.println(j);
		System.out.println(dd);
		
		//基本赋给引用，先把自己提升(封装)为与之对应的引用数据类型或者包装类
		Object o = i;  //Object o = new Integer(i);
		//自动包装成与之对应的包装类
		//o指向了父类的引用变量（父类的引用变量引用子类的对象）
		Integer b = (Integer)o;
		System.out.println(b);
		System.out.println(o);
	}
}
