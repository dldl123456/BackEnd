package com.sky.test;

//��ʾѧ����
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

	//alt + shift + s --> get,set����
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
	
	//��Ϊ��������������������ܸ���
	public void eat(String food){
		System.out.println("ȥ��:" + food);
	}

	//toString ���Ǹ�ʽ������ -- ��ӡ�úÿ�һ��
	//alt + shift + s --> toString
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}*/
}
