package com.zhizuobiao.class1;

import org.springframework.stereotype.Repository;

import com.zhizuobiao.class2.IUserDao;

//在spring容器中，UserDao类的bean[id]默认是userDao
// 如果想修改注册的默认id名， dao
//@Repository("dao")
@Repository
public class UserDao implements IUserDao {

	public User getUser(int id) {
		System.out.println("getUser");
		User user = new User();
		user.setId(1);
		user.setUsername("test proxy");
		return user;
	}
	
	public int insertUser(int id) {
		 
		return 1;
	}
}
