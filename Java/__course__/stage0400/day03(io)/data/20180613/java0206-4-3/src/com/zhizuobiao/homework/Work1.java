package com.zhizuobiao.homework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Work1 {

	// ѧ���ࣺid name age
	//
	// дһ��������ѭ��¼����������
	//
	// дһ��������ɾ��idΪ10����
	//
	// дһ����������ѯ�������Ƿ����һ�������ĵ���
	//
	// дһ����������ѯ�������Ƿ���һ�������岢������Ϊ32����
	//
	// дһ����������ȡ���������ֽ����壬����Ϊ32��idΪ4���˵��±�
	//
	// ͨ������±������˽����޸� �޸���������Ϊ55
	//
	// дһ�������������������ѧ������Ϣ
	//
	// дһ��������дһ���������������������Ϊ4��ѧԱ��Ϣ
	static LinkedList<Student> DATA_LIST = new LinkedList<Student>();

	public static void main(String[] args) {

		inputData(5);
		boolean success = delete(10);
		System.out.println(success ? "ɾ���ɹ�" : "ɾ��ʧ��");
		success = query("����");
		System.out.println(success ? "��ѯ���ĳɹ�" : "��ѯ����ʧ��");
		success = query("����", 32);
		System.out.println(success ? "[\"����\", 32 ]��ѯ�ɹ�" : "[\\\"����\\\", 32 ]��ѯʧ��");
		int index = query("����", 32, 4);
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
		System.out.println("�޸ĳɹ���" + id);
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
			System.out.println("ѭ��¼����������,id name age");

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