package com.zhizuobiao.eg;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapEG {

	public static void main(String[] args) {

		HashMap<String, HashMap<String, String>> map1 = new HashMap<String, HashMap<String, String>>();
		HashMap<String, HashMap<String, HashMap<String, String>>> map2 = new HashMap<String, HashMap<String, HashMap<String, String>>>();
		HashMap<HashMap<String, String>, HashMap<String, HashMap<String, String>>> map3 = new HashMap<HashMap<String, String>, HashMap<String, HashMap<String, String>>>();

	}

	public static void test1() {
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("name", "a");
		map.put("age", "11");
		map.put("email", "a11@zhizuobiao.com");

		// map 没有迭代器
		// key --> value
		// map --> 元素（key,value） --> entry
		// entry 就是封装key、value的对象，
		// map --> N个元素（key,value） --> N个entry
		// map --> entrySet方法 --> 返回N个entry的set集合

		// Set<String> Set<User>
		// Entry<String, String> Entry<K,V>
		Set<Entry<String, String>> entrys = map.entrySet();

		// Collection[set,list]，遍历set集合：可以使用foreach、迭代器

		for (Entry<String, String> entry : entrys) {
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}

		map.keySet(); // 返回map的key的集合
		// Set[name,age,email]
		map.values(); // 返回map的value的集合
		// Collection[a,11,a11@zhizuobiao.com]
	}
}
