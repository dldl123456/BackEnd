package step3.course.note.l171201;

public class Person {

	/*
	 * 属性（名词）
	 * 成员变量
	 */
	private String name;
	private int age;
	private char sex;
	private static Person p = null;
	
	protected String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>0){
			this.age = age;
		}
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	private Person() {}
	
	public Person(String name){
		this.name = name;
	}
	
	public Person(String name,int age){
		this(name);
		this.age = age;
	}
	
	public Person(String name,int age,char sex){
		this(name,age);
		this.sex = sex;
	}
	
	/*
	 * 静态不能调用非静态
	 */
	public static Person getInstance(){
		if(p == null){
			System.out.println("----------------");
			p = new Person();
		}
		return p;
	}
	
	
	/*
	 * 方法
	 */
	@SuppressWarnings("unused")
	public void eat(){
		String name = "";//局部变量
		System.out.println("eat.........");
	}
	
	public void eat(String food){
		System.out.println("eat.........");
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Person p = new Person();//不写系统默认提供一个无参构造方法
		p.getInstance();
		p.name = "zhangsan";
		p.age = -18;
		p.sex = '男';
		System.out.println(p.name +","+p.age+","+p.sex);
		
	}
	
	
}
