package com.zhizuobiao.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Work2 {

	// ����һ���ַ�������ArrayList��Ĭ�ϲ��ظ���
	//
	// ���� zhangsan,lisi wangwu zhaoliu tianqi
	//
	// 1.ѭ��¼��5������
	// 2.����������������е�����
	// 3.��ѯ��zhangsan������
	// 4.ɾ��lisi,���Ҵ�ӡ��ɾ���Ƿ�ɹ�
	// 5.�޸��±�Ϊ3������Ϊakak
	// 6.��ӡ���������Ƿ���� wanger�������
	// 7.��һ���¼��� ��������д�� wangwu zhaoliu erhuo����ӵ���һ��������
	// 8.�Լ��Ͻ���������ʾ ʹ��Collections.sort�����������������ֵ�˳��

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("�������֣�");
			String name = scan.next();
			list.add(name);
		}

		for (String name : list) {
			System.out.println(name);
		}

		for (String name : list) {
			if ("zhangsan".equals(name)) {
				System.out.println(name);
			}
		}

		Iterator<String> it = list.iterator();

		while (it.hasNext()) {
			String name = it.next();
			if ("lisi".equals(name)) {
				it.remove();
				System.out.println("ɾ���ɹ�");
			}
		}

		list.set(3, "modify-3");

		System.out.println(list.contains("wanger"));

		ArrayList<String> dataList = new ArrayList<String>();

		dataList.add("wangwu");
		dataList.add("zhaoliu");
		dataList.add("erhuo");

		list.addAll(dataList);

		for (String other : dataList) {
			if (!list.contains(other)) {
				list.add(other);
			}
		}

		Collections.sort(list);
	}
}
