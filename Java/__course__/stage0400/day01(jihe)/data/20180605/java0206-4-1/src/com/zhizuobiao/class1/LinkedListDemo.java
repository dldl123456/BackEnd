package com.zhizuobiao.class1;

import java.util.LinkedList;

/**
 * 集合-LinkedList
 */
public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		// 保存
		list.add("a");
		list.add(new User());

		// 获取
		Object obj0 = list.get(0);
		System.out.println(obj0);

		// 删除
		list.remove(0);
		System.out.println(list.get(0));

		list.getFirst();

		list.getLast();

		list.addFirst("fff");
		list.addLast("lll");
		
		list.size();
		list.clear();

	}

}
