package com.zhizuobiao.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Work2 {
	// ����һ��Worker�࣬�������� name sex salary level
	//
	// ����һ��linkedlist��Ϊ����������Դ������main������
	//
	// д��һ�·�����
	//
	// 1.¼��5��������Ϣ
	//
	// 2.������й�����Ϣ
	//
	// 3.���ݹ��˵�idͨ�������ڲ���������򣬲��������Ҫ���˵�����Ӱ��Դ����˳��
	//
	// ͨ�������һ���µ�arraylist�н�������
	//
	// 4.�������Թ��˵Ĺ�����ԭ�л����ϼ�200
	//
	// 5.ͨ��ʹ��listiterator�޸����й��ʳ���5000��Ա������ΪH

	static LinkedList<Worker> DATA_LIST = new LinkedList<Worker>();

	public static void main(String[] args) {

	}

	public static void updateLevel() {

		ListIterator<Worker> listIt = DATA_LIST.listIterator();
		while (listIt.hasNext()) {
			Worker worker = listIt.next();
			if (worker.getSalary() > 5000) {
				worker.setLevel("H");
			}
		}
	}

	public static void addSalary() {
		for (Worker w : DATA_LIST) {
			if (w.getSex().equals("��")) {
				w.setSalary(w.getSalary() + 200);
			}
		}
	}

	public static void sortList() {
		ArrayList<Worker> list = new ArrayList<Worker>(DATA_LIST);
		Collections.sort(list, new Comparator<Worker>() {

			@Override
			public int compare(Worker o1, Worker o2) {
				if (o1.getSalary() > o2.getSalary()) {
					return 1;
				} else if (o1.getSalary() < o2.getSalary()) {
					return -1;
				}
				return 0;
			}
		});
	}

	public static void inputData(int count) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < count; i++) {
			System.out.println("ѭ��¼����������,Worker�࣬�������� name sex salary level");

			String name = scanner.next();
			String sex = scanner.next();
			float salary = scanner.nextFloat();
			String level = scanner.next();
			Worker worker = new Worker(name, sex, salary, level);

			DATA_LIST.add(worker);
		}

		scanner.close();
	}
}

class Worker {
	private String name;
	private String sex;
	private float salary;
	private String level;

	public Worker(String name, String sex, float salary, String level) {
		super();
		this.name = name;
		this.sex = sex;
		this.salary = salary;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", sex=" + sex + ", salary=" + salary + ", level=" + level + "]";
	}

}
