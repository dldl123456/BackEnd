/*
 *  枚举类型就是预先创建多个枚举类型的对象，供外部人使用
 */

package video.note.enumDemo;

public class EnumDemo {
	//测试类
	public static void main(String[] args) {
		//调用枚举的值
		System.out.println(Color.BLUE);  //Color.BLUE.toString
		Color[] colors = Color.values();  //是一个数组
		for(Color c:colors){
			System.out.println(c);
		}
		
		//枚举类Person
		System.out.println(Person.P1.toString() + "\n----");  //toString可以省略
		//遍历枚举（数组）
		Person[] prs = Person.values();  //将枚举中的数据存入数组
		for(Person p:prs){
			System.out.println(p);
		}
		System.out.println("------");
		
		Person p = Person.P3;
		switch(p){
			case P1:
				System.out.println(Person.P1);
				break;
			case P2:
				System.out.println(Person.P2);
				break;
			case P3:
				System.out.println(Person.P3);
				break;
		}
	}
}

//构建出了静态常量
//当编译器（jvm-java虚拟机）去加载使用枚举类的时候，会预先创建多个枚举类型的对象供外部类(对象)来使用
//public static final Color RED = new Color();
//public static final Color BLUE = new Color();
//public static final Color YELLO = new Color();
enum Color{  //枚举，都是常量
	//是对象，就有构造方法，但
	//枚举类型的值必须作为第一条语句出现
	RED,BLUE,YELLOW;  //相当于RED(),BLUE(),YELLOW();
	
	//构造方法（但这个构造方法不公开,不能在外面new，所以不能用public修饰）
	//这里是无参构造方法
	private Color(){
		System.out.println("构造方法");
	}
	
	//重写toString方法
	/*public String toString(){
		return "aa";
	}*/
}

//public static final Person P1 = new Person("张三", 30);
//public static final Person P1 = new Person("李四", 30);
//public static final Person P1 = new Person("王五", 30);
enum Person{
	//调用构造方法
	P1("张三", 30), P2("李四", 30), P3("王五", 30);
	private String name;
	private int age;
	private Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//重写toString方法
	public String toString(){
		return name + "--" + age;
	}
}
