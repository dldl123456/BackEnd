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

		// Iterator û�����

		// listIterator������ȡ����List�������е�ȡ��Ԫ�ط�ʽ������������ɾ�Ĳ�ķ���

		LinkedList linkedList = new LinkedList();
		linkedList.add(1); // collection�ӿڵķ���
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
		linkedList.add(1); // collection�ӿڵķ���
		linkedList.add("b");
		linkedList.add(false);
		linkedList.add("4");

		for (Object obj : linkedList) {
			// System.out.println(obj);

			// java.util.ConcurrentModificationException
			// linkedList.add("add for");

			// �����
			// �ڼ������ҵ�ƥ��Ԫ�أ�Ȼ��ɾ��
			// linkedList.removeFirst();
		}

		// �õ�����
		Iterator iterator = linkedList.iterator();
		while (iterator.hasNext()) {
			Object value = iterator.next();
			if ("pipei".equals(value)) {
				// ʹ�õ�������ɾ������
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
		linkedList.add(1); // collection�ӿڵķ���
		linkedList.add("b");
		linkedList.add(false);
		linkedList.add("4");

		// �÷������
		System.out.println(linkedList.get(0));
		// ������һ����collection
		linkedList.listIterator();
		// ��ͷ�����Ԫ��
		linkedList.addFirst("first");
		System.out.println(linkedList.get(0));
		// ��β�����Ԫ��
		linkedList.addLast("last");

		// �Ӵ��б�����ʾ�Ķ�ջ������һ��Ԫ�ء�
		Object value = linkedList.pop();
		System.out.println(value);

		linkedList.add(3, "add_3_value");
		System.out.println(linkedList.get(3));
		// IndexOutOfBoundsException:
		System.out.println(linkedList.get(30));
	}

	// LinkedList�ṹ��LinkedList��ַ�ǿ��Է������Ŀռ��ַ���������������ģ�
	// (1)[��ַ->b],(b)[��ַ->false],(false)[��ַ->4],("4")[��ַ->null]
	// ��ȡindex=2��Ԫ�أ�
	// (1)[��ַ->b],(b)[��ַ->false],(false)[��ַ->4] --> false
	// ��ȡindex=3��Ԫ�أ�
	// (1)[��ַ->b],(b)[��ַ->false],(false)[��ַ->4],("4")[��ַ->null] --> "4"
	// ��ȡindex=1��Ԫ�أ�
	// (1)[��ַ->b],(b)[��ַ->false] --> b
	// LinkedList��ѯ����Ҫ���������е�Ԫ�أ��ҵ�ָ��ֵ�����ء�Ч�ʵ�
	// LinkedListɾ��
	// ɾ��index=2��Ԫ��
	// (false)[��ַ->4]��
	// (1)[��ַ->b],(b)[��ַ->4],("4")[��ַ->null] --> "4"

}
