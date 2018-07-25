package video.note.HashSet;

import java.util.HashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		//产生一个HashSet容器
		//支持泛型
		HashSet<String> data = new HashSet<>();
		
		//添加
		data.add("zhangsan");
		data.add("lisi");
		data.add("wangwu");
		data.add("zhaoliu");
		data.add("zhangsan");
		
		//打印
		System.out.println(data);
		
		//查看是否添加成功
		System.out.println(data.add("zhangsan"));
		
		//查看个数
		System.out.println(data.size());
		
		
		//学生容器
		HashSet<Student> stuSet = new HashSet<>();
		
		stuSet.add(new Student("张三", 20));
		stuSet.add(new Student("李四", 30));
		stuSet.add(new Student("张三", 20));
		
		//没有冲突(new)
		System.out.println(stuSet.add(new Student("张三", 20)));
		
		//查看数量
		System.out.println(stuSet.size());
	}
}

class Student{
	private String name;
	private int age;
	
	public Student() {
	}
	
	public Student(String name, int age) {
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

	//如果对象名字重复，则只认定其中一个
	//重写hashcode和equals方法
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
}
