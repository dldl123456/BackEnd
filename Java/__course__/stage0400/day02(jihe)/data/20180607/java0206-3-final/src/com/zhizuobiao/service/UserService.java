package com.zhizuobiao.service;

import com.zhizuobiao.bean.User;

public interface UserService {

	boolean login(String username, String password);
	
	
	boolean regist(User user);
}
