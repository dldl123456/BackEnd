package service;

import java.util.List;

import entity.User;

/**
 * 
 * @param 给用户服务提供接口
 * @author zmx2321
 *
 */

public interface UserService {
	//用户注册
	public boolean regist(User user);

	//用户登录
	public boolean login(String username, String password);
	
	//修改账户余额
	public boolean updateAccount(int id, float user_balance);
	
	//根据id查询用户
	public boolean querryUser(int id);
	
	//查询所有用户
	public boolean querryUsers(List<User> userlist);
	
	//根据id删除用户
	public boolean deleteUser(int id);
	
	//根据用户id修改账户余额(设置)
	public boolean setupCount(int id, float user_balance);
}
