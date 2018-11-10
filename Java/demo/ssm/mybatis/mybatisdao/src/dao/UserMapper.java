package dao;

import po.User;

public interface UserMapper {
	public void insertUser(User user);
	
	public User getUserById(int id);
}
