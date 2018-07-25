package com.zhizuobiao.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Work2 {

	// 创建一个字符串集合ArrayList（默认不重复）
	//
	// 数据 zhangsan,lisi wangwu zhaoliu tianqi
	//
	// 1.循环录入5条数据
	// 2.遍历输出集合中所有的数据
	// 3.查询叫zhangsan的数据
	// 4.删除lisi,并且打印出删除是否成功
	// 5.修改下标为3的数据为akak
	// 6.打印出集合中是否包含 wanger这个名字
	// 7.有一个新集合 其中数据写死 wangwu zhaoliu erhuo，添加到第一个集合中
	// 8.对集合进行排序，提示 使用Collections.sort方法（排序规则就是字典顺序）

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("输入名字：");
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
				System.out.println("删除成功");
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
