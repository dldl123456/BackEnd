package video.note.personjc;

public class PersonDemo {
	public static void main(String[] args) {
		Student stu = new Student("张三", 20, 100);
		stu.eat();
		stu.walk();
		stu.goSchool();
		stu.exam();
		System.out.println(stu);  //默认toString方法
	}
}

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void eat(){
		System.out.println("I am eating");
	}
	
	public void walk(){
		System.out.println("I am walking");
	}
	
	public String toString(){
		return "姓名：" + name + "，年龄：" + age;
	}
}

class Student extends Person{
	private int score;
	public Student(String name, int age, int score) {
		super(name, age);
		this.score = score;
	}
	
	public String toString(){
		return super.toString() + "分数" + score;
	}
	
	public void goSchool(){
		System.out.println("I am going to school");
	}
	
	public void exam(){
		System.out.println("I am taking a exam");
	}
	
}
