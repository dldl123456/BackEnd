package com.zhizuobiao.homework;

import java.util.ArrayList;
import java.util.HashSet;

public class Work1 {

	// 在Arraylist中存放以下数据：
	//
	// “张三”、“李四”、“王五”、“张三”、“aaa”、“aaa”、“bbb”
	//
	// 要求：去除ArrayList中的重复元素。

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		list.add("张三");
		list.add("李四");
		list.add("王五");
		list.add("aaa");
		list.add("aaa");
		list.add("张三");
		list.add("bbb");

		// HashSet<String> other = new HashSet<String>(list);
		// for (String value : other) {
		// System.out.println(value);
		// }

		ArrayList<String> newList = new ArrayList<String>();
		for (String ele : list) {
			if (!newList.contains(ele)) {
				newList.add(ele);
			}
		}
	}
}
