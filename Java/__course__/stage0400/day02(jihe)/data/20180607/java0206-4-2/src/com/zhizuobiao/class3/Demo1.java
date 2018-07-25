package com.zhizuobiao.class3;

import java.util.ArrayList;
import java.util.ListIterator;

public class Demo1 {

	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("a1");
		list.add("b1");

		list.iterator(); // next hasNext remove

		ListIterator<String> listIterator = list.listIterator();

		// while(listIterator.hasNext()) {
		listIterator.add("asdf");
		listIterator.set("");
		// }

	 
	}
}
