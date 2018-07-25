package step3.course.day12_01;

public class Person {
	/*
	 * 属性
	 * 在类名声明的变量，都叫做成员变量（成员变量的作用域在类里面）
	 */
	String stuname;
	int age;
	char sex;
	
	//私有属性
	private String pname;
	private int page;
	private char psex;
	
	//创建对象
	private static Person p = null;  //静态的不能调用非静态的
	
	//为了让外部类访问私有变量，用get,set方法
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page>0){
			this.page = page;
		}
	}

	public char getPsex() {
		return psex;
	}

	public void setPsex(char psex) {
		this.psex = psex;
	}
	
//方法名相同，参数列表不同，叫做重载
	
	//构造方法(系统默认)
	/*public Person(){
		
	}*/
	
	//私有构造方法
	private Person(){
		
	}

	//传参（如果有一个带参的构造函数，系统不会再提供默认的无参构造方法）
	public Person(String name){
		//方法里面调用成员变量要用this,this指当前对象
		this.stuname = name;  //改名字没关系
	}
	
	//这种写法不太好（构造方法参数太多的时候），而且代码的重用性不好，
	public Person(String name, int age){
		//为了避免这种问题，用以下方法（在构造方法之间调用方法也用this）
		//调用构造函数方法
		this(name);  //this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, char sex){
		this(name, age);
		this.sex = sex;
	}
	
	/*
	 * 方法
	 */
	public void eat(){
		String name = "";  //局部变量
		System.out.println("eat" + name);
	}
	
	public void eat(String food){  //局部变量
		System.out.println("eat" + food);
	}
	
	public static void main(String[] args) {
		Person p = new Person();
		p.pname = "aa";
		System.out.println(p.pname);  //在本类里面可以访问
	}
	
	//调用私有构造方法
	public static Person getInstance(){
		//会一直创建方法，所以不建议
		/*Person p = new Person();
		return p;*/
		if(p == null){
			p = new Person();
		}
		return p; //静态的不能调用非静态的
	}
}
