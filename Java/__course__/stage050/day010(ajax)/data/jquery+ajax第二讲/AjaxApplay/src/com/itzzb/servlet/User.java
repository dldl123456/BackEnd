package com.itzzb.servlet;

public class User {
	private int id;
	private String uname;
	private String upass;
	private String sex;
	private String address;
	
	public User() {}
	public User(int id, String uname, String upass, String sex, String address) {
		this.id = id;
		this.uname = uname;
		this.upass = upass;
		this.sex = sex;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upass=" + upass + ", sex=" + sex + ", address=" + address
				+ "]";
	}
	
}	
