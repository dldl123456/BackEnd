package com.lesson.phase4.l0907.l180105;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		
		//自己创建的对象，如果使用来作为TreeMap的key则需要变成比较器对象
		//1.实现Comparable接口
		//2.调用TreeMap的Comparator构造方法。
		TreeMap<Student,String> tstumap = new TreeMap<Student,String>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getAge()-o2.getAge();
			}
		});
		tstumap.put(new Student("zhangsan",28), "zhangsan");
		tstumap.put(new Student("lisi",20), "lisi");
		tstumap.put(new Student("wangwu",18), "wangwu");
		tstumap.put(new Student("lisi",22), "lisi2");
		//tstumap.put(null, null);
		Set<Entry<Student, String>> tstuset = tstumap.entrySet();
		for (Entry<Student, String> entry : tstuset) {
			System.out.println(entry.getKey()+","+entry.getValue());
		}
		
		
		//treemap 按照自然顺序进行排序
		Map<String,String> treemap = new TreeMap<String,String>();
		treemap.put("zhangsan", "123");
		treemap.put("lisi", "456");
		treemap.put("wangwu", "789");
		treemap.put("lisi", "555");//key唯一，如果key相同则进行覆盖
		treemap.put("abc", "789");
		Set<Entry<String, String>> tmapset = treemap.entrySet();
		for (Entry<String, String> entry : tmapset) {
			System.out.println(entry.getKey()+","+entry.getValue());
		}
		System.out.println("-------------");
		
		HashMap<Student,String> stumap = new HashMap<Student,String>();
		stumap.put(new Student("zhangsan",20), "zhangsan");
		stumap.put(new Student("lisi",20), "lisi");
		stumap.put(new Student("wangwu",20), "wangwu");
		stumap.put(new Student("lisi",20), "lisi2");
		Set<Entry<Student, String>> stuset = stumap.entrySet();
		for (Entry<Student, String> entry : stuset) {
			System.out.println(entry.getKey()+","+entry.getValue());
		}
		
		System.out.println("-----------------");
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("zhangsan", "123");
		map.put("lisi", "456");
		map.put("wangwu", "789");
		map.put("lisi", "555");//key唯一，如果key相同则进行覆盖
		map.put(null, null);
		
		
		Set<Entry<String, String>> mapset = map.entrySet();
		for (Entry<String, String> entry : mapset) {
			System.out.println(entry.getKey()+","+entry.getValue());
		}
		System.out.println("-------------");
		
		Set<String> keySet = map.keySet();
		for (String str : keySet) {
			System.out.println(str+","+map.get(str));
		}
		
		
		
		
	}
	
}



class Student implements Comparable<Student>{
	
	private String name;
	private int age;
	
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Student o) {
		return this.age-o.age;
	}	
	
	
	
}

