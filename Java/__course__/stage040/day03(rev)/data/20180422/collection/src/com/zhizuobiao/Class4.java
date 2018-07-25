package com.zhizuobiao;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * treeset
 */
public class Class4 {

	public static void main(String[] args) {

		test2();
		Comparator cp;
	}

	public static void test2() {
		TreeSet treeSet = new TreeSet();

		User user1 = new User("a", 1);
		User user2 = new User("b", 2);
		User user3 = new User("c", 3);

		// java.lang.ClassCastException: com.zhizuobiao.User cannot be cast to
		// java.lang.Comparable
		// Comparable user11 = (Comparable)user1;
		// int compareTo(T o) 比较此对象与指定对象的顺序。

		treeSet.add(user2);
		treeSet.add(user1);
		treeSet.add(user3);

		for (Object value : treeSet) {
			System.out.println(value);
		}

		System.out.println("user1.getClass() = " + user1.getClass());
	}

	public static void test1() {
		TreeSet treeSet = new TreeSet();
		// treeSet.add(3);
		// treeSet.add(2);
		// treeSet.add(4);
		// treeSet.add(1);
		treeSet.add("A");
		treeSet.add("b");
		treeSet.add("a");
		treeSet.add("W");

		char w1 = 'a';
		char w2 = 'A';

		System.out.println(((int) w1));
		System.out.println(((int) w2));

		for (Object value : treeSet) {
			System.out.println(value);
		}
	}

}
