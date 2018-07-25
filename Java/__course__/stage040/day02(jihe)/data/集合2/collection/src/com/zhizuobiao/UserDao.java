package com.zhizuobiao;

public interface UserDao {

	void insert();

	interface MyEntry {
		Object getKey();

		Object getValue();
	}
}
