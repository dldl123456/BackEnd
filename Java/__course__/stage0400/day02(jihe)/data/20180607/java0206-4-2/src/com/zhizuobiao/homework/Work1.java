package com.zhizuobiao.homework;

import java.util.ArrayList;
import java.util.HashSet;

public class Work1 {

	// ��Arraylist�д���������ݣ�
	//
	// ���������������ġ��������塱��������������aaa������aaa������bbb��
	//
	// Ҫ��ȥ��ArrayList�е��ظ�Ԫ�ء�

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		list.add("����");
		list.add("����");
		list.add("����");
		list.add("aaa");
		list.add("aaa");
		list.add("����");
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
