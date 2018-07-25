/*
 *  构造函数的方法主要对参数做初始化
 *  类名和方法名一致就是构造方法
 */

package video.note.constructorDemo;

public class ConstructorDemo {
	//测试类
	public static void main(String[] args) {
		/*//无参的构造方法
		Person p = new Person();  //实例化对象p(给Person类私有变量赋初始值)
		
		//赋值（有参的构造函数无法这样赋值）
		p.setName("张三");
		p.setCity("北京");
		p.setAge(3);*/
		
		//有参的构造方法
		/*
		 *  1.在堆中开辟空间，给属性分配默认的初始值
		 *  2.假设属性一开始就赋值了，就进行赋值工作
		 *  3.调用构造方法对属性进行初始化
		 */
		Person p = new Person("张三", "北京", 3);
		
		//调用toString方法输出
		System.out.println(p.toString());
	}
}

//当一个类没有显式声明一个构造方法的时候，系统会有一个默认的无参构造方法
class Person{
	//定义变量
	private String name;
	private String city;
	private int age;
	
	//构造方法(默认是无参，自动生成)
	/*public Person(){
		System.out.println("我是无参构造方法");
	}*/
	
	//构造方法（带参数的构造方法）
	public Person(int num){
		System.out.println("我是带参数的构造方法" + num);
	}
	
	//自定义构造方法(带参数的构造方法)
	public Person(String name, String city, int age){
		// this();  //调用当前对象中的无参构造方法
		this(1);  //调用当前对象中带参数的构造方法
		this.name = name;
		this.city = city;
		this.age = age;
		
		//不能在初始化属性之后调用当前对象的构造方法（必须放在首条语句）
	}
	
	//alt+shift+s
	//name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	//city
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	
	//age
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	//返回 alt+shift+s ==> toString
	//可以用this.name-->这个this就是指实例化的p的引用变量
	public String toString() {
		//方法中调用方法(方法是用对象调用的)就是p.getAge,即this.getAge,这里不能用p.getAge
		System.out.println(getAge());
		return "Person [name=" + name + ", city=" + city + ", age=" + age + "]";
	}	
}
