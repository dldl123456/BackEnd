package com.zhizuobiao.class1;

import java.util.LinkedList;

/**
 * ����-LinkedList
 */
public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		// ����
		list.add("a");
		list.add(new User());

		// ��ȡ
		Object obj0 = list.get(0);
		System.out.println(obj0);

		// ɾ��
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
