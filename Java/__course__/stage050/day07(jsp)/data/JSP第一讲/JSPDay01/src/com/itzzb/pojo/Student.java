package com.itzzb.pojo;

public class Student {
	private int id;
	private String uname;
	private String upass;
	private String address;
	public Student() {}
	public Student(int id, String uname, String upass, String address) {
		this.id = id;
		this.uname = uname;
		this.upass = upass;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", uname=" + uname + ", upass=" + upass + ", address=" + address + "]";
	}
	
}
