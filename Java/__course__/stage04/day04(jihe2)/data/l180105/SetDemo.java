package com.lesson.phase4.l0907.l180105;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		
		//底层map的key
		//无序，不能重复
		Set<Student> tstuset = new TreeSet<>();
		tstuset.add(new Student("zhangsan",21));
		tstuset.add(new Student("lisi",22));
		tstuset.add(new Student("wangwu",23));
		tstuset.add(new Student("lisi",22));
		//tstuset.add(null);//treeset不能添加null，报空指针异常
		for (Student str : tstuset) {
			System.out.println(str);
		}
		System.out.println("-------------");
		Set<Student> stuset = new HashSet<>();
		stuset.add(new Student("zhangsan",21));
		stuset.add(new Student("lisi",22));
		stuset.add(new Student("zhangsan",23));
		stuset.add(new Student("lisi",22));
		stuset.add(null);
		for (Student str : stuset) {
			System.out.println(str);
		}
		
		
		Set<String> set = new HashSet<>();
		set.add("abc");
		set.add("sss");
		set.add("def");
		System.out.println(set.add("abc"));
		
		for (String str : set) {
			System.out.println(str);
		}
		

	}

}
