package com.zhizuobiao;

public class User implements Comparable, UserDao {

	private String name;
	private int age;

	public User() {
	}

	public User(String name, int age) {
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
		User other = (User) obj;
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
	public int compareTo(Object obj) {
		// 对象的比较方法 ， 自己定义比较规则
		// 例如：按照年龄排序
		if (this == obj)
			return 0;
		if (getClass() != obj.getClass())
			return 0;
		// if(obj instanceof User) {
		// }
		User other = (User) obj;
		if (this.age > other.age) {
			return -1;
		} else if (this.age == other.age) {
			return 0;
		} else {
			return 1;
		}

	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

}
