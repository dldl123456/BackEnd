package video.note.otherio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputOutputDemo {
	public static void main(String[] args) throws IOException {
		Student stu1 = new Student("aaqqwaa", 20);
		
		//序列化
		FileOutputStream fos = new FileOutputStream("D:\\_site_\\aaa\\a.txt");
		
		//包装
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//写入(把对象序列化到指定的文件输出流中)
		oos.writeObject(stu1);
		
		oos.close();
		
		//反序列化
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\_site_\\aaa\\a.txt"));
		try {
			Student stu = (Student)ois.readObject();
			System.out.println(stu);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ois.close();
	}
}


class Student implements Serializable{
	private static final long serialVersionUID = 1717174595646044849L;
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
