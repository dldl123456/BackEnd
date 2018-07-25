package com.iotek.entity;

public class Admin {
	private int id;
	private String name;
	private String  psw;
	private int age;
	private String sex;
	private String adress;
	private String tel;
	public Admin() {
		super();
	}
	public Admin(int id, String name, String psw, int age, String sex, String adress, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.psw = psw;
		this.age = age;
		this.sex = sex;
		this.adress = adress;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", psw=" + psw + ", age=" + age + ", sex=" + sex + ", adress="
				+ adress + ", tel=" + tel + "]";
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
