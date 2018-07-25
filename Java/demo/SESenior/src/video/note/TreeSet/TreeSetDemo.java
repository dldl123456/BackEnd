package video.note.TreeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		//产生一个TreeMap容器(Person1)
		TreeSet<Person1> pset1 = new TreeSet<Person1>();
		
		//添加
		pset1.add(new Person1("zhangs", 30));
		pset1.add(new Person1("lisi", 20));
		pset1.add(new Person1("wangwu", 40));
		
		//没有比较规则会报错
		System.out.println(pset1);
		
		//用迭代器遍历
		Iterator<Person1> it1 = pset1.iterator();
		while(it1.hasNext()){
			Person1 p = it1.next();
			System.out.println(p.getName() + "--" + p.getAge());
		}
		
		
		//产生一个TreeMap容器(Person2)
		//使用匿名内部类
		TreeSet<Person2> pset2 = new TreeSet<Person2>(new Comparator<Person2>() {
			@Override
			public int compare(Person2 o1, Person2 o2) {
				//从小到大
				return o1.getAge() - o2.getAge();
			}
		});
		
		//添加
		pset2.add(new Person2("zhangs", 30));
		pset2.add(new Person2("lisi", 20));
		pset2.add(new Person2("wangwu", 40));
		
		//没有比较规则会报错
		System.out.println(pset2);
		
		//用迭代器遍历
		Iterator<Person1> it2 = pset1.iterator();
		while(it2.hasNext()){
			Person1 p = it2.next();
			System.out.println(p.getName() + "--" + p.getAge());
		}
	}
}

class Person1 implements Comparable<Person1>{
	private String name;
	private int age;
	
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
	
	public Person1() {}
	
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Person1 o) {
		//从小到大排序
		return this.getAge() - o.getAge();
	}
}

class Person2{
	private String name;
	private int age;
	
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
	
	public Person2() {}
	
	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
}