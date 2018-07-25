package com.zhizuobiao.entity;

// 参数类型是对象，对象的属性也是一个对象，规则如下：
// eg: parameterType="com.zhizuobiao.entity.Query"
// 
// insert into
// user(username,birthday,sex,address)
// values(
//	#{user.username},#{user.birthday},#{user.sex},#{user.address}
// )
public class Query {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Query [user=" + user + "]";
	}

}
