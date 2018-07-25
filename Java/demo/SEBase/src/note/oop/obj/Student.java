package note.oop.obj;

public class Student {
	public String name;
	public String sex;
	public int age;
	
	//行为：方法，就是这个对象能干嘛
	public void eat(String food){
		System.out.println("去吃:" + food);
	}

	//toString 就是格式化对象 -- 打印得好看一点
	//alt + shift + s --> toString
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
}
