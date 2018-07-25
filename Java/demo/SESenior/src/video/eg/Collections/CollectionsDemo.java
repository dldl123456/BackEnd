package video.eg.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {
	public static void main(String[] args) {
		//接口的引用变量可以引用实现类对象
		List<Person> data = new ArrayList<>();
		
		data.add(new Person(1, "jack", 15));
		data.add(new Person(5, "zhang", 20));
		data.add(new Person(8, "lisi", 18));
		data.add(new Person(19, "aiao", 18));
		
		//匿名内部类产生的是接口的实现类对象
		Collections.sort(data, new Comparator<Person>(){
			//先按年龄升序排序，再按名字升序排序
			@Override
			public int compare(Person o1, Person o2) {
				if(o1.getAge()-o2.getAge()>0){
					return 1;
				}else if(o1.getAge()-o2.getAge()<0){
					return -1;
				}else{
					return o1.getName().compareTo(o2.getName());
				}
			}
		});
		
		//遍历
		for(Person p:data){
			System.out.println(p);
		}
	}
}

class Person{
	private int id;
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}