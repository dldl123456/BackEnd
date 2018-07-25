package com.zhizuobiao.homework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Work1 {

	/**
	 * 创建一个Teacher类，具有属性 id,name,sex,score 使用linkedList进行存储
	 * 
	 * 1.写一个方法用来录入5名Teacher
	 * 
	 * 2.写一个方法遍历输出整个集合
	 * 
	 * 3.写一个方法使用迭代器遍历输出整个集合
	 * 
	 */
	public static void main(String[] args) {

		LinkedList<Teacher> list = bulidDataList();

		print2(list);
		print1(list);
	}

	/**
	 * 遍历方法一
	 * @param list
	 */
	public static void print2(LinkedList<Teacher> list) {
		Iterator<Teacher> it = list.iterator();
		while (it.hasNext()) {
			Teacher t = it.next();
			System.out.println(t);
		}
	}

	/**
	 * 遍历方法二
	 * @param list
	 */
	public static void print1(LinkedList<Teacher> list) {
		for (Teacher t : list) {
			System.out.println(t);
		}
	}

	/**
	 * 创建一个集合，里面有5个老师
	 */
	public static LinkedList<Teacher> bulidDataList() {
		LinkedList<Teacher> list = new LinkedList<Teacher>();
		for (int i = 0; i < 2; i++) {
			list.add(buildTeacher());
			// list.add(other1());
		}
		return list;
	}

	/**
	 * 创建一个教师，并给属性赋值
	 */
	public static Teacher buildTeacher() {
		Teacher teacher = new Teacher();
		int type = 1;
		while (type <= 4) {
			String value = null;
			try {
				switch (type) {
				// ---------------------------------
				case 1:
					value = userInput("输入id：");
					teacher.setId(Integer.parseInt(value));
					break;
				case 2:
					value = userInput("输入name：");
					teacher.setName(value);
					break;
				case 3:
					value = userInput("输入sex：");
					teacher.setSex(value);
					break;
				case 4:
					value = userInput("输入score：");
					teacher.setScore(Float.parseFloat(value));
					break;
				}
				// ---------------------------------
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			type++;
		}
		return teacher;
	}

	/**
	 * 键盘录入一个值，并返回
	 */
	public static String userInput(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(msg);
		String value = scanner.next();
		// scanner.close();
		return value;
	}
	
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//***********************************分界线**************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	
	/**
	 * 创建一个教师，并给其属性赋值
	 */
	public static Teacher other1() {
		Scanner scanner = new Scanner(System.in);

		Teacher teacher = new Teacher();
		System.out.println("输入id：");
		int id = testInt();
		teacher.setId(id);
		System.out.println("输入name：");
		String name = scanner.next();
		teacher.setName(name);
		System.out.println("输入sex：");
		String sex = scanner.next();
		teacher.setSex(sex);
		System.out.println("输入score：");
		float score = testFloat();
		teacher.setScore(score);

		return teacher;
	}

	/**
	 * int数据键盘录入，是否合法判断，并返回
	 */
	public static int testInt() {
		while (true) {
			int value = 0;
			try {
				Scanner scanner = new Scanner(System.in);
				value = scanner.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			return value;
		}
	}

	/**
	 * float数据键盘录入，是否合法判断，并返回
	 */
	public static float testFloat() {
		while (true) {
			float value = 0;
			try {
				Scanner scanner = new Scanner(System.in);
				value = scanner.nextFloat();
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			return value;
		}
	}

}
