package com.zhizuobiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Class6 {

	public static void demo1() {
		// 需求：统计字符串中字符出现次数，和一共有多少个不同的字符？
		String value = "akljsdfka";

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		char[] valueArray = value.toCharArray();

		for (char element : valueArray) {
			String key = "" + element;
			Integer val = hashMap.get(key);
			if (val != null) {
				// 集合中有 ，原有值+1
				hashMap.put(key, ++val);
			} else {
				// 集合中没有，第一次出现
				hashMap.put(key, 1);
			}
		}

		System.out.println("元素的个数：" + hashMap.size());

		Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println("元素 = " + entry.getKey() + " , 次数 = " + entry.getValue());
		}

	}

	public static void main(String[] args) {
		demo1();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();

		hashMap.put("name", "james");
		hashMap.put("age", 100);
		hashMap.put("email", "10000@qq.com");
		hashMap.put("address", "sh");

		System.out.println(hashMap.get("name"));
		System.out.println(hashMap.get("age"));
		System.out.println(hashMap.get("email"));
		System.out.println(hashMap.get("address"));

		System.out.println(hashMap.size());

		// hashMap.clear();

		hashMap.remove("name");

		hashMap.isEmpty();

		// 遍历一：通过获取key的集合，
		Set<String> keySet = hashMap.keySet();
		for (String key : keySet) {
			System.out.println(hashMap.get(key));
		}

		// 遍历二
		// map集合中的每一项元素，封装成一个Entry对象，对象中有key和value属性，分别用map的元素赋值
		// 多个元素封装成Set集合： Entry --> Set<Entry>
		Set<Map.Entry<String, Object>> entrySet = hashMap.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			System.out.println("key = " + entry.getKey() + " , value = " + entry.getValue());
		}

	}
}
