package com.zhizuobiao.entity;

public class OrdersUserCustom extends Orders {

//	private int id;
//	private int state;
//	private Date createTime;
	
	private String username;
	private String address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
