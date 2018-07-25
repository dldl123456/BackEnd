package com.zhizuobiao.class1;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Map HashMap,TreeMap
 */
public class TreeMapDemo {

	public static void main(String[] args) {

		TreeMap<Integer, String> map = new TreeMap<Integer, String>();

		map.put(1, "a");
		map.put(2, "b");
		map.put(53, "e");
		map.put(3, "e");
		map.put(32, "f");
		map.put(78, "w");
		map.put(13, "w");

		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			System.out.println(key); // ÓÐÐò
		}

		TreeSet<String> treeSet = new TreeSet<String>();
		treeSet.add("abc");
		treeSet.add("1c");
		treeSet.add("d23bc");
		treeSet.add("ebac");
		treeSet.add("xbac");
		treeSet.add("ybac");

		for (String s : treeSet) {
			System.out.println("treeSet = " + s);
		}
	}
}
