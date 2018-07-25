package com.zhizuobiao.bean;

import java.util.List;

public class RequestBean {

	private String source;
	private String version;

	private User user;

	private List<User> userList;

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RequestBean [source=" + source + ", version=" + version + ", user=" + user + ", userList=" + userList
				+ "]";
	}


}
