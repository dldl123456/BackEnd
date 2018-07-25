package com.zhizuobiao.entity;

import java.util.Date;
import java.util.List;

public class Orders {

	private int id;
	private int state;
	private Date createTime;

	// 一对一
	private User user;
	
	// 一对多
	private List<OrderDetail> orderDetailList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", state=" + state + ", createTime=" + createTime + ", user=" + user
				+ ", orderDetailList=" + orderDetailList + "]";
	}

 
	
	
}
