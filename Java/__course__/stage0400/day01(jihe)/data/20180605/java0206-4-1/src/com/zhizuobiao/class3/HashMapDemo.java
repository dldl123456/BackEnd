package com.zhizuobiao.class3;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Map�ӿ��µ�ʵ���� HashMap����
 */
public class HashMapDemo {

	public static void main(String[] args) {

		// HashSet --> HashMap��key
		HashMap map = new HashMap();

		// ��������
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		map.put("key4", "value3");

		map.put("name", "admin");
		map.put("age", "11");
		map.put("email", "11@qq.com");
		map.put("address", "shanghai");

		// ��ȡ����
		Object object = map.get("key1");
		System.out.println(object);

		// ɾ��
		// map.remove("key1");
		//
		// map.size();
		// map.clear();
		// map.isEmpty();

		// ����
		// ��ʽһ��
		Set keys = map.keySet(); // ��ȡmap�����е�����key
		for (Object key : keys) { // ����key�����е�Ԫ��
			map.get(key); // ����key��ȡmap�е�value
		}
		// ��ʽ����
		Set<Entry> entrys = map.entrySet(); // ����Entry[key,value]�����set����
		for (Entry entry : entrys) {
			System.out.println("key=" + entry.getKey() + " , value=" + entry.getValue());
		}

	}
}
