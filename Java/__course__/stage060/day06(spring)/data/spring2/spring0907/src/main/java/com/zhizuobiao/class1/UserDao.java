package com.zhizuobiao.class1;

import org.springframework.stereotype.Repository;

import com.zhizuobiao.class2.IUserDao;

//��spring�����У�UserDao���bean[id]Ĭ����userDao
// ������޸�ע���Ĭ��id���� dao
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
