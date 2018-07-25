package com.lesson.phase4.l0907.l180102;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		//有序，可重复
		LinkedList<String> list = new LinkedList<>();
		list.add("abc");
		list.add("zzz");
		list.add("sss");
		list.add("sss");
		list.add("eee");
		list.add(null);
		
		System.out.println(list.get(0));
		System.out.println(list.size());
		
		//foreach 循环
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("-------------");
		
		list.clear();
		
		//迭代器遍历 
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		

	}

}
