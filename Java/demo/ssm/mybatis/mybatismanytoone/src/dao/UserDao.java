package dao;

import po.User;

public interface UserDao {
	//根据用户id查询组
	public User getUserById(int uid);
	
	
}
