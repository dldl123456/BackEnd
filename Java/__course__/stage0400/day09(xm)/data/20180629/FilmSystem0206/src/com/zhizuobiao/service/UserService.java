package com.zhizuobiao.service;

import com.zhizuobiao.entity.User;

public interface UserService {

	boolean regist(User user);

	boolean login(String username, String password);

	boolean update(User user);
}
