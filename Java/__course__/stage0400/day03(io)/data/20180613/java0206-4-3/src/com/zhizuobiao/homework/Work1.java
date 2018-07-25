package com.zhizuobiao.homework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Work1 {

	// 学生类：id name age
	//
	// 写一个方法，循环录入五条数据
	//
	// 写一个方法，删除id为10的人
	//
	// 写一个方法，查询集合中是否存在一个叫李四的人
	//
	// 写一个方法，查询集合中是否有一个叫王五并且年龄为32的人
	//
	// 写一个方法，获取集合中名字叫王五，年龄为32，id为4的人的下标
	//
	// 通过这个下标对这个人进行修改 修改他的年龄为55
	//
	// 写一个方法，遍历输出所有学生的信息
	//
	// 写一个方法，写一个方法遍历输出所有年龄为4的学员信息
	static LinkedList<Student> DATA_LIST = new LinkedList<Student>();

	public static void main(String[] args) {

		inputData(5);
		boolean success = delete(10);
		System.out.println(success ? "删除成功" : "删除失败");
		success = query("李四");
		System.out.println(success ? "查询李四成功" : "查询李四失败");
		success = query("王五", 32);
		System.out.println(success ? "[\"王五\", 32 ]查询成功" : "[\\\"王五\\\", 32 ]查询失败");
		int index = query("王五", 32, 4);
		update(index);
		printList();
		printList(4);

	}

	public static void printList(int age) {
		Iterator<Student> it = DATA_LIST.iterator();
		while (it.hasNext()) {
			Student stu = it.next();
			if (stu.getAge() == age)
				System.out.println("age=" + age + " | " + stu);
		}
	}

	public static void printList() {
		Iterator<Student> it = DATA_LIST.iterator();
		while (it.hasNext()) {
			Student stu = it.next();
			System.out.println(stu);
		}
	}

	public static void update(int id) {
		Student stu = DATA_LIST.get(id);
		stu.setAge(55);
		System.out.println("修改成功：" + id);
	}

	public static int query(String name, int age, int id) {

		for (int i = 0; i < DATA_LIST.size(); i++) {
			Student stu = DATA_LIST.get(i);
			if (name.equals(stu.getName()) && age == stu.getAge() && id == stu.getId()) {
				return i;
			}
		}
		return -1;
	}

	public static boolean query(String name, int age) {

		Iterator<Student> it = DATA_LIST.iterator();
		while (it.hasNext()) {
			Student stu = it.next();
			if (name.equals(stu.getName()) && age == stu.getAge()) {

				return true;
			}
		}
		return false;
	}

	public static boolean query(String name) {

		Iterator<Student> it = DATA_LIST.iterator();
		while (it.hasNext()) {
			Student stu = it.next();
			if (name.equals(stu.getName())) {
				return true;
			}
		}
		return false;
	}

	public static boolean delete(int id) {

		Iterator<Student> it = DATA_LIST.iterator();
		while (it.hasNext()) {
			Student stu = it.next();
			if (id == stu.getId()) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public static void inputData(int count) {

		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < count; i++) {
			System.out.println("循环录入五条数据,id name age");

			int id = scanner.nextInt();
			String name = scanner.next();
			int age = scanner.nextInt();
			Student stu = new Student(id, name, age);

			DATA_LIST.add(stu);
		}

		scanner.close();
	}

}

class Student {
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Student() {
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	
}