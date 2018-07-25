package com.zhizuobiao.class2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * 对象的比较
 */
public class Demo {

	public static void main(String[] args) {

		Person p1 = new Person();
		p1.setId(12);
		p1.setName("aaa");

		Person p2 = new Person();
		p2.setId(23);
		p2.setName("bbb");

		Person p3 = new Person();
		p3.setId(99);
		p3.setName("ccc");

		TreeSet<Person> treeSet = new TreeSet<Person>();
		treeSet.add(p1);
		treeSet.add(p2);

		for (Person p : treeSet) {
			System.out.println(p);
		}

		// Comparable c = (Comparable)p2;

		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p2);
		list.add(p1);
		list.add(p3);

		Collections.sort(list);

		for (Person p : list) {
			System.out.println(p);
		}

		// Arrays.sort(a);

		LinkedList<User> lkList = new LinkedList<User>();

		User u1 = new User();
		u1.setId(10);

		User u2 = new User();
		u2.setId(44);
		lkList.add(u1);
		lkList.add(u2);

		Collections.sort(lkList, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				if (o1.getId() > o2.getId()) {
					return 1;
				} else if (o1.getId() < o2.getId()) {
					return -1;
				}
				return 0;
			}
		});

	}
}
