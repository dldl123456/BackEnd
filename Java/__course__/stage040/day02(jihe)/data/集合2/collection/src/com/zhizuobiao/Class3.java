package com.zhizuobiao;

import java.util.HashSet;
import java.util.Iterator;

/**
 * set
 */
public class Class3 {

	public static void main(String[] args) {

		User user1 = new User();
		User user2 = new User();
		User user3 = new User();

		user1.setName("a");
		user2.setName("a");
		user3.setName("a");

		// 要求 名字相同，就认为是同一个对象
		// 如何实现？

		// 不允许重复，无序
		HashSet hashSet = new HashSet();
		hashSet.add("a");
		hashSet.add("a");
		hashSet.add("a");
		// hashSet.add(user1);
		// hashSet.add(user2);
		// hashSet.add(user3);
		// User 是如何判断是否是同一个对象的？
		// hashCode equals
		System.out.println(hashSet.size());
		//

		for (int i = 0; i < 100; i++) {
			hashSet.add(i);
		}

		// 0123456789101112131415161718192021222324252627282930313233343536373839404142434445464748495051525354555657585960616263646566676869707172737475767778798081828384858687888990919293949596a979899
		for (Object obj : hashSet) {
			System.out.print(obj);
		}

		
	}
}
