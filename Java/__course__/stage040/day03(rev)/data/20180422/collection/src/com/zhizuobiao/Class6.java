package com.zhizuobiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Class6 {

	public static void demo1() {
		// ����ͳ���ַ������ַ����ִ�������һ���ж��ٸ���ͬ���ַ���
		String value = "akljsdfka";

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		char[] valueArray = value.toCharArray();

		for (char element : valueArray) {
			String key = "" + element;
			Integer val = hashMap.get(key);
			if (val != null) {
				// �������� ��ԭ��ֵ+1
				hashMap.put(key, ++val);
			} else {
				// ������û�У���һ�γ���
				hashMap.put(key, 1);
			}
		}

		System.out.println("Ԫ�صĸ�����" + hashMap.size());

		Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println("Ԫ�� = " + entry.getKey() + " , ���� = " + entry.getValue());
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

		// ����һ��ͨ����ȡkey�ļ��ϣ�
		Set<String> keySet = hashMap.keySet();
		for (String key : keySet) {
			System.out.println(hashMap.get(key));
		}

		// ������
		// map�����е�ÿһ��Ԫ�أ���װ��һ��Entry���󣬶�������key��value���ԣ��ֱ���map��Ԫ�ظ�ֵ
		// ���Ԫ�ط�װ��Set���ϣ� Entry --> Set<Entry>
		Set<Map.Entry<String, Object>> entrySet = hashMap.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			System.out.println("key = " + entry.getKey() + " , value = " + entry.getValue());
		}

	}
}
