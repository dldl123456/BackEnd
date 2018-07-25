package step3.course.day12_10;

public class PrinterTest {
	public static void main(String[] args) {
		//里式替换原则：
		//父类出现的地方都可以用子类来替换
		
		//多态三要素：
		//继承，重写，父类引用子类对象
		
		//父类引用子类对象
		//定义父类类型的引用变量指向其子类对象，此引用变量调用子类重写父类的方法
		//编译的时候是父类类型，运行的时候是子类类型
		//运行时才指向子类对象地址
		//把子类对象转成了父类，向上转型
		/*BlackPrinter*/ Printer black = new BlackPrinter();  //多态（向上转型）
		black.print();
		//black.test();不能直接调用扩展方法,编译的时候是父类类型，test不在父类里面
		//向下转型可以用自己的方法
		//判断black对象是否为BlackPrinter类的实例
		//判断black是否为BlackPrinter类型
		if(black instanceof BlackPrinter){
			//如果是进行强转,将父类引用的子类对象强制转换成子类对象
			BlackPrinter blk = (BlackPrinter)black;
			blk.test();  //调用子类对象的扩展方法
		}
		
		
		/*ColorPrinter*/ Printer color = new ColorPrinter();  //多态
		color.print();
		
		
		//整型转字符串（不能直接转换）
		Object obj = new Integer(123);  //向上转型
		//判断obj是否为String类型
		if(obj instanceof String){
			String str = (String)obj;  //强转，向下转型
			System.out.println(str);
		}
		System.out.println(obj);
		
		//字符串转int(基本数据类型的包装类)
		String str1 = "123";
		int num = Integer.parseInt(str1) + 100;
		System.out.println(num);
		
		/* 包装类,其他的首字母大写 ==>  包装类就是为了给我们提供方法
		 * char  --  Character
		 * byte
		 * short
		 * int  --  Integer
		 * long
		 * float
		 * double
		 * 
		 * boolean
		 */
	}
}
