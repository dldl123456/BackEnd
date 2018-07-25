package com.iotek.dao;

import java.util.List;

import com.iotek.entity.ShowPlan;
import com.iotek.entity.User;

public interface IUserDao {
	/**
	 * 输出所有用户的信息
	 * @return
	 */
	public List<User> selectAllUsers();
	/**
	 * 判断该用户名在数据库是否已经有了
	 * 有返回true
	 * 没有返回false
	 * @param name
	 * @return
	 */
	public boolean nameIsOk(String name);
	/**
	 * 登陆判断输入的用户名和密码是否同时满足条件
	 *满足返回用户信息
	 *没有返回null
	 * @param name
	 * @param psw
	 * @return
	 */
	public User login(String name,String psw);
	/**
	 * 通过用户id来查找用户信息
	 * @param userId
	 * @return
	 */
	public User selectUser(int userId);
	/**
	 * 注册用户
	 * 注册成功返回true
	 * 否则返回false
	 * @param u
	 * @return
	 */
	public boolean register(User u);
	/**
	 * 修改单个用户信息
	 * 修改成功返回ture
	 * 失败false
	 * @param u
	 * @return
	 */
	public boolean updateUser(User u);
	/**
	 * 修改密码
	 * @param userId
	 * @param psw
	 * @return
	 */
	public boolean updatePsw(int userId,String psw);
	/**
	 * 修改多个用户信息
	 * 返回修改成功的用户的个数
	 * 0表示没有修改
	 * @param uls
	 * @return
	 */
	public int updateUsers(List<User> uls);
	/**
	 * 用户充值功能
	 * 充值成功返回余额(并提示充值成功)
	 * 没有充值返回0
	 * 充值失败提返回-1
	 * @param id
	 * @param balance
	 * @param rank
	 * @return
	 */
	public double recharge(int userId,double balance,String rank);
	/**
	 * 购票扣费（账户余额变动）
	 * @param u
	 * @return
	 */
	public boolean payment(int userId,double cost);
	/**
	 * 账户退款
	 * @param u
	 * @param cost
	 * @return
	 */
	public boolean refund(int userId,double cost);
	/**
	 * 用户多张同一场次的票一起退款
	 * @param u
	 * @param sp
	 * @return
	 */
	public int refunds(User u,ShowPlan sp);
	/**
	 * 退回某一场次的所有票的钱给用户（管理员用）
	 * @param sp
	 * @return
	 */
	public int refunds(ShowPlan sp);
}
