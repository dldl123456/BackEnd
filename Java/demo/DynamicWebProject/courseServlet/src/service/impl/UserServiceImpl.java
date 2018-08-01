package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();
	private int code = 0;  //sql执行状态
	
	@Override
	public boolean register(User user) {
		code = userDao.addUser(user);
		
		return code == 0 ? false : true;
	}
	
	public static void main(String[] args) {
		UserServiceImpl usi = new UserServiceImpl();
		User u = new User("张三", "123123", "男", "aa");
		
		System.err.println(usi.register(u));
	}
}
