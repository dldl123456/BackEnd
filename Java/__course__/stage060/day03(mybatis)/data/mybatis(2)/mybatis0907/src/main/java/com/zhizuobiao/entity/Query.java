package com.zhizuobiao.entity;

// ���������Ƕ��󣬶��������Ҳ��һ�����󣬹������£�
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
