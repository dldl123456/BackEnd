package com.zhizuobiao.class3;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map接口下的实现类 HashMap集合
 */
public class HashMapDemo {

	public static void main(String[] args) {

		// HashSet --> HashMap的key
		HashMap map = new HashMap();

		// 保存数据
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value3");

		map.put("name", "admin");
		map.put("age", "11");
		map.put("email", "11@qq.com");
		map.put("address", "shanghai");

		// 获取数据
		Object object = map.get("key1");
		System.out.println(object);

		// 删除
		// map.remove("key1");
		//
		// map.size();
		// map.clear();
		// map.isEmpty();

		// 遍历
		// 方式一：
		Set keys = map.keySet(); // 获取map集合中的所有key
		for (Object key : keys) { // 遍历key集合中的元素
			map.get(key); // 根据key获取map中的value
		}
		// 方式二：
		Set<Entry> entrys = map.entrySet(); // 返回Entry[key,value]对象的set集合
		for (Entry entry : entrys) {
			System.out.println("key=" + entry.getKey() + " , value=" + entry.getValue());
		}

	}
}
