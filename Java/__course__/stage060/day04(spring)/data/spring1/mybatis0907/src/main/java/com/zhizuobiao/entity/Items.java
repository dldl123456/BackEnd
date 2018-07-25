package com.zhizuobiao.entity;

import java.io.Serializable;
// 测试代码修改，本地进行更新。
public class Items implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private float price;

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
