package com.zhizuobiao.homework;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Work1 {

	/**
	 * ����һ��Teacher�࣬�������� id,name,sex,score ʹ��linkedList���д洢
	 * 
	 * 1.дһ����������¼��5��Teacher
	 * 
	 * 2.дһ���������������������
	 * 
	 * 3.дһ������ʹ�õ��������������������
	 * 
	 */
	public static void main(String[] args) {

		LinkedList<Teacher> list = bulidDataList();

		print2(list);
		print1(list);
	}

	/**
	 * ��������һ
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
	 * ����������
	 * @param list
	 */
	public static void print1(LinkedList<Teacher> list) {
		for (Teacher t : list) {
			System.out.println(t);
		}
	}

	/**
	 * ����һ�����ϣ�������5����ʦ
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
	 * ����һ����ʦ���������Ը�ֵ
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
					value = userInput("����id��");
					teacher.setId(Integer.parseInt(value));
					break;
				case 2:
					value = userInput("����name��");
					teacher.setName(value);
					break;
				case 3:
					value = userInput("����sex��");
					teacher.setSex(value);
					break;
				case 4:
					value = userInput("����score��");
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
	 * ����¼��һ��ֵ��������
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
	//***********************************�ֽ���**************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	//*****************************************************************
	
	/**
	 * ����һ����ʦ�����������Ը�ֵ
	 */
	public static Teacher other1() {
		Scanner scanner = new Scanner(System.in);

		Teacher teacher = new Teacher();
		System.out.println("����id��");
		int id = testInt();
		teacher.setId(id);
		System.out.println("����name��");
		String name = scanner.next();
		teacher.setName(name);
		System.out.println("����sex��");
		String sex = scanner.next();
		teacher.setSex(sex);
		System.out.println("����score��");
		float score = testFloat();
		teacher.setScore(score);

		return teacher;
	}

	/**
	 * int���ݼ���¼�룬�Ƿ�Ϸ��жϣ�������
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
	 * float���ݼ���¼�룬�Ƿ�Ϸ��жϣ�������
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
