package dao;

import java.util.List;

import entity.User;

/**
 * 操作用户数据库接口
 * @author Useristrator
 *
 */
public interface Userdao {
	/**
	 * 用户登录的方法(查)
	 * @param user_name用户名
	 * @param user_password用户密码
	 * @return
	 * @throws Exception
	 */
	public User userLogin(int userAccount,String userPassword) throws Exception;
	/**
	 * 用户登录的方法(查)
	 * @param user_name用户名
	 * @param user_password用户密码
	 * @return
	 * @throws Exception
	 */
	public User userLoginByPhone(int userAccount,String userPhone) throws Exception;
	/**
	 * 用户注册的方法（增）
	 * @param user 传一个新的用户对象
	 * @return
	 * @throws Exception
	 */
	public int userRegister(User user) throws Exception;
	/**
	 * 修改用户密码的方法（改）
	 * @param user_name 用户姓名作为条件
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 * @return
	 * @throws Exception
	 */
	public int updateUserPassword(String userName,String newPassword) throws Exception;
	/**
	 * 修改账户余额的方法
	 * @param userId
	 * @param userBalance
	 * @return
	 * @throws Exception
	 */
	public int updateUserBalance(int userId,double userBalance) throws Exception;
	/**
	 * 修改账户电话的方法
	 *
	 */
	public int updateUserPhone(int userId,String newPhone) throws Exception;
	/**
	 * 修改用户信息的方法（不能改密码）
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int updateUser(User user) throws Exception;
	
	/**
	 * 查询所有用户的方法
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUsers() throws Exception;
	/**
	 * 查询某个城市所有用户的方法
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUsersByCity(int cityId) throws Exception;
	/**
	 * 根据用户编号查询用户
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public User queryUserById(int userId) throws Exception;
	public User queryUserByAccount(int userAccount) throws Exception;
	/**
	 * 比对用户账号是否存在的方法
	 * @param inputUserName
	 * @return
	 * @throws Exception
	 */
	public int comparisonUserAccount(int inputUserAccount) throws Exception;
	
	public int comparisonUserId(int inputUserId) throws Exception;
	
	/**
	 * 比对用户密码是否正确的方法
	 * @param inputUserName
	 * @return
	 * @throws Exception
	 */
	public int comparisonUserPas(int inputUserAccount,String inputUserPas) throws Exception;
	/**
	 * 比对用户电话号码是否正确的方法
	 * @param inputUserName
	 * @return
	 * @throws Exception
	 */
	public int comparisonUserPhone(int inputUserAccount,String inputUserPhone) throws Exception;
	
}
