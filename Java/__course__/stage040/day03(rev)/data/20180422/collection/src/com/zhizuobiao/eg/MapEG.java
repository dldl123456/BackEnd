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

		// map û�е�����
		// key --> value
		// map --> Ԫ�أ�key,value�� --> entry
		// entry ���Ƿ�װkey��value�Ķ���
		// map --> N��Ԫ�أ�key,value�� --> N��entry
		// map --> entrySet���� --> ����N��entry��set����

		// Set<String> Set<User>
		// Entry<String, String> Entry<K,V>
		Set<Entry<String, String>> entrys = map.entrySet();

		// Collection[set,list]������set���ϣ�����ʹ��foreach��������

		for (Entry<String, String> entry : entrys) {
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}

		map.keySet(); // ����map��key�ļ���
		// Set[name,age,email]
		map.values(); // ����map��value�ļ���
		// Collection[a,11,a11@zhizuobiao.com]
	}
}
