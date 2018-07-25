package com.zhizuobiao.homework;

public class Teacher {

	private int id;
	private String name;
	private String sex;
	private float score;
	
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

	public String getSex() {
		return sex;
	}

	 
	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setScore(int score) {
		this.score = score;
	}

//	@Override
//	public String toString() {
//		return "Teacher [id=" + id + ", name=" + name + ", sex=" + sex + ", score=" + score + "]";
//	}

}
