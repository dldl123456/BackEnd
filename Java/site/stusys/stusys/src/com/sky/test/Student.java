package com.sky.test;

//表示学生类
public class Student {
	public String id;
	public String name;
	public int chinese;
	public int math;
	public int english;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", chinese=" + chinese
				+ ", math=" + math + ", english=" + english + "]";
	}

	//alt + shift + s --> get,set方法
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChinese() {
		return chinese;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}
	

	/*public String name;
	public String sex;
	public int age;
	
	//行为：方法，就是这个对象能干嘛
	public void eat(String food){
		System.out.println("去吃:" + food);
	}

	//toString 就是格式化对象 -- 打印得好看一点
	//alt + shift + s --> toString
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}*/
}
