package com.zhizuobiao.homework;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Work2 {
	// 2.HashMap
	// 1������Student�࣬����String���͵�name��int���͵�age��double���͵�score������дgetter��setter�ȷ�����
	// 2������5��Student������֪һ��Integer���͵�ѧ�Ŷ�ӦΨһ��һ��Student����
	// 3����5��Student���󱣴浽HashMap�����С�
	// 4����������������ӡ������

	public static void main(String[] args) {
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();

		map.put(new Integer(1), new Student("a1", 1, 601));
		map.put(2, new Student("a2", 12, 602));
		map.put(3, new Student("a3", 13, 603));
		map.put(4, new Student("a4", 14, 604));
		map.put(5, new Student("a5", 15, 605));

		Set<Entry<Integer, Student>> entrySet = map.entrySet();
		for (Entry<Integer, Student> entry : entrySet) {
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}

	}
}

class Student {
	private String name;
	private int age;
	private double score;

	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
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

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

}