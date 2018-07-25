package video.note.dog;

public class Dog {
	String name;  //同个包中的其他类可以直接访问
	//不同包中的不能访问使用默认访问修饰符的属性和方法
	public String name1;
	public int age;
	public void show(){
		System.out.println("name " + name + "---" + age);
		System.out.println("name1 " + name1 + "---" + age);
	}
}
