package com.iotek.dao;

import com.iotek.entity.Admin;

public interface IAdminDao {
	public Admin selectAdmin(int id);
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
	public Admin login(String name,String psw);
	/**
	 * 注册用户
	 * 注册成功返回true
	 * 否则返回false
	 * @param u
	 * @return
	 */
	public boolean register(Admin u);
	/**
	 * 修改单个用户信息
	 * 修改成功返回ture
	 * 失败false
	 * @param u
	 * @return
	 */
	public boolean updateAdmin(Admin u);
	public boolean updatePsw(int adminId,String psw);
}
