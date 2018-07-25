package com.zhizuobiao.day3.service;

import com.zhizuobiao.day3.entity.User;

public interface UserService {
	
	int insertUser(User user);
	
	User getUser(int id);
	
	int deleteUser(int id);
	
	int updateUser(User user);

}
