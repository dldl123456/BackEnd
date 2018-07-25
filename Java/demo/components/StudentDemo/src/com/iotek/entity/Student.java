package com.iotek.entity;

/**
 *  µÃÂ¿‡
 * @author Administrator
 *
 */
public class Student {
	
	private int id;
	private String name;
	private String psw;
	private double score;
	
	public Student() {
		super();
	}
	
	public Student(String name, String psw) {
		super();
		this.name = name;
		this.psw = psw;
	}

	public Student(String name, String psw, double score) {
		super();
		this.name = name;
		this.psw = psw;
		this.score = score;
	}

	public Student(int id, String name, String psw, double score) {
		super();
		this.id = id;
		this.name = name;
		this.psw = psw;
		this.score = score;
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

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", psw=" + psw + ", score=" + score + "]";
	}

}
