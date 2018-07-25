package com.zhizuobiao.class2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * ������ ��������collection�ӿ��µ������Ӽ����඼�еķ���
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

		// ������
		Iterator arrayIterator = arrayList.iterator();
		Iterator linkedIterator = linkedList.iterator();
		Iterator hashIterator = hashSet.iterator();

		// [0,1,2,3,4,5]
		// ^,���õ��������������ض��󣬳�ʼ��״̬
		// next()
		// [0,1,2,3,4,5]
		// -^
		// next()�����ص�ǰԪ�أ���������һ��Ԫ��λ��
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
		// --------------^��������û��Ԫ�أ�false

		// �ж��Ƿ�����һ��Ԫ��
		while (arrayIterator.hasNext()) {
			// ��ȡԪ�أ����ƶ�����һ��Ԫ��
			Object value = arrayIterator.next();
			System.out.println(value);

			// ɾ��
			arrayIterator.remove();

			// arrayList.add("as"); ��ѭ��
		}

		// foreach
		// ��ߣ�Ԫ�أ��ұߣ�����
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

		// �Լ��ϵ����ݽ��ж�̬��ɾ����ֻ���õ�����

	}
}
