package com.zhizuobiao.service;

import com.zhizuobiao.entity.User;

public interface UserService {

	boolean checkLogin(User user);

	boolean registUser(User user);
 
}
