package com.zhizuobiao.entity;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String sex;
	private String address;
	private Date birthday;

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", username='" + username + '\'' + ", sex='" + sex + '\'' + ", address='"
				+ address + '\'' + ", birthday=" + birthday + '}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
