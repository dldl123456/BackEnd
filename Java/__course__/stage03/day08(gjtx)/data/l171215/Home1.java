package com.lesson.phase3.l0907.l171215;

import java.util.Arrays;
import java.util.Comparator;

public class Home1 {

	public static void main(String[] args) {
		String []  strs = {"sdfsf","sdf","ss","sdfdfere"};

		Arrays.sort(strs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		for (String str : strs) {
			System.out.println(str);
		}
		
		
		Integer i = 10; //new Integer(10);
		int num = i;   //i.intValue() 
		
		
	}

}
