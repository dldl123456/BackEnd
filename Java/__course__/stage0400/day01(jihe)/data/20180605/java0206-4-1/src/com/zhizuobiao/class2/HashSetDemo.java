package com.zhizuobiao.class2;

import java.util.ArrayList;
import java.util.HashSet;

import com.zhizuobiao.class1.User;

/**
 * ���� - HashSet
 */
public class HashSetDemo {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		ArrayList list = new ArrayList();

		// ����
		set.add("a");
		set.add("b");
		set.add(new User());
		set.add("a");

		// list����
		list.add("a");
		list.add("b");
		list.add(new User());
		list.add("a");

		// ɾ��
		set.remove("a"); // ����û��¼λ���Ǿ���ĳԪ�أ�����ֻ��ָ��Ԫ��ɾ����
		set.clear();
		set.size();
		set.isEmpty();

		System.out.println(set.size());

		// ��ȡ
		Object[] setArray = set.toArray();
		System.out.println("0 -- " + setArray[0]);
		System.out.println("1 -- " + setArray[1]);
		System.out.println("2 -- " + setArray[2]);

		// set��1������ 2��û���ظ�Ԫ��

		// �Ա�list
		// list��1������ 2�����ظ�Ԫ��
		Object[] listArray = list.toArray();
		System.out.println("list 0 -- " + listArray[0]);
		System.out.println("list 1 -- " + listArray[1]);
		System.out.println("list 2 -- " + listArray[2]);
		System.out.println("list 3 -- " + listArray[3]);

		// ���ӿڣ�collection -- map ���й�ϵ
		// �ӽӿڣ� Set List
		// List�ӿڵ�ʵ���ࣺArrayList��LinkedList 1������ 2�����ظ�Ԫ��
		// Set�ӿڵ�ʵ���ࣺHashSet 1������ 2��û���ظ�Ԫ��

	}
}
