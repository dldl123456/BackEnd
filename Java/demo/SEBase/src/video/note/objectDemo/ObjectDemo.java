package video.note.objectDemo;

public class ObjectDemo {
	public static void main(String[] args) {
		Student stu = new Student("aa", 20);
		System.out.println(stu);  //堆内存中的地址(哈希码),默认.toString()方法
		Student stu1 = new Student("aa", 20);
		System.out.println(stu.equals(stu1));  //默认当且仅当两个指针指向同一个对象的时候是true
	}
}

class Student{  //等同于extends Object
	private String name;
	private int age;
	
	public Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//重写toString方法
	public String toString(){
		return "姓名" + name + "，年龄" + age;
	}
	
	//重写equals方法
	public boolean equals(Object obj){
		//自己跟自己比（传过来的对象和当前的对象比较）
		if(this == obj){
			return true;
		}
		
		if(obj == null){
			return false;
		}
		
		//getClass返回的是当且对象的类型(student)
		//学生跟狗不相等
		if(this.getClass() != obj.getClass()){
			return false;
		}
		
		//强制类型转换
		//假设类型一样，传过来是学生，强制转换成对应的学生
		Student stu = (Student)obj;
		//当前对象和你传过来的对象
		if(this.age != stu.age){
			return false;
		}
		
		if(this.name == null){
			if(stu.name != null){
				return false;
			}
		}else if(!this.name.equals(stu.name)){
			return false;
		}
		
		return true;
	}
}