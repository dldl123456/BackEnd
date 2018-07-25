package com.itzzb.service;

import com.itzzb.dao.UserDao;
import com.itzzb.pojo.User;

public class UserService {
	private UserDao userDao=new UserDao();
	public boolean login(String uname,String upass){
		boolean flag=false;
		String checkPass=userDao.loginDao(uname);
		if(checkPass!=null){
			if(checkPass.equals(upass)){
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean register(User user){
		boolean flag=false;
		int res=userDao.saveUser(user);
		if(res>0){
			flag=true;
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
