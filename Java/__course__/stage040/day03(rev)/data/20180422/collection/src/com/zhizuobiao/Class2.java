package com.zhizuobiao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * collection -- linkedlist
 * 
 * https://blog.csdn.net/qq_34309305/article/details/79192107
 */
public class Class2 {

	public static void listIterator() {

		// Iterator 没有添加

		// listIterator方法获取，是List集合特有的取出元素方式，它包含了增删改查的方法

		LinkedList linkedList = new LinkedList();
		linkedList.add(1); // collection接口的方法
		linkedList.add("b");
		linkedList.add(false);
		linkedList.add("4");

		ListIterator listIterator = linkedList.listIterator();
		listIterator.add("ListIterator");

		for (Object obj : linkedList) {
			System.out.println(obj);
		}
	}

	public static void testTraverse() {
		LinkedList linkedList = new LinkedList();
		linkedList.add(1); // collection接口的方法
		linkedList.add("b");
		linkedList.add(false);
		linkedList.add("4");

		for (Object obj : linkedList) {
			// System.out.println(obj);

			// java.util.ConcurrentModificationException
			// linkedList.add("add for");

			// 需求多
			// 在集合中找到匹配元素，然后删除
			// linkedList.removeFirst();
		}

		// 用迭代器
		Iterator iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Object value = iterator.next();
			if ("pipei".equals(value)) {
				// 使用迭代器的删除方法
				iterator.remove();
				System.out.println("remove");
			}
		}
	}

	public static void main(String[] args) {

		if (true) {
			// listIterator();
			testTraverse();
			return;
		}

		LinkedList linkedList = new LinkedList();
		linkedList.add(1); // collection接口的方法
		linkedList.add("b");
		linkedList.add(false);
		linkedList.add("4");

		// 用法都差不多
		System.out.println(linkedList.get(0));
		// 迭代器一样，collection
		linkedList.listIterator();
		// 在头部添加元素
		linkedList.addFirst("first");
		System.out.println(linkedList.get(0));
		// 在尾部添加元素
		linkedList.addLast("last");

		// 从此列表所表示的堆栈处弹出一个元素。
		Object value = linkedList.pop();
		System.out.println(value);

		linkedList.add(3, "add_3_value");
		System.out.println(linkedList.get(3));
		// IndexOutOfBoundsException:
		System.out.println(linkedList.get(30));
	}

	// LinkedList结构（LinkedList地址是可以非连续的空间地址）（数组是连续的）
	// (1)[地址->b],(b)[地址->false],(false)[地址->4],("4")[地址->null]
	// 获取index=2的元素，
	// (1)[地址->b],(b)[地址->false],(false)[地址->4] --> false
	// 获取index=3的元素，
	// (1)[地址->b],(b)[地址->false],(false)[地址->4],("4")[地址->null] --> "4"
	// 获取index=1的元素，
	// (1)[地址->b],(b)[地址->false] --> b
	// LinkedList查询，需要遍历链表中的元素，找到指定值并返回。效率低
	// LinkedList删除
	// 删除index=2的元素
	// (false)[地址->4]，
	// (1)[地址->b],(b)[地址->4],("4")[地址->null] --> "4"

}
