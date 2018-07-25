package com.zhizuobiao.class2;

import java.util.HashSet;

/**
 * ¶ÔÏóµÄequals
 *
 */
public class Demo2 {

	public static void main(String[] args) {

		User user = new User();
		user.setId(1);
		user.setName("a");

		User user2 = new User();
		user2.setId(33);
		user2.setName("sdcg");

		User user3 = new User();
		user3.setId(33);
		user3.setName("sdcg");

		System.out.println(user.hashCode());
		System.out.println(user2.hashCode());
		System.out.println(user);
		System.out.println(user2);

		System.out.println(user.equals(user2));
		// System.out.println(user == user2);

		HashSet<User> set = new HashSet<User>();

		set.add(user3);
		set.add(user);
		set.add(user2);

		System.out.println("size=" + set.size());
	}
}
