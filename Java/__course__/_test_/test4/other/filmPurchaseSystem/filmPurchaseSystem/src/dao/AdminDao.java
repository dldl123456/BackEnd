package dao;

import java.util.List;

import entity.Admin;

/**
 * 操作管理员数据库接口
 * @author Administrator
 *
 */
public interface AdminDao {
	/**
	 * 管理员登录方法
	 * @param adminName
	 * @param adminPassword
	 * @return
	 * @throws Exception
	 */
	public Admin adminLogin(String adminName,String adminPassword) throws Exception;
	/**
	 * 查询所有管理员的方法
	 * @return
	 * @throws Exception
	 */
	public List<Admin> queryAdmins() throws Exception;
	/**
	 * 比对管理员姓名是否存在的方法
	 * @param inputAdminName
	 * @return
	 * @throws Exception
	 */
	public int comparisonAdminName(String inputAdminName) throws Exception;
	
	/**
	 * 比对管理员密码是否正确的方法
	 * @param inputAdminName
	 * @return
	 * @throws Exception
	 */
	public int comparisonAdminPas(String inputAdminName,String inputAdminPas) throws Exception;
	
}
