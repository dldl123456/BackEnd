package com.zhizuobiao.class4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.zhizuobiao.class1.User;

/**
 * ·ºÐÍ
 *
 */
public class TDemo {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		// list.add(1);

		LinkedList<User> list2 = new LinkedList<User>();
		// list2.add("a")
		list2.add(new User());

		User user = list2.get(0);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("a", "A");

		HashMap<String, User> map2 = new HashMap<String, User>();
		map2.put("a", new User());

	}
}
