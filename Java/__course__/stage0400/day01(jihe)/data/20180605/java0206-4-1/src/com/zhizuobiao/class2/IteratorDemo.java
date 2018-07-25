package com.zhizuobiao.class2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 迭代器 迭代器是collection接口下的所有子集合类都有的方法
 */
public class IteratorDemo {

	public static void main(String[] args) {

		ArrayList arrayList = new ArrayList();
		LinkedList linkedList = new LinkedList();
		HashSet hashSet = new HashSet();

		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("c");

		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");

		hashSet.add("a");
		hashSet.add("b");
		hashSet.add("c");

		// 迭代器
		Iterator arrayIterator = arrayList.iterator();
		Iterator linkedIterator = linkedList.iterator();
		Iterator hashIterator = hashSet.iterator();

		// [0,1,2,3,4,5]
		// ^,调用迭代器方法，返回对象，初始化状态
		// next()
		// [0,1,2,3,4,5]
		// -^
		// next()，返回当前元素，并移向下一个元素位置
		// [0,1,2,3,4,5]
		// ---^
		// next()
		// [0,1,2,3,4,5]
		// -----^
		// next()
		// [0,1,2,3,4,5]
		// -------^
		// next()
		// [0,1,2,3,4,5]
		// ---------^
		// next()
		// [0,1,2,3,4,5]
		// -----------^
		// next()
		// [0,1,2,3,4,5]
		// --------------^，集合中没有元素，false

		// 判断是否有下一个元素
		while (arrayIterator.hasNext()) {
			// 获取元素，并移动到下一个元素
			Object value = arrayIterator.next();
			System.out.println(value);

			// 删除
			arrayIterator.remove();

			// arrayList.add("as"); 死循环
		}

		// foreach
		// 左边：元素，右边：容器
		for (Object setEle : hashSet) {

		}
		for (Object listEle : arrayList) {

		}

		// linkedIterator.hasNext();
		linkedIterator.next();
		linkedIterator.remove();
		for (Object arrayEle : linkedList) {
			System.out.println("linkedList -> " + arrayEle);
		}

		// for (Object arrayEle : linkedList) {
		// linkedList.add("123");
		// linkedList.remove(arrayEle);
		// }

		// 对集合的内容进行动态的删除，只能用迭代器

	}
}
