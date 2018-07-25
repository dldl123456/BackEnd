package com.zhizuobiao;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * treemap
 *
 */
public class Class7 {

	public static void main(String[] args) {

		TreeMap<String, String> map = new TreeMap<String, String>();

		map.put("b", "123");
		map.put("a", "123");
		map.put("1", "123");
		map.put("22", "123");

		Set<Entry<String, String>> set = map.entrySet();

		for (Entry<String, String> entry : set) {
			System.out.println(entry.getKey());
		}

		// treemapµÄÅÅĞò£ºkey£¬×ÖµäË³Ğò
	}
}
