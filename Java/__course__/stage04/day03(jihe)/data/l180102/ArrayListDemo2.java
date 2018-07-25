package com.lesson.phase4.l0907.l180102;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
		//有序，可重复
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("zhangsan",22));
		list.add(new Student("lisi",12));
		list.add(new Student("wangwu",18));
		
		System.out.println(list.contains(new Student("lisi",12)));
		
		System.out.println(list.get(0));
		System.out.println(list.size());
		
		//foreach 循环
		for (Student str : list) {
			System.out.println(str);
		}
		System.out.println("-------------");
		
		list.clear();
		
		//迭代器遍历 
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		

	}

}

class Student{
	
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
	
	
	
}



