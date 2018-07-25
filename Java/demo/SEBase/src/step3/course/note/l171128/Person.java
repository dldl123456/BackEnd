package step3.course.note.l171128;

public class Person {
	
	/*
	 * 属性（名词）
	 */
	String name;
	int age;
	char sex;
	
	/*
	 * 构造方法  *****
	 * 方法名跟类名一致
	 * 不能声明返回值类型(有返回值：返回值是当前类对象)
	 * 1.创建对象
	 * 2.初始化
	 */
	public Person(){
		name = "小明";
		age = 20;
		sex = '男';
		System.out.println("有没有调用我。。。。。");
	}
	
	
	/*
	 * 方法（动词）
	 */
	public void eat(){
		System.out.println("eat................");
	}

	public void play(){
		System.out.println("play...............");
	}

	
	/*
	 * public:访问修饰符，公共的
	 * static:属于类，生命周期跟类一致。类名. 直接调用
	 * void:返回值类型 (没有返回值)
	 */
	public static void main(String[] args) {
		
		//类是抽象的
		//对象是具体的
		
		Person p = new Person();//实例化
		p.name="zhangsan";
		p.age=18;
		p.sex='女';
		p.eat();
		
		Person p2 = new Person();
		p2.name="lisi";
		p2.age=22;
		p2.sex='男';
		System.out.println(p2.name+","+p2.age+","+p2.sex);
		
		Person p3 = new Person();
		System.out.println(p3.name+","+p3.age+","+p3.sex);
	}
	
}
