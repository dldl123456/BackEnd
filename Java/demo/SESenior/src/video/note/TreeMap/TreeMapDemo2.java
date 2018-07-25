package video.note.TreeMap;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class TreeMapDemo2 {
	public static void main(String[] args) {
		//产生一个TreeMap容器(Person1)
		TreeMap<Person1, String> pdata1 = new TreeMap<>();
		pdata1.put(new Person1("zhangsan", 30), "张三");
		pdata1.put(new Person1("lisi", 60), "李四");
		pdata1.put(new Person1("rose", 22), "玫瑰");
		pdata1.put(new Person1("zhangsan", 16), "张三");
		
		Set<Entry<Person1, String>> entrys1 = pdata1.entrySet();
		for(Entry<Person1, String> entry:entrys1){
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
		System.out.println(pdata1);
		
		
		//产生一个TreeMap容器(Person2)
		//使用匿名内部类
		TreeMap<Person2, String> pdata2 = new TreeMap<>(new Comparator<Person2>(){
			@Override
			public int compare(Person2 o1, Person2 o2) {
				//从小到大
				//return o1.getAge() - o2.getAge();
				
				//如果名字相同，则根据年龄排序
				if(o1.getName().compareTo(o2.getName())>0){
					return 1;
				}else if(o1.getName().compareTo(o2.getName())<0){
					return -1;
				}else{
					return o1.getAge() - o2.getAge();
				}
			}
		});
		
		pdata2.put(new Person2("zhangsan", 30), "张三");
		pdata2.put(new Person2("lisi", 60), "李四");
		pdata2.put(new Person2("rose", 22), "玫瑰");
		pdata2.put(new Person2("zhangsan", 16), "张三");
		
		Set<Entry<Person2, String>> entrys2 = pdata2.entrySet();
		for(Entry<Person2, String> entry:entrys2){
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
		
		System.out.println(pdata2);
	}
}

//实现Comparable接口中的方法
class Person1 implements Comparable<Person1> {
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
	
	public Person1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//实现接口方法
	@Override
	public int compareTo(Person1 o) {
		if(this.age - o.getAge()>0){
			return 1;
		}else if(this.age - o.getAge()<0){
			return 1;
		}
		return 0;
	}
}

class Person2 {
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
	
	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}