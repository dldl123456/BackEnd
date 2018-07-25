package com.zhizuobiao.class2;

import java.util.ArrayList;
import java.util.HashSet;

import com.zhizuobiao.class1.User;

/**
 * 集合 - HashSet
 */
public class HashSetDemo {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		ArrayList list = new ArrayList();

		// 保存
		set.add("a");
		set.add("b");
		set.add(new User());
		set.add("a");

		// list保存
		list.add("a");
		list.add("b");
		list.add(new User());
		list.add("a");

		// 删除
		set.remove("a"); // 无序，没记录位置是具体某元素，所以只能指定元素删除。
		set.clear();
		set.size();
		set.isEmpty();

		System.out.println(set.size());

		// 获取
		Object[] setArray = set.toArray();
		System.out.println("0 -- " + setArray[0]);
		System.out.println("1 -- " + setArray[1]);
		System.out.println("2 -- " + setArray[2]);

		// set：1、无序 2、没有重复元素

		// 对比list
		// list：1、有序 2、有重复元素
		Object[] listArray = list.toArray();
		System.out.println("list 0 -- " + listArray[0]);
		System.out.println("list 1 -- " + listArray[1]);
		System.out.println("list 2 -- " + listArray[2]);
		System.out.println("list 3 -- " + listArray[3]);

		// 父接口：collection -- map 并列关系
		// 子接口： Set List
		// List接口的实现类：ArrayList、LinkedList 1、有序 2、有重复元素
		// Set接口的实现类：HashSet 1、无序 2、没有重复元素

	}
}
